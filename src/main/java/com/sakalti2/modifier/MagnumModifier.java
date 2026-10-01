package com.sakalti2.modifier;

import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/** Magnum: durability-recovery genre. */
public class MagnumModifier extends Rank3MaterialModifier {
    
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseDamage) {
        return damage + (1.90F * level);
    }

    
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        if (!valid(tool, level, context)) return 0;
        int currentDamage = tool.getDamage();
        if (currentDamage > 0) tool.setDamage(Math.max(0, currentDamage - (1 + level)));
        return 0;
    }
}
