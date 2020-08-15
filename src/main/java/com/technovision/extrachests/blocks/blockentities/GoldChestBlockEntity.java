package com.technovision.extrachests.blocks.blockentities;

import com.technovision.extrachests.blocks.ExtraChestTypes;
import com.technovision.extrachests.registry.ModBlockEntityType;
import com.technovision.extrachests.registry.ModScreenHandlerType;
import com.technovision.extrachests.screenhandlers.ExtraChestScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;

public class GoldChestBlockEntity extends GenericExtraChestBlockEntity {

    public GoldChestBlockEntity() {
        super(ModBlockEntityType.GOLD_CHEST, ExtraChestTypes.GOLD);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new ExtraChestScreenHandler(ModScreenHandlerType.GOLD_CHEST, type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory inventory) {
        return new ExtraChestScreenHandler(ModScreenHandlerType.GOLD_CHEST, type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }
}
