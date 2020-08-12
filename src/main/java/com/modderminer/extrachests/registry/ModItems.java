package com.modderminer.extrachests.registry;

import com.modderminer.extrachests.ExtraChests;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item IRON_CHEST = new BlockItem(ModBlocks.IRON_CHEST, new Item.Settings().group(ExtraChests.TAB));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(ExtraChests.MOD_ID, "iron_chest"), IRON_CHEST);
    }
}
