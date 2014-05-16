package sobiohazardous.mods.ec.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class BlockAncientIce extends BlockSlippery
{
	public BlockAncientIce(Material material)
	{
		super(material, 1.05F);
	}

    @Override
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) 
    {
		EntityLivingBase living = (EntityLivingBase)entity;
		living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 15 * 20));
    }
    
    @Override
	public int quantityDropped(Random random)
    {
        return 0;
    }
    
    @Override
	protected boolean canSilkHarvest()
    {
        return true;
    }
	
}
