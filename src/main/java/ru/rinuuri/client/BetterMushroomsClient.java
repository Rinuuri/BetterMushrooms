package ru.rinuuri.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderContext;
import net.minecraft.client.render.RenderLayer;
import ru.rinuuri.block.ModBlocks;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class BetterMushroomsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.chanterelle, RenderLayer.getCutout());
    }
}
