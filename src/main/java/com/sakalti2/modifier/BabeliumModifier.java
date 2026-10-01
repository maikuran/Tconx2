package com.sakalti2.modifier;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/** Babelium: mining-only special effect; it does not alter entity motion. */
public class BabeliumModifier extends Rank3MaterialModifier {
    public BabeliumModifier() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseDamage) {
        return damage + (1.00F * level);
    }

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer() == null || event.getWorld().isClientSide()) return;
        int level = ModifierUtil.getModifierLevel(event.getPlayer().getMainHandItem(), this);
        if (level <= 0) return;
        event.getPlayer().addEffect(new EffectInstance(Effects.DIG_SPEED, 55 + level * 12, Math.min(3, level), false, true));
    }
}
