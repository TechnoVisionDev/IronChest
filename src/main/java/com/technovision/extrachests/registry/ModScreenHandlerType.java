package com.technovision.extrachests.registry;

import com.technovision.extrachests.ExtraChests;
import com.technovision.extrachests.blocks.ExtraChestTypes;
import com.technovision.extrachests.screenhandlers.ExtraChestScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlerType {

    public static ScreenHandlerType<ExtraChestScreenHandler> IRON_CHEST;
    public static ScreenHandlerType<ExtraChestScreenHandler> GOLD_CHEST;
    public static ScreenHandlerType<ExtraChestScreenHandler> DIAMOND_CHEST;
    public static ScreenHandlerType<ExtraChestScreenHandler> COPPER_CHEST;
    public static ScreenHandlerType<ExtraChestScreenHandler> SILVER_CHEST;
    public static ScreenHandlerType<ExtraChestScreenHandler> CRYSTAL_CHEST;
    public static ScreenHandlerType<ExtraChestScreenHandler> OBSIDIAN_CHEST;
    public static ScreenHandlerType<ExtraChestScreenHandler> HOLIDAY_CHEST;

    public static void registerScreenHandlers() {
        IRON_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(ExtraChests.MOD_ID, "iron_chest"), (syncId, inventory) -> new ExtraChestScreenHandler(IRON_CHEST, ExtraChestTypes.IRON, syncId, inventory, ScreenHandlerContext.EMPTY));
        GOLD_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(ExtraChests.MOD_ID, "gold_chest"), (syncId, inventory) -> new ExtraChestScreenHandler(GOLD_CHEST, ExtraChestTypes.GOLD, syncId, inventory, ScreenHandlerContext.EMPTY));
        DIAMOND_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(ExtraChests.MOD_ID, "diamond_chest"), (syncId, inventory) -> new ExtraChestScreenHandler(DIAMOND_CHEST, ExtraChestTypes.DIAMOND, syncId, inventory, ScreenHandlerContext.EMPTY));
        COPPER_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(ExtraChests.MOD_ID, "copper_chest"), (syncId, inventory) -> new ExtraChestScreenHandler(COPPER_CHEST, ExtraChestTypes.COPPER, syncId, inventory, ScreenHandlerContext.EMPTY));
        SILVER_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(ExtraChests.MOD_ID, "silver_chest"), (syncId, inventory) -> new ExtraChestScreenHandler(SILVER_CHEST, ExtraChestTypes.SILVER, syncId, inventory, ScreenHandlerContext.EMPTY));
        CRYSTAL_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(ExtraChests.MOD_ID, "crystal_chest"), (syncId, inventory) -> new ExtraChestScreenHandler(CRYSTAL_CHEST, ExtraChestTypes.CRYSTAL, syncId, inventory, ScreenHandlerContext.EMPTY));
        OBSIDIAN_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(ExtraChests.MOD_ID, "obsidian_chest"), (syncId, inventory) -> new ExtraChestScreenHandler(OBSIDIAN_CHEST, ExtraChestTypes.OBSIDIAN, syncId, inventory, ScreenHandlerContext.EMPTY));
        HOLIDAY_CHEST = ScreenHandlerRegistry.registerSimple(new Identifier(ExtraChests.MOD_ID, "holiday_chest"), (syncId, inventory) -> new ExtraChestScreenHandler(HOLIDAY_CHEST, ExtraChestTypes.HOLIDAY, syncId, inventory, ScreenHandlerContext.EMPTY));
    }
}
