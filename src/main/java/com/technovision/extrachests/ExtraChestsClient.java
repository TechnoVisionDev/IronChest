package com.technovision.extrachests;

import com.technovision.extrachests.client.ExtraChestBlockEntityRenderer;
import com.technovision.extrachests.screenhandlers.ExtraChestScreenHandler;
import com.technovision.extrachests.registry.ModBlockEntityType;
import com.technovision.extrachests.registry.ModScreenHandlerType;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.minecraft.client.render.TexturedRenderLayers;

import net.minecraft.util.Identifier;

public class ExtraChestsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.IRON_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.GOLD_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));

        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.IRON_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.GOLD_CHEST, ExtraChestBlockEntityRenderer::new);

        //Register Textures to Chest Atlas
        ClientSpriteRegistryCallback.event(TexturedRenderLayers.CHEST_ATLAS_TEXTURE).register((texture, registry) -> {
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/iron_chest"));
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/gold_chest"));
        });
    }

}
