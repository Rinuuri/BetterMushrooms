package ru.rinuuri.world.feature.Mushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.MushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.HugeMushroomFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public class HugeChanterelleFeature
extends HugeMushroomFeature {
    public HugeChanterelleFeature(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }

    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config) {
        int i = config.foliageRadius;
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                boolean bl6;
                boolean bl = j == -i;
                boolean bl2 = j == i;
                boolean bl3 = k == -i;
                boolean bl4 = k == i;
                boolean bl5 = bl || bl2;
                boolean bl7 = bl6 = bl3 || bl4;
                if (bl5 && bl6) continue;


                if (j == -i || k == -i || j == i || k == i) mutable.set(start, j, y-1, k);
                else mutable.set(start, j, y, k);


                if (world.getBlockState(mutable).isOpaqueFullCube(world, mutable)) continue;
                boolean bl72 = bl || bl6 && j == 1 - i;
                boolean bl8 = bl2 || bl6 && j == i - 1;
                boolean bl9 = bl3 || bl5 && k == 1 - i;
                boolean bl10 = bl4 || bl5 && k == i - 1;
                BlockState blockState = config.capProvider.getBlockState(random, start);
                if (blockState.contains(MushroomBlock.WEST) && blockState.contains(MushroomBlock.EAST) && blockState.contains(MushroomBlock.NORTH) && blockState.contains(MushroomBlock.SOUTH)) {
                    blockState = (BlockState)((BlockState)((BlockState)((BlockState)blockState.with(MushroomBlock.WEST, bl72)).with(MushroomBlock.EAST, bl8)).with(MushroomBlock.NORTH, bl9)).with(MushroomBlock.SOUTH, bl10);
                }
                this.setBlockState(world, mutable, blockState);
            }
        }
    }

    @Override
    protected void generateStem(WorldAccess world, Random random, BlockPos pos, HugeMushroomFeatureConfig config, int height, BlockPos.Mutable mutablePos) {
        for (int i = 0; i < height; ++i) {
            mutablePos.set(pos).move(Direction.UP, i);
            if (world.getBlockState(mutablePos).isOpaqueFullCube(world, mutablePos)) continue;
            if (i != height-1) this.setBlockState(world, mutablePos, config.stemProvider.getBlockState(random, pos));
            else {
                this.setBlockState(world, mutablePos.add(1, 0, 0), config.stemProvider.getBlockState(random, pos));
                this.setBlockState(world, mutablePos.add(-1, 0, 0), config.stemProvider.getBlockState(random, pos));
                this.setBlockState(world, mutablePos.add(0, 0, 1), config.stemProvider.getBlockState(random, pos));
                this.setBlockState(world, mutablePos.add(0, 0, -1), config.stemProvider.getBlockState(random, pos));
                this.setBlockState(world, mutablePos, config.stemProvider.getBlockState(random, pos));
            }
        }
    }

    @Override
    protected int getCapSize(int i, int j, int capSize, int y) {
        return y <= 3 ? 0 : capSize;
    }
}

