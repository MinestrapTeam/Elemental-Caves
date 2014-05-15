package sobiohazardous.mods.ec.creativetab;

import sobiohazardous.mods.ec.lib.ECItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ECCreativeTabItems extends CreativeTabs
{
	public ECCreativeTabItems(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return ECItems.gemClear;
	}
}
