package sobiohazardous.mods.ec.cavetype;

import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;

public class CaveTypeIce extends CaveType
{
	public CaveTypeIce(String name)
	{
		super(name, ECBlocks.glacierRock);
		this.addOre(ECBlocks.oreFreezium, 18, 5, 48);
		this.addOre(ECBlocks.oreLapis, 8, 3, 31);
	}
	
	@Override
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, ECBlocks.ancientIce, 0, 3);
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome.getTempCategory() == TempCategory.COLD;
	}
	
	@Override
	public void generateCeilingAddons(World world, Random random, int x, int y, int z)
	{
		//generate crystal stallagitmites
		world.setBlock(x, y, z, ECBlocks.crystalIce, 0, 3);
		world.setBlock(x, y - 1, z, ECBlocks.crystalIce, 0, 3);
	}
}
