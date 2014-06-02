package minestrapteam.elementalcaves.entity.projectile;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public abstract class EntityGem extends EntityThrowable
{
	public EntityGem(World world)
	{
		super(world);
	}
	
	public EntityGem(World world, EntityLivingBase living)
	{
		super(world, living);
	}
	
	public EntityGem(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mop)
	{
		World world = this.worldObj;
		int x = (int) this.posX;
		int y = (int) this.posY;
		int z = (int) this.posZ;
		
		for (int i = -4; i <= 4; i++)
		{
			for (int j = -2; j <= 2; j++)
			{
				for (int k = -4; k <= 4; k++)
				{
					int x1 = x + i;
					int y1 = y + j;
					int z1 = z + k;
					this.affectBlock(world, x1, y1, z1);
				}
			}
		}
		
		AxisAlignedBB axisalignedbb = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
		List<EntityLivingBase> list1 = world.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		
		for (EntityLivingBase entity : list1)
		{
			float d0 = (float) this.getDistanceSqToEntity(entity);
			
			if (d0 < 16.0F)
			{
				this.addPotionEffect(entity);
			}
		}
		
		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}
	
	public abstract void addPotionEffect(EntityLivingBase entity);
	
	public abstract void affectBlock(World world, int x, int y, int z);
}
