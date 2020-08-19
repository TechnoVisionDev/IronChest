package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import com.technovision.ironchest.registry.ModBlockEntityType;
import com.technovision.ironchest.registry.ModScreenHandlerType;
import com.technovision.ironchest.screenhandlers.ExtraChestScreenHandler;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.*;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Language;

public class DirtChestBlockEntity extends GenericIronChestBlockEntity {

    private static final ItemStack guideBook = new ItemStack(Items.WRITTEN_BOOK);
    private static boolean bookDataCreated = false;

    public DirtChestBlockEntity() {
        super(ModBlockEntityType.DIRT_CHEST, ExtraChestTypes.DIRT);
        if (!bookDataCreated) {
            createBookData();
        }
        this.setStack(0, guideBook.copy());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new ExtraChestScreenHandler(ModScreenHandlerType.DIRT_CHEST, type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory inventory) {
        return new ExtraChestScreenHandler(ModScreenHandlerType.DIRT_CHEST, type, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    private static void createBookData() {
        CompoundTag tag = guideBook.getOrCreateTag();

        tag.putString("title", Language.getInstance().get("book.ironchest.guidebook.title"));
        tag.putString("author", "TechnoVision");

        ListTag pages = new ListTag();
        pages.add(StringTag.of(getPage("book.ironchest.guidebook.page1")));
        pages.add(StringTag.of(getPage("book.ironchest.guidebook.page2")));
        pages.add(StringTag.of(getPage("book.ironchest.guidebook.page3")));
        pages.add(StringTag.of(getPage("book.ironchest.guidebook.page4")));
        pages.add(StringTag.of(getPage("book.ironchest.guidebook.page5")));
        tag.put("pages", pages);

        guideBook.setTag(tag);
        bookDataCreated = true;
    }

    private static String getPage(String key) {
        String text = Language.getInstance().get(key);
        return String.format("\"%s\"", text);
    }
}

