package sobiohazardous.mods.ec.util;

import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class ECUtil
{
	public static void freeze(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block instanceof BlockFlower)
		{
			world.setBlock(x, y, z, Blocks.snow_layer);
		}
		else if (block instanceof BlockLeavesBase)
		{
			world.setBlock(x, y, z, Blocks.snow);
		}
		else if (block == Blocks.snow || block == Blocks.melon_block || block == Blocks.pumpkin || block == Blocks.cactus)
		{
			world.setBlock(x, y, z, Blocks.ice);
		}
		else if (block == Blocks.ice)
		{
			world.setBlock(x, y, z, Blocks.packed_ice);
		}
		else if (block == Blocks.netherrack)
		{
			world.setBlock(x, y, z, Blocks.cobblestone);
		}
		else if (block == Blocks.end_stone)
		{
			world.setBlock(x, y, z, ECBlocks.glacierRock, 1, 3);
		}
	}
}
