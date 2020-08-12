package com.technovision.extrachests.registry;

import com.technovision.extrachests.ExtraChests;
import com.technovision.extrachests.blocks.IronChestBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block IRON_CHEST = new IronChestBlock();

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(ExtraChests.MOD_ID, "iron_chest"), IRON_CHEST);
    }

}
