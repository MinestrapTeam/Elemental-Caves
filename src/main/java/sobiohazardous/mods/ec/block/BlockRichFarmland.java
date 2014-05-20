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
	}
	
	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity force, float velocity)
	{
		if (!world.isRemote && world.rand.nextFloat() < velocity - 0.5F)
		{
			if (force instanceof EntityPlayer || world.getGameRules().getGameRuleBooleanValue("mobGriefing"))
			{
				world.setBlock(x, y, z, ECBlocks.richSoil);
			}			
		}
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
		if (plantable.getPlantType(world, x, y + 1, z) == EnumPlantType.Crop)
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