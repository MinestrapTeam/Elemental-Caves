package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ECItemPickaxe extends ItemPickaxe
{
	public ECItemPickaxe(ToolMaterial mat)
	{
		super(mat);
		this.setCreativeTab(ElementalCaves.creativeTabECItems);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (this == ECItems.pickaxeFreezium)
		{
			if (ECUtil.freeze(world, x, y, z))
			{
				stack.damageItem(4, player);
				return true;
			}
		}
		else if (this == ECItems.pickaxeInfernium)
		{
			if (ECUtil.melt(world, x, y, z))
			{
				stack.damageItem(10, player);
				return true;
			}
		}
		else if (this == ECItems.pickaxeEarth)
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
		if (this == ECItems.pickaxeFreezium)
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20));
			return super.hitEntity(stack, living, attacker);
		}
		if (this == ECItems.pickaxeInfernium)
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20));
			living.setFire(10);
			return super.hitEntity(stack, living, attacker);
		}
		return super.hitEntity(stack, living, attacker);
	}
	
}
