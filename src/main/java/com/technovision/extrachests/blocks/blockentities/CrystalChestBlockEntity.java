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
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.util.collection.DefaultedList;

import java.util.stream.Stream;

public class CrystalChestBlockEntity extends GenericExtraChestBlockEntity {

    private DefaultedList<ItemStack> topStacks;

    public CrystalChestBlockEntity() {
        super(ModBlockEntityType.CRYSTAL_CHEST, ExtraChestTypes.CRYSTAL);
        topStacks = DefaultedList.ofSize(8, ItemStack.EMPTY);
    }

    @Override
    public void onOpen(PlayerEntity playerEntity) {
        if (!playerEntity.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.onInvOpenOrClose();
        }
        Stream<PlayerEntity> watchingPlayers = PlayerStream.watching(world,pos);
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
        passedData.writeBlockPos(pos);
        DefaultedList<ItemStack> inv = getInvStackList();
        for (int i = 0; i < 12; i++) {
            passedData.writeItemStack(inv.get(i));
        }
        watchingPlayers.forEach(player ->
                ServerSidePacketRegistry.INSTANCE.sendToPlayer(player, ExtraChests.UPDATE_INV_PACKET_ID, passedData));
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
