package minestrapteam.elementalcaves.cavetype;

import java.util.Random;

import minestrapteam.caveapi.cavetype.CaveType;
import minestrapteam.elementalcaves.block.BlockCrystals;
import minestrapteam.elementalcaves.lib.ECBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.TempCategory;
import net.minecraft.world.biome.BiomeGenDesert;

public class CaveTypeFire extends CaveType
{
	public CaveTypeFire(String name)
	{
		super(name, ECBlocks.moltenstone);
		
		this.addOre(ECBlocks.moltenstone, 1, 18, 6, this.spawnHeight);
		this.addOre(ECBlocks.oreDiamond, 1, 8, 4, this.spawnHeight);
		
		this.getWallGen().addReplacement(Blocks.water, Blocks.lava);
		this.getWallGen().addReplacement(Blocks.dirt, Blocks.hardened_clay);
		this.getWallGen().addReplacement(Blocks.gravel, Blocks.stained_hardened_clay, 1);
	}
	
	@Override
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, Blocks.lava);
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome.getTempCategory() == TempCategory.WARM && !(biome instanceof BiomeGenDesert);
	}
	
	@Override
	public void generateCeilingAddons(World world, Random random, int x, int y, int z)
	{
		BlockCrystals.worldGen = true;
		setBlock(world, x, y, z, ECBlocks.crystals, 1);
		setBlock(world, x, y - 1, z, ECBlocks.crystals, 1);
		BlockCrystals.worldGen = false;
	}
}
