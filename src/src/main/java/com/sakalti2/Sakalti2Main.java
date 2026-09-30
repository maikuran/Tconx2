package com.sakalti2;

import com.sakalti2.modifier.Sakalti2Modifiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Sakalti2Main.MODID)
public final class Sakalti2Main {
    public static final String MODID = "sakalti2";
    public Sakalti2Main() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        Sakalti2Fluids.register(bus);
        Sakalti2Blocks.register(bus);
        Sakalti2Items.register(bus);
        Sakalti2Modifiers.register(bus);
    }
}
