package com.technovision.extrachests.blocks.blockentities;

import com.technovision.extrachests.blocks.ExtraChestTypes;
import com.technovision.extrachests.registry.ModBlockEntityType;

public class IronChestBlockEntity extends GenericExtraChestBlockEntity {

    public IronChestBlockEntity() {
        super(ModBlockEntityType.IRON_CHEST, ExtraChestTypes.IRON);
    }
}
