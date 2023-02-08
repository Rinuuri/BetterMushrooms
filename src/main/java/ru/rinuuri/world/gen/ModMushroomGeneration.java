package ru.rinuuri.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import ru.rinuuri.world.feature.ModPlacedFeatures;

import java.util.ArrayList;
import java.util.Collection;

public class ModMushroomGeneration {

    public static void generateMushrooms(){
        /*Collection<RegistryKey<Biome>> biomes = new ArrayList<RegistryKey<Biome>>();

        biomes.add(BiomeKeys.MUSHROOM_FIELDS);
        biomes.add(BiomeKeys.DARK_FOREST);*/

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MUSHROOM_FIELDS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.huge_chanterelle_placed.getKey().get());
    }
}
