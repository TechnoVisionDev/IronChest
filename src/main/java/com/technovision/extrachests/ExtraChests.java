package com.technovision.extrachests;

import com.technovision.extrachests.registry.ModBlockEntityType;
import com.technovision.extrachests.registry.ModBlocks;
import com.technovision.extrachests.registry.ModItems;
import com.technovision.extrachests.registry.ModScreenHandlerType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ExtraChests implements ModInitializer {

    public static final String MOD_ID = "extrachests";

    @Override
    public void onInitialize() {
        ModBlockEntityType.registerBlockEntities();
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModScreenHandlerType.registerScreenHandlers();
    }

    public static final ItemGroup TAB = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID))
            .icon(() -> new ItemStack(ModItems.IRON_CHEST))
            .build();
}
