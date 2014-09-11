package minestrapteam.elementalcaves.addons.minestrappolation;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import minestrapteam.elementalcaves.addons.Addon;
import minestrapteam.elementalcaves.item.ECItem;
import minestrapteam.elementalcaves.lib.ECBlocks;
import minestrapteam.elementalcaves.util.ECUtil;
import minestrapteam.minestrappolation.crafting.stonecutter.StonecuttingManager;
import minestrapteam.minestrappolation.lib.MBlocks;
import minestrapteam.minestrappolation.util.MUtil;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AddonMinestrappolation extends Addon
{
	public static Block	ancientMossStone;
	public static Block	ancientMossStone2;
	
	public static Block	glacierRock;
	public static Block	glacierRock2;
	
	public static Block	moltenstone;
	public static Block	moltenstone2;
	
	public static Item	ancientMossStoneBrick;
	public static Item	moltenstoneBrick;
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		loadBlocks();
		loadItems();
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
	
	private void loadItems()
	{
		ancientMossStoneBrick = new ECItem().setTextureName(ECUtil.getTexture("ancient_moss_stone_brick")).setUnlocalizedName("ancient_moss_stone_brick");
		moltenstoneBrick = new ECItem().setTextureName(ECUtil.getTexture("moltenstone_brick")).setUnlocalizedName("moltenstone_brick");
	}
	
	private void loadBlocks()
	{
		
	}
	
	private void loadRecipes()
	{
		ItemStack glacierrockRaw = new ItemStack(ECBlocks.glacierRock, 1, 0);
		ItemStack glacierrockCracked = new ItemStack(ECBlocks.glacierRock, 1, 1);
		ItemStack glacierrockBricks = new ItemStack(ECBlocks.glacierRock, 1, 2);
		
		ItemStack moltenstoneRaw = new ItemStack(ECBlocks.moltenstone, 1, 0);
		ItemStack moltenstoneBricks = new ItemStack(ECBlocks.moltenstone, 1, 2);
		
		ItemStack ancientMossCobblestone = new ItemStack(ECBlocks.ancientMossStone, 1, 1);
		ItemStack ancientMossStoneBricks = new ItemStack(ECBlocks.ancientMossStone, 1, 2);
		
		// Compatibility recipes
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRock, 4, 2), null, new Object[] { "BB", "BB", 'B', glacierrockRaw });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockStairs, 4), null, new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockCracked });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockBrickStairs, 4), null, new Object[] { "M  ", "MM ", "MMM", 'M', glacierrockBricks });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 0), null, new Object[] { "MMM", 'M', glacierrockRaw });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 1), null, new Object[] { "MMM", 'M', glacierrockCracked });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.glacierRockSlabSingle, 6, 2), null, new Object[] { "MMM", 'M', glacierrockBricks });
		
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.moltenstone, 4, 2), null, new Object[] { "BB", "BB", 'B', moltenstoneRaw });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.moltenstoneSlabSingle, 6, 0), null, new Object[] { "MMM", 'M', moltenstoneRaw });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.moltenstoneSlabSingle, 6, 1), null, new Object[] { "MMM", 'M', moltenstoneBricks });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.moltenstoneBrickStairs, 4), null, new Object[] { "M  ", "MM ", "MMM", 'M', moltenstoneBricks });
		
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossStone, 4, 2), null, new Object[] { "MM", "MM", 'M', ECBlocks.ancientMossStone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 0), null, new Object[] { "MMM", 'M', ECBlocks.ancientMossStone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 1), null, new Object[] { "MMM", 'M', ancientMossCobblestone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossySlabSingle, 6, 2), null, new Object[] { "MMM", 'M', ancientMossStoneBricks });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossyBrickStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', ancientMossStoneBricks });
		StonecuttingManager.instance.addRecipe(new ItemStack(ECBlocks.ancientMossyCobbleStairs, 4, 0), null, new Object[] { "M  ", "MM ", "MMM", 'M', ancientMossCobblestone });
		
		// New Recipes
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', ancientMossStoneBrick });
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone, 1, 3), null, new Object[] { "BB", "BB", 'B', new ItemStack(ancientMossStone, 1, 5) });
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone, 1, 4), null, new Object[] { "BBB", "BBB", "SSS", 'B', ancientMossStoneBrick, 'S', ECBlocks.richSoil });
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone, 1, 5), null, new Object[] { "B", "B", 'B', new ItemStack(ancientMossStone2, 1, 4) });
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone, 8, 14), null, new Object[] { "SSS", "SGS", "SSS", 'S', new ItemStack(ancientMossStone, 1, 5), 'G', Blocks.glowstone });
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone, 8, 15), null, new Object[] { "SSS", "SGS", "SSS", 'S', new ItemStack(ancientMossStone, 1, 5), 'G', MBlocks.sunstoneBlock });
		
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone2, 1, 0), null, new Object[] { "B", "B", 'B', new ItemStack(ancientMossStone, 1, 5) });
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone2, 6, 3), null, new Object[] { "BBB", "BBB", 'B', new ItemStack(ancientMossStone, 1, 3) });
		StonecuttingManager.instance.addRecipe(new ItemStack(ancientMossStone2, 6, 4), null, new Object[] { "BBB", "BBB", 'B', new ItemStack(ancientMossStone, 1, 5) });
		
		StonecuttingManager.instance.addRecipe(new ItemStack(moltenstone, 2, 2), null, new Object[] { "BBB", "BBB", "BBB", 'B', moltenstoneBrick });
		StonecuttingManager.instance.addRecipe(new ItemStack(moltenstone, 1, 3), null, new Object[] { "BB", "BB", 'B', new ItemStack(moltenstone, 1, 5) });
		StonecuttingManager.instance.addRecipe(new ItemStack(moltenstone, 1, 4), null, new Object[] { "BBB", "BBB", "SSS", 'B', moltenstoneBrick, 'S', Blocks.obsidian });
		StonecuttingManager.instance.addRecipe(new ItemStack(moltenstone, 1, 5), null, new Object[] { "B", "B", 'B', new ItemStack(moltenstone2, 1, 4) });
		StonecuttingManager.instance.addRecipe(new ItemStack(moltenstone, 8, 14), null, new Object[] { "SSS", "SGS", "SSS", 'S', new ItemStack(moltenstone, 1, 5), 'G', Items.lava_bucket });
		
		StonecuttingManager.instance.addRecipe(new ItemStack(moltenstone2, 1, 0), null, new Object[] { "B", "B", 'B', new ItemStack(moltenstone, 1, 5) });
		StonecuttingManager.instance.addRecipe(new ItemStack(moltenstone2, 6, 3), null, new Object[] { "BBB", "BBB", 'B', new ItemStack(moltenstone, 1, 3) });
		StonecuttingManager.instance.addRecipe(new ItemStack(moltenstone2, 6, 4), null, new Object[] { "BBB", "BBB", 'B', new ItemStack(moltenstone, 1, 5) });
		
		// TODO add glaccierrock recipes when brick is available.
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
		MUtil.removeRecipe(new ItemStack(ECBlocks.ancientMossyBrickStairs, 4, 0));
		MUtil.removeRecipe(new ItemStack(ECBlocks.ancientMossyCobbleStairs, 4, 0));
	}
}
