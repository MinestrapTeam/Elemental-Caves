package sobiohazardous.mods.ec.cavetype;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sobiohazardous.mods.ec.world.OreGenData;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class CaveType
{
	public static List<CaveType>	caveTypes				= new ArrayList();
	
	public static CaveType			ice						= new CaveTypeIce("ice");
	public static CaveType			fire					= new CaveTypeFire("fire");
	public static CaveType			forest					= new CaveTypeForest("forest");
	public static CaveType			ocean					= new CaveTypeOcean("ocean");
	
	public final String				name;
	public Block					block;
	public Block					floorBlock;
	public Block					ceilingBlock;
	
	public int						blockMetadata;
	public int						floorMetadata;
	public int						ceilingMetadata;
	
	protected int					spawnHeight				= 62;
	protected float					ceilingAddonSpawnWeight	= 0.1F;
	protected float					floorAddonSpawnWeight	= 0.2F;
	
	public BiomeGenBase				biome;
	
	protected CaveWallGenerator		wallGen;
	
	public List<OreGenData>			ores					= new ArrayList();
	
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
		this.wallGen = null;
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
	 * 
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
	 * 
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
		int y = this.spawnHeight;
		
		boolean cave = false;
		while (y > 4)
		{
			boolean isAir = world.isAirBlock(x, y, z);
			if (isAir)
			{
				if (!cave)
				{
					this.generateCeiling(world, random, x, y + 1, z);
					if (random.nextFloat() < this.ceilingAddonSpawnWeight)
					{
						this.generateCeilingAddons(world, random, x, y + 1, z);
					}
					
					cave = true;
				}
				
				if ((y & 3) == 0)
					this.generate(world, random, x, y, z);
			}
			else if (cave)
			{
				this.generate(world, random, x, y + 4, z);
				this.generateFloor(world, random, x, y, z);
				
				if (random.nextFloat() < this.floorAddonSpawnWeight)
				{
					this.generateFloorAddons(world, random, x, y, z);
				}
				
				cave = false;
			}
			y--;
		}
	}
	
	public CaveWallGenerator getWallGen()
	{
		if (this.wallGen == null)
		{
			this.wallGen = new CaveWallGenerator(this.block, this.blockMetadata);
		}
		return this.wallGen;
	}
	
	public void generate(World world, Random random, int x, int y, int z)
	{
		this.getWallGen().generate(world, random, x, y, z);
	}
	
	public void generateCeiling(World world, Random random, int x, int y, int z)
	{
		if (this.ceilingBlock != null)
		{
			world.setBlock(x, y, z, this.ceilingBlock, this.ceilingMetadata, 2);
		}
		else
		{
			world.setBlock(x, y, z, this.block, this.blockMetadata, 2);
		}
	}
	
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		if (this.floorBlock != null)
		{
			world.setBlock(x, y, z, this.floorBlock, this.floorMetadata, 2);
		}
		else
		{
			world.setBlock(x, y, z, this.block, this.blockMetadata, 2);
		}
	}
	
	public void generateCeilingAddons(World world, Random random, int x, int y, int z)
	{
	}
	
	public void generateFloorAddons(World world, Random random, int x, int y, int z)
	{
	}
	
	public void addOre(Block ore, int vainsPerChunk, int orePerVain, int spawnHeight)
	{
		this.addOre(ore, 0, vainsPerChunk, orePerVain, spawnHeight);
	}
	
	public void addOre(Block ore, int metadata, int vainsPerChunk, int orePerVain, int spawnHeight)
	{
		this.ores.add(new OreGenData(this, ore, metadata, vainsPerChunk, orePerVain, spawnHeight));
	}
}
