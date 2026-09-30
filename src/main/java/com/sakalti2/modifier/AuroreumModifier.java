package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.vector.Vector3d;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class AuroreumModifier extends Modifier {
    public AuroreumModifier() { super(0xFFD75A); }
    
    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && !target.level.isClientSide) {
            Vector3d v = target.getDeltaMovement();
            double launch = 1.15D + 0.45D * level;
            target.setDeltaMovement(v.x * 0.35D, Math.max(v.y, launch), v.z * 0.35D);
            target.hurtMarked = true;
        }
        return 0;
    }
}
