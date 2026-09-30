package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

public class UnderpressModifier extends Modifier {
    public UnderpressModifier() {
        super(0x8E7B5A);
    }

    
    @Override
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && !target.level.isClientSide) {
            double y = Math.max(0.0D, target.getY() - (2.0D * level));
            BlockPos below = new BlockPos(target.getX(), y, target.getZ());
            target.setPos(target.getX(), below.getY(), target.getZ());
            target.hurtMarked = true;
        }
        return 0;
    }
}
