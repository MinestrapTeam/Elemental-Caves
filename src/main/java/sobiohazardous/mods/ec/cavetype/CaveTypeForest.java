package sobiohazardous.mods.ec.cavetype;

import java.util.Random;

import sobiohazardous.mods.ec.block.BlockRichGrass;
import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenJungle;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class CaveTypeForest extends CaveType
{
	public CaveTypeForest(String name)
	{
		super(name, ECBlocks.ancientMossStone);
		
		this.getWallGen().addReplacement(Blocks.dirt, ECBlocks.richSoil);
		this.getWallGen().addReplacement(Blocks.gravel, ECBlocks.richSoil);
		
		this.setFloorAddonSpawnWeight(0.5F);
		
		// TODO Add ores
		// TODO add more flowers
	}
	
	@Override
	public void generateFloorAddons(World world, Random random, int x, int y, int z)
	{
		((BlockRichGrass)ECBlocks.richGrass).func_149853_b(world, random, x, y, z);
		
		if (random.nextFloat() < 0.01F)
			new WorldGenTrees(false).generate(world, random, x, y, z);
	}
	
	@Override
	public void generateCeilingAddons(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, ECBlocks.crystals, 2, 2);
		world.setBlock(x, y - 1, z, ECBlocks.crystals, 2, 2);
	}
	
	@Override
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, ECBlocks.richGrass, 0, 2);
		world.setBlock(x, y - 1, z, ECBlocks.richSoil, 0, 2);
		world.setBlock(x, y - 2, z, ECBlocks.richSoil, 0, 2);
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome instanceof BiomeGenForest || biome instanceof BiomeGenJungle;
	}
}
