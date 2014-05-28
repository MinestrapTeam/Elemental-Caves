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
		ItemStack moltenstoneBricks = new ItemStack(ECBlocks.moltenstone, 1, 2);
		
		ItemStack ancientMossStone = new ItemStack(ECBlocks.ancientMossStone, 1, 0);
		ItemStack ancientMossCobblestone = new ItemStack(ECBlocks.ancientMossStone, 1, 1);
		ItemStack ancientMossStoneBricks = new ItemStack(ECBlocks.ancientMossStone, 1, 2);
		
		ItemStack clearGem = new ItemStack(ECItems.gems, 1, 0);
		ItemStack iceGem = new ItemStack(ECItems.gems, 1, 1);
		ItemStack magmaGem = new ItemStack(ECItems.gems, 1, 2);
		ItemStack forestGem = new ItemStack(ECItems.gems, 1, 3);
		
		ItemStack iceShard = new ItemStack(ECItems.shards, 1, 1);
		ItemStack fireShard = new ItemStack(ECItems.shards, 1, 2);
		ItemStack forestShard = new ItemStack(ECItems.shards, 1, 3);
		
		GameRegistry.addRecipe(iceGem, new Object[] { "SAS", "ACA", "SAS", 'A', ECBlocks.ancientIce, 'S', iceShard, 'C', clearGem });
		GameRegistry.addRecipe(magmaGem, new Object[] { "SAS", "ACA", "SAS", 'A', ECBlocks.moltenstone, 'S', fireShard, 'C', clearGem });
		GameRegistry.addRecipe(forestGem, new Object[] { "SAS", "ACA", "SAS", 'A', ECBlocks.richGrass, 'S', forestShard, 'C', clearGem });
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.crystals, 1, 0), new Object[] { "SS", "SS", 'S', iceShard });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.crystals, 1, 1), new Object[] { "SS", "SS", 'S', fireShard });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.crystals, 1, 2), new Object[] { "SS", "SS", 'S', forestShard });
		
		GameRegistry.addSmelting(ECBlocks.oreFreezium, new ItemStack(ECBlocks.ancientIce, 1, 0), 0.8F);
		GameRegistry.addSmelting(ECBlocks.oreLapis, new ItemStack(Items.dye, 8, 4), 0.8F);
		GameRegistry.addSmelting(ECBlocks.oreDiamond, new ItemStack(Items.diamond, 2), 1.0F);
		GameRegistry.addSmelting(ECBlocks.oreFertile, new ItemStack(Items.dye, 4, 15), 0.8F);
		
		GameRegistry.addSmelting(glacierrockCracked, glacierrock, 0.8F);
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRock, 4, 2), new Object[] { "BB", "BB", 'B', glacierrock });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockStairs, 4), new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockCracked });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockBrickStairs, 4), new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockBricks });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 0), new Object[] { "MMM", 'M', glacierrock });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 1), new Object[] { "MMM", 'M', glacierrockCracked });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 2), new Object[] { "MMM", 'M', glacierrockBricks });
		
		GameRegistry.addSmelting(new ItemStack(ECBlocks.moltenstone, 1, 1), moltenstone, 0.75F);
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.moltenstone, 4, 2), new Object[] { "BB", "BB", 'B', moltenstone });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.moltenstoneSlabSingle, 6, 0), new Object[] { "MMM", 'M', moltenstone });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.moltenstoneSlabSingle, 6, 1), new Object[] { "MMM", 'M', moltenstoneBricks });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.moltenstoneBrickStairs, 4), new Object[] { "M  ", "MM ", "MMM", 'M', moltenstoneBricks });
		
		GameRegistry.addSmelting(ancientMossCobblestone, ancientMossStone, 1.0F);
		
		GameRegistry.addRecipe(new ItemStack(ECBlocks.ancientMossStone, 4, 2), new Object[] { "MM", "MM", 'M', ECBlocks.ancientMossStone });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 0), new Object[] { "MMM", 'M', ECBlocks.ancientMossStone });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 1), new Object[] { "MMM", 'M', ancientMossCobblestone });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 2), new Object[] { "MMM", 'M', ancientMossStoneBricks });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.ancientMossyStonebrickStairs, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', ancientMossStoneBricks });
		GameRegistry.addRecipe(new ItemStack(ECBlocks.ancientMossyCobbleStairs, 4, 0), new Object[] { "M  ", "MM ", "MMM", 'M', ancientMossCobblestone });
		
		// Tools
		
		GameRegistry.addRecipe(new ItemStack(ECItems.axeFreezium), new Object[] { "MM ", "MS ", " S ", 'S', Items.stick, 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.hoeFreezium), new Object[] { "MM ", " S ", " S ", 'S', Items.stick, 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.pickaxeFreezium), new Object[] { "MMM", " S ", " S ", 'S', Items.stick, 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.swordFreezium), new Object[] { "M", "M", "S", 'S', Items.stick, 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.shovelFreezium), new Object[] { " M ", " S ", " S ", 'S', Items.stick, 'M', iceGem });
		
		GameRegistry.addRecipe(new ItemStack(ECItems.helmetFreezium), new Object[] { "MMM", "M M", 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.chestplateFreezium), new Object[] { "M M", "MMM", "MMM", 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.leggingsFreezium), new Object[] { "MMM", "M M", "M M", 'M', iceGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.bootsFreezium), new Object[] { "M M", "M M", 'M', iceGem });
		
		GameRegistry.addRecipe(new ItemStack(ECItems.axeInfernium), new Object[] { "MM ", "MS ", " S ", 'S', Items.blaze_rod, 'M', magmaGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.hoeInfernium), new Object[] { "MM ", " S ", " S ", 'S', Items.blaze_rod, 'M', magmaGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.pickaxeInfernium), new Object[] { "MMM", " S ", " S ", 'S', Items.blaze_rod, 'M', magmaGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.swordInfernium), new Object[] { "M", "M", "S", 'S', Items.blaze_rod, 'M', magmaGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.shovelInfernium), new Object[] { " M ", " S ", " S ", 'S', Items.blaze_rod, 'M', magmaGem });
		
		GameRegistry.addRecipe(new ItemStack(ECItems.helmetInfernium), new Object[] { "MMM", "M M", 'M', magmaGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.chestplateInfernium), new Object[] { "M M", "MMM", "MMM", 'M', magmaGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.leggingsInfernium), new Object[] { "MMM", "M M", "M M", 'M', magmaGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.bootsInfernium), new Object[] { "M M", "M M", 'M', magmaGem });
		
		GameRegistry.addRecipe(new ItemStack(ECItems.axeEarth), new Object[] { "MM ", "MS ", " S ", 'S', Items.blaze_rod, 'M', forestGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.hoeEarth), new Object[] { "MM ", " S ", " S ", 'S', Items.blaze_rod, 'M', forestGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.pickaxeEarth), new Object[] { "MMM", " S ", " S ", 'S', Items.blaze_rod, 'M', forestGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.swordEarth), new Object[] { "M", "M", "S", 'S', Items.blaze_rod, 'M', forestGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.shovelEarth), new Object[] { " M ", " S ", " S ", 'S', Items.blaze_rod, 'M', forestGem });
		
		GameRegistry.addRecipe(new ItemStack(ECItems.helmetEarth), new Object[] { "MMM", "M M", 'M', forestGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.chestplateEarth), new Object[] { "M M", "MMM", "MMM", 'M', forestGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.leggingsEarth), new Object[] { "MMM", "M M", "M M", 'M', forestGem });
		GameRegistry.addRecipe(new ItemStack(ECItems.bootsEarth), new Object[] { "M M", "M M", 'M', forestGem });
	}
}
