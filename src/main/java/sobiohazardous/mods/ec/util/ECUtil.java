package sobiohazardous.mods.ec.util;

import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class ECUtil
{
	public static boolean freeze(World world, int x, int y, int z)
	{
		return freeze(world, x, y, z, false);
	}
	
	public static boolean freeze(World world, int x, int y, int z, boolean flag)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block instanceof BlockBush)
		{
			world.setBlock(x, y, z, Blocks.snow_layer);
			flag = true;
		}
		else if (block instanceof BlockLeavesBase)
		{
			world.setBlock(x, y, z, Blocks.snow);
			flag = true;
		}
		else if (block == Blocks.snow || block == Blocks.melon_block || block == Blocks.pumpkin || block == Blocks.cactus || block == Blocks.red_mushroom_block || block == Blocks.brown_mushroom_block)
		{
			world.setBlock(x, y, z, Blocks.ice);
			flag = true;
		}
		else if (block == Blocks.ice)
		{
			world.setBlock(x, y, z, Blocks.packed_ice);
			flag = true;
		}
		else if (block == Blocks.netherrack)
		{
			world.setBlock(x, y, z, Blocks.cobblestone);
			flag = true;
		}
		else if (block == Blocks.end_stone)
		{
			world.setBlock(x, y, z, ECBlocks.glacierRock, 1, 3);
			flag = true;
		}
		else if (block == Blocks.fire)
		{
			world.setBlockToAir(x, y, z);
			flag = true;
		}
		else if (block == Blocks.lava)
		{
			world.setBlock(x, y, z, Blocks.obsidian);
			flag = true;
		}
		else if (block == Blocks.water)
		{
			world.setBlock(x, y, z, Blocks.ice);
			flag = true;
		}
		
		if (flag)
		{
			world.playAuxSFX(2001, x, y, z, 79);
			world.playAuxSFX(2001, x, y, z, 80);
		}
		
		return flag;
	}
	
	public static boolean melt(World world, int x, int y, int z)
	{
		return melt(world, x, y, z, false);
	}
	
	public static boolean melt(World world, int x, int y, int z, boolean flag)
	{
		if (flag)
		{
			world.playAuxSFX(2004, x, y, z, 0);
		}
		
		return flag;
	}
}
