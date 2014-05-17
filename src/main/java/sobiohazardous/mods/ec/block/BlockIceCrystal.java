package sobiohazardous.mods.ec.block;

import java.util.ArrayList;
import java.util.Random;

import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockIceCrystal extends BlockSlippery
{
	public BlockIceCrystal()
	{
		super(Material.rock);
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeGlass);
		this.setLightOpacity(1);
	}
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		this.updateTick(world, x, y, z, world.rand);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		if (world.provider.dimensionId == -1)
			return new ArrayList();
		return super.getDrops(world, x, y, z, metadata, fortune);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return ECItems.iceShard;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		int i = 2 + random.nextInt(3) + random.nextInt(fortune + 1);
		if (i > 4)
			i = 4;
		return i;
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
	
	@Override
    public int getRenderBlockPass()
    {
        return 1;
    }
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
