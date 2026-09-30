package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/** Shared base for the five Rank 3 material traits. The five concrete classes deliberately own different effect genres. */
public abstract class Rank3MaterialModifier extends Modifier {
    protected Rank3MaterialModifier() {
        super(0xFFFFFF);
    }

    protected final LivingEntity target(ToolAttackContext context) {
        return context.getLivingTarget();
    }

    protected final LivingEntity attacker(ToolAttackContext context) {
        return context.getAttacker();
    }

    protected final boolean valid(IModifierToolStack tool, int level, ToolAttackContext context) {
        return level > 0 && !tool.isBroken() && target(context) != null && attacker(context) != null
                && !attacker(context).level.isClientSide;
    }

    
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
                                 float damage, float baseDamage) {
        return damage;
    }
}
