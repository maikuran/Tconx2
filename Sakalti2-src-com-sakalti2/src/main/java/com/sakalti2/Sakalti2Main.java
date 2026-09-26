package com.sakalti2;

import com.sakalti2.modifier.Sakalti2Modifiers;
import com.sakalti2.worldgen.Sakalti2OreGeneration;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Sakalti2Main.MODID)
public final class Sakalti2Main {
    public static final String MODID = "sakalti2";
    public Sakalti2Main() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Sakalti2Blocks.register(bus);
        Sakalti2Items.register(bus);
        Sakalti2Fluids.register(bus);
        Sakalti2Modifiers.register(bus);
        MinecraftForge.EVENT_BUS.register(Sakalti2OreGeneration.class);
    }
}
