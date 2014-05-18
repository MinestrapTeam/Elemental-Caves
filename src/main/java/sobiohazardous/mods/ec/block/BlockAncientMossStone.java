package sobiohazardous.mods.ec.block;

import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockAncientMossStone extends ECBlock
{
	private IIcon	topIcon;
	
	public BlockAncientMossStone(Material material)
	{
		super(material);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(this.getTextureName() + "_side");
		this.topIcon = iconRegister.registerIcon(this.getTextureName());
	}
	
	@Override
	public IIcon getIcon(int side, int meta)
	{
		return side == 0 || side == 1 ? this.topIcon : this.blockIcon;
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		return Item.getItemFromBlock(ECBlocks.ancientMossyCobblestone);
	}
}
