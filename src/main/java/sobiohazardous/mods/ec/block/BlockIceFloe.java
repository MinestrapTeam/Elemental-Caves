package sobiohazardous.mods.ec.block;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockIceFloe extends BlockFluidClassic
{
	private IIcon	flowingIcon;
	
	public BlockIceFloe()
	{
		super(ElementalCaves.iceFloe, Material.water);
		ElementalCaves.iceFloe.setBlock(this);
		this.setLightLevel(0.921F);
		this.disableStats();
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(ECUtil.getTexture("icefloe_still"));
		this.flowingIcon = iconRegister.registerIcon(ECUtil.getTexture("icefloe_flowing"));
	}
	
	@Override
	public Fluid getFluid()
	{
		return ElementalCaves.iceFloe;
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityLivingBase)
		{
			EntityLivingBase living = ((EntityLivingBase) entity);
			living.attackEntityFrom(DamageSource.generic, 0.25F);
			living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20 * 30, 1));
		}
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return (side == 0 || side == 1) ? this.blockIcon : flowingIcon;
	}
	
	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		
		if (block == Blocks.flowing_water)
		{
			world.setBlock(x, y, z, Blocks.snow);
		}
		else if (block == Blocks.water)
		{
			world.setBlock(x, y, z, Blocks.ice);
		}
		else if (world.getBlock(x, y + 1, z) == Blocks.flowing_lava)
		{
			world.setBlock(x, y, z, ECBlocks.glacierRock, 0, 3);
		}
		else if (block == Blocks.lava)
		{
			if (world.getBlockMetadata(x, y, z) != 0)
			{
				world.setBlock(x, y, z, ECBlocks.glacierRock, 1, 3);
			}
			else
			{
				world.setBlock(x, y, z, Blocks.obsidian);
			}
		}
		return super.displaceIfPossible(world, x, y, z);
	}
}
