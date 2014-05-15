package sobiohazardous.mods.ec.block;

import sobiohazardous.mods.ec.ElementalCaves;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ECBlock extends Block
{
	public ECBlock(Material mat)
	{
		super(mat);
		this.setCreativeTab(ElementalCaves.creativeTabECBlocks);
	}

}
