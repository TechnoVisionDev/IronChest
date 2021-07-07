package com.technovision.ironchest.blocks;

import com.technovision.ironchest.IronChests;
import com.technovision.ironchest.blocks.blockentities.*;
import com.technovision.ironchest.registry.ModBlockEntityType;
import com.technovision.ironchest.registry.ModBlocks;
import com.technovision.ironchest.registry.ModItems;
import com.technovision.ironchest.registry.ModScreenHandlerType;
import com.technovision.ironchest.screenhandlers.ExtraChestScreenHandler;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public enum ExtraChestTypes {

    IRON(54, 9, new Identifier(IronChests.MOD_ID, "entity/chest/iron_chest")),
    GOLD(81, 9, new Identifier(IronChests.MOD_ID, "entity/chest/gold_chest")),
    DIAMOND(108, 12, new Identifier(IronChests.MOD_ID, "entity/chest/diamond_chest")),
    COPPER(45, 9, new Identifier(IronChests.MOD_ID, "entity/chest/copper_chest")),
    SILVER(72, 9, new Identifier(IronChests.MOD_ID, "entity/chest/silver_chest")),
    CRYSTAL(108, 12, new Identifier(IronChests.MOD_ID, "entity/chest/crystal_chest")),
    OBSIDIAN(108, 12, new Identifier(IronChests.MOD_ID, "entity/chest/obsidian_chest")),
    DIRT(1, 1, new Identifier(IronChests.MOD_ID, "entity/chest/dirt_chest")),
    HOLIDAY(27, 9, new Identifier("entity/chest/christmas")),
    WOOD(27, 9, new Identifier("entity/chest/normal"));

    public final int size;
    public final int rowLength;
    public final Identifier texture;

    ExtraChestTypes(int size, int rowLength, Identifier texture) {
        this.size = size;
        this.rowLength = rowLength;
        this.texture = texture;
    }

    public int getRowCount() {
        return this.size / this.rowLength;
    }

    public static Block get(ExtraChestTypes type) {
        switch (type) {
            case IRON:
                return ModBlocks.IRON_CHEST;
            case GOLD:
                return ModBlocks.GOLD_CHEST;
            case DIAMOND:
                return ModBlocks.DIAMOND_CHEST;
            case COPPER:
                return ModBlocks.COPPER_CHEST;
            case SILVER:
                return ModBlocks.SILVER_CHEST;
            case CRYSTAL:
                return ModBlocks.CRYSTAL_CHEST;
            case OBSIDIAN:
                return ModBlocks.OBSIDIAN_CHEST;
            case DIRT:
                return ModBlocks.DIRT_CHEST;
            case HOLIDAY:
                return ModBlocks.HOLIDAY_CHEST;
            default:
                return Blocks.CHEST;
        }
    }

    public ChestBlockEntity makeEntity() {
        switch (this) {
            case IRON:
                return ModBlockEntityType.IRON_CHEST.instantiate();
            case GOLD:
                return ModBlockEntityType.GOLD_CHEST.instantiate();
            case DIAMOND:
                return ModBlockEntityType.DIAMOND_CHEST.instantiate();
            case COPPER:
                return ModBlockEntityType.COPPER_CHEST.instantiate();
            case SILVER:
                return ModBlockEntityType.SILVER_CHEST.instantiate();
            case CRYSTAL:
                return ModBlockEntityType.CRYSTAL_CHEST.instantiate();
            case OBSIDIAN:
                return ModBlockEntityType.OBSIDIAN_CHEST.instantiate();
            case DIRT:
                GenericIronChestBlockEntity dirtChest = ModBlockEntityType.DIRT_CHEST.instantiate();
                dirtChest.setStack(0, ModItems.dirtChestGuideBook.copy());
                return dirtChest;
            case HOLIDAY:
                return ModBlockEntityType.HOLIDAY_CHEST.instantiate();
            default:
                return new ChestBlockEntity();
        }
    }

    public ScreenHandlerType<ExtraChestScreenHandler> getScreenHandlerType() {
        switch (this) {
            case IRON:
                return ModScreenHandlerType.IRON_CHEST;
            case GOLD:
                return ModScreenHandlerType.GOLD_CHEST;
            case DIAMOND:
                return ModScreenHandlerType.DIAMOND_CHEST;
            case COPPER:
                return ModScreenHandlerType.COPPER_CHEST;
            case SILVER:
                return ModScreenHandlerType.SILVER_CHEST;
            case CRYSTAL:
                return ModScreenHandlerType.CRYSTAL_CHEST;
            case OBSIDIAN:
                return ModScreenHandlerType.OBSIDIAN_CHEST;
            case DIRT:
                return ModScreenHandlerType.DIRT_CHEST;
            case HOLIDAY:
                return ModScreenHandlerType.HOLIDAY_CHEST;
            default:
                return ModScreenHandlerType.HOLIDAY_CHEST;
        }
    }

    public BlockEntityType<? extends ChestBlockEntity> getBlockEntityType() {
        switch (this) {
            case IRON:
                return ModBlockEntityType.IRON_CHEST;
            case GOLD:
                return ModBlockEntityType.GOLD_CHEST;
            case DIAMOND:
                return ModBlockEntityType.DIAMOND_CHEST;
            case COPPER:
                return ModBlockEntityType.COPPER_CHEST;
            case SILVER:
                return ModBlockEntityType.SILVER_CHEST;
            case CRYSTAL:
                return ModBlockEntityType.CRYSTAL_CHEST;
            case OBSIDIAN:
                return ModBlockEntityType.OBSIDIAN_CHEST;
            case DIRT:
                return ModBlockEntityType.DIRT_CHEST;
            case HOLIDAY:
                return ModBlockEntityType.HOLIDAY_CHEST;
            default:
                return BlockEntityType.CHEST;
        }
    }
}
