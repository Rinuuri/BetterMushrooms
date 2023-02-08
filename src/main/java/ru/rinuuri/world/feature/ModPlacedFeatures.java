package ru.rinuuri.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class ModPlacedFeatures {

    public static final RegistryEntry<PlacedFeature> huge_chanterelle_placed =
            PlacedFeatures.register("huge_chanterelle_placed", ModConfiguredFeatures.huge_chanterelle_spawn);

}
