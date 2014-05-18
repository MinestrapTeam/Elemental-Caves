package sobiohazardous.mods.ec.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ECBlockSlab extends BlockSlab
{
	private IIcon[]		sideIcons;
	private IIcon[]		topIcons;
	
	private String[]	sideIconNames;
	private String[]	topIconNames;
	
	private Item		otherSlab;
	
	public ECBlockSlab(boolean isDouble, String[] sideIconNames, String[] topIconNames)
	{
		this(Material.rock, isDouble, sideIconNames, topIconNames);
	}
	
	public ECBlockSlab(Material material, boolean isDouble, String[] sideIconNames, String[] topIconNames)
	{
		super(isDouble, material);
		this.sideIconNames = sideIconNames;
		this.topIconNames = topIconNames;
	}
	
	public void setOtherSlab(Item item)
	{
		this.otherSlab = item;
	}
	
	public void setOtherSlab(Block block)
	{
		this.otherSlab = Item.getItemFromBlock(block);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		int meta = metadata & 3;
		if (meta >= topIcons.length)
			meta = 0;
		
		if (side == 1 || side == 0)
		{
			return this.topIcons[meta];
		}
		return this.sideIcons[meta];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.sideIcons = new IIcon[this.sideIconNames.length];
		this.topIcons = new IIcon[this.topIconNames.length];
		
		for (int i = 0; i < this.sideIcons.length; ++i)
		{
			this.sideIcons[i] = iconRegister.registerIcon(this.sideIconNames[i]);
		}
		
		for (int i = 0; i < this.topIcons.length; ++i)
		{
			this.topIcons[i] = iconRegister.registerIcon(this.topIconNames[i]);
		}
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return this.getItem(metadata);
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return this.getItem(world.getBlockMetadata(x, y, z));
	}
	
	public Item getItem(int metadata)
	{
		return this.field_150004_a ? this.otherSlab : Item.getItemFromBlock(this);
	}
	
	@Override
	public String func_150002_b(int meta)
	{
		return super.getUnlocalizedName() + "." + meta;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		if (!this.field_150004_a)
		{
			for (int i = 0; i < this.topIconNames.length; i++)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
	}
}
