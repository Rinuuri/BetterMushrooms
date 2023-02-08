package ru.rinuuri.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import ru.rinuuri.BetterMushrooms;
import ru.rinuuri.block.ModBlocks;
import ru.rinuuri.world.feature.Mushrooms.HugeChanterelleFeature;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryEntry<ConfiguredFeature<HugeMushroomFeatureConfig, ?>> huge_chanterelle =
            ConfiguredFeatures.register("huge_chanterelle", new HugeChanterelleFeature(HugeMushroomFeatureConfig.CODEC), new HugeMushroomFeatureConfig(

                    BlockStateProvider.of(ModBlocks.chanterelle_block),
                    BlockStateProvider.of(ModBlocks.chanterelle_stem),
                    3

            ) );

    public static final RegistryEntry<PlacedFeature> huge_chanterelle_checked = PlacedFeatures.register("huge_chanterelle_checked", ModConfiguredFeatures.huge_chanterelle, List.of(PlacedFeatures.wouldSurvive(ModBlocks.chanterelle)));


    public static final RegistryEntry<ConfiguredFeature<RandomFeatureConfig, ?>> huge_chanterelle_spawn = ConfiguredFeatures.register("huge_chanterelle_spawn", Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(new RandomFeatureEntry(huge_chanterelle_checked, 0.5f)), huge_chanterelle_checked));

    public static void registerConfiguredFeatures(){
        BetterMushrooms.LOGGER.debug("registering configured features");

    }
}
