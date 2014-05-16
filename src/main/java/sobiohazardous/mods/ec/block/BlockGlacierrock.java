package sobiohazardous.mods.ec.block;

import java.util.List;

import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECReference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockGlacierrock extends BlockSlippery
{
	public static final String[]	types			= new String[] { null, "cracked", "bricks" };
	
	public IIcon[]					icons;
	public boolean					sideTextured	= false;
	
	public IIcon					icySideIcon;
	
	public BlockGlacierrock()
	{
		super(Material.rock);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata < 0 || metadata >= types.length)
			metadata = 0;
		return this.icons[metadata];
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 0 && side > 1 && world.getBlock(x, y + 1, z) == ECBlocks.ancientIce)
		{
			return this.icySideIcon;
		}
		return this.getIcon(side, metadata);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata == 0 ? 1 : metadata;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < types.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.icySideIcon = iconRegister.registerIcon(ECReference.getTexture("glacierrock_icy"));
		
		this.icons = new IIcon[types.length];
		
		for (int i = 0; i < this.icons.length; ++i)
		{
			String str = this.getTextureName();
			if (types[i] != null)
				str += "_" + types[i];
			this.icons[i] = iconRegister.registerIcon(str);
		}
	}
}
