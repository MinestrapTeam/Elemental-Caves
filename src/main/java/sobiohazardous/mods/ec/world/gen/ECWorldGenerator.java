package sobiohazardous.mods.ec.world.gen;

import java.util.Random;

import sobiohazardous.mods.ec.cavetype.CaveType;
import sobiohazardous.mods.ec.lib.ECBlocks;
import cpw.mods.fml.common.IWorldGenerator;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class ECWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		chunkX <<= 4;
		chunkZ <<= 4;
		if (chunkGenerator instanceof ChunkProviderGenerate)
		{
			this.generateSurface(world, random, chunkX, chunkZ, chunkGenerator);
		}
		else if (chunkGenerator instanceof ChunkProviderHell)
		{
			this.generateNether(world, random, chunkX, chunkZ);
		}
		else if (chunkGenerator instanceof ChunkProviderEnd)
		{
			this.generateEnd(world, random, chunkX, chunkZ);
		}
	}
	
	public void generateSurface(World world, Random rand, int chunkX, int chunkZ, IChunkProvider chunk)
	{
		int x1;
		int z1;
		
		for (int x0 = 0; x0 < 16; x0++)
		{
			for (int z0 = 0; z0 < 16; z0++)
			{
				x1 = chunkX + x0;
				z1 = chunkZ + z0;
				for (CaveType type : CaveType.caveTypes)
				{
					if (type.canGenerateAt(world, x1, z1))
					{
						type.generate(world, rand, x1, z1);
					}
				}
			}
		}
	}
	
	public void generateNether(World world, Random rand, int chunkX, int chunkZ)
	{
		WorldGenMinable glisteningOreGen = new WorldGenMinable(ECBlocks.oreGlistening, 5, Blocks.netherrack);
		
		int x1;
		int y1;
		int z1;
		
		for (int i = 0; i < 10; i++)
		{
			x1 = chunkX + rand.nextInt(16);
			y1 = rand.nextInt(24);
			z1 = chunkZ + rand.nextInt(16);
			
			glisteningOreGen.generate(world, rand, x1, y1, z1);
		}
	}
	
	public void generateEnd(World world, Random rand, int chunkX, int chunkZ)
	{
	}
}
