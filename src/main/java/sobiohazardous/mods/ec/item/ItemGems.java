package sobiohazardous.mods.ec.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import sobiohazardous.mods.ec.entity.projectile.EntityFrostGem;
import sobiohazardous.mods.ec.entity.projectile.EntityMagmaGem;

public class ItemGems extends ECItemMulti
{
	public static final String[]	types	= new String[] { "clear", "ice", "fire", "forest" };
	
	public ItemGems()
	{
		super(types);
		this.maxStackSize = 16;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		int metadata = stack.getItemDamage();
		
		if (metadata > 0)
		{
			if (!player.capabilities.isCreativeMode)
			{
				--stack.stackSize;
			}
			
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!world.isRemote)
			{
				if (metadata == 1)
					world.spawnEntityInWorld(new EntityFrostGem(world, player));
				else if (metadata == 2)
					world.spawnEntityInWorld(new EntityMagmaGem(world, player));
			}
		}
		
		return stack;
	}
}
