package com.technovision.extrachests.registry;

import com.technovision.extrachests.ExtraChests;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item IRON_CHEST = new BlockItem(ModBlocks.IRON_CHEST, new Item.Settings().group(ExtraChests.TAB));
    public static final Item GOLD_CHEST = new BlockItem(ModBlocks.GOLD_CHEST, new Item.Settings().group(ExtraChests.TAB));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "iron_chest"), IRON_CHEST);
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "gold_chest"), GOLD_CHEST);
    }
}
