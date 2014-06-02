package minestrapteam.elementalcaves.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIceShard extends EntityThrowable
{
	public EntityIceShard(World world)
	{
		super(world);
	}
	
	public EntityIceShard(World world, EntityLivingBase living)
	{
		super(world, living);
	}
	
	public EntityIceShard(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition mop)
	{
		this.worldObj.playAuxSFX(2001, (int) this.posX, (int) this.posY, (int) this.posZ, 80);
		
		if (mop.entityHit != null)
		{
			byte b0 = 0;
			
			if (mop.entityHit instanceof EntityBlaze)
			{
				b0 = 3;
			}
			
			mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
			EntityLivingBase l = (EntityLivingBase) mop.entityHit;
			l.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20, 0, false));
		}
		
		for (int i = 0; i < 8; ++i)
		{
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}
		
		if (!this.worldObj.isRemote)
		{
			this.setDead();
		}
	}
}