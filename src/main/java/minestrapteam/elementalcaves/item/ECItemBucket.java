package minestrapteam.elementalcaves.item;

import minestrapteam.elementalcaves.ElementalCaves;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class ECItemBucket extends ItemBucket
{
	public ECItemBucket(Block liquid)
	{
		super(liquid);
		this.setContainerItem(Items.bucket);
		this.setCreativeTab(ElementalCaves.tabItems);
	}
	
}
