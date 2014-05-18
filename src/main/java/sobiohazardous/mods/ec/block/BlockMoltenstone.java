package sobiohazardous.mods.ec.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockMoltenstone extends ECBlockMulti
{
	public static final String[]	types	= new String[] { null, "cooled", "bricks" };
	
	public BlockMoltenstone()
	{
		super(Material.rock, types);
	}
	
	@Override
	public int quantityDropped(int metadata, int fortune, Random random)
	{
		return metadata == 0 ? 0 : 1;
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		entity.setFire(2);
	}
	
	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int metadata, EntityPlayer player)
	{
		if (metadata == 0)
		{
			if (EnchantmentHelper.getSilkTouchModifier(player))
			{
				this.dropBlockAsItem(world, x, y, z, new ItemStack(this));
			}
			else
			{
				System.out.println("good");
	            world.setBlock(x, y, z, Blocks.flowing_lava);	            
			}		
		}
	}
}
