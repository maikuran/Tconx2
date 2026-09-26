package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/**
 * Zarlon trait: creates a resonant follow-up window against weakened targets.
 */
public class ResonantRendTrait extends Modifier {
    public ResonantRendTrait() {
        super(0x7544C6);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        LivingEntity target = context.getLivingTarget();
        LivingEntity attacker = context.getAttacker();
        if (target == null || attacker == null || target.level.isClientSide || level <= 0) {
            return 0;
        }

        if (target.hasEffect(Effects.WEAKNESS)) {
            target.hurt(net.minecraft.util.DamageSource.MAGIC, 0.75F * level);
        } else if (attacker.getRandom().nextFloat() < 0.28F + 0.05F * Math.min(level - 1, 3)) {
            target.addEffect(new EffectInstance(Effects.WEAKNESS, 45 + level * 10, 0, false, true));
        }
        return 0;
    }
}
