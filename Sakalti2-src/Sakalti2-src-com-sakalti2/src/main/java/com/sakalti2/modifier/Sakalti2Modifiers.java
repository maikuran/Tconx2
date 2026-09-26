package com.sakalti2.modifier;

import com.sakalti2.Sakalti2Main;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public final class Sakalti2Modifiers {
    public static final DeferredRegister<Modifier> MODIFIERS = DeferredRegister.create(Modifier.class, Sakalti2Main.MODID);
    public static final RegistryObject<Modifier> MELTING = MODIFIERS.register("melting", MeltingModifier::new);
    public static final RegistryObject<Modifier> AUROREUM = MODIFIERS.register("auroreum", AuroreumModifier::new);
    public static final RegistryObject<Modifier> UNDERPRESS = MODIFIERS.register("underpress", UnderpressModifier::new);
    public static void register(IEventBus bus) { MODIFIERS.register(bus); }
    private Sakalti2Modifiers() {}
}
