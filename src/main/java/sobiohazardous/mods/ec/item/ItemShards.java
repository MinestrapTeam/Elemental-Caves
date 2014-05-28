package sobiohazardous.mods.ec.item;

import java.util.List;

import sobiohazardous.mods.ec.entity.projectile.EntityFireShard;
import sobiohazardous.mods.ec.entity.projectile.EntityIceShard;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShards extends ECItemMulti
{
	public static final String[]	types	= new String[] { "clear", "ice", "fire", "forest" };
	
	public ItemShards()
	{
		super(types);
		this.maxStackSize = 16;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		int metadata = stack.getItemDamage();
		
		if (metadata != 0 && metadata != 3)
		{
			if (!player.capabilities.isCreativeMode)
			{
				--stack.stackSize;
			}
			
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!world.isRemote)
			{
				if (metadata == 1)
				{
					world.spawnEntityInWorld(new EntityIceShard(world, player));
				}
				else if (metadata == 2)
				{
					world.spawnEntityInWorld(new EntityFireShard(world, player));
				}
			}
		}
		
		return stack;
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int i = 1; i < ItemShards.types.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
}