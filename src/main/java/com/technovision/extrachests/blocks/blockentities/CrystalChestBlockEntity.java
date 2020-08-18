package com.technovision.extrachests.blocks.blockentities;

import com.technovision.extrachests.ExtraChests;
import com.technovision.extrachests.blocks.ExtraChestTypes;
import com.technovision.extrachests.registry.ModBlockEntityType;
import com.technovision.extrachests.registry.ModScreenHandlerType;
import com.technovision.extrachests.screenhandlers.ExtraChestScreenHandler;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.server.PlayerStream;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.collection.DefaultedList;

import java.util.stream.Stream;

public class CrystalChestBlockEntity extends GenericExtraChestBlockEntity {

    private DefaultedList<ItemStack> topStacks;
    private boolean inventoryTouched;

    public CrystalChestBlockEntity() {
        super(ModBlockEntityType.CRYSTAL_CHEST, ExtraChestTypes.CRYSTAL);
        topStacks = DefaultedList.ofSize(12, ItemStack.EMPTY);
        inventoryTouched = true;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.world.isClient && this.inventoryTouched) {
            Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(world, pos);
            PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
            passedData.writeBlockPos(pos);
            getTopStacks();
            for (int i = 0; i < 12; i++) {
                passedData.writeItemStack(topStacks.get(i));
            }
            watchingPlayers.forEach(player -> ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ExtraChests.UPDATE_INV_PACKET_ID, passedData));
            inventoryTouched = false;
            topStacks.clear();
        }
    }

    private void getTopStacks() {
        int startIndex = 0;
        for (int i = 0; i < 12; i++) {
            DefaultedList<ItemStack> inv = getInventory();
            for (int j = startIndex; j < inv.size(); j++) {
                ItemStack stack = inv.get(j);
                if (stack.getItem() != Items.AIR) {
                    startIndex = j+1;
                    topStacks.set(i, stack);
                    if (startIndex > inv.size()) { return; }
                    break;
                }
            }
        }
    }

    private DefaultedList<ItemStack> getInventory() {
        return super.getInvStackList();
    }

    @Override
    public DefaultedList<ItemStack> getInvStackList() {
        this.inventoryTouched = true;
        return super.getInvStackList();
    }

    @Override
    public void setInvStackList(DefaultedList<ItemStack> list) {
        super.setInvStackList(list);
        this.inventoryTouched = true;
    }

    @Override
    public void onClose(PlayerEntity player) {
        super.onClose(player);
        this.inventoryTouched = true;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new ExtraChestScreenHandler(ModScreenHandlerType.CRYSTAL_CHEST, type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory inventory) {
        return new ExtraChestScreenHandler(ModScreenHandlerType.CRYSTAL_CHEST, type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

}
