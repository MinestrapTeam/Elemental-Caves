package sobiohazardous.mods.ec.lib;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECRecipes
{
	public static void init()
	{
		ItemStack glacierrock = new ItemStack(ECBlocks.glacierRock, 1, 0);
		ItemStack glacierrockCracked = new ItemStack(ECBlocks.glacierRock, 1, 1);
		ItemStack glacierrockBricks = new ItemStack(ECBlocks.glacierRock, 1, 2);
		ItemStack moltenstone = new ItemStack(ECBlocks.moltenstone, 1, 0);
		ItemStack moltenstoneCooled = new ItemStack(ECBlocks.moltenstone, 1, 1);
		ItemStack moltenstoneBricks = new ItemStack(ECBlocks.moltenstone, 1, 2);
		
		GameRegistry.addRecipe(new ItemStack(ECItems.gemFrost), new Object[] { "SAS", "ACA", "SAS", 'A', ECBlocks.ancientIce, 'S', ECItems.iceShard, 'C', ECItems.gemClear });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.crystals), new Object[] { "SS", "SS", 'S', ECItems.iceShard });
		GameRegistry.addSmelting(new ItemStack(ECBlocks.oreFreezium, 1, 0), new ItemStack(ECBlocks.ancientIce, 1, 0), 0.8F);
		
		GameRegistry.addRecipe(new ItemStack(ECItems.axeFreezium), new Object[] { "MM ", "MS ", " S ", 'S', Items.stick, 'M', ECItems.gemFrost });
		GameRegistry.addRecipe(new ItemStack(ECItems.hoeFreezium), new Object[] { "MM ", " S ", " S ", 'S', Items.stick, 'M', ECItems.gemFrost });
		GameRegistry.addRecipe(new ItemStack(ECItems.pickaxeFreezium), new Object[] { "MMM", " S ", " S ", 'S', Items.stick, 'M', ECItems.gemFrost });
		GameRegistry.addRecipe(new ItemStack(ECItems.swordFreezium), new Object[] { "M", "M", "S", 'S', Items.stick, 'M', ECItems.gemFrost });
		GameRegistry.addRecipe(new ItemStack(ECItems.shovelFreezium), new Object[] { " M ", " S ", " S ", 'S', Items.stick, 'M', ECItems.gemFrost });
		
		GameRegistry.addRecipe(new ItemStack(ECItems.helmetFreezium), new Object[] { "MMM", "M M", 'M', ECItems.gemFrost });
		GameRegistry.addRecipe(new ItemStack(ECItems.chestplateFreezium), new Object[] { "M M", "MMM", "MMM", 'M', ECItems.gemFrost });
		GameRegistry.addRecipe(new ItemStack(ECItems.leggingsFreezium), new Object[] { "MMM", "M M", "M M", 'M', ECItems.gemFrost });
		GameRegistry.addRecipe(new ItemStack(ECItems.bootsFreezium), new Object[] { "M M", "M M", 'M', ECItems.gemFrost });
		
		
		GameRegistry.addSmelting(glacierrockCracked, glacierrock, 0.8F);
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRock, 4, 2), new Object[] { "BB", "BB", 'B', glacierrock });
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.moltenstone, 4, 2), new Object[] { "BB", "BB", 'B', moltenstone });
	
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockStairs, 4), new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockCracked });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockBrickStairs, 4), new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockBricks });
	}
}
