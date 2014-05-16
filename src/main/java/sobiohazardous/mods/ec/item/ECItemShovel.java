package sobiohazardous.mods.ec.item;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ECItemShovel extends ItemSpade
{
	public ECItemShovel(ToolMaterial mat)
	{
		super(mat);
		this.setCreativeTab(ElementalCaves.creativeTabECItems);
	}

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	{
		if(this == ECItems.shovelFreezium)
		{
			if(ECUtil.freeze(world, par4, par5, par6))
			{
				par1ItemStack.damageItem(4, par2EntityPlayer);
				return true;
			}
		}
		return false;
	}
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
    	if(this == ECItems.shovelFreezium)
    	{
    		par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 10 * 20));
    		return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    	}
    	return super.hitEntity(par1ItemStack, par2EntityLivingBase, par3EntityLivingBase);
    }
}
