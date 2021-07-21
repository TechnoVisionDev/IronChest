package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CopperChestBlockEntity extends GenericIronChestBlockEntity {

    public CopperChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.COPPER, pos, state);
    }
}
