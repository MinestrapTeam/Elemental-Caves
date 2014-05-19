package sobiohazardous.mods.ec.block;

import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRichFarmland extends BlockFarmland
{
	public BlockRichFarmland()
	{
		super();
		this.setTickRandomly(true);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
		this.setLightOpacity(255);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (rand.nextInt(16) == 0)
			ECUtil.grow(world, x, y + 1, z);
		
		if (!world.canLightningStrikeAt(x, y + 1, z))
		{
			int l = world.getBlockMetadata(x, y, z);
			
			if (l > 0)
			{
				world.setBlockMetadataWithNotify(x, y, z, l - 1, 2);
			}
			else if (!this.func_149822_e(world, x, y, z))
			{
				world.setBlock(x, y, z, ECBlocks.richSoil);
			}
		}
		else
		{
			world.setBlockMetadataWithNotify(x, y, z, 7, 2);
		}
	}
	
	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity force, float velocity)
	{
		if (!world.isRemote && world.rand.nextFloat() < velocity - 0.5F)
		{
			if (!(force instanceof EntityPlayer) && !world.getGameRules().getGameRuleBooleanValue("mobGriefing"))
			{
				return;
			}
			
			world.setBlock(x, y, z, ECBlocks.richSoil);
		}
	}
	
	private boolean func_149822_e(World world, int x, int y, int z)
	{
		byte b0 = 0;
		
		for (int l = x - b0; l <= x + b0; ++l)
		{
			for (int i1 = z - b0; i1 <= z + b0; ++i1)
			{
				Block block = world.getBlock(l, y + 1, i1);
				
				if (block instanceof IPlantable && canSustainPlant(world, x, y, z, ForgeDirection.UP, (IPlantable) block))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block changed)
	{
		super.onNeighborBlockChange(world, x, y, z, changed);
		Material material = world.getBlock(x, y + 1, z).getMaterial();
		
		if (material.isSolid())
		{
			world.setBlock(x, y, z, ECBlocks.richSoil);
		}
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
	{
		EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
		if (plantType == plantType.Crop)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		return ECBlocks.richSoil.getItemDropped(0, rand, fortune);
	}
	
	@Override
	public Item getItem(World world, int x, int y, int z)
	{
		return Item.getItemFromBlock(ECBlocks.richSoil);
	}
}