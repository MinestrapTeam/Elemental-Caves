package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.entity.projectile.EntityFireShard;
import sobiohazardous.mods.ec.entity.projectile.EntityIceShard;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemShards extends ECItemMulti
{
	public static final String[]	types	= new String[] {null, "shard_ice", "shard_fire", "shard_forest" };

	public ItemShards()
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
				System.out.println(metadata);

				if (metadata == 1)
					world.spawnEntityInWorld(new EntityIceShard(world, player));
				else if (metadata == 2)
					world.spawnEntityInWorld(new EntityFireShard(world, player));
			}
		}
		
		return stack;
	}
}