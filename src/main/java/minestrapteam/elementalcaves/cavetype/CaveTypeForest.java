package minestrapteam.elementalcaves.cavetype;

import java.util.Random;

import minestrapteam.caveapi.cavetype.CaveType;
import minestrapteam.elementalcaves.block.BlockCrystals;
import minestrapteam.elementalcaves.lib.ECBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenForest;
import net.minecraft.world.biome.BiomeGenJungle;

public class CaveTypeForest extends CaveType
{
	public CaveTypeForest(String name)
	{
		super(name, ECBlocks.ancientMossStone);
		
		this.getWallGen().addReplacement(Blocks.dirt, ECBlocks.richSoil);
		this.getWallGen().addReplacement(Blocks.gravel, ECBlocks.richSoil);
		this.getWallGen().addReplacement(Blocks.lava, Blocks.water);
		
		this.addOre(ECBlocks.oreFertile, 14, 3, this.spawnHeight);
		
		// TODO add more flowers
	}
	
	@Override
	public void generateFloorAddons(World world, Random random, int x, int y, int z)
	{
		int rand = random.nextInt(10);
		if (rand < 4)
		{
			setBlock(world, x, y + 1, z, Blocks.sapling, rand);
		}
	}
	
	@Override
	public void generateCeilingAddons(World world, Random random, int x, int y, int z)
	{
		BlockCrystals.worldGen = true;
		setBlock(world, x, y, z, ECBlocks.crystals, 2);
		setBlock(world, x, y - 1, z, ECBlocks.crystals, 2);
		BlockCrystals.worldGen = false;
	}
	
	@Override
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		setBlock(world, x, y, z, ECBlocks.richGrass);
		setBlock(world, x, y - 1, z, ECBlocks.richSoil);
		setBlock(world, x, y - 2, z, ECBlocks.richSoil);
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome instanceof BiomeGenForest || biome instanceof BiomeGenJungle;
	}
}
