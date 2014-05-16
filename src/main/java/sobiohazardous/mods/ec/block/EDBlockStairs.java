package sobiohazardous.mods.ec.block;

import sobiohazardous.mods.ec.ElementalCaves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class EDBlockStairs extends BlockStairs
{
	public EDBlockStairs(Block block)
	{
		this(block, 0);
		this.setCreativeTab(ElementalCaves.creativeTabECBlocks);
	}
	
	public EDBlockStairs(Block block, int metadata)
	{
		super(block, metadata);
		this.setCreativeTab(ElementalCaves.creativeTabECBlocks);
	}
}
