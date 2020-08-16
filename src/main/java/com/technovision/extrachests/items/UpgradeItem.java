package com.technovision.extrachests.items;

import com.technovision.extrachests.ExtraChests;
import com.technovision.extrachests.blocks.ExtraChestTypes;
import com.technovision.extrachests.blocks.GenericExtraChestBlock;
import com.technovision.extrachests.blocks.blockentities.GenericExtraChestBlockEntity;
import com.technovision.extrachests.registry.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class UpgradeItem extends Item {

    ExtraChestTypes type;

    public UpgradeItem(ExtraChestTypes type) {
        super(new Item.Settings().group(ExtraChests.TAB));
        this.type = type;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        PlayerEntity entityPlayer = context.getPlayer();
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        ItemStack itemStack = context.getStack();

        if (world.isClient) { return ActionResult.PASS; }

        if (entityPlayer == null) { return ActionResult.PASS; }

        BlockEntity blockEntity = world.getBlockEntity(blockPos);
        GenericExtraChestBlockEntity newChest = null;
        Text customName = null;
        DefaultedList<ItemStack> chestContents = DefaultedList.ofSize(27, ItemStack.EMPTY);
        Direction chestFacing = Direction.NORTH;

        if (blockEntity != null) {
            if (blockEntity instanceof GenericExtraChestBlockEntity) {
                GenericExtraChestBlockEntity chest = (GenericExtraChestBlockEntity) blockEntity;
                BlockState chestState = world.getBlockState(blockPos);

                if (GenericExtraChestBlockEntity.countViewers(world, blockPos.getX(), blockPos.getY(), blockPos.getZ()) > 0) {
                    return ActionResult.PASS;
                }
                if (!chest.canPlayerUse(entityPlayer)) {
                    return ActionResult.PASS;
                }

                chestContents = chest.getInvStackList();
                chestFacing = chestState.get(GenericExtraChestBlock.FACING);
                customName = chest.getCustomName();
                newChest = this.type.makeEntity();

                if (newChest == null) {
                    return ActionResult.PASS;
                }
            }
            else if (blockEntity instanceof ChestBlockEntity) {
                ChestBlockEntity chest = (ChestBlockEntity) blockEntity;
                BlockState chestState = world.getBlockState(blockPos);

                if (GenericExtraChestBlockEntity.countViewers(world, blockPos.getX(), blockPos.getY(), blockPos.getZ()) > 0) {
                    return ActionResult.PASS;
                }
                if (!chest.canPlayerUse(entityPlayer)) {
                    return ActionResult.PASS;
                }

                chestFacing = chestState.get(ChestBlock.FACING);
                chestContents = DefaultedList.ofSize(chest.size(), ItemStack.EMPTY);

                for (int slot = 0; slot < chestContents.size(); slot++) {
                    chestContents.set(slot, chest.getStack(slot));
                }

                customName = chest.getCustomName();
                newChest = this.type.makeEntity();
            }

            blockEntity.toUpdatePacket();
            world.removeBlockEntity(blockPos);
            world.removeBlock(blockPos, false);

            BlockState blockState = ExtraChestTypes.get(type).getDefaultState().with(GenericExtraChestBlock.FACING, chestFacing).with(GenericExtraChestBlock.WATERLOGGED, false);
            world.setBlockState(blockPos, blockState, 3);
            world.setBlockEntity(blockPos, newChest);
            world.updateListeners(blockPos, blockState, blockState, 3);

            itemStack.decrement(1);

            BlockEntity blockEntity2 = world.getBlockEntity(blockPos);

            if (blockEntity2 instanceof GenericExtraChestBlockEntity) {
                if (customName != null) {
                    ((GenericExtraChestBlockEntity) blockEntity2).setCustomName(customName);
                }
                ((GenericExtraChestBlockEntity) blockEntity2).setInvStackList(chestContents);
            }
        }
        return ActionResult.PASS;
    }
}
