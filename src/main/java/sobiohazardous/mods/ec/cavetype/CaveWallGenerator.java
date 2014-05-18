package sobiohazardous.mods.ec.cavetype;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import sobiohazardous.mods.ec.util.ECUtil;
import sobiohazardous.mods.ec.world.BlockM;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class CaveWallGenerator extends WorldGenerator
{
	private static final int	radius			= 4;
	
	private Block				block;
	private int					blockMetadata;
	
	private Block				target;
	private int					targetMetadata;
	
	public Map<BlockM, BlockM>	replacements	= new HashMap();
	
	public CaveWallGenerator(Block block, Block target)
	{
		this(block, 0, target, 0);
	}
	
	public CaveWallGenerator(Block block, int metadata)
	{
		this(block, metadata, Blocks.stone, 0);
	}
	
	public CaveWallGenerator(Block block, int metadata, Block target, int targetMetadata)
	{
		if (block == null)
			throw new IllegalArgumentException("Cannot set the block to null!");
		else if (target == null)
			throw new IllegalArgumentException("Cannot set the target to null!");
		
		this.block = block;
		this.blockMetadata = metadata;
		this.target = target;
		this.targetMetadata = targetMetadata;
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
		int xmin = x - radius;
		int xmax = x + radius;
		int ymin = y - radius;
		int ymax = y + radius;
		int zmin = z - radius;
		int zmax = z + radius;
		
		if (ymin < 0)
			ymin = 0;
		if (ymax > 255)
			ymax = 255;
		
		for (int x1 = xmin; x1 <= xmax; x1++)
		{
			for (int y1 = ymin; y1 <= ymax; y1++)
			{
				for (int z1 = zmin; z1 <= zmax; z1++)
				{
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
		try
		{
			Block block = world.getBlock(x, y, z);
			
			if (block != Blocks.air)
			{
				int metadata = world.getBlockMetadata(x, y, z);
				if (block == this.target && metadata == this.targetMetadata)
				{
					world.setBlock(x, y, z, this.block, this.blockMetadata, 2);
				}
				else
				{
					BlockM replacement = this.getReplacement(block, metadata);
					if (replacement != null)
					{
						replacement.set(world, x, y, z, 2);
					}
				}
			}
		}
		catch (Exception ex)
		{
			ECUtil.position("Block Set Error", x, y, z);
		}
	}
}
