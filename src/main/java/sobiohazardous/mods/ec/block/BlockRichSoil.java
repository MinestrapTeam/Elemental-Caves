package sobiohazardous.mods.ec.block;

import java.util.Random;

import sobiohazardous.mods.ec.util.ECUtil;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

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
	    ECUtil.grow(world, x, y, z);
	}
}
