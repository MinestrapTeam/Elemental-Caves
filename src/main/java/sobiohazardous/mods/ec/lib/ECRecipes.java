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
		
		ItemStack clearGem = new ItemStack(ECItems.gems, 1, 0);
		ItemStack iceGem = new ItemStack(ECItems.gems, 1, 1);
		ItemStack magmaGem = new ItemStack(ECItems.gems, 1, 2);
		
		ItemStack iceShard = new ItemStack(ECItems.shards, 1, 1);
		ItemStack fireShard = new ItemStack(ECItems.shards, 1, 2);
		
		GameRegistry.addRecipe(iceGem, new Object[] { "SAS", "ACA", "SAS", 'A', ECBlocks.ancientIce, 'S', iceShard, 'C', clearGem });
		GameRegistry.addRecipe(magmaGem, new Object[] { "SAS", "ACA", "SAS", 'A', ECBlocks.moltenstone, 'S', fireShard, 'C', clearGem });
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.crystals, 1, 0), new Object[] { "SS", "SS", 'S', iceShard });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.crystals, 1, 1), new Object[] { "SS", "SS", 'S', fireShard });
		
		GameRegistry.addSmelting(new ItemStack(ECBlocks.oreFreezium, 1, 0), new ItemStack(ECBlocks.ancientIce, 1, 0), 0.8F);
		
		GameRegistry.addRecipe(new ItemStack(ECItems.axeFreezium), new Object[] { "MM ", "MS ", " S ", 'S', Items.stick, 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.hoeFreezium), new Object[] { "MM ", " S ", " S ", 'S', Items.stick, 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.pickaxeFreezium), new Object[] { "MMM", " S ", " S ", 'S', Items.stick, 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.swordFreezium), new Object[] { "M", "M", "S", 'S', Items.stick, 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.shovelFreezium), new Object[] { " M ", " S ", " S ", 'S', Items.stick, 'M', iceGem });
		
		GameRegistry.addRecipe(new ItemStack(ECItems.helmetFreezium), new Object[] { "MMM", "M M", 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.chestplateFreezium), new Object[] { "M M", "MMM", "MMM", 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.leggingsFreezium), new Object[] { "MMM", "M M", "M M", 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.bootsFreezium), new Object[] { "M M", "M M", 'M', iceGem });
		
		
		GameRegistry.addSmelting(glacierrockCracked, glacierrock, 0.8F);
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRock, 4, 2), new Object[] { "BB", "BB", 'B', glacierrock });
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.moltenstone, 4, 2), new Object[] { "BB", "BB", 'B', moltenstone });
	
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockStairs, 4), new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockCracked });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockBrickStairs, 4), new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockBricks });
	}
}
