package sobiohazardous.mods.ec.block;

import java.util.Random;

import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BlockIceCrystal extends BlockTransparent
{
	public BlockIceCrystal()
	{
		super(Material.ice);
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeGlass);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		this.updateTick(world, x, y, z, world.rand);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		world.scheduleBlockUpdate(x, y, z, this, 100);
		
		for (int i = 0; i < 4; i++)
		{
			int x1 = x + random.nextInt(5) - 2;
			int y1 = y + random.nextInt(5) - 2;
			int z1 = z + random.nextInt(5) - 2;
			
			if (ECUtil.freeze(world, x1, y1, z1))
			{
				for (int j = 0; j < 32; j++)
				{
					world.spawnParticle("snowballpoof", x1 + random.nextDouble(), y1 + random.nextDouble(), z1 + random.nextDouble(), 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}
}
