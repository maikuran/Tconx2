package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/** Ires: the only knockback-oriented Rank 3 trait. */
public class IresModifier extends Rank3MaterialModifier {
    @Override
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context, float damage, float baseDamage) {
        return damage + (1.10F * level);
    }

    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        if (!valid(tool, level, context)) return 0;
        LivingEntity target = target(context);
        LivingEntity attacker = attacker(context);
        double lookX = attacker.getLookAngle().x;
        double lookZ = attacker.getLookAngle().z;
        double rightX = -lookZ;
        double rightZ = lookX;
        double strength = 1.05D + 0.20D * Math.min(level, 4);
        target.setDeltaMovement((lookX + rightX) * strength,
                0.22D + 0.05D * Math.min(level, 4),
                (lookZ + rightZ) * strength);
        target.hurtMarked = true;
        return 0;
    }
}
