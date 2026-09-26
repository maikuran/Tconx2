package com.sakalti2.modifier;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class MeltingModifier extends Modifier {
    public MeltingModifier() {
        super(0xFF5555);
        MinecraftForge.EVENT_BUS.register(this);
    }
    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && !target.level.isClientSide) target.setSecondsOnFire(4 + level * 2);
        return 0;
    }
    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer() == null || event.getWorld().isClientSide()) return;
        if (ModifierUtil.getModifierLevel(event.getPlayer().getMainHandItem(), this) <= 0) return;
        if (!isStoneLike(event.getState().getBlock())) return;
        BlockPos pos = event.getPos();
        event.setCanceled(true);
        event.getWorld().setBlock(pos, Blocks.MAGMA_BLOCK.defaultBlockState(), 3);
    }
    private static boolean isStoneLike(Block block) {
        return block == Blocks.STONE || block == Blocks.COBBLESTONE
                || block == Blocks.MOSSY_COBBLESTONE || block == Blocks.GRANITE
                || block == Blocks.DIORITE || block == Blocks.ANDESITE
                || block == Blocks.STONE_BRICKS || block == Blocks.MOSSY_STONE_BRICKS
                || block == Blocks.CRACKED_STONE_BRICKS || block == Blocks.CHISELED_STONE_BRICKS;
    }
}
