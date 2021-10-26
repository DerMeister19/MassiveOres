package com.dermeister_19.massive_ores.generation;

import java.util.Random;

import com.dermeister_19.massive_ores.main.MassiveOres;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class MassiveGeneration implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 1:
			generateEnd(world, random, chunkX, chunkZ);
			break;
		case 0:
			generateOverworld(world, random, chunkX, chunkZ);
			break;
		case -1:
			generateNether(world, random, chunkX, chunkZ);
			break;
		}		
	}
	
	public void generateEnd(World world, Random rand, int x, int z) {}

	public void generateNether(World world, Random rand, int x, int z) {
		generateOre(MassiveOres.massiveQuartz, world, rand, x, z, 6, 35, 45, 1, 256, Blocks.netherrack);
	}

	public void generateOverworld(World world, Random rand, int x, int z) {
		generateOre(MassiveOres.massiveCoal, world, rand, x, z, 6, 35, 45, 1, 256, Blocks.stone);
		generateOre(MassiveOres.massiveIron, world, rand, x, z, 6, 30, 40, 1, 150, Blocks.stone);
		generateOre(MassiveOres.massiveGold, world, rand, x, z, 6, 30, 30, 1, 30, Blocks.stone);
		generateOre(MassiveOres.massiveRedstone, world, rand, x, z, 6, 30, 30, 1, 30, Blocks.stone);
		generateOre(MassiveOres.massiveLapis, world, rand, x, z, 6, 30, 30, 1, 40, Blocks.stone);
		generateOre(MassiveOres.massiveDiamond, world, rand, x, z, 10, 50, 30, 1, 30, Blocks.stone);
		generateOre(MassiveOres.massiveEmerald, world, rand, x, z, 4, 20, 20, 1, 25, Blocks.stone);
	}
	
	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVienSize, int maxVienSize, int chance, int minY, int maxY, Block generateIn) {
	    int VienSize = minVienSize + random.nextInt(maxVienSize - minVienSize);
	    int heightRange = maxY - minY;
	    WorldGenMinable gen = new WorldGenMinable(block, VienSize, generateIn);
	    for (int i = 0; i < chance; i++) {
	        int xRand = chunkX * 16 + random.nextInt(16);
	        int yRand = random.nextInt(heightRange) + minY;
	        int zRand = chunkZ * 16 + random.nextInt(16);
	        gen.generate(world, random, xRand, yRand, zRand);
      } 
	}
}
