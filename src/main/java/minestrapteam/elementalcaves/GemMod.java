package minestrapteam.elementalcaves;

import java.util.List;
import java.util.Random;

import me.dawars.CraftingPillars.api.baubles.IMod;
import minestrapteam.elementalcaves.util.ECUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.EnumChatFormatting;

public class GemMod implements IMod
{
	private static final Random rand = new Random();
	
	public EnumChatFormatting getColor(ItemStack gem)
	{
		int metadata = gem.getItemDamage();

		if(metadata == 0) return EnumChatFormatting.BLUE;
		if(metadata == 1) return EnumChatFormatting.RED;
		if(metadata == 2) return EnumChatFormatting.GREEN;
		return EnumChatFormatting.YELLOW;
	}
	
	
	public void onWornTick(ItemStack ring, ItemStack gem, EntityLivingBase player)
	{
		if (!player.worldObj.isRemote)
		{
			int metadata = gem.getItemDamage();
		
			int px = (int) player.posX;
			int py = (int) player.posY;
			int pz = (int) player.posZ;
			
			int x1 = px + rand.nextInt(5) - 2;
			int y1 = py + rand.nextInt(5) - 2;
			int z1 = pz + rand.nextInt(5) - 2;
			
			if (metadata == 0)
			{
				for (int i = 0; i < 4; i++)
					ECUtil.freeze(player.worldObj, x1, y1, z1);
				ECUtil.freeze(player.worldObj, px, py - 1, pz);
				
			}
			else if (metadata == 1)
			{
				for (int i = 0; i < 4; i++)
					ECUtil.melt(player.worldObj, x1, y1, z1);
				ECUtil.melt(player.worldObj, px, py - 1, pz);
	
			}
			else if (metadata == 2)
			{
				for (int i = 0; i < 4; i++)
					ECUtil.grow(player.worldObj, x1, y1, z1);
				ECUtil.grow(player.worldObj, px, py - 1, pz);
	
			}
			else
			{
				if(rand.nextInt(20) == 0)
				{
					List list = player.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.getBoundingBox(px-5, py-5, pz-5, px+5, py+5, pz+5));
					
					while(list.iterator().hasNext())
					{
						EntityLivingBase entity = (EntityLivingBase) list.iterator().next();
			            entity.curePotionEffects(new ItemStack(Items.milk_bucket));
					}
				}
			}
	}
	}

	public void onEquipped(ItemStack ring, EntityLivingBase player)
	{
	
	}

	public void onUnequipped(ItemStack ring, EntityLivingBase player)
	{
	
	}

	public boolean canEquip(ItemStack ring, EntityLivingBase player)
	{
		return true;
	
	}

	public boolean canUnequip(ItemStack ring, EntityLivingBase player)
	{
		return true;
	
	}
}