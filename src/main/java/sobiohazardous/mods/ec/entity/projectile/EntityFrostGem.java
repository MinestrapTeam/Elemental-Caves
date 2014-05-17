package sobiohazardous.mods.ec.entity.projectile;

import java.util.List;

import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityFrostGem extends EntityThrowable
{
	public EntityFrostGem(World world)
	{
		super(world);
	}
	
	public EntityFrostGem(World world, EntityLivingBase living)
	{
		super(world, living);
	}
	
	public EntityFrostGem(World world, double x, double y, double z)
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
					ECUtil.freeze(world, x1, y1, z1, true, false);
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
				entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20 * 120, 9));
				entity.addPotionEffect(new PotionEffect(Potion.jump.id, 20 * 120, -10));
				entity.attackEntityFrom(new DamageSource("explosion"), 1F);
			}
		}
		
		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}
}