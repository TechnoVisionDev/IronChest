package com.technovision.extrachests;

import com.technovision.extrachests.gui.IronChestDescription;
import com.technovision.extrachests.registry.ModBlockEntityType;
import com.technovision.extrachests.registry.ModScreenHandlerType;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;

public class ExtraChestsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.<IronChestDescription, CottonInventoryScreen<IronChestDescription>>register(ModScreenHandlerType.IRON_CHEST,
                (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.IRON_CHEST, ChestBlockEntityRenderer::new);
    }

}
