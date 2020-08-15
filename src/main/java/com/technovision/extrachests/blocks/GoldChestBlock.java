package com.technovision.extrachests.blocks;

import com.technovision.extrachests.blocks.blockentities.GoldChestBlockEntity;
import com.technovision.extrachests.registry.ModBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.world.BlockView;

public class GoldChestBlock extends GenericExtraChestBlock {

    public GoldChestBlock() {
        super(FabricBlockSettings.of(Material.METAL)
                        .hardness(3.5F)
                        .resistance(4.0F)
                        .sounds(BlockSoundGroup.METAL)
                        .breakByTool(FabricToolTags.PICKAXES, 0)
                        .requiresTool(),
                ExtraChestTypes.GOLD,
                () -> ModBlockEntityType.GOLD_CHEST);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new GoldChestBlockEntity();
    }
}
