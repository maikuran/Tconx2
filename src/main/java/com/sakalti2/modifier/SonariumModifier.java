package com.sakalti2.modifier;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/** Sonarium: status-control genre; it never changes entity velocity. */
public class SonariumModifier extends Rank3MaterialModifier {
    
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseDamage) {
        return damage + (0.70F * level);
    }

    
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        if (!valid(tool, level, context)) return 0;
        int duration = 55 + level * 12;
        int amplifier = Math.min(2, level - 1);
        target(context).addEffect(new EffectInstance(Effects.WEAKNESS, duration, amplifier, false, true));
        target(context).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, duration, Math.min(1, level - 1), false, true));
        if (target(context).getHealth() <= target(context).getMaxHealth() * 0.35F) {
            target(context).addEffect(new EffectInstance(Effects.DIG_SLOWDOWN, 35 + level * 8, 0, false, true));
        }
        return 0;
    }
}
