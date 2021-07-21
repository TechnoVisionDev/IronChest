package com.technovision.ironchest.registry;

import com.technovision.ironchest.IronChests;
import com.technovision.ironchest.blocks.blockentities.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityType {

    public static final BlockEntityType<IronChestBlockEntity> IRON_CHEST = FabricBlockEntityTypeBuilder.create(IronChestBlockEntity::new, ModBlocks.IRON_CHEST).build(null);
    public static final BlockEntityType<GoldChestBlockEntity> GOLD_CHEST = FabricBlockEntityTypeBuilder.create(GoldChestBlockEntity::new, ModBlocks.GOLD_CHEST).build(null);
    public static final BlockEntityType<DiamondChestBlockEntity> DIAMOND_CHEST = FabricBlockEntityTypeBuilder.create(DiamondChestBlockEntity::new, ModBlocks.DIAMOND_CHEST).build(null);
    public static final BlockEntityType<CopperChestBlockEntity> COPPER_CHEST = FabricBlockEntityTypeBuilder.create(CopperChestBlockEntity::new, ModBlocks.COPPER_CHEST).build(null);
    public static final BlockEntityType<SilverChestBlockEntity> SILVER_CHEST = FabricBlockEntityTypeBuilder.create(SilverChestBlockEntity::new, ModBlocks.SILVER_CHEST).build(null);
    public static final BlockEntityType<CrystalChestBlockEntity> CRYSTAL_CHEST = FabricBlockEntityTypeBuilder.create(CrystalChestBlockEntity::new, ModBlocks.CRYSTAL_CHEST).build(null);
    public static final BlockEntityType<ObsidianChestBlockEntity> OBSIDIAN_CHEST = FabricBlockEntityTypeBuilder.create(ObsidianChestBlockEntity::new, ModBlocks.OBSIDIAN_CHEST).build(null);
    public static final BlockEntityType<HolidayChestBlockEntity> HOLIDAY_CHEST = FabricBlockEntityTypeBuilder.create(HolidayChestBlockEntity::new, ModBlocks.HOLIDAY_CHEST).build(null);
    public static final BlockEntityType<DirtChestBlockEntity> DIRT_CHEST = FabricBlockEntityTypeBuilder.create(DirtChestBlockEntity::new, ModBlocks.DIRT_CHEST).build(null);

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
