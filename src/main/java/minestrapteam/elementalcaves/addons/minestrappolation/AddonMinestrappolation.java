package minestrapteam.elementalcaves.addons.minestrappolation;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import minestrapteam.elementalcaves.ElementalCaves;
import minestrapteam.elementalcaves.addons.Addon;
import minestrapteam.elementalcaves.lib.ECBlocks;
import minestrapteam.minestrappolation.crafting.stonecutter.StonecuttingManager;
import minestrapteam.minestrappolation.util.MBlockHelper;
import minestrapteam.minestrappolation.util.MUtil;

public class AddonMinestrappolation extends Addon
{
	public static Block ancientMossStone;
	public static Block ancientMossStone2;
	
	public static Block glacierRock;
	public static Block glacierRock2;
	
	public static Block moltenstone;
	public static Block moltenstone2;

	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		loadBlocks();
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		loadRecipes();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		removeRecipes();
	}

	@Override
	public String getModForAddon()
	{
		return "minestrappolation";
	}
	
	private void loadBlocks()
	{
		String[] ancient_moss_stone_types = new String[] { null, null, "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "lamp_glowstone", "lamp_sunstone" };
		String[] stone_types2 = new String[] { "pillar", null, null, "tile_slab", "refined_slab" };

		String[] moltenstone_types = new String[] { null, "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "lamp_glowstone", null };

		ancientMossStone = MBlockHelper.createStoneBlock(ancient_moss_stone_types, "ancient_moss_stone", 2F, 11F, 0, ElementalCaves.tabBlocks);
		ancientMossStone2 = MBlockHelper.createStoneBlock2(stone_types2, "ancient_moss_stone", 2F, 3F, 0, ElementalCaves.tabBlocks);
		
		glacierRock = MBlockHelper.createStoneBlock(ancient_moss_stone_types, "glacierrock", 2F, 10F, 1, ElementalCaves.tabBlocks);
		glacierRock2 = MBlockHelper.createStoneBlock2(stone_types2, "glacierrock", 2F, 3F, 0, ElementalCaves.tabBlocks);
		
		moltenstone = MBlockHelper.createStoneBlock(moltenstone_types, "moltenstone", 2F, 8F, 2, ElementalCaves.tabBlocks);
		moltenstone2 = MBlockHelper.createStoneBlock2(stone_types2, "moltenstone", 2.1F, 8F, 3, ElementalCaves.tabBlocks);		
	}
	
	private void loadRecipes()
	{
		ItemStack glacierrock = new ItemStack(ECBlocks.glacierRock, 1, 0);
		ItemStack glacierrockCracked = new ItemStack(ECBlocks.glacierRock, 1, 1);
		ItemStack glacierrockBricks = new ItemStack(ECBlocks.glacierRock, 1, 2);
		
		ItemStack moltenstone = new ItemStack(ECBlocks.moltenstone, 1, 0);
		ItemStack moltenstoneBricks = new ItemStack(ECBlocks.moltenstone, 1, 2);
		
		ItemStack ancientMossCobblestone = new ItemStack(ECBlocks.ancientMossStone, 1, 1);
		ItemStack ancientMossStoneBricks = new ItemStack(ECBlocks.ancientMossStone, 1, 2);
		
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRock, 4, 2), null, new Object[] { "BB", "BB", 'B', glacierrock });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockStairs, 4), null, new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockCracked });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockBrickStairs, 4), null, new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockBricks });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 0), null, new Object[] { "MMM", 'M', glacierrock });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 1), null, new Object[] { "MMM", 'M', glacierrockCracked });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 2), null, new Object[] { "MMM", 'M', glacierrockBricks });
				
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.moltenstone, 4, 2), null, new Object[] { "BB", "BB", 'B', moltenstone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.moltenstoneSlabSingle, 6, 0), null, new Object[] { "MMM", 'M', moltenstone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.moltenstoneSlabSingle, 6, 1), null, new Object[] { "MMM", 'M', moltenstoneBricks });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.moltenstoneBrickStairs, 4), null, new Object[] { "M  ", "MM ", "MMM", 'M', moltenstoneBricks });
				
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossStone, 4, 2), null, new Object[] { "MM", "MM", 'M', ECBlocks.ancientMossStone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 0), null, new Object[] { "MMM", 'M', ECBlocks.ancientMossStone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 1), null, new Object[] { "MMM", 'M', ancientMossCobblestone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 2), null, new Object[] { "MMM", 'M', ancientMossStoneBricks });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossyStonebrickStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', ancientMossStoneBricks });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossyCobbleStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', ancientMossCobblestone });
	}
	
	private void removeRecipes()
	{
		MUtil.removeRecipe(new ItemStack(ECBlocks.glacierRock, 4, 2));
		MUtil.removeRecipe(new ItemStack(ECBlocks.glacierRockStairs, 4));
		MUtil.removeRecipe(new ItemStack(ECBlocks.glacierRockBrickStairs, 4));
		MUtil.removeRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 0));
		MUtil.removeRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 1));
		MUtil.removeRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 2));
		
		MUtil.removeRecipe(new ItemStack(ECBlocks.moltenstone, 4, 2));
		MUtil.removeRecipe(new ItemStack(ECBlocks.moltenstoneSlabSingle, 6, 0));
		MUtil.removeRecipe(new ItemStack(ECBlocks.moltenstoneSlabSingle, 6, 1));
		MUtil.removeRecipe(new ItemStack(ECBlocks.moltenstoneBrickStairs, 4));

		MUtil.removeRecipe(new ItemStack(ECBlocks.ancientMossStone, 4, 2));
		MUtil.removeRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 0));
		MUtil.removeRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 1));
		MUtil.removeRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 2));
		MUtil.removeRecipe(new ItemStack(ECBlocks.ancientMossyStonebrickStairs, 4, 0));
		MUtil.removeRecipe(new ItemStack(ECBlocks.ancientMossyCobbleStairs, 4, 0));
	}
}
