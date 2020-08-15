package com.technovision.extrachests.client;

import com.technovision.extrachests.blocks.GenericExtraChestBlock;
import com.technovision.extrachests.blocks.blockentities.GenericExtraChestBlockEntity;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.block.ChestAnimationProgress;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ExtraChestBlockEntityRenderer<T extends BlockEntity> extends BlockEntityRenderer<T> {

    private final ModelPart chestLid;
    private final ModelPart chestBottom;
    private final ModelPart chestLock;

    public ExtraChestBlockEntityRenderer(BlockEntityRenderDispatcher tileEntityRendererDispatcher) {
        super(tileEntityRendererDispatcher);

        this.chestBottom = new ModelPart(64, 64, 0, 19);
        this.chestBottom.addCuboid(1.0F, 0.0F, 1.0F, 14.0F, 10.0F, 14.0F, 0.0F);
        this.chestLid = new ModelPart(64, 64, 0, 0);
        this.chestLid.addCuboid(1.0F, 0.0F, 0.0F, 14.0F, 5.0F, 14.0F, 0.0F);
        this.chestLid.pivotY = 9.0F;
        this.chestLid.pivotZ = 1.0F;
        this.chestLock = new ModelPart(64, 64, 0, 0);
        this.chestLock.addCuboid(7.0F, -1.0F, 15.0F, 2.0F, 4.0F, 1.0F, 0.0F);
        this.chestLock.pivotY = 8.0F;
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        GenericExtraChestBlockEntity blockEntity = (GenericExtraChestBlockEntity) entity;

        World world = blockEntity.getWorld();
        boolean flag = world != null;

        BlockState blockstate = flag ? entity.getCachedState() : (BlockState) Blocks.CHEST.getDefaultState().with(ChestBlock.FACING, Direction.SOUTH);
        Block block = blockstate.getBlock();

        if (block instanceof GenericExtraChestBlock) {
            GenericExtraChestBlock ironChestBlock = (GenericExtraChestBlock) block;

            matrices.push();
            float f = ((Direction)blockstate.get(ChestBlock.FACING)).asRotation();
            matrices.translate(0.5D, 0.5D, 0.5D);
            matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(-f));
            matrices.translate(-0.5D, -0.5D, -0.5D);

            DoubleBlockProperties.PropertySource propertySource2;
            if (flag) {
                propertySource2 = ironChestBlock.getBlockEntitySource(blockstate, world, entity.getPos(), true);
            } else {
                propertySource2 = DoubleBlockProperties.PropertyRetriever::getFallback;
            }

            float g = ((Float2FloatFunction)propertySource2.apply(GenericExtraChestBlock.getAnimationProgressRetriever((ChestAnimationProgress)entity))).get(tickDelta);
            g = 1.0F - g;
            g = 1.0F - g * g * g;
            int i = ((Int2IntFunction)propertySource2.apply(new LightmapCoordinatesRetriever())).applyAsInt(light);

            SpriteIdentifier spriteIdentifier = new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, ironChestBlock.getType().texture);
            VertexConsumer vertexConsumer = spriteIdentifier.getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout);

            this.handleModelRender(matrices, vertexConsumer, this.chestLid, this.chestLock, this.chestBottom, g, i, overlay);
            matrices.pop();
        }
    }
    
    private void handleModelRender(MatrixStack matrices, VertexConsumer vertices, ModelPart lid, ModelPart latch, ModelPart base, float openFactor, int light, int overlay) {
        lid.pitch = -(openFactor * 1.5707964F);
        latch.pitch = lid.pitch;
        lid.render(matrices, vertices, light, overlay);
        latch.render(matrices, vertices, light, overlay);
        base.render(matrices, vertices, light, overlay);
    }
}
