package com.technovision.extrachests.blocks.blockentities;

import com.technovision.extrachests.gui.IronChestDescription;
import com.technovision.extrachests.registry.ModBlockEntityType;
import com.technovision.extrachests.registry.ModBlocks;
import com.technovision.extrachests.registry.ModScreenHandlerType;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvironmentInterface;
import net.fabricmc.api.EnvironmentInterfaces;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.*;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.block.ChestAnimationProgress;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Tickable;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

@EnvironmentInterfaces({@EnvironmentInterface(
        value = EnvType.CLIENT,
        itf = ChestAnimationProgress.class
)})
public class IronChestBlockEntity extends LootableContainerBlockEntity implements ChestAnimationProgress, Tickable {

    public static final int INVENTORY_SIZE = 54;
    private DefaultedList<ItemStack> chestContents;
    protected float lidAngle;
    protected float prevLidAngle;
    public int numPlayersUsing;
    private int ticksSinceSync;
    private Supplier<Block> blockToUse;

    public IronChestBlockEntity() {
        super(ModBlockEntityType.IRON_CHEST);
        chestContents = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);
        this.blockToUse = () -> ModBlocks.IRON_CHEST;
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory inventory, PlayerEntity player) {
        return new IronChestDescription(ModScreenHandlerType.IRON_CHEST, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory inventory) {
        return new IronChestDescription(ModScreenHandlerType.IRON_CHEST, syncId, inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return chestContents;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> list) {
        this.chestContents = DefaultedList.<ItemStack>ofSize(INVENTORY_SIZE, ItemStack.EMPTY);

        for (int i = 0; i < list.size(); i++) {
            if (i < this.chestContents.size()) {
                this.getInvStackList().set(i, list.get(i));
            }
        }
    }

    @Override
    public int size() {
        return this.getInvStackList().size();
    }

    @Environment(EnvType.CLIENT)
    public float getAnimationProgress(float tickDelta) {
        return MathHelper.lerp(tickDelta, this.prevLidAngle, this.lidAngle);
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack itemstack : this.chestContents) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.chestContents = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(tag)) {
            Inventories.fromTag(tag, this.chestContents);
        }

    }

    @Override
    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        if (!this.serializeLootTable(tag)) {
            Inventories.toTag(tag, this.chestContents);
        }

        return tag;
    }

    @Override
    public void tick() {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        ++this.ticksSinceSync;
        this.numPlayersUsing = tickViewerCount(this.world, this, this.ticksSinceSync, i, j, k, this.numPlayersUsing);
        this.prevLidAngle = this.lidAngle;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F) {
            this.playSound(SoundEvents.BLOCK_CHEST_OPEN);
        }

        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
            System.out.println("LOL");
            float f1 = this.lidAngle;
            if (this.numPlayersUsing > 0) {
                this.lidAngle += 0.1F;
            }
            else {
                this.lidAngle -= 0.1F;
            }

            if (this.lidAngle > 1.0F) {
                this.lidAngle = 1.0F;
            }

            if (this.lidAngle < 0.5F && f1 >= 0.5F) {
                this.playSound(SoundEvents.BLOCK_CHEST_CLOSE);
            }

            if (this.lidAngle < 0.0F) {
                this.lidAngle = 0.0F;
            }
        }
    }

    private void playSound(SoundEvent soundEvent) {
        ChestType chestType = (ChestType)this.getCachedState().get(ChestBlock.CHEST_TYPE);
        if (chestType != ChestType.LEFT) {
            double d = (double)this.pos.getX() + 0.5D;
            double e = (double)this.pos.getY() + 0.5D;
            double f = (double)this.pos.getZ() + 0.5D;
            if (chestType == ChestType.RIGHT) {
                Direction direction = ChestBlock.getFacing(this.getCachedState());
                d += (double)direction.getOffsetX() * 0.5D;
                f += (double)direction.getOffsetZ() * 0.5D;
            }
            this.world.playSound((PlayerEntity)null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.9F);
        }
    }

    public static int tickViewerCount(World world, LockableContainerBlockEntity blockEntity, int ticksOpen, int x, int y, int z, int viewerCount) {
        if (!world.isClient && viewerCount != 0 && (ticksOpen + x + y + z) % 200 == 0) {
            viewerCount = countViewers(world, blockEntity, x, y, z);
        }

        return viewerCount;
    }

    public static int countViewers(World world, LockableContainerBlockEntity container, int ticksOpen, int x, int y) {
        int i = 0;
        float f = 5.0F;
        List<PlayerEntity> list = world.getNonSpectatingEntities(PlayerEntity.class, new Box((double)((float)ticksOpen - 5.0F), (double)((float)x - 5.0F), (double)((float)y - 5.0F), (double)((float)(ticksOpen + 1) + 5.0F), (double)((float)(x + 1) + 5.0F), (double)((float)(y + 1) + 5.0F)));
        Iterator var8 = list.iterator();

        while(true) {
            Inventory inventory;
            do {
                PlayerEntity playerEntity;
                do {
                    if (!var8.hasNext()) {
                        return i;
                    }

                    playerEntity = (PlayerEntity)var8.next();
                } while(!(playerEntity.currentScreenHandler instanceof GenericContainerScreenHandler));

                inventory = ((GenericContainerScreenHandler)playerEntity.currentScreenHandler).getInventory();
            } while(inventory != container && (!(inventory instanceof DoubleInventory) || !((DoubleInventory)inventory).isPart(container)));

            ++i;
        }
    }

    @Override
    public boolean onSyncedBlockEvent(int type, int data) {
        System.out.println(data);
        if (type == 1) {
            this.numPlayersUsing = data;
            return true;
        } else {
            return super.onSyncedBlockEvent(type, data);
        }
    }

    @Override
    public void onOpen(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }

            ++this.numPlayersUsing;
            this.onInvOpenOrClose();
        }

    }

    @Override
    public void onClose(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
            this.onInvOpenOrClose();
        }
    }

    protected void onInvOpenOrClose() {
        Block block = this.getCachedState().getBlock();
        if (block instanceof ChestBlock) {
            this.world.addSyncedBlockEvent(this.pos, block, 1, this.numPlayersUsing);
            this.world.updateNeighborsAlways(this.pos, block);
        }

    }
}
