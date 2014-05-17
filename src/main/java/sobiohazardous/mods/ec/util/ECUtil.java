package sobiohazardous.mods.ec.util;

import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ECUtil
{
	public static boolean freeze(World world, int x, int y, int z)
	{
		return freeze(world, x, y, z, false, false);
	}
	
	public static boolean freeze(World world, int x, int y, int z, boolean flag, boolean isArmorEffect)
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
			if(isArmorEffect)
			{
				world.setBlock(x, y - 2, z, Blocks.obsidian);
			}
			world.setBlock(x, y, z, Blocks.obsidian);
			flag = true;
		}
		else if (block == Blocks.water)
		{
			if(isArmorEffect)
			{
				world.setBlock(x, y - 2, z, Blocks.ice);
			}
			world.setBlock(x, y, z, Blocks.ice);
			flag = true;
		}
		
		if (flag)
		{
			world.playAuxSFX(2001, x, y, z, 79);
		}
		
		return flag;
	}
	
	public static boolean melt(World world, int x, int y, int z)
	{
		return melt(world, x, y, z, false);
	}
	
	public static boolean melt(World world, int x, int y, int z, boolean flag)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block.getFlammability(world, x, y, z, ForgeDirection.NORTH) > 1)
		{
			world.setBlock(x, y, z, Blocks.fire);
			flag = true;
		}
		else if (block == Blocks.stone || block == Blocks.end_stone)
		{
			world.setBlock(x, y, z, ECBlocks.moltenstone, 1, 3);
			flag = true;
		}
		else if (block == ECBlocks.moltenstone)
		{
			if (world.getBlockMetadata(x, y, z) == 1)
			{
				world.setBlock(x, y, z, ECBlocks.moltenstone);
				flag = true;
			}
		}
		else if (block == Blocks.cobblestone || block == Blocks.mossy_cobblestone || block == Blocks.stonebrick || block == Blocks.gravel)
		{
			world.setBlock(x, y, z, Blocks.stone);
			flag = true;
		}
		else if (block == Blocks.sandstone)
		{
			if (world.getBlockMetadata(x, y, z) != 1)
			{
				world.setBlockMetadataWithNotify(x, y, z, 1, 3);
			}
			else
			{
				world.setBlock(x, y, z, Blocks.flowing_lava);
			}
			flag = true;
		}
		else if (block == Blocks.cobblestone_wall)
		{
			world.setBlock(x, y, z, Blocks.flowing_lava);
			flag = true;
		}
		else if (block == Blocks.farmland || block == Blocks.grass || block == Blocks.grass)
		{
			world.setBlock(x, y, z, Blocks.dirt);
			flag = true;
		}
		else if (block == Blocks.dirt)
		{
			if (world.getBlockMetadata(x, y, z) != 0)
			{
				world.setBlockMetadataWithNotify(x, y, z, 0, 3);
				flag = true;
			}
		}
		else if (block == Blocks.sand)
		{
			world.setBlock(x, y, z, Blocks.glass);
			flag = true;
		}
		else if (block == Blocks.obsidian || block == Blocks.netherrack)
		{
			world.setBlock(x, y, z, Blocks.lava);
			flag = true;
		}
		else if (block == Blocks.packed_ice)
		{
			world.setBlock(x, y, z, Blocks.ice);
			flag = true;
		}
		else if (block == Blocks.ice)
		{
			world.setBlock(x, y, z, Blocks.snow);
			flag = true;
		}
		else if (block == Blocks.snow_layer)
		{
			world.setBlockToAir(x, y, z);
			flag = true;
		}
		
		if (flag)
		{
			world.playAuxSFX(2004, x, y, z, 0);
			world.playAuxSFX(2004, x, y, z, 0);
		}
		
		return flag;
	}
}
