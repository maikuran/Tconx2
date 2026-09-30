package com.sakalti2.modifier;

import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;

/**
 * Rank 3 special modifiers. Each material deliberately belongs to a different
 * effect genre: knockback, status control, life steal, durability, or mining.
 */
public class FiveMaterialModifier extends Modifier {
    public enum Mode { IRES, SONARIUM, RINALITE, MAGNUM, BABELIUM }

    private final Mode mode;

    public FiveMaterialModifier(Mode mode) {
        super(0xFFFFFF);
        this.mode = mode;
        MinecraftForge.EVENT_BUS.register(this);
    }

    
    public float getEntityDamage(IModifierToolStack tool, int level, ToolAttackContext context,
                                 float damage, float baseDamage) {
        if (level <= 0 || tool.isBroken()) return baseDamage;
        switch (mode) {
            case IRES: return baseDamage + 1.10F * level;
            case SONARIUM: return baseDamage + 0.70F * level;
            case RINALITE: return baseDamage + 0.85F * level;
            case MAGNUM: return baseDamage + 1.90F * level;
            case BABELIUM: return baseDamage + 1.00F * level;
            default: return baseDamage;
        }
    }

    
    public int afterEntityHit(IModifierToolStack tool, int level, ToolAttackContext context, float damage) {
        LivingEntity target = context.getLivingTarget();
        LivingEntity attacker = context.getAttacker();
        if (target == null || attacker == null || attacker.level.isClientSide || level <= 0) return 0;

        switch (mode) {
            case IRES:
                // The ONLY knockback genre among the five. Deliberately diagonal.
                double lookX = attacker.getLookAngle().x;
                double lookZ = attacker.getLookAngle().z;
                double rightX = -lookZ;
                double rightZ = lookX;
                double strength = 1.05D + 0.20D * Math.min(level, 4);
                target.setDeltaMovement((lookX + rightX) * strength,
                        0.22D + 0.05D * Math.min(level, 4),
                        (lookZ + rightZ) * strength);
                target.hurtMarked = true;
                break;

            case SONARIUM:
                // Status genre: no movement manipulation at all.
                int duration = 55 + level * 12;
                int amplifier = Math.min(2, level - 1);
                target.addEffect(new EffectInstance(Effects.WEAKNESS, duration, amplifier, false, true));
                target.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN,
                        duration, Math.min(1, level - 1), false, true));
                if (target.getHealth() <= target.getMaxHealth() * 0.35F) {
                    target.addEffect(new EffectInstance(Effects.DIG_SLOWDOWN,
                            35 + level * 8, 0, false, true));
                }
                break;

            case RINALITE:
                // Sustain genre: successful attacks restore the wielder's health.
                attacker.heal(0.65F + 0.45F * level);
                attacker.addEffect(new EffectInstance(Effects.REGENERATION,
                        18 + level * 5, 0, false, true));
                break;

            case MAGNUM:
                // Durability genre: hits repair the tool instead of moving entities.
                int repair = 1 + level;
                int currentDamage = tool.getDamage();
                if (currentDamage > 0) {
                    tool.setDamage(Math.max(0, currentDamage - repair));
                }
                break;

            case BABELIUM:
                // Mining genre is handled on block break. Entity hits get no special motion/effect.
                break;
            default:
                break;
        }
        return 0;
    }

    @SubscribeEvent
    public void onBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer() == null || event.getWorld().isClientSide()) return;
        if (mode != Mode.BABELIUM) return;

        int level = ModifierUtil.getModifierLevel(event.getPlayer().getMainHandItem(), this);
        if (level <= 0) return;

        // Babelium is the only mining-genre modifier in this set.
        event.getPlayer().addEffect(new EffectInstance(
                Effects.DIG_SPEED, 55 + level * 12, Math.min(3, level), false, true));
    }

}
