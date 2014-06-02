package minestrapteam.caveapi.world.gen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import minestrapteam.caveapi.CavesAPI;
import minestrapteam.caveapi.cavetype.CaveType;
import minestrapteam.caveapi.world.OreGenData;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.ChunkProviderHell;

public class CWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		chunkX <<= 4;
		chunkZ <<= 4;
		if (chunkGenerator instanceof ChunkProviderGenerate)
		{
			CWorldGenerator.generateSurface(world, random, chunkX, chunkZ, chunkGenerator);
		}
		else if (chunkGenerator instanceof ChunkProviderHell)
		{
			CWorldGenerator.generateNether(world, random, chunkX, chunkZ);
		}
		else if (chunkGenerator instanceof ChunkProviderEnd)
		{
			CWorldGenerator.generateEnd(world, random, chunkX, chunkZ);
		}
	}
	
	public static void generateSurface(World world, Random rand, int chunkX, int chunkZ, IChunkProvider chunk)
	{
		for (int x0 = 0; x0 < 16; x0++)
		{
			int x1 = chunkX + x0;
			for (int z0 = 0; z0 < 16; z0++)
			{
				int z1 = chunkZ + z0;
				
				for (CaveType type : CavesAPI.caveTypes)
				{
					if (type.canGenerateAt(world, x1, z1))
					{
						replaceCaves(type, world, rand, x1, z1);
					}
				}
			}
		}
		
		int x1;
		int y1;
		int z1;
		
		for (CaveType type : CavesAPI.caveTypes)
		{
			for (OreGenData ore : type.ores)
			{
				for (int i = 0; i < ore.vainsPerChunk; i++)
				{
					x1 = chunkX + rand.nextInt(16);
					y1 = rand.nextInt(ore.oreSpawnHeight);
					z1 = chunkZ + rand.nextInt(16);
					ore.generate(world, rand, x1, y1, z1);
				}
			}
		}
	}
	
	public static void generateNether(World world, Random rand, int chunkX, int chunkZ)
	{
	}
	
	public static void generateEnd(World world, Random rand, int chunkX, int chunkZ)
	{
	}
	
	public static void replaceCaves(CaveType type, World world, Random random, int x, int z)
	{
		int y = type.spawnHeight;
		
		int ceiling = -1;
		boolean wasAir = false;
		while (y > 5)
		{
			if (world.isAirBlock(x, y, z))
			{
				if (!wasAir && ceiling == -1)
				{
					ceiling = y + 1;
				}
				wasAir = true;
			}
			else
			{
				if (ceiling != -1)
				{
					type.generate(world, random, x, y, ceiling, z);
					ceiling = -1;
					y -= 4;
				}
				wasAir = false;
			}
			y--;
		}
	}
}
