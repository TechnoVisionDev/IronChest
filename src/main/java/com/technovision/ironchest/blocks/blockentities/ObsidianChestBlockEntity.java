package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class ObsidianChestBlockEntity extends GenericIronChestBlockEntity {

    public ObsidianChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.OBSIDIAN, pos, state);
    }
}
