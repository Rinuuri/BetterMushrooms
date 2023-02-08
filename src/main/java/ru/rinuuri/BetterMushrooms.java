package ru.rinuuri;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.rinuuri.block.ModBlocks;
import ru.rinuuri.world.feature.ModConfiguredFeatures;
import ru.rinuuri.world.gen.ModMushroomGeneration;


public class BetterMushrooms implements ModInitializer {

    public static final String MOD_ID = "better_mushrooms";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    @Override
    public void onInitialize(){

        ModConfiguredFeatures.registerConfiguredFeatures();


        ModBlocks.registerModBlocks();

        ModMushroomGeneration.generateMushrooms();
    }
}
