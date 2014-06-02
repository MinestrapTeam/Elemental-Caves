package minestrapteam.elementalcaves.block;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockMoltenSlab extends ECBlockSlab
{
	public BlockMoltenSlab(boolean isDouble, String[] sideIconNames, String[] topIconNames)
	{
		super(isDouble, sideIconNames, topIconNames);
	}
	
	@Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity)
	{
		entity.setFire(2);
	}
}
