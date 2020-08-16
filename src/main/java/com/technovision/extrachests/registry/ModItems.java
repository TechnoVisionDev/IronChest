package com.technovision.extrachests.registry;

import com.technovision.extrachests.ExtraChests;
import com.technovision.extrachests.blocks.ExtraChestTypes;
import com.technovision.extrachests.items.UpgradeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    // Chest Items
    public static final Item IRON_CHEST = new BlockItem(ModBlocks.IRON_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item GOLD_CHEST = new BlockItem(ModBlocks.GOLD_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item DIAMOND_CHEST = new BlockItem(ModBlocks.DIAMOND_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item COPPER_CHEST = new BlockItem(ModBlocks.COPPER_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item SILVER_CHEST = new BlockItem(ModBlocks.SILVER_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item CRYSTAL_CHEST = new BlockItem(ModBlocks.CRYSTAL_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item OBSIDIAN_CHEST = new BlockItem(ModBlocks.OBSIDIAN_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item HOLIDAY_CHEST = new BlockItem(ModBlocks.HOLIDAY_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item DIRT_CHEST = new BlockItem(ModBlocks.DIRT_CHEST, new Item.Settings().group(ExtraChests.TAB));

    // Upgrade Items
    public static final Item WOOD_IRON_UPGRADE = new UpgradeItem(ExtraChestTypes.IRON);
    public static final Item WOOD_COPPER_UPGRADE = new UpgradeItem(ExtraChestTypes.COPPER);
    public static final Item COPPER_SILVER_UPGRADE = new UpgradeItem(ExtraChestTypes.SILVER);
    public static final Item COPPER_IRON_UPGRADE = new UpgradeItem(ExtraChestTypes.IRON);
    public static final Item SILVER_GOLD_UPGRADE = new UpgradeItem(ExtraChestTypes.GOLD);
    public static final Item IRON_GOLD_UPGRADE = new UpgradeItem(ExtraChestTypes.GOLD);
    public static final Item GOLD_DIAMOND_UPGRADE = new UpgradeItem(ExtraChestTypes.DIAMOND);
    public static final Item DIAMOND_CRYSTAL_UPGRADE = new UpgradeItem(ExtraChestTypes.CRYSTAL);
    public static final Item DIAMOND_OBSIDIAN_UPGRADE = new UpgradeItem(ExtraChestTypes.OBSIDIAN);

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "iron_chest"), IRON_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "gold_chest"), GOLD_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "diamond_chest"), DIAMOND_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "copper_chest"), COPPER_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "silver_chest"), SILVER_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "crystal_chest"), CRYSTAL_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "obsidian_chest"), OBSIDIAN_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "holiday_chest"), HOLIDAY_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "dirt_chest"), DIRT_CHEST);

        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "wood_iron_upgrade"), WOOD_IRON_UPGRADE);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "wood_copper_upgrade"), WOOD_COPPER_UPGRADE);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "copper_silver_upgrade"), COPPER_SILVER_UPGRADE);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "copper_iron_upgrade"), COPPER_IRON_UPGRADE);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "silver_gold_upgrade"), SILVER_GOLD_UPGRADE);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "iron_gold_upgrade"), IRON_GOLD_UPGRADE);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "gold_diamond_upgrade"), GOLD_DIAMOND_UPGRADE);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "diamond_crystal_upgrade"), DIAMOND_CRYSTAL_UPGRADE);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "diamond_obsidian_upgrade"), DIAMOND_OBSIDIAN_UPGRADE);
    }
}
