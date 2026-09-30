package com.sakalti2.modifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
public class SonicResonanceTrait extends Modifier {
 public SonicResonanceTrait(){super(0xE54832); MinecraftForge.EVENT_BUS.register(this);}
 @SubscribeEvent public void breakBlock(PlayerEvent.BreakSpeed e){ PlayerEntity p=e.getPlayer(); if(ModifierUtil.getModifierLevel(p.getMainHandItem(),this)>0 && !p.level.isClientSide){p.addEffect(new EffectInstance(Effects.DIG_SPEED,40,0,false,true));}}
}
