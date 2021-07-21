package com.technovision.ironchest.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ObsidianChestBlock extends GenericIronChestBlock {

    public ObsidianChestBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .hardness(3.0F)
                .resistance(10000.0F)
                .sounds(BlockSoundGroup.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool(),
                ExtraChestTypes.OBSIDIAN);
    }
}
