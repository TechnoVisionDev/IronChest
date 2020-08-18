package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import com.technovision.ironchest.registry.ModBlockEntityType;

public class IronChestBlockEntity extends GenericIronChestBlockEntity {

    public IronChestBlockEntity() {
        super(ModBlockEntityType.IRON_CHEST, ExtraChestTypes.IRON);
    }
}
