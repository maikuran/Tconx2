package com.sakalti2.modifier;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/** Rinalite: sustain/life-steal genre. */
public class RinaliteModifier extends Rank3MaterialModifier {
    
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseDamage) {
        return damage + (0.85F * level);
    }

    
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        if (!valid(tool, level, context)) return 0;
        attacker(context).heal(0.65F + 0.45F * level);
        attacker(context).addEffect(new EffectInstance(Effects.REGENERATION, 18 + level * 5, 0, false, true));
        return 0;
    }
}
