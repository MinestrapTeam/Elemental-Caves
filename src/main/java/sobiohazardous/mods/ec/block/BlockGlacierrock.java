package sobiohazardous.mods.ec.block;

import java.util.List;

import sobiohazardous.mods.ec.lib.ECBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockGlacierrock extends BlockSlippery
{
	public static final String[] types = new String[] { null, "cracked", "bricks" };
	
	public IIcon[] icons;
	public boolean sideTextured = false;
	
	public BlockGlacierrock()
	{
		super(Material.rock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata < 0 || metadata >= types.length)
			metadata = 0;
		return this.icons[metadata];
	}
	
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) 
    {
    	if(world.getBlock(x, y + 1, z) == ECBlocks.ancientIce)
    	{
    		
    	}
    }
    
    public void onBlockAdded(World world, int x, int y, int z) 
    {
    	
    }

	@Override
	public int damageDropped(int metadata)
	{
		return metadata == 0 ? 1 : metadata;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < types.length; ++i)
			list.add(new ItemStack(item, 1, i));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
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
}
