package sobiohazardous.mods.ec.creativetab;

import sobiohazardous.mods.ec.lib.ECBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ECCreativeTabBlocks extends CreativeTabs
{
	public ECCreativeTabBlocks(String label)
	{
		super(label);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(ECBlocks.glacierRock);
	}
}
