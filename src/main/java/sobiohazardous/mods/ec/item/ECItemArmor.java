package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECReference;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ECItemArmor extends ItemArmor
{
	private String texturePrefix;
	
	public ECItemArmor(ArmorMaterial material, int renderIndex, int type, String texturePrefix)
	{
		super(material, renderIndex, type);
		this.setCreativeTab(ElementalCaves.creativeTabECItems);
		this.texturePrefix = texturePrefix;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		return ECReference.getTexture("textures/armor/" + texturePrefix + slot);
	}
}
