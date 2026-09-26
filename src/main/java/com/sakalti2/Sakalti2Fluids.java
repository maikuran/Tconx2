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
            DeferredRegister.create(
                    ForgeRegistries.FLUIDS,
                    Sakalti2Main.MODID
            );

    /*
     * ------------------------------------------------------------
     * Fluid registry objects
     * ------------------------------------------------------------
     *
     * ここでは他のFluid RegistryObjectを直接初期化式から
     * 参照しない。
     *
     * properties() 内では ResourceLocation から registry を
     * 解決するため、Javaの illegal forward reference を
     * 完全に回避できる。
     */

    public static final RegistryObject<FlowingFluid> OSIUM =
            registerSource("osium", "flowing_osium", "osium");

    public static final RegistryObject<FlowingFluid> FLOWING_OSIUM =
            registerFlowing("flowing_osium", "osium", "flowing_osium");

    public static final RegistryObject<FlowingFluid> IGNITZ =
            registerSource("ignitz", "flowing_ignitz", "ignitz");

    public static final RegistryObject<FlowingFluid> FLOWING_IGNITZ =
            registerFlowing("flowing_ignitz", "ignitz", "flowing_ignitz");

    public static final RegistryObject<FlowingFluid> AUROREUM =
            registerSource("auroreum", "flowing_auroreum", "auroreum");

    public static final RegistryObject<FlowingFluid> FLOWING_AUROREUM =
            registerFlowing("flowing_auroreum", "auroreum", "flowing_auroreum");

    public static final RegistryObject<FlowingFluid> TRIUM =
            registerSource("trium", "flowing_trium", "trium");

    public static final RegistryObject<FlowingFluid> FLOWING_TRIUM =
            registerFlowing("flowing_trium", "trium", "flowing_trium");


    /*
     * ------------------------------------------------------------
     * Registration
     * ------------------------------------------------------------
     */

    private static RegistryObject<FlowingFluid> registerSource(
            String id,
            String flowingId,
            String blockId) {

        return FLUIDS.register(
                id,
                () -> new ForgeFlowingFluid.Source(
                        properties(id, flowingId, blockId)
                )
        );
    }

    private static RegistryObject<FlowingFluid> registerFlowing(
            String id,
            String sourceId,
            String blockId) {

        return FLUIDS.register(
                id,
                () -> new ForgeFlowingFluid.Flowing(
                        properties(sourceId, id, blockId)
                )
        );
    }


    /*
     * ------------------------------------------------------------
     * Properties
     * ------------------------------------------------------------
     *
     * 重要：
     *
     * OSIUM / FLOWING_OSIUM などを直接参照しない。
     *
     * RegistryObjectの相互参照をここで行うと、
     * Fluid -> Block -> Fluid
     * Fluid -> Item -> Fluid
     * の循環初期化を作ってしまう。
     *
     * そのため、registry nameを使って登録時に解決する。
     */

    private static ForgeFlowingFluid.Properties properties(
            String sourceId,
            String flowingId,
            String blockId) {

        int color = colorFor(sourceId);

        Supplier<FlowingFluid> source =
                () -> getFluid(sourceId);

        Supplier<FlowingFluid> flowing =
                () -> getFluid(flowingId);

        Supplier<FlowingFluidBlock> block =
                () -> getFluidBlock(blockId);

        Supplier<Item> bucket =
                () -> getBucket(sourceId);

        return new ForgeFlowingFluid.Properties(
                source,
                flowing,
                attributes(color)
        )
                .block(block)
                .bucket(bucket);
    }


    /*
     * ------------------------------------------------------------
     * Registry lookup
     * ------------------------------------------------------------
     */

    private static FlowingFluid getFluid(String id) {

        Fluid fluid = FLUIDS.getEntries().stream()
                .filter(entry ->
                        entry.getId().getPath().equals(id))
                .map(RegistryObject::get)
                .findFirst()
                .orElseThrow(() ->
                        new IllegalStateException(
                                "Sakalti2 fluid not registered: " + id
                        )
                );

        return (FlowingFluid) fluid;
    }


    private static FlowingFluidBlock getFluidBlock(String id) {

        RegistryObject<FlowingFluidBlock> block;

        switch (id) {

            case "osium":
                block = Sakalti2Blocks.OSIUM_FLUID_BLOCK;
                break;

            case "ignitz":
                block = Sakalti2Blocks.IGNITZ_FLUID_BLOCK;
                break;

            case "auroreum":
                block = Sakalti2Blocks.AUROREUM_FLUID_BLOCK;
                break;

            case "trium":
                block = Sakalti2Blocks.TRIUM_FLUID_BLOCK;
                break;

            default:
                throw new IllegalStateException(
                        "Unknown Sakalti2 fluid block: " + id
                );
        }

        return block.get();
    }


    private static Item getBucket(String sourceId) {

        switch (sourceId) {

            case "osium":
                return Sakalti2Items.OSIUM_BUCKET.get();

            case "ignitz":
                return Sakalti2Items.IGNITZ_BUCKET.get();

            case "auroreum":
                return Sakalti2Items.AUROREUM_BUCKET.get();

            case "trium":
                return Sakalti2Items.TRIUM_BUCKET.get();

            default:
                throw new IllegalStateException(
                        "Unknown Sakalti2 fluid bucket: " + sourceId
                );
        }
    }


    /*
     * ------------------------------------------------------------
     * Fluid attributes
     * ------------------------------------------------------------
     */

    private static FluidAttributes.Builder attributes(int color) {

        return FluidAttributes.builder(
                        new ResourceLocation(
                                "minecraft",
                                "block/water_still"
                        ),
                        new ResourceLocation(
                                "minecraft",
                                "block/water_flow"
                        )
                )
                .color(color)
                .density(2000)
                .viscosity(2500)
                .luminosity(0);
    }


    private static int colorFor(String id) {

        switch (id) {

            case "osium":
                return 0xFF5A321E;

            case "ignitz":
                return 0xFFFF5555;

            case "auroreum":
                return 0xFFF2D56B;

            case "trium":
                return 0xFFD0D0D0;

            default:
                throw new IllegalArgumentException(
                        "Unknown Sakalti2 fluid: " + id
                );
        }
    }


    public static void register(IEventBus bus) {
        FLUIDS.register(bus);
    }


    private Sakalti2Fluids() {
    }
}
