package sobiohazardous.mods.caveapi.world;

import java.util.Random;

import sobiohazardous.mods.caveapi.cavetype.CaveType;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class OreGenData
{
	protected CaveType			caveType;
	
	public Block				block;
	public int					metadata;
	public int					vainsPerChunk;
	public int					orePerVain;
	public int					oreSpawnHeight;
	
	protected WorldGenMinable	generator;
	
	public OreGenData(CaveType caveType, Block block, int metadata, int vainsPerChunk, int orePerVain, int oreSpawnHeight)
	{
		this.caveType = caveType;
		
		this.block = block;
		this.metadata = metadata;
		this.vainsPerChunk = vainsPerChunk;
		this.orePerVain = orePerVain;
		this.oreSpawnHeight = oreSpawnHeight;
	}
	
	public void generate(World world, Random random, int x, int y, int z)
	{
		if (this.generator == null)
		{
			this.generator = new WorldGenMinable(this.block, this.metadata, this.orePerVain, this.caveType.block);
		}
		this.generator.generate(world, random, x, y, z);
	}
}