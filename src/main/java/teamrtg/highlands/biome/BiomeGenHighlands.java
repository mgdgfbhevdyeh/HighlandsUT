package teamrtg.highlands.biome;

import java.util.Random;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import teamrtg.highlands.generator.HighlandsGenerators;

public class BiomeGenHighlands extends BiomeGenBaseHighlands {

    public BiomeGenHighlands(int par1) {

        super(HLBiomeProps.HIGHLANDS.getProps());

        this.spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 5, 2, 6));

        theBiomeDecorator.treesPerChunk = 3;
        theBiomeDecorator.grassPerChunk = 12;
        theBiomeDecorator.flowersPerChunk = 6;

        plants.add(HighlandsGenerators.thornbush);
        plants.add(HighlandsGenerators.lavender);
        plants.add(HighlandsGenerators.cotton);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenAbstractTree genBigTreeChance(Random random) {

        return (random.nextInt(3) != 0 ? HighlandsGenerators.shrub2Gen : this.TREE_FEATURE);
    }

    public void decorate(World world, Random random, BlockPos pos) {

        super.decorate(world, random, pos);

        genStandardOre(theBiomeDecorator.chunkProviderSettings.coalCount / 2, theBiomeDecorator.coalGen, theBiomeDecorator.chunkProviderSettings.coalMinHeight, theBiomeDecorator.chunkProviderSettings.coalMaxHeight, world, random, pos);
    }
}
