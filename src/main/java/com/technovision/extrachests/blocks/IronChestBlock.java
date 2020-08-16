package com.technovision.extrachests.blocks;

import com.technovision.extrachests.registry.ModBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class IronChestBlock extends GenericExtraChestBlock {
    public IronChestBlock() {
        super(FabricBlockSettings.of(Material.STONE)
                .hardness(3.0F)
                .resistance(3.0F)
                .sounds(BlockSoundGroup.STONE)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool(),
                ExtraChestTypes.IRON,
                () -> ModBlockEntityType.IRON_CHEST);
    }
}
