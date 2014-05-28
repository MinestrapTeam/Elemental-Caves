package sobiohazardous.mods.ec.util;

import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.block.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class ECUtil
{
	public static String getTexture(String name)
	{
		if (name == null)
		{
			throw new IllegalArgumentException("Name cannot be null!");
		}
		return "elementalcaves:" + name;
	}
	
	public static String position(String message, int x, int y, int z)
	{
		return message + " (" + x + ";" + y + ";" + z + ")";
	}
	
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
		else if (block == ECBlocks.moltenstone)
		{
			int metadata = world.getBlockMetadata(x, y, z);
			if (metadata == 0)
			{
				world.setBlock(x, y, z, ECBlocks.moltenstone, 1, 3);
				flag = true;
			}
			else if (metadata == 1)
			{
				world.setBlock(x, y, z, Blocks.stone);
				flag = true;
			}
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
		else if (block == ECBlocks.moltenstone && world.getBlockMetadata(x, y, z) == 0)
		{
			world.setBlock(x, y, z, ECBlocks.moltenstone, 1, 3);
		}
		else if (block == ECBlocks.moltenstone && world.getBlockMetadata(x, y, z) == 1)
		{
			world.setBlock(x, y, z, Blocks.stone, 0, 3);
		}
		if (flag)
		{
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
		Block block = world.getBlock(x, y, z);
		
		if (block.getFlammability(world, x, y, z, ForgeDirection.NORTH) > 1)
		{
			world.setBlock(x, y, z, Blocks.fire);
			flag = true;
		}
		else if (block == Blocks.end_stone)
		{
			world.setBlock(x, y, z, ECBlocks.moltenstone, 1, 3);
			flag = true;
		}
		else if (block == Blocks.stone || block == Blocks.stone_stairs || block == Blocks.stone_brick_stairs)
		{
			world.setBlock(x, y, z, Blocks.flowing_lava, 15, 3);
			flag = true;
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
				world.setBlock(x, y, z, Blocks.flowing_lava, 15, 3);
			}
			flag = true;
		}
		else if (block == Blocks.cobblestone_wall)
		{
			world.setBlock(x, y, z, Blocks.flowing_lava, 18, 3);
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
		else if (block == Blocks.stone_slab || block == Blocks.double_stone_slab)
		{
			int metadata = world.getBlockMetadata(x, y, z);
			int type = metadata & 7;
			if (type == 0 || type == 1 || type == 5)
			{
				world.setBlock(x, y, z, Blocks.flowing_lava, 15, 3);
				flag = true;
			}
			else if (type == 3)
			{
				world.setBlockMetadataWithNotify(x, y, z, metadata > 7 ? 8 : 0, 3);
				flag = true;
			}
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
		else if (block == Blocks.snow)
		{
			world.setBlock(x, y, z, Blocks.water);
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
	
	public static boolean grow(World world, int x, int y, int z)
	{
		return grow(world, x, y, z, false);
	}
	
	public static boolean grow(World world, int x, int y, int z, boolean flag)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block == Blocks.dirt)
		{
			if (world.getBlockMetadata(x, y, z) == 1)
			{
				world.setBlock(x, y, z, Blocks.mycelium);
			}
			else
			{
				world.setBlock(x, y, z, Blocks.grass);
			}
			flag = true;
		}
		else if (block == Blocks.cobblestone)
		{
			world.setBlock(x, y, z, Blocks.mossy_cobblestone);
			flag = true;
		}
		else if (block == Blocks.stonebrick)
		{
			if (world.getBlockMetadata(x, y, z) == 0)
			{
				world.setBlockMetadataWithNotify(x, y, z, 2, 3);
				flag = true;
			}
		}
		else if (block == Blocks.cobblestone_wall)
		{
			if (world.getBlockMetadata(x, y, z) == 0)
			{
				world.setBlockMetadataWithNotify(x, y, z, 1, 3);
				flag = true;
			}
		}
		else if (block == Blocks.sand)
		{
			world.setBlock(x, y, z, Blocks.clay);
			flag = true;
		}
		else if (block == Blocks.clay)
		{
			world.setBlock(x, y, z, Blocks.dirt);
			flag = true;
		}
		else if (block == Blocks.cactus || block == Blocks.reeds)
		{
			world.setBlock(x, y + 1, z, block);
			world.setBlock(x, y + 2, z, block);
			flag = true;
		}
		else if (block instanceof IGrowable && !(block instanceof BlockDoublePlant))
		{
			IGrowable igrowable = (IGrowable) block;
			if (igrowable.func_149852_a(world, world.rand, x, y, z))
			{
				igrowable.func_149853_b(world, world.rand, x, y, z);
				flag = true;
			}
		}
		
		if (flag)
		{
			world.playAuxSFX(2005, x, y, z, 0);
			world.playAuxSFX(2001, x, y, z, 18);
		}
		
		return flag;
	}
}
