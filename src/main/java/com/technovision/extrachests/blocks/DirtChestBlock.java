package com.technovision.extrachests.blocks;

import com.technovision.extrachests.blocks.blockentities.DirtChestBlockEntity;
import com.technovision.extrachests.registry.ModBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class DirtChestBlock extends GenericExtraChestBlock {

    public DirtChestBlock() {
        super(FabricBlockSettings.of(Material.SOIL)
                        .hardness(1.5F)
                        .resistance(1.5F)
                        .sounds(BlockSoundGroup.GRAVEL),
                ExtraChestTypes.DIRT,
                () -> ModBlockEntityType.DIRT_CHEST);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new DirtChestBlockEntity();
    }
}
