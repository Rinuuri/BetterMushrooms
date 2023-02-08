package ru.rinuuri.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import ru.rinuuri.BetterMushrooms;
import ru.rinuuri.world.feature.ModConfiguredFeatures;

import java.util.function.Supplier;

public class ModBlocks {
    public static final Block chanterelle = registerBlock("chanterelle", new MushroomPlantBlock(FabricBlockSettings.of(Material.PLANT).breakInstantly().luminance(1).collidable(false),

            new Supplier<RegistryEntry<? extends ConfiguredFeature<?, ?>>>() {
                @Override
                public RegistryEntry<? extends ConfiguredFeature<?, ?>> get() {
                    return ModConfiguredFeatures.huge_chanterelle;
                }
            }

    ), ItemGroup.DECORATIONS);
    public static final Block chanterelle_block = registerBlock("chanterelle_block", new Block(FabricBlockSettings.of(Material.WOOD).hardness(0.2f).dropsNothing()), ItemGroup.DECORATIONS);
    public static final Block chanterelle_stem = registerBlock("chanterelle_stem", new Block(FabricBlockSettings.of(Material.WOOD).hardness(0.2f).dropsNothing()), ItemGroup.DECORATIONS);

    private static Block registerBlock(String name, Block block, ItemGroup tab){
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(BetterMushrooms.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup tab){
        return Registry.register(Registry.ITEM, new Identifier(BetterMushrooms.MOD_ID, name), new BlockItem(block, new FabricItemSettings().group(tab)));
    }
    public static void registerModBlocks(){
        BetterMushrooms.LOGGER.debug("registering blocks");
    }

}
