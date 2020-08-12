package com.technovision.extrachests;

import com.technovision.extrachests.gui.IronChestDescription;
import com.technovision.extrachests.registry.ModScreenHandlerType;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class ExtraChestsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.<IronChestDescription, CottonInventoryScreen<IronChestDescription>>register(ModScreenHandlerType.IRON_CHEST,
                (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
    }
}
