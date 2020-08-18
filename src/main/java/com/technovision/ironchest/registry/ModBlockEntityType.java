package com.technovision.ironchest.registry;

import com.technovision.ironchest.IronChests;
import com.technovision.ironchest.blocks.blockentities.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityType {

    public static final BlockEntityType<IronChestBlockEntity> IRON_CHEST = BlockEntityType.Builder.create(IronChestBlockEntity::new, ModBlocks.IRON_CHEST).build(null);
    public static final BlockEntityType<GoldChestBlockEntity> GOLD_CHEST = BlockEntityType.Builder.create(GoldChestBlockEntity::new, ModBlocks.GOLD_CHEST).build(null);
    public static final BlockEntityType<DiamondChestBlockEntity> DIAMOND_CHEST = BlockEntityType.Builder.create(DiamondChestBlockEntity::new, ModBlocks.DIAMOND_CHEST).build(null);
    public static final BlockEntityType<CopperChestBlockEntity> COPPER_CHEST = BlockEntityType.Builder.create(CopperChestBlockEntity::new, ModBlocks.COPPER_CHEST).build(null);
    public static final BlockEntityType<SilverChestBlockEntity> SILVER_CHEST = BlockEntityType.Builder.create(SilverChestBlockEntity::new, ModBlocks.SILVER_CHEST).build(null);
    public static final BlockEntityType<CrystalChestBlockEntity> CRYSTAL_CHEST = BlockEntityType.Builder.create(CrystalChestBlockEntity::new, ModBlocks.CRYSTAL_CHEST).build(null);
    public static final BlockEntityType<ObsidianChestBlockEntity> OBSIDIAN_CHEST = BlockEntityType.Builder.create(ObsidianChestBlockEntity::new, ModBlocks.OBSIDIAN_CHEST).build(null);
    public static final BlockEntityType<HolidayChestBlockEntity> HOLIDAY_CHEST = BlockEntityType.Builder.create(HolidayChestBlockEntity::new, ModBlocks.HOLIDAY_CHEST).build(null);
    public static final BlockEntityType<DirtChestBlockEntity> DIRT_CHEST = BlockEntityType.Builder.create(DirtChestBlockEntity::new, ModBlocks.DIRT_CHEST).build(null);

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
