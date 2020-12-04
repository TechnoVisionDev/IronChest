package com.technovision.ironchest.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class GenericIronChestBlock extends ChestBlock {

    private final ExtraChestTypes type;

    public GenericIronChestBlock(FabricBlockSettings settings, ExtraChestTypes type) {
        super(settings, () -> type.getBlockEntityType());
        this.type = type;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return this.type.makeEntity();
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerFacing().getOpposite();
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return this.getDefaultState().with(FACING, direction).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
    }

    public ExtraChestTypes getType() {
        return type;
    }

}