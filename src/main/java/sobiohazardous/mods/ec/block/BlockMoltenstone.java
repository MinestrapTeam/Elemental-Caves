package sobiohazardous.mods.ec.block;

import net.minecraft.block.material.Material;

public class BlockMoltenstone extends ECBlockMulti
{
	public static final String[] types = new String[] { null, "cooled", "bricks" };
	
	public BlockMoltenstone(Material material)
	{
		super(material, types);
	}
}
