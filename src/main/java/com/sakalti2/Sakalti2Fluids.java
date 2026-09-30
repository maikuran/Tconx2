package com.sakalti2;

import java.util.function.Supplier;

import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.item.Item;
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

    public static final FluidEntry OSIUM_ENTRY = registerFluid("osium", 0xFF5A321E, 2000, 1000, 1900);
    public static final RegistryObject<ForgeFlowingFluid> OSIUM = OSIUM_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_OSIUM = OSIUM_ENTRY.flowing;

    public static final FluidEntry IGNITZ_ENTRY = registerFluid("ignitz", 0xFFFF5555, 2000, 1000, 1900);
    public static final RegistryObject<ForgeFlowingFluid> IGNITZ = IGNITZ_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_IGNITZ = IGNITZ_ENTRY.flowing;

    public static final FluidEntry AUROREUM_ENTRY = registerFluid("auroreum", 0xFFF2D56B, 2000, 1000, 1900);
    public static final RegistryObject<ForgeFlowingFluid> AUROREUM = AUROREUM_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_AUROREUM = AUROREUM_ENTRY.flowing;

    public static final FluidEntry TRIUM_ENTRY = registerFluid("trium", 0xFFD0D0D0, 2000, 1000, 1900);
    public static final RegistryObject<ForgeFlowingFluid> TRIUM = TRIUM_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_TRIUM = TRIUM_ENTRY.flowing;

    public static final FluidEntry ZARLON_ENTRY = registerFluid("zarlon", 0xFF9137C0, 2100, 1100, 1050);
    public static final RegistryObject<ForgeFlowingFluid> ZARLON = ZARLON_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_ZARLON = ZARLON_ENTRY.flowing;

    public static final FluidEntry KNITZ_ENTRY = registerFluid("knitz", 0xFF7D1638, 2200, 1150, 1150);
    public static final RegistryObject<ForgeFlowingFluid> KNITZ = KNITZ_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_KNITZ = KNITZ_ENTRY.flowing;

    public static final FluidEntry SITUAN_ENTRY = registerFluid("situan", 0xFF2E70D0, 2050, 1050, 1000);
    public static final RegistryObject<ForgeFlowingFluid> SITUAN = SITUAN_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_SITUAN = SITUAN_ENTRY.flowing;

    public static final FluidEntry HINEUR_ENTRY = registerFluid("hineur", 0xFF25A96C, 2150, 1080, 950);
    public static final RegistryObject<ForgeFlowingFluid> HINEUR = HINEUR_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_HINEUR = HINEUR_ENTRY.flowing;

    public static final FluidEntry IRES_ENTRY = registerFluid("ires", 0xFFFFFFFF, 2300, 1250, 1350);
    public static final RegistryObject<ForgeFlowingFluid> IRES = IRES_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_IRES = IRES_ENTRY.flowing;

    public static final FluidEntry SONARIUM_ENTRY = registerFluid("sonarium", 0xFFE34A28, 2350, 1200, 1250);
    public static final RegistryObject<ForgeFlowingFluid> SONARIUM = SONARIUM_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_SONARIUM = SONARIUM_ENTRY.flowing;

    public static final FluidEntry RINALITE_ENTRY = registerFluid("rinalite", 0xFFF4A9BE, 2200, 1180, 1225);
    public static final RegistryObject<ForgeFlowingFluid> RINALITE = RINALITE_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_RINALITE = RINALITE_ENTRY.flowing;

    public static final FluidEntry MAGNUM_ENTRY = registerFluid("magnum", 0xFFA52E72, 2450, 1300, 1400);
    public static final RegistryObject<ForgeFlowingFluid> MAGNUM = MAGNUM_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_MAGNUM = MAGNUM_ENTRY.flowing;

    public static final FluidEntry BABELIUM_ENTRY = registerFluid("babelium", 0xFFD8B5FF, 2500, 1320, 1450);
    public static final RegistryObject<ForgeFlowingFluid> BABELIUM = BABELIUM_ENTRY.source;
    public static final RegistryObject<ForgeFlowingFluid> FLOWING_BABELIUM = BABELIUM_ENTRY.flowing;


    private static FluidEntry registerFluid(
            String name,
            int color,
            int density,
            int viscosity,
            int temperature) {

        FluidEntry entry = new FluidEntry(name, color, density, viscosity, temperature);

        entry.source = FLUIDS.register(
                name,
                () -> new ForgeFlowingFluid.Source(createProperties(entry)));

        entry.flowing = FLUIDS.register(
                name + "_flow",
                () -> new ForgeFlowingFluid.Flowing(createProperties(entry)));

        return entry;
    }

    private static ForgeFlowingFluid.Properties createProperties(FluidEntry entry) {
        ResourceLocation still = new ResourceLocation(
                Sakalti2Main.MODID,
                "fluid/" + entry.name + "_still");

        ResourceLocation flowing = new ResourceLocation(
                Sakalti2Main.MODID,
                "fluid/" + entry.name + "_flow");

        FluidAttributes.Builder attributes = FluidAttributes.builder(still, flowing)
                .color(entry.color)
                .density(entry.density)
                .viscosity(entry.viscosity)
                .temperature(entry.temperature);

        return new ForgeFlowingFluid.Properties(
                entry.source,
                entry.flowing,
                attributes)
                .slopeFindDistance(4)
                .levelDecreasePerBlock(1)
                .block(() -> findFluidBlock(entry.name).get())
                .bucket(() -> findBucket(entry.name).get());
    }

    @SuppressWarnings("unchecked")
    private static RegistryObject<FlowingFluidBlock> findFluidBlock(String name) {
        String id = name + "_fluid";
        return (RegistryObject<FlowingFluidBlock>) (RegistryObject<?>) Sakalti2Blocks.BLOCKS
                .getEntries()
                .stream()
                .filter(entry -> entry.getId().getPath().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Missing Sakalti2 fluid block: " + id));
    }

    @SuppressWarnings("unchecked")
    private static RegistryObject<Item> findBucket(String name) {
        String id = name + "_bucket";
        return (RegistryObject<Item>) (RegistryObject<?>) Sakalti2Items.ITEMS
                .getEntries()
                .stream()
                .filter(entry -> entry.getId().getPath().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Missing Sakalti2 fluid bucket: " + id));
    }

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }

    public static final class FluidEntry {
        public final String name;
        public final int color;
        public final int density;
        public final int viscosity;
        public final int temperature;
        private RegistryObject<ForgeFlowingFluid> source;
        private RegistryObject<ForgeFlowingFluid> flowing;

        private FluidEntry(String name, int color, int density, int viscosity, int temperature) {
            this.name = name;
            this.color = color;
            this.density = density;
            this.viscosity = viscosity;
            this.temperature = temperature;
        }
    }

    private Sakalti2Fluids() {}
}
