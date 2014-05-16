package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ECItemHoe extends ItemHoe
{
	public ECItemHoe(ToolMaterial mat)
	{
		super(mat);
		this.setCreativeTab(ElementalCaves.creativeTabECItems);
	}
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if(this == ECItems.hoeFreezium)
    	{
    		par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20));
    		return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    	}
    	return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }
	
}
