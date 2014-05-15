package sobiohazardous.mods.ec.entity.projectile;

import net.minecraft.entity.EntityLiving;
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
    public EntityIceShard(World par1World)
    {
        super(par1World);
    }

    public EntityIceShard(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityIceShard(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            byte b0 = 0;

            if (par1MovingObjectPosition.entityHit instanceof EntityBlaze)
            {
                b0 = 3;
            }

            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
            EntityLiving l = (EntityLiving)par1MovingObjectPosition.entityHit;
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