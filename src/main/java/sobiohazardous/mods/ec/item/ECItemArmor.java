package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class ECItemArmor extends ItemArmor
{
	private String	armorPrefix;
	
	public ECItemArmor(ArmorMaterial material, int renderIndex, int type, String prefix)
	{
		super(material, renderIndex, type);
		this.setCreativeTab(ElementalCaves.tabItems);
		this.armorPrefix = prefix;
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		String layer = "1";
		if (slot == 2)
		{
			layer = "2";
		}
		else
		{
			layer = "1";
		}
		return ECUtil.getTexture("textures/armor/" + this.armorPrefix + layer + ".png");
	}
}
