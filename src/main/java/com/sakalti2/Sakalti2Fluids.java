package com.sakalti2;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Sakalti2Fluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Sakalti2Main.MODID);

    private static FluidAttributes.Builder attributes(int color) {
        return FluidAttributes.builder(FluidRegistry.WATER_STILL, FluidRegistry.WATER_FLOWING)
                .color(color)
                .density(2000)
                .viscosity(2500)
                .luminosity(0);
    }

    public static final RegistryObject<FlowingFluid> OSIUM = FLUIDS.register("osium",
            () -> new ForgeFlowingFluid.Source(OSIUM_PROPS));
    public static final RegistryObject<FlowingFluid> FLOWING_OSIUM = FLUIDS.register("flowing_osium",
            () -> new ForgeFlowingFluid.Flowing(OSIUM_PROPS));

    public static final RegistryObject<FlowingFluid> IGNITZ = FLUIDS.register("ignitz",
            () -> new ForgeFlowingFluid.Source(IGNITZ_PROPS));
    public static final RegistryObject<FlowingFluid> FLOWING_IGNITZ = FLUIDS.register("flowing_ignitz",
            () -> new ForgeFlowingFluid.Flowing(IGNITZ_PROPS));

    public static final RegistryObject<FlowingFluid> AUROREUM = FLUIDS.register("auroreum",
            () -> new ForgeFlowingFluid.Source(AUROREUM_PROPS));
    public static final RegistryObject<FlowingFluid> FLOWING_AUROREUM = FLUIDS.register("flowing_auroreum",
            () -> new ForgeFlowingFluid.Flowing(AUROREUM_PROPS));

    public static final RegistryObject<FlowingFluid> TRIUM = FLUIDS.register("trium",
            () -> new ForgeFlowingFluid.Source(TRIUM_PROPS));
    public static final RegistryObject<FlowingFluid> FLOWING_TRIUM = FLUIDS.register("flowing_trium",
            () -> new ForgeFlowingFluid.Flowing(TRIUM_PROPS));

    public static final ForgeFlowingFluid.Properties OSIUM_PROPS = new ForgeFlowingFluid.Properties(
            OSIUM, FLOWING_OSIUM, attributes(0xFF5A321E))
            .block(() -> Sakalti2Blocks.OSIUM_FLUID_BLOCK.get())
            .bucket(() -> Sakalti2Items.OSIUM_BUCKET.get());

    public static final ForgeFlowingFluid.Properties IGNITZ_PROPS = new ForgeFlowingFluid.Properties(
            IGNITZ, FLOWING_IGNITZ, attributes(0xFFFF5555))
            .block(() -> Sakalti2Blocks.IGNITZ_FLUID_BLOCK.get())
            .bucket(() -> Sakalti2Items.IGNITZ_BUCKET.get());

    public static final ForgeFlowingFluid.Properties AUROREUM_PROPS = new ForgeFlowingFluid.Properties(
            AUROREUM, FLOWING_AUROREUM, attributes(0xFFF2D56B))
            .block(() -> Sakalti2Blocks.AUROREUM_FLUID_BLOCK.get())
            .bucket(() -> Sakalti2Items.AUROREUM_BUCKET.get());

    public static final ForgeFlowingFluid.Properties TRIUM_PROPS = new ForgeFlowingFluid.Properties(
            TRIUM, FLOWING_TRIUM, attributes(0xFFD0D0D0))
            .block(() -> Sakalti2Blocks.TRIUM_FLUID_BLOCK.get())
            .bucket(() -> Sakalti2Items.TRIUM_BUCKET.get());

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }

    private Sakalti2Fluids() {}
}
