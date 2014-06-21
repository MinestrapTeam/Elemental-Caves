package minestrapteam.elementalcaves.cavetype;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import minestrapteam.caveapi.cavetype.CaveType;
import minestrapteam.elementalcaves.lib.ECBlocks;
 
public class CaveTypeDesert extends CaveType
{
	public CaveTypeDesert(String name)
	{
		super(name, ECBlocks.pressurizedSandstone);
		
		this.addOre(ECBlocks.sand, 1, 15, 6, spawnHeight);
		
		this.wallGen.addReplacement(Blocks.gravel, ECBlocks.sand, 1);
	}

	@Override
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, ECBlocks.sand, 0, 3);
	}
	
	@Override
	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome == biome.desert || biome == biome.desertHills || biome == biome.mesa || biome == biome.mesaPlateau || biome == biome.mesaPlateau_F;
	}
}
