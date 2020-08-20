package com.technovision.ironchest;

import com.technovision.ironchest.registry.ModBlockEntityType;
import com.technovision.ironchest.registry.ModBlocks;
import com.technovision.ironchest.registry.ModItems;
import com.technovision.ironchest.registry.ModScreenHandlerType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class IronChests implements ModInitializer {

    public static final String MOD_ID = "ironchest";
    public static final Identifier UPDATE_INV_PACKET_ID = new Identifier(MOD_ID, "update");

    @Override
    public void onInitialize() {

        ModBlockEntityType.registerBlockEntities();
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModScreenHandlerType.registerScreenHandlers();
    }

    public static final ItemGroup TAB = FabricItemGroupBuilder.create(
            new Identifier(MOD_ID, "ironchest"))
            .icon(() -> new ItemStack(ModItems.IRON_CHEST))
            .build();
}
