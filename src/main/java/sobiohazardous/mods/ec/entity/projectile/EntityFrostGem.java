package sobiohazardous.mods.ec.entity.projectile;

import java.util.List;

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
		for (int i = 0; i < 32; i++)
		{
			double velocityX = this.rand.nextDouble() * 2D;
			double velocityY = this.rand.nextDouble() * 2D;
			double velocityZ = this.rand.nextDouble() * 2D;
			
			this.worldObj.spawnParticle("flame", this.posX, this.posY, this.posZ, velocityX, velocityY, velocityZ);
		}
		
		AxisAlignedBB axisalignedbb = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
		List<EntityLivingBase> list1 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
		
		for (EntityLivingBase entity : list1)
		{
			float d0 = (float) this.getDistanceSqToEntity(entity);
			
			if (d0 < 16.0F)
			{
				entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20 * 120, 9));
				entity.addPotionEffect(new PotionEffect(Potion.jump.id, 20 * 120, -10));
				
				if (entity == mop.entityHit)
				{
					mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4F);
				}
			}
		}
		
		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}
}