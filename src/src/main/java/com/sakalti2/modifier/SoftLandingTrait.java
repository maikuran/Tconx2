package com.sakalti2.modifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
public class SoftLandingTrait extends Modifier {
 public SoftLandingTrait(){super(0xF3B7C9); MinecraftForge.EVENT_BUS.register(this);}
 @SubscribeEvent public void tick(net.minecraftforge.event.TickEvent.PlayerTickEvent e){ PlayerEntity p=e.player; if(e.phase==net.minecraftforge.event.TickEvent.Phase.END && ModifierUtil.getModifierLevel(p.getMainHandItem(),this)>0 && !p.level.isClientSide){p.fallDistance=0;}}
}
