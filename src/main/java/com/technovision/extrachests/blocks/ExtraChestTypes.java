package com.technovision.extrachests.blocks;

import com.technovision.extrachests.ExtraChests;
import net.minecraft.util.Identifier;

public enum ExtraChestTypes {

    IRON(54, 9, 184, 222, new Identifier(ExtraChests.MOD_ID, "entity/chest/iron_chest"), 256, 256),
    GOLD(81, 9, 184, 276, new Identifier(ExtraChests.MOD_ID, "entity/chest/gold_chest"), 256, 276),
    DIAMOND(108, 12, 238, 276, new Identifier(ExtraChests.MOD_ID, "entity/chest/diamond_chest"), 256, 276),
    COPPER(45, 9, 184, 204, new Identifier(ExtraChests.MOD_ID, "entity/chest/copper_chest_chest"), 256, 256),
    SILVER(72, 9, 184, 258, new Identifier(ExtraChests.MOD_ID, "entity/chest/silver_chest_chest"), 256, 276),
    CRYSTAL(108, 12, 238, 276, new Identifier(ExtraChests.MOD_ID, "entity/chest/crystal_chest"), 256, 276),
    OBSIDIAN(108, 12, 238, 276, new Identifier(ExtraChests.MOD_ID,"entity/chest/obsidian_chest"), 256, 276),
    DIRT(1, 1, 184, 184, new Identifier(ExtraChests.MOD_ID, "entity/chest/dirt_chest"), 256, 256),
    WOOD(0, 0, 0, 0, new Identifier(ExtraChests.MOD_ID, "entity/chest/wood_chest"), 0, 0);

    private final String name;
    public final int size;
    public final int rowLength;
    public final int xSize;
    public final int ySize;
    public final Identifier texture;
    public final int textureXSize;
    public final int textureYSize;

    ExtraChestTypes(int size, int rowLength, int xSize, int ySize, Identifier texture, int textureXSize, int textureYSize) {
        this(null, size, rowLength, xSize, ySize, texture, textureXSize, textureYSize);
    }

    ExtraChestTypes(String name, int size, int rowLength, int xSize, int ySize, Identifier texture, int textureXSize, int textureYSize) {
        this.name = name;
        this.size = size;
        this.rowLength = rowLength;
        this.xSize = xSize;
        this.ySize = ySize;
        this.texture = texture;
        this.textureXSize = textureXSize;
        this.textureYSize = textureYSize;
    }

    public int getRowCount() {
        return this.size / this.rowLength;
    }
}
