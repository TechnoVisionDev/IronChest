package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class DiamondChestBlockEntity extends GenericIronChestBlockEntity {

    public DiamondChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.DIAMOND, pos, state);
    }
}
