package minestrapteam.elementalcaves.block;

import net.minecraft.block.material.Material;

public class BlockTransparent extends ECBlock
{
	public BlockTransparent(Material mat)
	{
		super(mat);
		this.setLightOpacity(1);
	}
	
	@Override
	public int getRenderBlockPass()
	{
		return 1;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
