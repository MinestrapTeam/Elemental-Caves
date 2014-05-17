package sobiohazardous.mods.ec.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ECItemMulti extends Item
{
	public String[] types;
	
	public IIcon[] icons;
	
	public ECItemMulti(String[] types)
	{
		this.types = types;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[this.types.length];
		
		for (int i = 0; i < this.types.length; i++)
		{
			String s = this.getIconString();
			if (this.types[i] != null)
				s += "_" + this.types[i];
			this.icons[i] = iconRegister.registerIcon(s);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		if (metadata < 0 || metadata >= this.icons.length)
			metadata = 0;
		return this.icons[metadata];
	}
}
