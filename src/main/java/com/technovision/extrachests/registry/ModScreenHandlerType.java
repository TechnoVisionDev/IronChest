package com.technovision.extrachests.registry;

import com.technovision.extrachests.blocks.IronChestBlock;
import com.technovision.extrachests.gui.IronChestDescription;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class ModScreenHandlerType {

    public static ScreenHandlerType<IronChestDescription> IRON_CHEST;

    public static void registerScreenHandlers() {
        IRON_CHEST = ScreenHandlerRegistry.registerSimple(IronChestBlock.ID, (syncId, inventory) -> new IronChestDescription(IRON_CHEST, syncId, inventory, ScreenHandlerContext.EMPTY));
    }
}
