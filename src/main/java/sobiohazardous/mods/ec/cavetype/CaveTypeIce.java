package sobiohazardous.mods.ec.cavetype;

import java.util.Random;

import sobiohazardous.mods.caveapi.cavetype.CaveType;
import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.init.Blocks;
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
		
		this.getWallGen().addReplacement(Blocks.dirt, Blocks.ice);
		this.getWallGen().addReplacement(Blocks.gravel, Blocks.packed_ice);
		this.getWallGen().addReplacement(Blocks.water, ECBlocks.iceFloe);
		this.getWallGen().addReplacement(Blocks.lava, ECBlocks.iceFloe);
	}
	
	@Override
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, ECBlocks.ancientIce, 0, 2);
		if (y < 16)
		{
			world.setBlock(x, y + 1, z, ECBlocks.iceFloe);
		}
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome.getTempCategory() == TempCategory.COLD;
	}
	
	@Override
	public void generateCeilingAddons(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, ECBlocks.crystals, 0, 2);
		world.setBlock(x, y - 1, z, ECBlocks.crystals, 0, 2);
	}
}
