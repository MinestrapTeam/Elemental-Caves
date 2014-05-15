package sobiohazardous.mods.ec.creativetab;

import sobiohazardous.mods.ec.lib.ECBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ECCreativeTabBlocks extends CreativeTabs
{
	public ECCreativeTabBlocks(int par1, String par2Str)
	{
		super(par1, par2Str);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(ECBlocks.glacierRock);
	}

}
