package com.modderminer.extrachests;

import com.modderminer.extrachests.registry.ModBlockEntityType;
import com.modderminer.extrachests.registry.ModBlocks;
import com.modderminer.extrachests.registry.ModItems;
import com.modderminer.extrachests.registry.ModScreenHandlerType;
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
            new Identifier(MOD_ID, "extrachests"))
            .icon(() -> new ItemStack(ModItems.IRON_CHEST))
            .build();
}
