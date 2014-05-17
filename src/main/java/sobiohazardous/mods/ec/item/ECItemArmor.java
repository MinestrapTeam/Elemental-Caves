package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.lib.ECReference;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ECItemArmor extends ItemArmor
{
	public ECItemArmor(ArmorMaterial material, int renderIndex, int type)
	{
		super(material, renderIndex, type);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return ECReference.getTexture("textures/armor/" + type + slot);
	}
}
