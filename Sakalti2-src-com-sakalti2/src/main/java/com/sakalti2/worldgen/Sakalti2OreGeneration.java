package com.sakalti2.worldgen;

import com.sakalti2.Sakalti2Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public final class Sakalti2OreGeneration {
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        // Worldgen hooks are intentionally kept isolated here so the four Rank-1 materials
        // can later receive independent configured/placed features without touching registries.
        Biome.Category category = event.getCategory();
        if (category == Biome.Category.THEEND) {
            // Auroreum is the Mystic/End material.
        } else if (category == Biome.Category.NETHER) {
            // Ignitz is the Hell material.
        } else {
            // Osium is the Geo material; Trium is Ratio and is not dimension-bound.
        }
    }
    private Sakalti2OreGeneration() {}
}
