package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import com.technovision.ironchest.screenhandlers.ExtraChestScreenHandler;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class GenericIronChestBlockEntity extends ChestBlockEntity {

    ExtraChestTypes type;

    public GenericIronChestBlockEntity(ExtraChestTypes type) {
        super(type.getBlockEntityType());
        this.type = type;
        this.setInvStackList(DefaultedList.ofSize(this.size(), ItemStack.EMPTY));
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new ExtraChestScreenHandler(type.getScreenHandlerType(), type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory inventory) {
        return new ExtraChestScreenHandler(type.getScreenHandlerType(), type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public int size() {
        return type.size;
    }

    /*@Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
    	System.out.println("Setting invStackList");
        if (list.size() != this.size()) {

            DefaultedList<ItemStack> newList = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);

            System.out.println("Size is not equal: old list " + list.size() + " this " + this.size() + " new list " + newList.size());

            for (int i = 0; i < list.size(); i++) {
            	ItemStack temp = list.get(i);
            	//System.out.println("Adding element " + list.get(i).toString() + " at postition " + i + ".");
            	System.out.println("Adding element " + temp + " at postition " + i + ".");
                newList.set(i, temp);
            }

            super.setInvStackList(newList);
        } else {
        	System.out.println("Size is equial");
            super.setInvStackList(list);
        }
    }*/

}
