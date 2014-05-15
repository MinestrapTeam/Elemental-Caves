package sobiohazardous.mods.ec.lib;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECRecipes
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(ECItems.gemFrost), new Object[] { "SAS", "ACA", "SAS", 'A', ECBlocks.ancientIce, 'S', ECItems.iceShard, 'C', ECItems.gemClear });
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.crystalIce), new Object[] { "SS", "SS", 'S', ECItems.iceShard });
	}
}
