package sobiohazardous.mods.ec.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;

public class BlockTransparent extends ECBlock
{
	public BlockTransparent(Material mat)
	{
		super(mat);
		this.setLightOpacity(1);
	}
	
	@SideOnly(Side.CLIENT)
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
