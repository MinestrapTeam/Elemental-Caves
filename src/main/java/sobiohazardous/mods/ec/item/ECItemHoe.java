package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ECItemHoe extends ItemHoe
{
	public ECItemHoe(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(ElementalCaves.creativeTabECItems);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase living, EntityLivingBase attacker)
	{
		if (this == ECItems.hoeFreezium)
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20));
			return super.hitEntity(stack, living, attacker);
		}
		else if (this == ECItems.hoeInfernium)
		{
			living.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20));
			living.setFire(10);
			return super.hitEntity(stack, living, attacker);
		}
		return super.hitEntity(stack, living, attacker);
	}
	
}
