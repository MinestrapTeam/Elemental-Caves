package minestrapteam.elementalcaves.entity.projectile;

import minestrapteam.elementalcaves.util.ECUtil;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityForestGem extends EntityGem
{
	public EntityForestGem(World world)
	{
		super(world);
	}
	
	public EntityForestGem(World world, EntityLivingBase living)
	{
		super(world, living);
	}
	
	public EntityForestGem(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase entity)
	{
	}
	
	@Override
	public void affectBlock(World world, int x, int y, int z)
	{
		ECUtil.grow(world, x, y, z);
	}
}