package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ECItemAxe extends ItemAxe
{
	public ECItemAxe(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(ElementalCaves.creativeTabECItems);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (this == ECItems.axeFreezium)
		{
			if (ECUtil.freeze(world, x, y, z))
			{
				stack.damageItem(4, player);
				return true;
			}
		}
		else if (this == ECItems.axeInfernium)
		{
			if (ECUtil.melt(world, x, y, z))
			{
				stack.damageItem(10, player);
				return true;
			}
		}
		else if (this == ECItems.axeEarth)
		{
			if (ECUtil.grow(world, x, y, z))
			{
				stack.damageItem(10, player);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase living, EntityLivingBase attacker)
	{
		if (this == ECItems.axeFreezium)
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20));
			return super.hitEntity(stack, living, attacker);
		}
		if (this == ECItems.axeInfernium)
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20));
			living.setFire(10);
			return super.hitEntity(stack, living, attacker);
		}
		return super.hitEntity(stack, living, attacker);
	}
	
}
