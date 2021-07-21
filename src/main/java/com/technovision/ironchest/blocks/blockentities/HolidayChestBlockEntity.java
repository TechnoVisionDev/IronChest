package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class HolidayChestBlockEntity extends GenericIronChestBlockEntity {

    public HolidayChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.HOLIDAY, pos, state);
    }
}
