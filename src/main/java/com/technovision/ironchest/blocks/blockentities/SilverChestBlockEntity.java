package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class SilverChestBlockEntity extends GenericIronChestBlockEntity {

    public SilverChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.SILVER, pos, state);
    }
}
