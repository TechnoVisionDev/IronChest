package com.technovision.extrachests.gui;

import com.technovision.extrachests.blocks.blockentities.IronChestBlockEntity;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class IronChestDescription extends SyncedGuiDescription {

    public IronChestDescription(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, getBlockInventory(context, IronChestBlockEntity.INVENTORY_SIZE), null);

        WGridPanel root = new WGridPanel();
        setRootPanel(root);

        WItemSlot itemSlot;
        int counter = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < 9; j++) {
                itemSlot = WItemSlot.of(blockInventory, counter);
                root.add(itemSlot, j, i);
                counter++;
            }
        }

        root.add(this.createPlayerInventoryPanel(), 0, 7);
        root.validate(this);
    }

}
