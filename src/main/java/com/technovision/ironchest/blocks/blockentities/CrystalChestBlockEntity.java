package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class CrystalChestBlockEntity extends GenericIronChestBlockEntity {

    public CrystalChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.CRYSTAL, pos, state);
    }
}
