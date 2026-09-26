package com.sakalti2.worldgen;

import com.sakalti2.Sakalti2Blocks;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class Sakalti2OreGeneration {
    private static ConfiguredFeature<?, ?> ore(net.minecraft.block.BlockState target, net.minecraft.block.BlockState replacement,
                                                int size, int count, int minY, int maxY) {
        return Feature.ORE.configured(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.create("sakalti2_target", target::equals),
                replacement, size))
                .decorated(Placement.RANGE.configured(new CountRangeConfig(count, minY, 0, maxY)))
                .squared();
    }

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        Biome.Category category = event.getCategory();
        if (category == Biome.Category.NETHER) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                    .add(ore(Blocks.NETHERRACK.defaultBlockState(), Sakalti2Blocks.IGNITZ_ORE.get().defaultBlockState(), 5, 7, 5, 32));
            // Ratio is dimension-independent, so Trium may also occur here at a low rate.
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                    .add(ore(Blocks.NETHERRACK.defaultBlockState(), Sakalti2Blocks.TRIUM_ORE.get().defaultBlockState(), 3, 2, 4, 24));
        } else if (category == Biome.Category.THEEND) {
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                    .add(ore(Blocks.END_STONE.defaultBlockState(), Sakalti2Blocks.AUROREUM_ORE.get().defaultBlockState(), 4, 6, 8, 40));
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                    .add(ore(Blocks.END_STONE.defaultBlockState(), Sakalti2Blocks.TRIUM_ORE.get().defaultBlockState(), 3, 2, 4, 24));
        } else {
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                    .add(ore(Blocks.STONE.defaultBlockState(), Sakalti2Blocks.OSIUM_ORE.get().defaultBlockState(), 6, 8, 5, 80));
            event.getGeneration().getFeatures(GenerationStage.Decoration.UNDERGROUND_ORES)
                    .add(ore(Blocks.STONE.defaultBlockState(), Sakalti2Blocks.TRIUM_ORE.get().defaultBlockState(), 3, 3, 4, 32));
        }
    }

    private Sakalti2OreGeneration() {}
}
