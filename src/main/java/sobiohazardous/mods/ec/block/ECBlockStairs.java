package sobiohazardous.mods.ec.block;

import sobiohazardous.mods.ec.ElementalCaves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class ECBlockStairs extends BlockStairs
{
	public ECBlockStairs(Block block)
	{
		this(block, 0);
		this.setCreativeTab(ElementalCaves.creativeTabECBlocks);
	}
	
	public ECBlockStairs(Block block, int metadata)
	{
		super(block, metadata);
		this.setCreativeTab(ElementalCaves.creativeTabECBlocks);
	}
}
