package sobiohazardous.mods.ec.item;

import java.util.List;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class ECItemSword extends ItemSword
{
	public ECItemSword(ToolMaterial mat)
	{
		super(mat);
		this.setCreativeTab(ElementalCaves.creativeTabECItems);
	}

	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if(this == ECItems.swordFreezium)
		{
			if(ECUtil.freeze(world, x, y, z))
			{
				stack.damageItem(4, player);
				return true;
			}
		}
		if(this == ECItems.swordInfernium)
		{
			if(ECUtil.melt(world, x, y, z))
			{
				stack.damageItem(10, player);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase living, EntityLivingBase attacker)
    {
    	if(this == ECItems.swordFreezium)
    	{
    		living.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20));
    		return super.hitEntity(stack, living, attacker);
    	}
    	if(this == ECItems.swordInfernium)
    	{
    		living.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 10 * 20));
    		living.setFire(10);
    		return super.hitEntity(stack, living, attacker);
    	}
    	return super.hitEntity(stack, living, attacker);
    }
}
