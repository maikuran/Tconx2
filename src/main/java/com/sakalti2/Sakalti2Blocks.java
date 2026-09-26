package com.sakalti2;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class Sakalti2Blocks {
 public static final DeferredRegister<Block> BLOCKS=DeferredRegister.create(ForgeRegistries.BLOCKS,Sakalti2Main.MODID);
 public static final RegistryObject<Block> OSIUM_ORE=ore("osium_ore",4); public static final RegistryObject<Block> IGNITZ_ORE=ore("ignitz_ore",5); public static final RegistryObject<Block> AUROREUM_ORE=ore("auroreum_ore",5); public static final RegistryObject<Block> TRIUM_ORE=ore("trium_ore",5);
 public static final RegistryObject<Block> OSIUM_BLOCK=metal("osium_block"); public static final RegistryObject<Block> IGNITZ_BLOCK=metal("ignitz_block"); public static final RegistryObject<Block> AUROREUM_BLOCK=metal("auroreum_block"); public static final RegistryObject<Block> TRIUM_BLOCK=metal("trium_block");
 public static final RegistryObject<FlowingFluidBlock> OSIUM_FLUID_BLOCK=fluid("osium_fluid", () -> Sakalti2Fluids.OSIUM.get()); public static final RegistryObject<FlowingFluidBlock> IGNITZ_FLUID_BLOCK=fluid("ignitz_fluid", () -> Sakalti2Fluids.IGNITZ.get()); public static final RegistryObject<FlowingFluidBlock> AUROREUM_FLUID_BLOCK=fluid("auroreum_fluid", () -> Sakalti2Fluids.AUROREUM.get()); public static final RegistryObject<FlowingFluidBlock> TRIUM_FLUID_BLOCK=fluid("trium_fluid", () -> Sakalti2Fluids.TRIUM.get());
 private static RegistryObject<Block> ore(String id,float h){return BLOCKS.register(id,()->new Block(AbstractBlock.Properties.of(Material.STONE).strength(h,6).sound(SoundType.STONE)));}
 private static RegistryObject<Block> metal(String id){return BLOCKS.register(id,()->new Block(AbstractBlock.Properties.of(Material.METAL).strength(6,8).sound(SoundType.METAL)));}
 private static RegistryObject<FlowingFluidBlock> fluid(String id, java.util.function.Supplier<net.minecraft.fluid.FlowingFluid> fluid){return BLOCKS.register(id,()->new FlowingFluidBlock(fluid,AbstractBlock.Properties.of(Material.WATER).noCollission().strength(100).noDrops()));}
 public static void register(IEventBus bus){BLOCKS.register(bus);}
 private Sakalti2Blocks(){}
}
