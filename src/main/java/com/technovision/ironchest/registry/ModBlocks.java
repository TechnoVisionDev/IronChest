package com.technovision.ironchest.registry;

import com.technovision.ironchest.IronChests;
import com.technovision.ironchest.blocks.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final FabricBlockSettings genericChestBlockSettings = FabricBlockSettings.of(Material.STONE)
            .hardness(3.0F)
            .resistance(3.0F)
            .sounds(BlockSoundGroup.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool();

    public static final Block IRON_CHEST = new GenericIronChestBlock(genericChestBlockSettings, ExtraChestTypes.IRON);
    public static final Block GOLD_CHEST = new GenericIronChestBlock(genericChestBlockSettings, ExtraChestTypes.GOLD);
    public static final Block DIAMOND_CHEST = new GenericIronChestBlock(genericChestBlockSettings, ExtraChestTypes.DIAMOND);
    public static final Block COPPER_CHEST = new GenericIronChestBlock(genericChestBlockSettings, ExtraChestTypes.COPPER);
    public static final Block SILVER_CHEST = new GenericIronChestBlock(genericChestBlockSettings, ExtraChestTypes.SILVER);
    public static final Block CRYSTAL_CHEST = new GenericIronChestBlock(genericChestBlockSettings, ExtraChestTypes.CRYSTAL);
    public static final Block OBSIDIAN_CHEST = new GenericIronChestBlock(FabricBlockSettings.of(Material.STONE)
            .hardness(3.0F)
            .resistance(10000.0F)
            .sounds(BlockSoundGroup.STONE)
            .breakByTool(FabricToolTags.PICKAXES, 0)
            .requiresTool(),
            ExtraChestTypes.OBSIDIAN);
    public static final Block HOLIDAY_CHEST = new GenericIronChestBlock(FabricBlockSettings.of(Material.WOOD)
            .hardness(3.0F)
            .resistance(3.0F)
            .sounds(BlockSoundGroup.WOOD)
            .breakByTool(FabricToolTags.AXES, 0)
            .requiresTool(),
            ExtraChestTypes.HOLIDAY);
    public static final Block DIRT_CHEST = new GenericIronChestBlock(FabricBlockSettings.of(Material.STONE)
            .hardness(1.5F)
            .resistance(1.5F)
            .sounds(BlockSoundGroup.STONE),
            ExtraChestTypes.DIRT);

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "iron_chest"), IRON_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "gold_chest"), GOLD_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "diamond_chest"), DIAMOND_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "copper_chest"), COPPER_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "silver_chest"), SILVER_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "crystal_chest"), CRYSTAL_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "obsidian_chest"), OBSIDIAN_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "holiday_chest"), HOLIDAY_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(IronChests.MOD_ID, "dirt_chest"), DIRT_CHEST);
    }

}
