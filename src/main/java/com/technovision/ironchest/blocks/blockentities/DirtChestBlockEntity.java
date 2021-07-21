package com.technovision.ironchest.blocks.blockentities;

import com.technovision.ironchest.blocks.ExtraChestTypes;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtString;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

public class DirtChestBlockEntity extends GenericIronChestBlockEntity {

    private static final ItemStack guideBook = new ItemStack(Items.WRITTEN_BOOK);
    private static boolean bookDataCreated = false;

    public DirtChestBlockEntity(BlockPos pos, BlockState state) {
        super(ExtraChestTypes.DIRT, pos, state);
        if (!bookDataCreated) {
            createBookData();
        }
        this.setStack(0, guideBook.copy());
    }

    private static void createBookData() {
        NbtCompound tag = guideBook.getOrCreateNbt();

        tag.putString("title", "How to Use Your DirtChest 9000!");
        tag.putString("author", "TechnoVision");

        NbtList pages = new NbtList();
        pages.add(NbtString.of(Text.Serializer.toJson(new TranslatableText("book.ironchest.guidebook.page1"))));
        pages.add(NbtString.of(Text.Serializer.toJson(new TranslatableText("book.ironchest.guidebook.page2"))));
        pages.add(NbtString.of(Text.Serializer.toJson(new TranslatableText("book.ironchest.guidebook.page3"))));
        pages.add(NbtString.of(Text.Serializer.toJson(new TranslatableText("book.ironchest.guidebook.page4"))));
        pages.add(NbtString.of(Text.Serializer.toJson(new TranslatableText("book.ironchest.guidebook.page5"))));
        tag.put("pages", pages);

        guideBook.setNbt(tag);
        bookDataCreated = true;
    }
}
