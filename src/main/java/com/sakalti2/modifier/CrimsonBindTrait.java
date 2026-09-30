package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/**
 * Knitz trait: binds a struck target while granting a short defensive buffer.
 */
public class CrimsonBindTrait extends Modifier {
    public CrimsonBindTrait() {
        super(0x7A1E3F);
    }

    
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        LivingEntity target = context.getLivingTarget();
        LivingEntity attacker = context.getAttacker();
        if (target == null || attacker == null || target.level.isClientSide || level <= 0) {
            return 0;
        }

        int duration = 35 + level * 8;
        target.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, duration, Math.min(1, level - 1), false, true));
        if (attacker.getRandom().nextFloat() < 0.20F + 0.04F * Math.min(level - 1, 3)) {
            attacker.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 25 + level * 5, 0, false, true));
        }
        return 0;
    }
}
