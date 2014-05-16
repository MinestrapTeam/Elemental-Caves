package sobiohazardous.mods.ec.util;

import sobiohazardous.mods.ec.lib.ECBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class ECUtil
{
	public static boolean freeze(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block instanceof BlockBush)
		{
			world.setBlock(x, y, z, Blocks.snow_layer);
			return true;
		}
		else if (block instanceof BlockLeavesBase)
		{
			world.setBlock(x, y, z, Blocks.snow);
			return true;
		}
		else if (block == Blocks.snow || block == Blocks.melon_block || block == Blocks.pumpkin || block == Blocks.cactus || block == Blocks.red_mushroom_block || block == Blocks.brown_mushroom_block)
		{
			world.setBlock(x, y, z, Blocks.ice);
			return true;
		}
		else if (block == Blocks.ice)
		{
			world.setBlock(x, y, z, Blocks.packed_ice);
			return true;
		}
		else if (block == Blocks.netherrack)
		{
			world.setBlock(x, y, z, Blocks.cobblestone);
			return true;
		}
		else if (block == Blocks.end_stone)
		{
			world.setBlock(x, y, z, ECBlocks.glacierRock, 1, 3);
			return true;
		}
		else if (block.getMaterial() == Material.lava)
		{
			world.setBlock(x, y, z, Blocks.obsidian, 0, 3);
			return true;
		}
		return false;
	}
}
