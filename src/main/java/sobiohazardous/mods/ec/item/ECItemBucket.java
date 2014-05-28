package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.ElementalCaves;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class ECItemBucket extends ItemBucket
{
	public ECItemBucket(Block liquid)
	{
		super(liquid);
		this.setContainerItem(Items.bucket);
		this.setCreativeTab(ElementalCaves.creativeTabECItems);
	}
	
}
