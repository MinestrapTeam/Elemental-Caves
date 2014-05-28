package sobiohazardous.mods.ec.block;

import java.util.Random;

import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRichSoil extends ECBlock
{
	public BlockRichSoil(Material material)
	{
		super(material);
		this.setTickRandomly(true);
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (rand.nextInt(16) == 0)
		{
			ECUtil.grow(world, x, y + 1, z);
		}
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
	{
		return true;
	}
}
