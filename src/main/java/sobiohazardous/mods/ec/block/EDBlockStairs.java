package sobiohazardous.mods.ec.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class EDBlockStairs extends BlockStairs
{
	public EDBlockStairs(Block block)
	{
		this(block, 0);
	}
	
	public EDBlockStairs(Block block, int metadata)
	{
		super(block, metadata);
	}
}
