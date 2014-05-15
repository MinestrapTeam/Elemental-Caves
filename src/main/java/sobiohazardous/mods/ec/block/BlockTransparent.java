package sobiohazardous.mods.ec.block;

import net.minecraft.block.material.Material;

public class BlockTransparent extends ECBlock
{
	public BlockTransparent()
	{
		super(Material.rock);
		this.setLightOpacity(1);
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
}
