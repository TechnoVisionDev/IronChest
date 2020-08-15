package com.technovision.extrachests.blocks;

import com.technovision.extrachests.registry.ModBlockEntityType;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class IronChestBlock extends GenericExtraChestBlock {
    public IronChestBlock() {
        super(FabricBlockSettings.of(Material.METAL)
                .hardness(3.5F)
                .resistance(4.0F)
                .sounds(BlockSoundGroup.METAL)
                .breakByTool(FabricToolTags.PICKAXES, 0)
                .requiresTool(),
                ExtraChestTypes.IRON,
                () -> ModBlockEntityType.IRON_CHEST);
    }
}
