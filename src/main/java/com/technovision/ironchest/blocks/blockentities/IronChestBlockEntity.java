package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class IronChestBlockEntity extends GenericIronChestBlockEntity {

    public IronChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.IRON, pos, state);
    }
}
