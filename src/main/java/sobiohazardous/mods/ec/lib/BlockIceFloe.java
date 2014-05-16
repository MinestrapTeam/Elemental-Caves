package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.ElementalCaves;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;

public class BlockIceFloe extends BlockFluidFinite
{
	private IIcon flowingIcon;
	
	public BlockIceFloe()
	{
		super(ElementalCaves.iceFloe, Material.water);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(ECReference.getTexture("icefloe_still"));
		this.flowingIcon = iconRegister.registerIcon(ECReference.getTexture("icefloe_flowing"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return side == 0 || side == 1 || metadata > 0 ? this.flowingIcon : this.blockIcon;
	}
	
	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block == Blocks.flowing_water)
		{
			world.setBlock(x, y, z, Blocks.snow);
			return true;
		}
		else if (block == Blocks.water)
		{
			world.setBlock(x, y, z, Blocks.ice);
			return true;
		}
		else if (block == Blocks.flowing_lava)
		{
			world.setBlock(x, y, z, ECBlocks.glacierRock, 1, 3);
			return true;
		}
		else if (block == Blocks.lava)
		{
			world.setBlock(x, y, z, Blocks.obsidian);
			return true;
		}
		
		return false;
	}
}
