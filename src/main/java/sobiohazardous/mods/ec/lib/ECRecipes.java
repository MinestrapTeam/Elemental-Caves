package sobiohazardous.mods.ec.lib;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECRecipes
{
	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(ECItems.gemFrost), new Object[] { "SAS", "ACA", "SAS", 'A', ECBlocks.ancientIce, 'S', ECItems.iceShard, 'C', ECItems.gemClear });
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.crystalIce), new Object[] { "SS", "SS", 'S', ECItems.iceShard });
		
		GameRegistry.addRecipe(new ItemStack(ECItems.axeFreezium), new Object[]{"MM ", "MS ", " S ", 'S', Items.stick, 'M', ECItems.gemFrost});
		GameRegistry.addRecipe(new ItemStack(ECItems.hoeFreezium), new Object[]{"MM ", " S ", " S ", 'S', Items.stick, 'M', ECItems.gemFrost});
		GameRegistry.addRecipe(new ItemStack(ECItems.pickaxeFreezium), new Object[]{"MMM", " S ", " S ", 'S', Items.stick, 'M', ECItems.gemFrost});
		GameRegistry.addRecipe(new ItemStack(ECItems.swordFreezium), new Object[]{"M", "M", "S", 'S', Items.stick, 'M', ECItems.gemFrost});
		GameRegistry.addRecipe(new ItemStack(ECItems.shovelFreezium), new Object[]{" M ", " S ", " S ", 'S', Items.stick, 'M', ECItems.gemFrost});
		
		GameRegistry.addSmelting(new ItemStack(ECBlocks.glacierRock, 1, 1), new ItemStack(ECBlocks.glacierRock, 1, 0), 0.8F);
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRock, 4, 2), new Object[]{"BB", "BB", 'B', new ItemStack(ECBlocks.glacierRock, 1, 0)});
		GameRegistry.addSmelting(new ItemStack(ECBlocks.oreFreezium, 1, 0), new ItemStack(ECBlocks.ancientIce, 1, 0), 0.8F);

	}
}
