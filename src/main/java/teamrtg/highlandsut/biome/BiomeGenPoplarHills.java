package teamrtg.highlandsut.biome;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlandsut.generator.HighlandsGenerators;

public class BiomeGenPoplarHills extends BiomeGenBaseHighlands {

    private static BiomeProperties properties = new Biome.BiomeProperties("Poplar Hills")
        .setBaseHeight(-0.1F)
        .setHeightVariation(0.4F)
        .setTemperature(0.6F)
        .setRainfall(0.8F);

    public BiomeGenPoplarHills(int par1) {

        super(properties);

        theBiomeDecorator.treesPerChunk = 6;
        theBiomeDecorator.grassPerChunk = 10;
        theBiomeDecorator.flowersPerChunk = 4;

        plants.add(HighlandsGenerators.mcOrchid);
        plants.add(HighlandsGenerators.mcDaisy);
    }


    public WorldGenAbstractTree genBigTreeChance(Random par1Random) {

        return HighlandsGenerators.poplarGen;
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        genStandardOre(10, HighlandsGenerators.hlwater, 10, 64, world, random, pos);
        genStandardOre(theBiomeDecorator.chunkProviderSettings.diamondCount / 2, theBiomeDecorator.diamondGen, theBiomeDecorator.chunkProviderSettings.diamondMinHeight, theBiomeDecorator.chunkProviderSettings.diamondMaxHeight, world, random, pos);
    }
}
