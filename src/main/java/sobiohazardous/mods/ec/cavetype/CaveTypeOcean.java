package sobiohazardous.mods.ec.cavetype;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;

public class CaveTypeOcean extends CaveType
{
	public CaveTypeOcean(String name)
	{
		super(name, Blocks.stone);
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome.getTempCategory() == TempCategory.OCEAN;
	}
}
