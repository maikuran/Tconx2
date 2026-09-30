package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/**
 * Situan trait: successful strikes build a short burst of momentum.
 */
public class PrismaticDriveTrait extends Modifier {
    public PrismaticDriveTrait() {
        super(0x438FE5);
    }

    
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        LivingEntity attacker = context.getAttacker();
        if (attacker == null || attacker.level.isClientSide || level <= 0) {
            return 0;
        }

        int duration = 25 + level * 6;
        attacker.addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, duration, Math.min(1, level - 1), false, true));
        if (attacker.getRandom().nextFloat() < 0.12F + 0.03F * Math.min(level - 1, 3)) {
            attacker.addEffect(new EffectInstance(Effects.DIG_SPEED, 30 + level * 5, 0, false, true));
        }
        return 0;
    }
}
