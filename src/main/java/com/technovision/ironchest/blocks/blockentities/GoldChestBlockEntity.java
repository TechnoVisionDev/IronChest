package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class GoldChestBlockEntity extends GenericIronChestBlockEntity {

    public GoldChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.GOLD, pos, state);
    }
}
