package com.technovision.ironchest.items;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import static com.technovision.ironchest.blocks.ExtraChestTypes.*;

public enum IronChestsUpgradeType {

    IRON_TO_GOLD(IRON, GOLD),
    GOLD_TO_DIAMOND(GOLD, DIAMOND),
    COPPER_TO_SILVER(COPPER, SILVER),
    SILVER_TO_GOLD(SILVER, GOLD),
    COPPER_TO_IRON(COPPER, IRON),
    DIAMOND_TO_CRYSTAL(DIAMOND, CRYSTAL),
    WOOD_TO_IRON(WOOD, IRON),
    WOOD_TO_COPPER(WOOD, COPPER),
    DIAMOND_TO_OBSIDIAN(DIAMOND, OBSIDIAN);

    public final ExtraChestTypes source;
    public final ExtraChestTypes target;

    IronChestsUpgradeType(ExtraChestTypes source, ExtraChestTypes target) {
        this.source = source;
        this.target = target;
    }

    public boolean canUpgrade(ExtraChestTypes from) {
        return from == this.source;
    }
}
