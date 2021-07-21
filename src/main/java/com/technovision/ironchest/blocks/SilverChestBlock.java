package com.technovision.ironchest.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class SilverChestBlock extends GenericIronChestBlock {

    public SilverChestBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .hardness(3.0F)
                .resistance(3.0F)
                .sounds(BlockSoundGroup.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool(),
                ExtraChestTypes.SILVER);
    }
}
