package sobiohazardous.mods.ec.block;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ECBlockMulti extends ECBlock
{
	public String[]	types;
	
	public IIcon[]	icons;
	
	public ECBlockMulti(Material material, String[] types)
	{
		super(material);
		this.types = types;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata;
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata < 0 || metadata >= types.length)
			metadata = 0;
		return this.icons[metadata];
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[types.length];
		
		for (int i = 0; i < this.icons.length; ++i)
		{
			String str = this.getTextureName();
			if (types[i] != null)
				str += "_" + types[i];
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
