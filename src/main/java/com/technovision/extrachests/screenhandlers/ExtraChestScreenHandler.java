package com.technovision.extrachests.screenhandlers;

import com.technovision.extrachests.blocks.ExtraChestTypes;
import com.technovision.extrachests.blocks.blockentities.GenericExtraChestBlockEntity;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class ExtraChestScreenHandler extends SyncedGuiDescription {

    Inventory inventory;

    public ExtraChestScreenHandler(ScreenHandlerType<?> type, ExtraChestTypes chestType, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, getBlockInventory(context, chestType.size), null);
        inventory = getBlockInventory(context, chestType.size);
        inventory.onOpen(playerInventory.player);

        int rows = chestType.getRowCount();
        int length = chestType.rowLength;

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);

        WItemSlot itemSlot;
        int counter = 0;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < length; i++) {
                itemSlot = WItemSlot.of(blockInventory, counter);
                root.add(itemSlot, (18 * i), 12 + (18 * j));
                counter++;
            }
        }

        int height = 15;
        height += 18 * (chestType.size / length);

        int width = 0;
        if (chestType.rowLength > 9) {
            width = 9 * (chestType.rowLength - 9);
        }
        root.add(this.createPlayerInventoryPanel(), width, height);
        root.validate(this);
    }

    @Override
    public void close(PlayerEntity player) {
        super.close(player);
        this.inventory.onClose(player);
    }
}
