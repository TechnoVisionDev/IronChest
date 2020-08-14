package com.technovision.extrachests.screenhandlers;

import com.technovision.extrachests.blocks.blockentities.IronChestBlockEntity;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;

public class IronChestDescription extends SyncedGuiDescription {

    Inventory inventory;

    public IronChestDescription(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, getBlockInventory(context, IronChestBlockEntity.INVENTORY_SIZE), null);
        inventory = getBlockInventory(context, IronChestBlockEntity.INVENTORY_SIZE);
        inventory.onOpen(playerInventory.player);

        WPlainPanel root = new WPlainPanel();
        setRootPanel(root);

        WItemSlot itemSlot;
        int counter = 0;
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 9; i++) {
                itemSlot = WItemSlot.of(blockInventory, counter);
                root.add(itemSlot, (18 * i), 12 + (18 * j));
                counter++;
            }
        }
        root.add(this.createPlayerInventoryPanel(), 0, 102 + 21);
        root.validate(this);
    }

    @Override
    public void close(PlayerEntity player) {
        super.close(player);
        this.inventory.onClose(player);
    }
}
