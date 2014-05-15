package sobiohazardous.mods.ec.block;

import java.util.Random;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class ECBlock extends Block
{
	public ECBlock(Material material)
	{
		super(material);
		this.setCreativeTab(ElementalCaves.creativeTabECBlocks);
	}
	
    @Override
	public Item getItemDropped(int metadata, Random random, int fortune)
    {
    	if(this == ECBlocks.oreGlistening)
    	{
    		return ECItems.gemClear;
    	}
    	return super.getItemDropped(metadata, random, fortune);
    }
}
