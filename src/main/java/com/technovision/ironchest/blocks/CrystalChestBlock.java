package com.technovision.ironchest.blocks;

import com.technovision.ironchest.blocks.blockentities.CrystalChestBlockEntity;
import com.technovision.ironchest.blocks.blockentities.GenericIronChestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.World;

public class CrystalChestBlock extends GenericIronChestBlock {

    public CrystalChestBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .hardness(3.0F)
                .resistance(3.0F)
                .sounds(BlockSoundGroup.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool(),
                ExtraChestTypes.CRYSTAL);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        if (type != this.getType().getBlockEntityType()){ return null; }
        return world.isClient ? (world1, pos, state1, blockEntity) -> ((GenericIronChestBlockEntity)blockEntity).clientTick() : (world1, pos, state1, blockEntity) -> ((CrystalChestBlockEntity)blockEntity).tick();
    }
}
