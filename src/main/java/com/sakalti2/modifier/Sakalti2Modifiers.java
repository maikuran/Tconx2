package com.sakalti2.modifier;

import com.sakalti2.Sakalti2Main;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import slimeknights.tconstruct.library.modifiers.Modifier;

public final class Sakalti2Modifiers {
    public static final DeferredRegister<Modifier> MODIFIERS =
            DeferredRegister.create(Modifier.class, Sakalti2Main.MODID);

    public static final RegistryObject<Modifier> UNSTABLE = MODIFIERS.register("unstable", UnstableModifier::new);
    public static final RegistryObject<Modifier> MELTING = MODIFIERS.register("melting", MeltingModifier::new);
    public static final RegistryObject<Modifier> AUROREUM = MODIFIERS.register("auroreum", AuroreumModifier::new);
    public static final RegistryObject<Modifier> UNDERPRESS = MODIFIERS.register("underpress", UnderpressModifier::new);
    public static final RegistryObject<Modifier> ZARLON = MODIFIERS.register("resonant_rend", ResonantRendTrait::new);
    public static final RegistryObject<Modifier> KNITZ = MODIFIERS.register("crimson_bind", CrimsonBindTrait::new);
    public static final RegistryObject<Modifier> SITUAN = MODIFIERS.register("prismatic_drive", PrismaticDriveTrait::new);
    public static final RegistryObject<Modifier> HINEUR = MODIFIERS.register("layered_renewal", LayeredRenewalTrait::new);

    public static final RegistryObject<Modifier> IRES_SPECIAL =
            MODIFIERS.register("prismatic_rift", IresModifier::new);
    public static final RegistryObject<Modifier> SONARIUM_SPECIAL =
            MODIFIERS.register("resonant_torque", SonariumModifier::new);
    public static final RegistryObject<Modifier> RINALITE_SPECIAL =
            MODIFIERS.register("rose_impact", RinaliteModifier::new);
    public static final RegistryObject<Modifier> MAGNUM_SPECIAL =
            MODIFIERS.register("crimson_torque", MagnumModifier::new);
    public static final RegistryObject<Modifier> BABELIUM_SPECIAL =
            MODIFIERS.register("triune_force", BabeliumModifier::new);


    public static void register(IEventBus bus) {
        MODIFIERS.register(bus);
    }

    private Sakalti2Modifiers() {}
}
