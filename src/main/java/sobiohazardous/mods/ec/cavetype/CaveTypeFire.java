package sobiohazardous.mods.ec.cavetype;

import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;

public class CaveTypeFire extends CaveType
{
	public CaveTypeFire(String name, Block mainCaveBlock)
	{
		super(name, ECBlocks.moltenstone);		
		this.setSpawnHeight(60);
	}
	
	@Override
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, Blocks.lava, 0, 3);
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome.getTempCategory() == TempCategory.WARM;
	}
	
	@Override
	public void generateCeilingAddons(World world, Random random, int x, int y, int z)
	{
		//generate crystal stallagitmites
		world.setBlock(x, y, z, ECBlocks.crystals, 1, 3);
		world.setBlock(x, y - 1, z, ECBlocks.crystals, 1, 3);
	}
}
