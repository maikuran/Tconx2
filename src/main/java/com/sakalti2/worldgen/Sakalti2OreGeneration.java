package com.sakalti2.worldgen;

import com.sakalti2.Sakalti2Blocks;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "sakalti2", bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class Sakalti2OreGeneration {
    private static ConfiguredFeature<?, ?> ore(RuleTest target, BlockState replacement,
                                                int size, int count, int minY, int maxY) {
        return Feature.ORE.configured(new OreFeatureConfig(target, replacement, size))
                .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minY, 0, maxY)))
                .squared()
                .count(count);
    }

    private static void add(BiomeGenerationSettingsBuilder generation, RuleTest target, BlockState replacement,
                            int size, int count, int minY, int maxY) {
        generation.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                ore(target, replacement, size, count, minY, maxY));
    }

    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        Biome.Category category = event.getCategory();
        BiomeGenerationSettingsBuilder generation = event.getGeneration();

        if (category == Biome.Category.NETHER) {
            add(generation, OreFeatureConfig.FillerBlockType.NETHERRACK,
                    Sakalti2Blocks.IGNITZ_ORE.get().defaultBlockState(), 5, 7, 5, 32);
            // Ratio/Trium is dimension-independent and therefore also occurs in the Nether.
            add(generation, OreFeatureConfig.FillerBlockType.NETHERRACK,
                    Sakalti2Blocks.TRIUM_ORE.get().defaultBlockState(), 3, 2, 4, 24);
        } else if (category == Biome.Category.THEEND) {
            add(generation, new BlockMatchRuleTest(Blocks.END_STONE),
                    Sakalti2Blocks.AUROREUM_ORE.get().defaultBlockState(), 4, 6, 8, 40);
            add(generation, new BlockMatchRuleTest(Blocks.END_STONE),
                    Sakalti2Blocks.TRIUM_ORE.get().defaultBlockState(), 3, 2, 4, 24);
        } else {
            // NATURAL_STONE covers stone, granite, diorite, and andesite in 1.16.5.
            add(generation, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    Sakalti2Blocks.OSIUM_ORE.get().defaultBlockState(), 6, 8, 5, 80);
            add(generation, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    Sakalti2Blocks.TRIUM_ORE.get().defaultBlockState(), 3, 3, 4, 32);
            add(generation, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    Sakalti2Blocks.IRES_ORE.get().defaultBlockState(), 4, 5, 8, 28);
            add(generation, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    Sakalti2Blocks.SONARIUM_ORE.get().defaultBlockState(), 5, 6, 12, 48);
            add(generation, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    Sakalti2Blocks.RINALITE_ORE.get().defaultBlockState(), 5, 5, 20, 60);
            add(generation, OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                    Sakalti2Blocks.MAGNUM_ORE.get().defaultBlockState(), 4, 4, 4, 24);
        }
    }

    private Sakalti2OreGeneration() {}
}
