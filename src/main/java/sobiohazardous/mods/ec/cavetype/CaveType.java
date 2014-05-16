package sobiohazardous.mods.ec.cavetype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CaveType
{
	public static List<CaveType>	caveTypes	= new ArrayList();
	
	public static CaveType			ice			= new CaveTypeIce("ice").setSpawnHeight(60);
	// public static CaveType ocean = new CaveTypeOcean("ocean");
	
	public final String				name;
	public Block					block;
	public Block					floorBlock;
	public Block					ceilingBlock;
	
	public int						blockMetadata;
	public int						floorMetadata;
	public int						ceilingMetadata;
	
	public BiomeGenBase				biome;
	
	protected WorldGenerator		wallGen;
	
	protected int					spawnHeight	= 64;
	
	/**
	 * The weight of which ceiling addons spawn. must be between 0 and 1.
	 */
	protected float					ceilingAddonSpawnWeight = 0.2F;
	
	/**
	 * The weight of which floor addons spawn. must be between 0 and 1.
	 */
	protected float					floorAddonSpawnWeight = 0.2F;
	
	public Map<Block, OreSpawnerHelper> ores = new HashMap<Block, OreSpawnerHelper>();
	protected WorldGenerator		oreGen;

	
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
		this.floorMetadata = blockMetadata;
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
		this.ceilingMetadata = blockMetadata;
		return this;
	}
	
	public CaveType setBiome(BiomeGenBase biome)
	{
		this.biome = biome;
		return this;
	}
	
	/**
	 * Set the rate at which floor addons spawn. Must be between 0 and 1.
	 * @param weight
	 * @return
	 */
	public CaveType setFloorAddonSpawnWeight(float weight)
	{
		this.floorAddonSpawnWeight = weight;
		return this;
	}
	
	/**
	 * Set the rate at which ceiling addons spawn. Must be between 0 and 1.
	 * @param weight
	 * @return
	 */
	public CaveType setCeilingAddonSpawnWeight(float weight)
	{
		this.ceilingAddonSpawnWeight = weight;
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
		while (y > 4)
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
						
						if (val < ceilingAddonSpawnWeight)
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
					
					float val = random.nextFloat();
					
					if(val < floorAddonSpawnWeight)
					{
						generateFloorAddons(world, random, x, y, z);
					}
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
			this.wallGen = new WorldGenMinable(this.block, this.blockMetadata, 16, Blocks.stone);
		}
		this.wallGen.generate(world, random, x, y, z);
	}
	
	public void generateCeiling(World world, Random random, int x, int y, int z)
	{
		if (this.ceilingBlock != null)
		{
			world.setBlock(x, y, z, this.ceilingBlock, this.ceilingMetadata, 3);
		}
	}
	
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		if (this.floorBlock != null)
		{
			world.setBlock(x, y, z, this.floorBlock, this.floorMetadata, 3);
		}
		else
		{
			world.setBlock(x, y, z, this.block, this.blockMetadata, 3);
			
		}
	}
	
	public void generateCeilingAddons(World world, Random random, int x, int y, int z){}
	public void generateFloorAddons(World world, Random random, int x, int y, int z){}
	
	public void generateOre(World world, Random random, int x, int y, int z, Block ore)
	{
		if (this.oreGen == null)
		{
			//TODO add ore metadata
			this.oreGen = new WorldGenMinable(ore, 0, ores.get(ore).orePerVain, this.block);			
		}
		this.oreGen.generate(world, random, x, y, z);
	}
	
	public void addOre(Block ore, int vainsPerChunk, int orePerVain, int spawnHeight)
	{
		this.ores.put(ore, new OreSpawnerHelper(vainsPerChunk, orePerVain, spawnHeight));
	}
	
	public class OreSpawnerHelper
	{
		public int vainsPerChunk;
		public int orePerVain;
		public int oreSpawnHeight;
		
		public OreSpawnerHelper(int vainsPerChunk, int orePerVain, int oreSpawnHeight)
		{
			this.vainsPerChunk = vainsPerChunk;
			this.orePerVain = orePerVain;
			this.oreSpawnHeight = oreSpawnHeight;
		}
	}
}
