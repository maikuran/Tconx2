package com.sakalti2;

import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Sakalti2Blocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Sakalti2Main.MODID);

    public static final RegistryObject<Block> OSIUM_ORE = ore("osium_ore", 4.0F, 2);
    public static final RegistryObject<Block> IGNITZ_ORE = ore("ignitz_ore", 5.0F, 3);
    public static final RegistryObject<Block> AUROREUM_ORE = ore("auroreum_ore", 5.0F, 3);
    public static final RegistryObject<Block> TRIUM_ORE = ore("trium_ore", 5.0F, 2);
    public static final RegistryObject<Block> IRES_ORE = ore("ires_ore", 24.0F, 4);
    public static final RegistryObject<Block> SONARIUM_ORE = ore("sonarium_ore", 21.0F, 4);
    public static final RegistryObject<Block> RINALITE_ORE = ore("rinalite_ore", 20.0F, 4);
    public static final RegistryObject<Block> MAGNUM_ORE = ore("magnum_ore", 27.0F, 4);

    public static final RegistryObject<Block> OSIUM_BLOCK = metal("osium_block", 5.5F, 8.0F);
    public static final RegistryObject<Block> IGNITZ_BLOCK = metal("ignitz_block", 6.0F, 10.0F);
    public static final RegistryObject<Block> AUROREUM_BLOCK = metal("auroreum_block", 6.5F, 11.0F);
    public static final RegistryObject<Block> TRIUM_BLOCK = metal("trium_block", 4.5F, 7.0F);
    public static final RegistryObject<Block> ZARLON_BLOCK = metal("zarlon_block", 7.0F, 12.0F);
    public static final RegistryObject<Block> KNITZ_BLOCK = metal("knitz_block", 7.5F, 13.0F);
    public static final RegistryObject<Block> SITUAN_BLOCK = metal("situan_block", 8.0F, 14.0F);
    public static final RegistryObject<Block> HINEUR_BLOCK = metal("hineur_block", 8.5F, 15.0F);
    public static final RegistryObject<Block> IRES_BLOCK = metal("ires_block", 12.0F, 24.0F);
    public static final RegistryObject<Block> SONARIUM_BLOCK = metal("sonarium_block", 11.0F, 22.0F);
    public static final RegistryObject<Block> RINALITE_BLOCK = metal("rinalite_block", 10.5F, 20.0F);
    public static final RegistryObject<Block> MAGNUM_BLOCK = metal("magnum_block", 13.5F, 28.0F);
    public static final RegistryObject<Block> BABELIUM_BLOCK = metal("babelium_block", 12.5F, 26.0F);

    public static final RegistryObject<FlowingFluidBlock> OSIUM_FLUID_BLOCK =
            fluid("osium_fluid", () -> Sakalti2Fluids.OSIUM.get(), 41.0F);
    public static final RegistryObject<FlowingFluidBlock> IGNITZ_FLUID_BLOCK =
            fluid("ignitz_fluid", () -> Sakalti2Fluids.IGNITZ.get(), 82.0F);
    public static final RegistryObject<FlowingFluidBlock> AUROREUM_FLUID_BLOCK =
            fluid("auroreum_fluid", () -> Sakalti2Fluids.AUROREUM.get(), 70.0F);
    public static final RegistryObject<FlowingFluidBlock> TRIUM_FLUID_BLOCK =
            fluid("trium_fluid", () -> Sakalti2Fluids.TRIUM.get(), 50.0F);
    public static final RegistryObject<FlowingFluidBlock> ZARLON_FLUID_BLOCK =
            fluid("zarlon_fluid", () -> Sakalti2Fluids.ZARLON.get(), 145.0F);
    public static final RegistryObject<FlowingFluidBlock> KNITZ_FLUID_BLOCK =
            fluid("knitz_fluid", () -> Sakalti2Fluids.KNITZ.get(), 165.0F);
    public static final RegistryObject<FlowingFluidBlock> SITUAN_FLUID_BLOCK =
            fluid("situan_fluid", () -> Sakalti2Fluids.SITUAN.get(), 185.0F);
    public static final RegistryObject<FlowingFluidBlock> HINEUR_FLUID_BLOCK =
            fluid("hineur_fluid", () -> Sakalti2Fluids.HINEUR.get(), 120.0F);
    public static final RegistryObject<FlowingFluidBlock> IRES_FLUID_BLOCK =
            fluid("ires_fluid", () -> Sakalti2Fluids.IRES.get(), 355.0F);
    public static final RegistryObject<FlowingFluidBlock> SONARIUM_FLUID_BLOCK =
            fluid("sonarium_fluid", () -> Sakalti2Fluids.SONARIUM.get(), 285.0F);
    public static final RegistryObject<FlowingFluidBlock> RINALITE_FLUID_BLOCK =
            fluid("rinalite_fluid", () -> Sakalti2Fluids.RINALITE.get(), 270.0F);
    public static final RegistryObject<FlowingFluidBlock> MAGNUM_FLUID_BLOCK =
            fluid("magnum_fluid", () -> Sakalti2Fluids.MAGNUM.get(), 330.0F);
    public static final RegistryObject<FlowingFluidBlock> BABELIUM_FLUID_BLOCK =
            fluid("babelium_fluid", () -> Sakalti2Fluids.BABELIUM.get(), 345.0F);

    private static RegistryObject<Block> ore(String id, float hardness, int harvestLevel) {
        return BLOCKS.register(id, () -> new Block(
                AbstractBlock.Properties.of(Material.STONE)
                        .strength(hardness, 6.0F)
                        .harvestLevel(harvestLevel)
                        .sound(SoundType.STONE)));
    }

    private static RegistryObject<Block> metal(String id, float hardness, float explosionResistance) {
        return BLOCKS.register(id, () -> new Block(
                AbstractBlock.Properties.of(Material.METAL)
                        .strength(hardness, explosionResistance)
                        .sound(SoundType.METAL)));
    }

    private static RegistryObject<FlowingFluidBlock> fluid(
            String id,
            Supplier<FlowingFluid> fluid,
            float explosionResistance) {
        return BLOCKS.register(id, () -> new FlowingFluidBlock(
                fluid,
                AbstractBlock.Properties.of(Material.WATER)
                        .noCollission()
                        .strength(100.0F, explosionResistance)
                        .noDrops()));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }

    private Sakalti2Blocks() {}
}
