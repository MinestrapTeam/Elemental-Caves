package sobiohazardous.mods.ec.entity.projectile;

import sobiohazardous.mods.ec.util.ECUtil;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityFrostGem extends EntityGem
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
	public void addPotionEffect(EntityLivingBase entity)
	{
		entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20 * 120, 9));
		entity.addPotionEffect(new PotionEffect(Potion.jump.id, 20 * 120, -10));
		entity.attackEntityFrom(new DamageSource("explosion"), 1F);
	}
	
	@Override
	public void affectBlock(World world, int x, int y, int z)
	{
		ECUtil.freeze(world, x, y, z);
	}
}