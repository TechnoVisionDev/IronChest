package com.technovision.ironchest.blocks;

import com.technovision.ironchest.blocks.blockentities.DirtChestBlockEntity;
import com.technovision.ironchest.registry.ModBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class DirtChestBlock extends GenericIronChestBlock {

    public DirtChestBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                        .hardness(1.5F)
                        .resistance(1.5F)
                        .sounds(BlockSoundGroup.STONE),
                ExtraChestTypes.DIRT,
                () -> ModBlockEntityType.DIRT_CHEST);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new DirtChestBlockEntity();
    }
}
