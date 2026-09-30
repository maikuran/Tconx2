package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/**
 * Hineur trait: layered resilience converts successful hits into controlled recovery.
 */
public class LayeredRenewalTrait extends Modifier {
    public LayeredRenewalTrait() {
        super(0x2E985A);
    }

    
    
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        LivingEntity attacker = context.getAttacker();
        LivingEntity target = context.getLivingTarget();
        if (attacker == null || target == null || attacker.level.isClientSide || level <= 0) {
            return 0;
        }

        if (attacker.getRandom().nextFloat() < 0.22F + 0.04F * Math.min(level - 1, 3)) {
            attacker.heal(0.75F * level);
            attacker.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 20 + level * 4, 0, false, true));
        }
        if (attacker.getRandom().nextFloat() < 0.10F + 0.02F * Math.min(level - 1, 3)) {
            target.addEffect(new EffectInstance(Effects.POISON, 25 + level * 5, 0, false, true));
        }
        return 0;
    }
}
