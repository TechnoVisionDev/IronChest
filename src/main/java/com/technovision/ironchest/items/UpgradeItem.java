package com.technovision.ironchest.items;

import com.technovision.ironchest.IronChests;
import net.minecraft.item.Item;

public class UpgradeItem extends Item {

    IronChestsUpgradeType type;

    public UpgradeItem(IronChestsUpgradeType type) {
        super(new Item.Settings().group(IronChests.TAB));
        this.type = type;
    }
}
