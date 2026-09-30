package com.sakalti2.modifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;
public class GravityAnchorTrait extends Modifier {
 public GravityAnchorTrait(){super(0x8A2BE2); MinecraftForge.EVENT_BUS.register(this);}
 @SubscribeEvent public void tick(TickEvent.PlayerTickEvent e){ PlayerEntity p=e.player; if(e.phase==TickEvent.Phase.END && ModifierUtil.getModifierLevel(p.getMainHandItem(),this)>0 && !p.level.isClientSide){p.setDeltaMovement(p.getDeltaMovement().x*0.85D,p.getDeltaMovement().y,p.getDeltaMovement().z*0.85D); p.hurtMarked=true;}}
}
