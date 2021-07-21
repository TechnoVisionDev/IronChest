package com.technovision.ironchest.blocks;

import com.technovision.ironchest.IronChests;
import com.technovision.ironchest.registry.ModBlockEntityType;
import com.technovision.ironchest.registry.ModBlocks;
import com.technovision.ironchest.registry.ModScreenHandlerType;
import com.technovision.ironchest.screenhandlers.ExtraChestScreenHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public enum ExtraChestTypes {

    IRON(54, 9, new Identifier(IronChests.MOD_ID, "entity/chest/iron_chest")),
    GOLD(81, 9, new Identifier(IronChests.MOD_ID, "entity/chest/gold_chest")),
    DIAMOND(108, 12, new Identifier(IronChests.MOD_ID, "entity/chest/diamond_chest")),
    COPPER(45, 9, new Identifier(IronChests.MOD_ID, "entity/chest/copper_chest")),
    SILVER(72, 9, new Identifier(IronChests.MOD_ID, "entity/chest/silver_chest")),
    CRYSTAL(108, 12, new Identifier(IronChests.MOD_ID, "entity/chest/crystal_chest")),
    OBSIDIAN(108, 12, new Identifier(IronChests.MOD_ID,"entity/chest/obsidian_chest")),
    DIRT(1, 1, new Identifier(IronChests.MOD_ID, "entity/chest/dirt_chest")),
    HOLIDAY(27, 9, new Identifier("entity/chest/christmas")),
    WOOD(0, 0, new Identifier(IronChests.MOD_ID, ("entity/chest/dirt_chest")));

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
        return switch (type) {
            case IRON -> ModBlocks.IRON_CHEST;
            case GOLD -> ModBlocks.GOLD_CHEST;
            case DIAMOND -> ModBlocks.DIAMOND_CHEST;
            case COPPER -> ModBlocks.COPPER_CHEST;
            case SILVER -> ModBlocks.SILVER_CHEST;
            case CRYSTAL -> ModBlocks.CRYSTAL_CHEST;
            case OBSIDIAN -> ModBlocks.OBSIDIAN_CHEST;
            case HOLIDAY -> ModBlocks.HOLIDAY_CHEST;
            case DIRT -> ModBlocks.DIRT_CHEST;
            default -> Blocks.CHEST;
        };
    }

    public ChestBlockEntity getEntity(BlockPos pos, BlockState state) {
        return switch (this) {
            case IRON -> ModBlockEntityType.IRON_CHEST.instantiate(pos, state);
            case GOLD -> ModBlockEntityType.GOLD_CHEST.instantiate(pos, state);
            case DIAMOND -> ModBlockEntityType.DIAMOND_CHEST.instantiate(pos, state);
            case COPPER -> ModBlockEntityType.COPPER_CHEST.instantiate(pos, state);
            case SILVER -> ModBlockEntityType.SILVER_CHEST.instantiate(pos, state);
            case CRYSTAL -> ModBlockEntityType.CRYSTAL_CHEST.instantiate(pos, state);
            case OBSIDIAN -> ModBlockEntityType.OBSIDIAN_CHEST.instantiate(pos, state);
            case HOLIDAY -> ModBlockEntityType.HOLIDAY_CHEST.instantiate(pos, state);
            case DIRT -> ModBlockEntityType.DIRT_CHEST.instantiate(pos, state);
            default -> new ChestBlockEntity(pos, state);
        };
    }

    public BlockEntityType<? extends ChestBlockEntity> getBlockEntityType() {
        return switch (this) {
            case IRON -> ModBlockEntityType.IRON_CHEST;
            case GOLD -> ModBlockEntityType.GOLD_CHEST;
            case DIAMOND -> ModBlockEntityType.DIAMOND_CHEST;
            case COPPER -> ModBlockEntityType.COPPER_CHEST;
            case SILVER -> ModBlockEntityType.SILVER_CHEST;
            case CRYSTAL -> ModBlockEntityType.CRYSTAL_CHEST;
            case OBSIDIAN -> ModBlockEntityType.OBSIDIAN_CHEST;
            case HOLIDAY -> ModBlockEntityType.HOLIDAY_CHEST;
            case DIRT -> ModBlockEntityType.DIRT_CHEST;
            default -> BlockEntityType.CHEST;
        };
    }

    public ScreenHandlerType<ExtraChestScreenHandler> getScreenHandlerType() {
        return switch (this) {
            case IRON -> ModScreenHandlerType.IRON_CHEST;
            case GOLD -> ModScreenHandlerType.GOLD_CHEST;
            case DIAMOND -> ModScreenHandlerType.DIAMOND_CHEST;
            case COPPER -> ModScreenHandlerType.COPPER_CHEST;
            case SILVER -> ModScreenHandlerType.SILVER_CHEST;
            case CRYSTAL -> ModScreenHandlerType.CRYSTAL_CHEST;
            case OBSIDIAN -> ModScreenHandlerType.OBSIDIAN_CHEST;
            case DIRT -> ModScreenHandlerType.DIRT_CHEST;
            default -> ModScreenHandlerType.HOLIDAY_CHEST;
        };
    }
}
