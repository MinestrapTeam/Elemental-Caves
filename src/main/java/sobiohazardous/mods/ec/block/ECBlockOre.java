package sobiohazardous.mods.ec.block;

import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECItems;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public class ECBlockOre extends BlockSlippery
{
	private Random	random	= new Random();
	
	public ECBlockOre()
	{
		super(Material.rock);
	}
	
	public ECBlockOre(float sliperiness)
	{
		super(Material.rock, sliperiness);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		if (this == ECBlocks.oreLapis)
			return Items.dye;
		else if (this == ECBlocks.oreGlistening)
			return ECItems.gemClear;
		return super.getItemDropped(metadata, random, fortune);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		if (this == ECBlocks.oreLapis)
			return 4;
		return 0;
	}
	
	@Override
	public int quantityDropped(Random random)
	{
		if (this == ECBlocks.oreLapis)
			return 4 + random.nextInt(5);
		return 1;
	}
	
	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		if (this == ECBlocks.oreLapis)
			return 2 + this.random.nextInt(4);
		else if (this == ECBlocks.oreGlistening)
			return 4 + this.random.nextInt(5);
		return 0;
	}
}
