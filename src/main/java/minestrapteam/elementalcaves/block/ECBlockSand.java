package minestrapteam.elementalcaves.block;

import java.util.List;

import minestrapteam.elementalcaves.ElementalCaves;
import minestrapteam.elementalcaves.lib.ECBlocks;
import minestrapteam.elementalcaves.util.ECUtil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ECBlockSand extends BlockFalling
{
	public IIcon	sandDarkIcon;
	public IIcon	sandQuickIcon;
	
	public ECBlockSand(Material mat)
	{
		super(mat);
		this.setStepSound(Block.soundTypeSand);
		this.setCreativeTab(ElementalCaves.tabBlocks);
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return metadata == 1 ? this.sandQuickIcon : this.sandDarkIcon;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.sandDarkIcon = iconRegister.registerIcon(ECUtil.getTexture("dark_sand"));
		this.sandQuickIcon = iconRegister.registerIcon(ECUtil.getTexture("quicksand"));
	}
	
	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
	{
		super.onNeighborBlockChange(world, x, y, z, neighbor);
		if (world.getBlockMetadata(x, y, z) == 0)
		{
			if (neighbor == Blocks.water || neighbor == Blocks.flowing_water)
			{
				world.setBlock(x, y, z, ECBlocks.sand, 1, 3);
			}
		}
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
	{
		Block plant = plantable.getPlant(world, x, y + 1, z);
		EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
		return plantType == EnumPlantType.Desert || plant == Blocks.reeds;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (world.getBlockMetadata(x, y, z) == 1)
		{
			entity.setInWeb();
		}
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		if (world.getBlockMetadata(x, y, z) == 1)
		{
			return null;
		}
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	}
}
