package minestrapteam.elementalcaves.entity.projectile;

import minestrapteam.elementalcaves.util.ECUtil;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityMagmaGem extends EntityGem
{
	public EntityMagmaGem(World world)
	{
		super(world);
	}
	
	public EntityMagmaGem(World world, EntityLivingBase living)
	{
		super(world, living);
	}
	
	public EntityMagmaGem(World world, double x, double y, double z)
	{
		super(world, x, y, z);
	}
	
	@Override
	public void addPotionEffect(EntityLivingBase entity)
	{
		entity.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 60, 9));
		entity.setFire(20);
		entity.attackEntityFrom(new DamageSource("explosion"), 1F);
	}
	
	@Override
	public void affectBlock(World world, int x, int y, int z)
	{
		ECUtil.melt(world, x, y, z);
	}
}