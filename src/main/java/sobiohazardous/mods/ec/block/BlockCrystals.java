package sobiohazardous.mods.ec.block;

import java.util.ArrayList;
import java.util.Random;

import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockCrystals extends ECBlockMulti
{
	public BlockCrystals()
	{
		super(Material.rock, new String[] { "ice", "fire", "forest" });
		this.setTickRandomly(true);
		this.setStepSound(Block.soundTypeGlass);
		this.setLightOpacity(1);
		this.setLightLevel(0.921F);
	}
	
	/*
	 * @Override public int getLightValue(IBlockAccess world, int x, int y, int
	 * z) { int meta = world.getBlockMetadata(x, y, z); if(meta == 0) { return
	 * CLApi.makeRGBLightValue(0.329F, 0.6F, 0.921F); } else if(meta == 1) {
	 * return CLApi.makeRGBLightValue(0.909F, 0.392F, 0.235F); } else if(meta ==
	 * 2) { return CLApi.makeRGBLightValue(0.49F, 0.811F, 0.227F); } return 0; }
	 */
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		if (world.getBlockMetadata(x, y, z) == 1)
		{
			entity.setFire(2);
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
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		this.updateTick(world, x, y, z, world.rand);
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		if (metadata == 0 && world.provider.dimensionId == -1)
		{
			return new ArrayList();
		}
		return super.getDrops(world, x, y, z, metadata, fortune);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return ECItems.shards;
	}
	
	@Override
	public int quantityDropped(int metadata, int fortune, Random random)
	{
		int i = 2 + random.nextInt(3) + random.nextInt(fortune + 1);
		if (i > 4)
		{
			i = 4;
		}
		return i;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata + 1;
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random random)
	{
		world.scheduleBlockUpdate(x, y, z, this, 100);
		
		int metadata = world.getBlockMetadata(x, y, z);
		for (int i = 0; i < 4; i++)
		{
			int x1 = x + random.nextInt(5) - 2;
			int y1 = y + random.nextInt(5) - 2;
			int z1 = z + random.nextInt(5) - 2;
			
			if (metadata == 0)
			{
				ECUtil.freeze(world, x1, y1, z1);
			}
			else if (metadata == 1)
			{
				ECUtil.melt(world, x1, y1, z1);
			}
			else if (metadata == 2)
			{
				ECUtil.grow(world, x1, y1, z1);
			}
		}
	}
}
