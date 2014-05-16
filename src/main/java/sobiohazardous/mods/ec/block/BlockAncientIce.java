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

    public void onEntityWalking(World world, int x, int y, int z, Entity entity) 
    {
		EntityLivingBase living = (EntityLivingBase)entity;
		living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 15 * 20));
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 0;
    }
    
    /**
     * Return true if a player with Silk Touch can harvest this block directly, and not its normal drops.
     */
    protected boolean canSilkHarvest()
    {
        return true;
    }
	
}
