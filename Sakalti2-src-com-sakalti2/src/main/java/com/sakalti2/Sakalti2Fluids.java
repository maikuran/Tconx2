package com.sakalti2;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Sakalti2Fluids {
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Sakalti2Main.MODID);
    public static final RegistryObject<FlowingFluid> OSIUM = FLUIDS.register("osium", () -> new FlowingFluid.Source(Sakalti2Fluids.OSIUM_PROPS));
    public static final RegistryObject<FlowingFluid> FLOWING_OSIUM = FLUIDS.register("flowing_osium", () -> new FlowingFluid.Flowing(Sakalti2Fluids.OSIUM_PROPS));
    public static final RegistryObject<FlowingFluid> IGNITZ = FLUIDS.register("ignitz", () -> new FlowingFluid.Source(Sakalti2Fluids.IGNITZ_PROPS));
    public static final RegistryObject<FlowingFluid> FLOWING_IGNITZ = FLUIDS.register("flowing_ignitz", () -> new FlowingFluid.Flowing(Sakalti2Fluids.IGNITZ_PROPS));
    public static final RegistryObject<FlowingFluid> AUROREUM = FLUIDS.register("auroreum", () -> new FlowingFluid.Source(Sakalti2Fluids.AUROREUM_PROPS));
    public static final RegistryObject<FlowingFluid> FLOWING_AUROREUM = FLUIDS.register("flowing_auroreum", () -> new FlowingFluid.Flowing(Sakalti2Fluids.AUROREUM_PROPS));
    public static final RegistryObject<FlowingFluid> TRIUM = FLUIDS.register("trium", () -> new FlowingFluid.Source(Sakalti2Fluids.TRIUM_PROPS));
    public static final RegistryObject<FlowingFluid> FLOWING_TRIUM = FLUIDS.register("flowing_trium", () -> new FlowingFluid.Flowing(Sakalti2Fluids.TRIUM_PROPS));

    private static FluidAttributes.Builder attr(int color) { return FluidAttributes.builder(FluidRegistry.WATER_STILL, FluidRegistry.WATER_FLOWING).color(color).density(2000).viscosity(2500).luminosity(0); }
    public static final FlowingFluid.Properties OSIUM_PROPS = new FlowingFluid.Properties(OSIUM, FLOWING_OSIUM, attr(0xFF5A321E)).block(() -> Sakalti2Blocks.OSIUM_FLUID_BLOCK.get()).bucket(() -> Sakalti2Items.OSIUM_BUCKET.get());
    public static final FlowingFluid.Properties IGNITZ_PROPS = new FlowingFluid.Properties(IGNITZ, FLOWING_IGNITZ, attr(0xFFFF5555)).block(() -> Sakalti2Blocks.IGNITZ_FLUID_BLOCK.get()).bucket(() -> Sakalti2Items.IGNITZ_BUCKET.get());
    public static final FlowingFluid.Properties AUROREUM_PROPS = new FlowingFluid.Properties(AUROREUM, FLOWING_AUROREUM, attr(0xFFF2D56B)).block(() -> Sakalti2Blocks.AUROREUM_FLUID_BLOCK.get()).bucket(() -> Sakalti2Items.AUROREUM_BUCKET.get());
    public static final FlowingFluid.Properties TRIUM_PROPS = new FlowingFluid.Properties(TRIUM, FLOWING_TRIUM, attr(0xFFD0D0D0)).block(() -> Sakalti2Blocks.TRIUM_FLUID_BLOCK.get()).bucket(() -> Sakalti2Items.TRIUM_BUCKET.get());
    public static void register(IEventBus bus) { FLUIDS.register(bus); }
    private Sakalti2Fluids() {}
}
