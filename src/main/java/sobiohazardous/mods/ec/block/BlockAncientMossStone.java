package sobiohazardous.mods.ec.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockAncientMossStone extends ECBlockMulti
{
	public static final String[]	types			= new String[] { null, "cracked", "bricks" };
	
	public BlockAncientMossStone()
	{
		super(Material.rock, types);
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata == 0 ? 1 : metadata;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		super.registerBlockIcons(iconRegister);
		this.blockIcon = iconRegister.registerIcon(this.getTextureName() + "_side");
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		if (metadata == 0)
		{
			if (side == 0 || side == 1)
			{
				return this.blockIcon;
			}
		}
		return super.getIcon(side, metadata);
	}
}
