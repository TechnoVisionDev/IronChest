package com.modderminer.extrachests.registry;

import com.modderminer.extrachests.ExtraChests;
import com.modderminer.extrachests.blocks.IronChestBlock;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block IRON_CHEST = new IronChestBlock(ModBlockEntityType.IRON_CHEST);

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(ExtraChests.MOD_ID, "iron_chest"), IRON_CHEST);
    }

}
