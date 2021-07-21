package com.technovision.ironchest.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class DirtChestBlock extends GenericIronChestBlock {

    public DirtChestBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .hardness(1.5F)
                .resistance(1.5F)
                .sounds(BlockSoundGroup.STONE),
                ExtraChestTypes.DIRT);
    }
}
