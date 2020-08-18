package com.technovision.extrachests;

import com.technovision.extrachests.blocks.blockentities.CrystalChestBlockEntity;
import com.technovision.extrachests.client.ExtraChestBlockEntityRenderer;
import com.technovision.extrachests.screenhandlers.ExtraChestScreenHandler;
import com.technovision.extrachests.registry.ModBlockEntityType;
import com.technovision.extrachests.registry.ModScreenHandlerType;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.TexturedRenderLayers;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class ExtraChestsClient implements ClientModInitializer {

    public static ItemStack stack = new ItemStack(Items.AIR);

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

        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.IRON_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.GOLD_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.DIAMOND_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.COPPER_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.SILVER_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.CRYSTAL_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.OBSIDIAN_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.HOLIDAY_CHEST, ExtraChestBlockEntityRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(ModBlockEntityType.DIRT_CHEST, ExtraChestBlockEntityRenderer::new);

        //Register Textures to Chest Atlas
        ClientSpriteRegistryCallback.event(TexturedRenderLayers.CHEST_ATLAS_TEXTURE).register((texture, registry) -> {
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/iron_chest"));
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/gold_chest"));
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/diamond_chest"));
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/copper_chest"));
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/silver_chest"));
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/crystal_chest"));
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/obsidian_chest"));
            registry.register(new Identifier(ExtraChests.MOD_ID, "entity/chest/dirt_chest"));
        });

        // Crystal Chest Rendering Packets
        ClientSidePacketRegistry.INSTANCE.register(ExtraChests.UPDATE_INV_PACKET_ID,
                (packetContext, attachedData) -> {
                    BlockPos pos = attachedData.readBlockPos();
                    DefaultedList<ItemStack> inv = DefaultedList.ofSize(12, ItemStack.EMPTY);
                    for (int i = 0; i < 12; i++) {
                        inv.set(i, attachedData.readItemStack());
                    }
                    packetContext.getTaskQueue().execute(() -> {
                        CrystalChestBlockEntity blockEntity = (CrystalChestBlockEntity) MinecraftClient.getInstance().world.getBlockEntity(pos);
                        blockEntity.setInvStackList(inv);
                    });
                });
    }
}
