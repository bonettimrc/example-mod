package com.example.examplemod.feature;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.block.ExampleModBlocks;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = ExampleMod.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFeatures {

        public static ConfiguredFeature<?, ?> FEDERICHITE_ORE_CONFIG;

        @SubscribeEvent
        public static void setup(FMLCommonSetupEvent event) {
                FEDERICHITE_ORE_CONFIG = Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, "federichite_ore",
                                Feature.ORE.configured(
                                                new OreFeatureConfig(
                                                                OreFeatureConfig.FillerBlockType.NATURAL_STONE,
                                                                ExampleModBlocks.FEDERICHITE_ORE.get()
                                                                                .defaultBlockState(),
                                                                9))
                                                .range(64).squared().count(20));
        }
}