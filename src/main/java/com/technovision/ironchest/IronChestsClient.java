package com.technovision.ironchest;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import com.technovision.ironchest.blocks.blockentities.CrystalChestBlockEntity;
import com.technovision.ironchest.client.ChestEntityRenderer;
import com.technovision.ironchest.registry.ModBlockEntityType;
import com.technovision.ironchest.registry.ModScreenHandlerType;
import com.technovision.ironchest.screenhandlers.ExtraChestScreenHandler;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class IronChestsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.IRON_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.GOLD_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.DIAMOND_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.COPPER_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.SILVER_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.CRYSTAL_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.OBSIDIAN_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.HOLIDAY_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));
        ScreenRegistry.<ExtraChestScreenHandler, CottonInventoryScreen<ExtraChestScreenHandler>>register(ModScreenHandlerType.DIRT_CHEST, (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title));

        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.IRON_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.GOLD_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.DIAMOND_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.COPPER_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.SILVER_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.CRYSTAL_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.OBSIDIAN_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.HOLIDAY_CHEST, ChestEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.DIRT_CHEST, ChestEntityRenderer::new);

        //Register Textures to Chest Atlas
        ClientSpriteRegistryCallback.event(TexturedRenderLayers.CHEST_ATLAS_TEXTURE).register((texture, registry) -> {
            registry.register(ExtraChestTypes.IRON.texture);
            registry.register(ExtraChestTypes.GOLD.texture);
            registry.register(ExtraChestTypes.DIAMOND.texture);
            registry.register(ExtraChestTypes.COPPER.texture);
            registry.register(ExtraChestTypes.SILVER.texture);
            registry.register(ExtraChestTypes.OBSIDIAN.texture);
            registry.register(ExtraChestTypes.CRYSTAL.texture);
            registry.register(ExtraChestTypes.HOLIDAY.texture);
            registry.register(ExtraChestTypes.DIRT.texture);
        });
    }
}
