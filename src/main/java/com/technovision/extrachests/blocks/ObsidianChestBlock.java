package com.technovision.extrachests.blocks;

import com.technovision.extrachests.blocks.blockentities.ObsidianChestBlockEntity;
import com.technovision.extrachests.registry.ModBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class ObsidianChestBlock extends GenericExtraChestBlock {

    public ObsidianChestBlock() {
        super(FabricBlockSettings.of(Material.METAL)
                        .hardness(3.0F)
                        .resistance(10000.0F)
                        .sounds(BlockSoundGroup.METAL)
                        .breakByTool(FabricToolTags.PICKAXES, 0)
                        .requiresTool(),
                ExtraChestTypes.OBSIDIAN,
                () -> ModBlockEntityType.OBSIDIAN_CHEST);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new ObsidianChestBlockEntity();
    }
}
