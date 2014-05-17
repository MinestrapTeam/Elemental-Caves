package sobiohazardous.mods.ec.cavetype;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sobiohazardous.mods.ec.world.BlockM;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CaveWallGenerator extends WorldGenerator
{
	private static int			radius			= 5;
	
	private Block				block;
	private int					blockMetadata;
	
	private Block				target			= Blocks.stone;
	private int					targetMetadata;
	
	public Map<BlockM, BlockM>	replacements	= new HashMap();
	
	public CaveWallGenerator(Block block, int metadata)
	{
		this.block = block;
		this.blockMetadata = metadata;
	}
	
	public void addReplacement(Block targetBlock, Block replacementBlock)
	{
		this.addReplacement(targetBlock, 0, replacementBlock, 0);
	}
	
	public void addReplacement(Block targetBlock, Block replacementBlock, int replacementMetadata)
	{
		this.addReplacement(targetBlock, 0, replacementBlock, replacementMetadata);
	}
	
	public void addReplacement(Block targetBlock, int targetMetadata, Block replacementBlock, int replacementMetadata)
	{
		BlockM target = new BlockM(targetBlock, targetMetadata);
		BlockM replacement = new BlockM(replacementBlock, replacementMetadata);
		
		this.replacements.put(target, replacement);
	}
	
	public BlockM getReplacement(Block block, int metadata)
	{
		for (Map.Entry<BlockM, BlockM> entry : this.replacements.entrySet())
		{
			if (entry.getKey().equals(block, metadata))
			{
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	@Override
	public boolean generate(World world, Random random, int x, int y, int z)
	{
		for (int i = -radius; i <= radius; i++)
		{
			for (int j = -radius; j <= radius; j++)
			{
				for (int k = -radius; k <= radius; k++)
				{
					int x1 = x + i;
					int y1 = y + j;
					int z1 = z + k;
					
					int x2 = x1 - x;
					int y2 = y1 - y;
					int z2 = z1 - z;
					
					if (MathHelper.sqrt_float((x2 * x2) + (y2 * y2) + (z2 * z2)) <= radius)
					{
						this.replaceBlock(world, x1, y1, z1);
					}
				}
			}
		}
		
		return true;
	}
	
	public void replaceBlock(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		int metadata = world.getBlockMetadata(x, y, z);
		
		if (block == this.target && metadata == this.targetMetadata)
		{
			world.setBlock(x, y, z, this.block, this.blockMetadata, 3);
		}
		else if (block != Blocks.air)
		{
			BlockM replacement = this.getReplacement(block, metadata);
			if (replacement != null)
			{
				replacement.set(world, x, y, z);
			}
		}
	}
}
