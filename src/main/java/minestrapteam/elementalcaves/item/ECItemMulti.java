package minestrapteam.elementalcaves.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ECItemMulti extends ECItem
{
	public String[]	textureNames;
	
	public IIcon[]	icons;
	
	public ECItemMulti(String[] textureNames)
	{
		this.textureNames = textureNames;
		this.setHasSubtypes(true);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		this.icons = new IIcon[this.textureNames.length];
		
		for (int i = 0; i < this.textureNames.length; i++)
		{
			String s = this.getIconString();
			if (this.textureNames[i] != null)
			{
				s += "_" + this.textureNames[i];
			}
			this.icons[i] = iconRegister.registerIcon(s);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		return this.icons[metadata];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < this.textureNames.length; i++)
		{
			list.add(new ItemStack(this, 1, i));
		}
	}
}
