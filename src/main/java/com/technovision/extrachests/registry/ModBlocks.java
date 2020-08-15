package com.technovision.extrachests.registry;

import com.technovision.extrachests.ExtraChests;
import com.technovision.extrachests.blocks.DiamondChestBlock;
import com.technovision.extrachests.blocks.GoldChestBlock;
import com.technovision.extrachests.blocks.IronChestBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block IRON_CHEST = new IronChestBlock();
    public static final Block GOLD_CHEST = new GoldChestBlock();
    public static final Block DIAMOND_CHEST = new DiamondChestBlock();

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(ExtraChests.MOD_ID, "iron_chest"), IRON_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(ExtraChests.MOD_ID, "gold_chest"), GOLD_CHEST);
        Registry.register(Registry.BLOCK, new Identifier(ExtraChests.MOD_ID, "diamond_chest"), DIAMOND_CHEST);
    }

}
