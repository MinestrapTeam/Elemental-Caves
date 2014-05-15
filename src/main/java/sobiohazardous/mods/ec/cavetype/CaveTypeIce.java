package sobiohazardous.mods.ec.cavetype;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;

public class CaveTypeIce extends CaveType
{
	public CaveTypeIce(String name)
	{
		super(name);
	}
	
	@Override
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		// TODO set Icefloe
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome.getTempCategory() == TempCategory.COLD;
	}
}
