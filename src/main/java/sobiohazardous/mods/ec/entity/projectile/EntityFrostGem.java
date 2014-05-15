package sobiohazardous.mods.ec.entity.projectile;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
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
        for (int i = 0; i < 32; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
        
        AxisAlignedBB axisalignedbb = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
        List list1 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);

        if (list1 != null && !list1.isEmpty())
        {
            Iterator iterator = list1.iterator();

            while (iterator.hasNext())
            {
                EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();
                double d0 = this.getDistanceSqToEntity(entitylivingbase);

                if (d0 < 16.0D)
                {
                    if (entitylivingbase == mop.entityHit)
                    {
                    	mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 4.0F);
                    }
                }
            }
        }
    }
}