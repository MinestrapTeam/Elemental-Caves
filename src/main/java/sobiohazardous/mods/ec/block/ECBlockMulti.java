package sobiohazardous.mods.ec.block;

import java.util.List;

import sobiohazardous.mods.ec.ElementalCaves;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ECBlockMulti extends ECBlock
{
	public String[]	types;
	
	public IIcon[]	icons;
	
	public ECBlockMulti(Material material, String[] types)
	{
		super(material);
		this.types = types;
		this.setCreativeTab(ElementalCaves.tabBlocks);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata < 0 || metadata >= this.types.length)
		{
			metadata = 0;
		}
		return this.icons[metadata];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[this.types.length];
		
		for (int i = 0; i < this.icons.length; ++i)
		{
			String str = this.getTextureName();
			if (this.types[i] != null)
			{
				str += "_" + this.types[i];
			}
			this.icons[i] = iconRegister.registerIcon(str);
		}
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.types.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
