package com.technovision.extrachests.registry;

import com.technovision.extrachests.blocks.blockentities.IronChestBlockEntity;
import com.technovision.extrachests.blocks.IronChestBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class ModBlockEntityType {

    public static final BlockEntityType<IronChestBlockEntity> IRON_CHEST =
            BlockEntityType.Builder.create(IronChestBlockEntity::new, ModBlocks.IRON_CHEST).build(null);

    public static void registerBlockEntities() {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, IronChestBlock.ID, IRON_CHEST);
    }
}
