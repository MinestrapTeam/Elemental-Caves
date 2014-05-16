package sobiohazardous.mods.ec.cavetype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CaveType
{
	public static List<CaveType>	caveTypes	= new ArrayList();
	
	public static CaveType			ice			= new CaveTypeIce("ice");
	//public static CaveType			ocean		= new CaveTypeOcean("ocean");
	
	public final String				name;
	public Block					block;
	public Block					floorBlock;
	public Block					ceilingBlock;

	public int						blockMetadata = 0;
	public int						blockMetadataFloor = 0;
	public int						blockMetadataCeiling = 0;

	public BiomeGenBase				biome;
	
	protected WorldGenerator		wallGen;
	
	protected int					spawnHeight = 64;
	
	public CaveType(String name, Block mainCaveBlock)
	{
		this.name = name;
		this.block = mainCaveBlock;
		caveTypes.add(this);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public CaveType setBlock(Block block)
	{
		this.block = block;
		return this;
	}
	
	public CaveType setBlock(Block block, int blockMetadata)
	{
		this.block = block;
		this.blockMetadata = blockMetadata;
		return this;
	}
	
	public CaveType setFloorBlock(Block block)
	{
		this.floorBlock = block;
		return this;
	}
	
	public CaveType setFloorBlock(Block block, int blockMetadata)
	{
		this.floorBlock = block;
		this.blockMetadataFloor = blockMetadata;
		return this;
	}
	
	public CaveType setCeilingBlock(Block block)
	{
		this.ceilingBlock = block;
		return this;
	}
	
	public CaveType setCeilingBlock(Block block, int blockMetadata)
	{
		this.ceilingBlock = block;
		this.blockMetadataCeiling = blockMetadata;
		return this;
	}
	
	
	public CaveType setBiome(BiomeGenBase biome)
	{
		this.biome = biome;
		return this;
	}
	
	public boolean canGenerateAt(World world, int x, int z)
	{
		return this.canGenerateInBiome(world.getBiomeGenForCoords(x, z));
	}
	
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return this.biome == null || this.biome == biome;
	}
	
	public CaveType setSpawnHeight(int height)
	{
		this.spawnHeight = height;
		return this;
	}
	
	public void generate(World world, Random random, int x, int z)
	{
		int y = spawnHeight;
		
		boolean wasAir = true;
		while (y >= 0)
		{
			try
			{
				boolean isAir = world.isAirBlock(x, y, z);
				if (isAir)
				{
					if (!wasAir)
					{
						this.generateCeiling(world, random, x, y + 1, z);
						
						float val = random.nextFloat();
						
						if(val < 0.2F)
						{
							generateCeilingAddons(world, random, x, y + 1, z);
						}
					}
					
					this.generate(world, random, x, y - 4, z);
				}
				else if (wasAir)
				{
					this.generate(world, random, x, y + 4, z);
					this.generateFloor(world, random, x, y, z);
				}
				wasAir = isAir;
			}
			catch (Exception ex)
			{
				System.err.println("Cave Gen Error");
				ex.printStackTrace();
			}
			y--;
		}
	}
	
	public void generate(World world, Random random, int x, int y, int z)
	{
		if (this.wallGen == null)
		{
			this.wallGen = new WorldGenMinable(this.block, this.blockMetadata, 48, Blocks.stone);
		}
		this.wallGen.generate(world, random, x, y, z);
	}
	
	public void generateCeiling(World world, Random random, int x, int y, int z)
	{
		if(this.ceilingBlock != null) 
		{
			world.setBlock(x, y, z, this.ceilingBlock, this.blockMetadataCeiling, 3);
		}
	}
	
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		if(this.floorBlock != null) 
		{
			world.setBlock(x, y, z, this.floorBlock, this.blockMetadataFloor, 3);
		}
		else
		{
			world.setBlock(x, y, z, this.block, this.blockMetadata, 3);

		}
	}
	
	public void generateCeilingAddons(World world, Random random, int x, int y, int z){}

	//TODO add method for ore generation and floor generation
}
