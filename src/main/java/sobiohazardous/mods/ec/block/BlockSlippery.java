package sobiohazardous.mods.ec.block;

import net.minecraft.block.material.Material;

public class BlockSlippery extends ECBlock
{
	public BlockSlippery(Material material)
	{
		this(material, 0.98F);
	}
	
	public BlockSlippery(Material material, float slipperiness)
	{
		super(material);
		this.slipperiness = slipperiness;
	}
}
