package com.modderminer.extrachests.blockentities;

import com.modderminer.extrachests.gui.IronChestDescription;
import com.modderminer.extrachests.registry.ModBlockEntityType;
import com.modderminer.extrachests.registry.ModScreenHandlerType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class IronChestBlockEntity extends ChestBlockEntity implements NamedScreenHandlerFactory{

    public static final int INVENTORY_SIZE = 54;
    private DefaultedList<ItemStack> inventory;

    public IronChestBlockEntity() {
        super(ModBlockEntityType.IRON_CHEST);
        inventory = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new IronChestDescription(ModScreenHandlerType.IRON_CHEST, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.inventory = list;
    }


}
