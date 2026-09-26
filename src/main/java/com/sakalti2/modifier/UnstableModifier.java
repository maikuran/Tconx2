package com.sakalti2.modifier;

import java.util.Random;
import net.minecraft.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/** Behavior ported from the original Sakalti 1.04 UnstableModifier. */
public class UnstableModifier extends Modifier {
    public UnstableModifier() {
        super(0xCC00FF);
    }

    
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
                                 float damage, float baseDamage) {
        LivingEntity attacker = context.getAttacker();
        if (tool.isBroken() || attacker == null || level <= 0) {
            return baseDamage;
        }
        Random random = attacker.getRandom();
        float multiplier = 1.0F + random.nextFloat() * 3.4F;
        int extraDamage;
        if (multiplier < 2.0F) extraDamage = 0;
        else if (multiplier < 3.0F) extraDamage = 1;
        else if (multiplier < 4.0F) extraDamage = 2;
        else if (multiplier < 4.4F) extraDamage = 3;
        else extraDamage = 4;

        if (!attacker.level.isClientSide && extraDamage > 0) {
            tool.setDamage(tool.getDamage() + extraDamage);
        }
        return baseDamage * multiplier;
    }
}
