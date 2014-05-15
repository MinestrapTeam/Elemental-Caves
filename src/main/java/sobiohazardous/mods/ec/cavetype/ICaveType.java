package sobiohazardous.mods.ec.cavetype;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public interface ICaveType
{
	public String getName();
	
	public Block getBlock();
	
	public int getBlockMetadata();
	
	public boolean canGenerateAt(World world, int x, int z);
	
	public void generate(World world, Random random, int x, int z);
}
