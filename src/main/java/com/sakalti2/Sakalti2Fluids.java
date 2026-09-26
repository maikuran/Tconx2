package com.sakalti2;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Sakalti2Fluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, Sakalti2Main.MODID);

    private static FluidAttributes.Builder attributes(int color) {
        return FluidAttributes.builder(
                        new ResourceLocation("minecraft", "block/water_still"),
                        new ResourceLocation("minecraft", "block/water_flow"))
                .color(color)
                .density(2000)
                .viscosity(2500)
                .luminosity(0);
    }

    public static final RegistryObject<FlowingFluid> OSIUM = registerSource("osium", () -> properties(OSIUM, FLOWING_OSIUM, 0xFF5A321E));
    public static final RegistryObject<FlowingFluid> FLOWING_OSIUM = registerFlowing("flowing_osium", () -> properties(OSIUM, FLOWING_OSIUM, 0xFF5A321E));

    public static final RegistryObject<FlowingFluid> IGNITZ = registerSource("ignitz", () -> properties(IGNITZ, FLOWING_IGNITZ, 0xFFFF5555));
    public static final RegistryObject<FlowingFluid> FLOWING_IGNITZ = registerFlowing("flowing_ignitz", () -> properties(IGNITZ, FLOWING_IGNITZ, 0xFFFF5555));

    public static final RegistryObject<FlowingFluid> AUROREUM = registerSource("auroreum", () -> properties(AUROREUM, FLOWING_AUROREUM, 0xFFF2D56B));
    public static final RegistryObject<FlowingFluid> FLOWING_AUROREUM = registerFlowing("flowing_auroreum", () -> properties(AUROREUM, FLOWING_AUROREUM, 0xFFF2D56B));

    public static final RegistryObject<FlowingFluid> TRIUM = registerSource("trium", () -> properties(TRIUM, FLOWING_TRIUM, 0xFFD0D0D0));
    public static final RegistryObject<FlowingFluid> FLOWING_TRIUM = registerFlowing("flowing_trium", () -> properties(TRIUM, FLOWING_TRIUM, 0xFFD0D0D0));

    private static RegistryObject<FlowingFluid> registerSource(String id, java.util.function.Supplier<ForgeFlowingFluid.Properties> properties) {
        return FLUIDS.register(id, () -> new ForgeFlowingFluid.Source(properties.get()));
    }

    private static RegistryObject<FlowingFluid> registerFlowing(String id, java.util.function.Supplier<ForgeFlowingFluid.Properties> properties) {
        return FLUIDS.register(id, () -> new ForgeFlowingFluid.Flowing(properties.get()));
    }

    private static ForgeFlowingFluid.Properties properties(
            java.util.function.Supplier<? extends FlowingFluid> source,
            java.util.function.Supplier<? extends FlowingFluid> flowing,
            int color) {
        return new ForgeFlowingFluid.Properties(source, flowing, attributes(color))
                .block(() -> blockFor(source).get())
                .bucket(() -> bucketFor(source).get());
    }

    @SuppressWarnings("unchecked")
    private static RegistryObject<net.minecraft.block.FlowingFluidBlock> blockFor(java.util.function.Supplier<? extends FlowingFluid> source) {
        if (source == OSIUM) return Sakalti2Blocks.OSIUM_FLUID_BLOCK;
        if (source == IGNITZ) return Sakalti2Blocks.IGNITZ_FLUID_BLOCK;
        if (source == AUROREUM) return Sakalti2Blocks.AUROREUM_FLUID_BLOCK;
        return Sakalti2Blocks.TRIUM_FLUID_BLOCK;
    }

    private static RegistryObject<? extends net.minecraft.item.Item> bucketFor(java.util.function.Supplier<? extends FlowingFluid> source) {
        if (source == OSIUM) return Sakalti2Items.OSIUM_BUCKET;
        if (source == IGNITZ) return Sakalti2Items.IGNITZ_BUCKET;
        if (source == AUROREUM) return Sakalti2Items.AUROREUM_BUCKET;
        return Sakalti2Items.TRIUM_BUCKET;
    }

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }

    private Sakalti2Fluids() {}
}
