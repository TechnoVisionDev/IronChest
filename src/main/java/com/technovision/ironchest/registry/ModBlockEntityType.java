package com.technovision.ironchest.registry;

import com.technovision.ironchest.IronChests;
import com.technovision.ironchest.blocks.ExtraChestTypes;
import com.technovision.ironchest.blocks.blockentities.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityType {

    public static final BlockEntityType<GenericIronChestBlockEntity> IRON_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.IRON), ModBlocks.IRON_CHEST).build(null);
    public static final BlockEntityType<GenericIronChestBlockEntity> GOLD_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.GOLD), ModBlocks.GOLD_CHEST).build(null);
    public static final BlockEntityType<GenericIronChestBlockEntity> DIAMOND_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.DIAMOND), ModBlocks.DIAMOND_CHEST).build(null);
    public static final BlockEntityType<GenericIronChestBlockEntity> COPPER_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.COPPER), ModBlocks.COPPER_CHEST).build(null);
    public static final BlockEntityType<GenericIronChestBlockEntity> SILVER_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.SILVER), ModBlocks.SILVER_CHEST).build(null);
    //public static final BlockEntityType<GenericIronChestBlockEntity> CRYSTAL_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.CRYSTAL), ModBlocks.CRYSTAL_CHEST).build(null);
    public static final BlockEntityType<CrystalChestBlockEntity> CRYSTAL_CHEST = BlockEntityType.Builder.create(() -> new CrystalChestBlockEntity(), ModBlocks.CRYSTAL_CHEST).build(null);
    public static final BlockEntityType<GenericIronChestBlockEntity> OBSIDIAN_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.OBSIDIAN), ModBlocks.OBSIDIAN_CHEST).build(null);
    public static final BlockEntityType<GenericIronChestBlockEntity> HOLIDAY_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.HOLIDAY), ModBlocks.HOLIDAY_CHEST).build(null);
    public static final BlockEntityType<GenericIronChestBlockEntity> DIRT_CHEST = BlockEntityType.Builder.create(() -> new GenericIronChestBlockEntity(ExtraChestTypes.DIRT), ModBlocks.DIRT_CHEST).build(null);

    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "iron_chest"), IRON_CHEST);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "gold_chest"), GOLD_CHEST);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "diamond_chest"), DIAMOND_CHEST);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "copper_chest"), COPPER_CHEST);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "silver_chest"), SILVER_CHEST);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "crystal_chest"), CRYSTAL_CHEST);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "obsidian_chest"), OBSIDIAN_CHEST);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "holiday_chest"), HOLIDAY_CHEST);
        Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(IronChests.MOD_ID, "dirt_chest"), DIRT_CHEST);
    }
}
