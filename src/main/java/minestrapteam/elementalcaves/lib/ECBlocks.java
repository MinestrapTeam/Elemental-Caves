package minestrapteam.elementalcaves.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.elementalcaves.ElementalCaves;
import minestrapteam.elementalcaves.block.*;
import minestrapteam.elementalcaves.item.block.ECItemBlockMulti;
import minestrapteam.elementalcaves.item.block.ECItemSlab;
import minestrapteam.elementalcaves.util.ECUtil;
import minestrapteam.minestrappolation.util.MBlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class ECBlocks
{
	public static Block	crystals;
	
	public static Block	ancientIce;
	public static Block	iceFloe;
	
	public static Block	glacierRock;
	public static Block	glacierRockSlabSingle;
	public static Block	glacierRockSlabDouble;
	public static Block	glacierRockStairs;
	public static Block	glacierRockBrickStairs;
	
	public static Block	moltenstone;
	public static Block	moltenstoneSlabSingle;
	public static Block	moltenstoneSlabDouble;
	public static Block	moltenstoneStairs;
	public static Block	moltenstoneBrickStairs;
	
	public static Block	ancientMossStone;
	public static Block	ancientMossySlabSingle;
	public static Block	ancientMossySlabDouble;
	public static Block	ancientMossyCobbleStairs;
	public static Block	ancientMossyBrickStairs;
	
	public static Block	richGrass;
	public static Block	richSoil;
	public static Block	richFarmland;
	
	public static Block	oreLapis;
	public static Block	oreFreezium;
	public static Block	oreGlistening;
	public static Block	oreDiamond;
	public static Block	oreFertile;
	
	public static Block	sand;
	public static Block	pressurizedSandstone;
	public static Block	pressurizedSandstoneSlabSingle;
	public static Block	pressurizedSandstoneSlabDouble;
	
	public static void init()
	{
		crystals = new BlockCrystals().setHardness(5F).setResistance(8F).setBlockTextureName(ECUtil.getTexture("crystal"));
		
		ancientIce = new BlockAncientIce(Material.rock).setStepSound(Block.soundTypeGlass).setHardness(2F).setResistance(40000F).setBlockTextureName(ECUtil.getTexture("ancient_ice"));
		iceFloe = new BlockIceFloe();
		
		richGrass = new BlockRichGrass(Material.grass).setHardness(0.6F);
		richSoil = new BlockRichSoil(Material.ground).setHardness(0.5F).setBlockTextureName(ECUtil.getTexture("rich_soil")).setStepSound(Block.soundTypeGravel);
		richFarmland = new BlockRichFarmland().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockTextureName(ECUtil.getTexture("rich_farmland"));
		
		oreLapis = new ECBlockOre(0.98F).setHardness(3F).setResistance(5.0F).setBlockTextureName(ECUtil.getTexture("lapis_ore_glacier"));
		oreFreezium = new ECBlockOre(0.98F).setHardness(3.5F).setResistance(6F).setBlockTextureName(ECUtil.getTexture("freezium_ore"));
		oreGlistening = new ECBlockOre().setHardness(3.0F).setResistance(15.0F).setLightLevel(0.6F).setBlockTextureName(ECUtil.getTexture("glistening_ore"));
		oreDiamond = new ECBlockOre().setHardness(3.5F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockTextureName(ECUtil.getTexture("diamond_ore_molten"));
		oreFertile = new ECBlockOre().setHardness(3F).setResistance(5.0F).setBlockTextureName(ECUtil.getTexture("fertile_ore"));
		
		sand = new ECBlockSand(Material.sand).setBlockName("sand_ec").setResistance(2.0F).setHardness(1.0F);
		pressurizedSandstone = new BlockPressurizedSandstone(Material.rock).setBlockTextureName(ECUtil.getTexture("pressurized_sandstone")).setBlockName("pressurized_sandstone").setHardness(1.6F).setResistance(2.0F);
		
		String[] pressurizedSandstoneSlabSideIcons = new String[] { ECUtil.getTexture("pressurized_sandstone_side_connect"), ECUtil.getTexture("smooth_pressurized_sandstone_side") };
		String[] pressurizedSandstoneSlabTopIcons = new String[] { ECUtil.getTexture("pressurized_sandstone_side_connect"), ECUtil.getTexture("pressurized_sandstone_top") };
		pressurizedSandstoneSlabSingle = new ECBlockSlab(false, pressurizedSandstoneSlabSideIcons, pressurizedSandstoneSlabTopIcons).setCreativeTab(ElementalCaves.tabBlocks).setHardness(1.6F).setResistance(2F);
		pressurizedSandstoneSlabDouble = new ECBlockSlab(true, pressurizedSandstoneSlabSideIcons, pressurizedSandstoneSlabTopIcons).setHardness(1.6F).setResistance(2F);
		
		// TODO Cave specific vanilla ores
		
		addBlock(crystals, ECItemBlockMulti.class, "crystal");
		
		addBlock(ancientIce, "ancient_ice");
		addBlock(iceFloe, "ice_floe");
		
		addBlock(richGrass, "rich_grass");
		addBlock(richSoil, "rich_soil");
		addBlock(richFarmland, "rich_farmland");
		
		addBlock(oreLapis, "lapis_ore_glacier");
		addBlock(oreFreezium, "freezium_ore");
		addBlock(oreGlistening, "glistening_ore");
		addBlock(oreDiamond, "diamond_ore_infernium");
		addBlock(oreFertile, "fertile_ore");
		
		addBlock(sand, ECItemBlockMulti.class, "sand_ec");
		addBlock(pressurizedSandstone, ECItemBlockMulti.class, "pressurized_sandstone");
		addBlock(pressurizedSandstoneSlabSingle, ECItemSlab.class, "pressurized_sandstone_slab_single", pressurizedSandstoneSlabSingle, pressurizedSandstoneSlabDouble);
		addBlock(pressurizedSandstoneSlabDouble, ECItemSlab.class, "pressurized_sandstone_slab_double", pressurizedSandstoneSlabSingle, pressurizedSandstoneSlabDouble);
	}
	
	public static void addHarvestLevels()
	{
		ancientIce.setHarvestLevel("pickaxe", 2);
		crystals.setHarvestLevel("pickaxe", 3);
		
		richGrass.setHarvestLevel("shovel", 0);
		richSoil.setHarvestLevel("shovel", 0);
		richFarmland.setHarvestLevel("shovel", 0);
		
		oreLapis.setHarvestLevel("pickaxe", 2);
		oreFreezium.setHarvestLevel("pickaxe", 3);
		oreGlistening.setHarvestLevel("pickaxe", 3);
		oreDiamond.setHarvestLevel("pickaxe", 2);
		oreFertile.setHarvestLevel("pickaxe", 2);
		
		sand.setHarvestLevel("shovel", 2);
		pressurizedSandstone.setHarvestLevel("pickaxe", 2);
	}
	
	private static void addStoneBlocks()
	{
		String[] stone_types = null;
		String[] stone_types_2 = null;
		
		// Glacierrock
		if (ElementalCaves.minestrappolation)
		{
			stone_types = new String[] { "raw", "cracked", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "lamp_glowstone", "lamp_sunstone" };
			stone_types_2 = new String[] { "raw_slab", "bricks_slab", "tile_slab", "refined_slab", "pillar" };
			
			glacierRock = MBlockHelper.createStoneBlock(stone_types, "glacierrock", 2F, 11F, 2, ElementalCaves.tabBlocks);
			glacierRockSlabSingle = MBlockHelper.createStoneBlock2(stone_types_2, "glacierrock", 2F, 11F, 2, ElementalCaves.tabBlocks);
		}
		else
		{
			glacierRock = new BlockGlacierrock().setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECUtil.getTexture("glacierrock"));
			glacierRock.setHarvestLevel("pickaxe", 2);
			
			String[] glacierRockSlabSideIcons = new String[] { ECUtil.getTexture("glacierrock_slab_side"), ECUtil.getTexture("glacierrock_cracked"), ECUtil.getTexture("glacierrock_bricks") };
			String[] glacierRockSlabTopIcons = new String[] { ECUtil.getTexture("glacierrock_slab_top"), ECUtil.getTexture("glacierrock_cracked"), ECUtil.getTexture("glacierrock_bricks") };
			glacierRockSlabSingle = new ECBlockSlab(false, glacierRockSlabSideIcons, glacierRockSlabTopIcons).setCreativeTab(ElementalCaves.tabBlocks).setHardness(2F).setResistance(10F);
			glacierRockSlabSingle.setHarvestLevel("pickaxe", 2);
			glacierRockSlabSingle.slipperiness = 0.98F;
			
			glacierRockSlabDouble = new ECBlockSlab(true, glacierRockSlabSideIcons, glacierRockSlabTopIcons).setHardness(2F).setResistance(10F);
			glacierRockSlabDouble.setHarvestLevel("pickaxe", 2);
			glacierRockSlabDouble.slipperiness = 0.98F;
			
			addBlock(glacierRock, ECItemBlockMulti.class, "glacierrock");
			addBlock(glacierRockSlabSingle, ECItemSlab.class, "glacierrock_slab_single", glacierRockSlabSingle, glacierRockSlabDouble);
			addBlock(glacierRockSlabDouble, ECItemSlab.class, "glacierrock_slab_double", glacierRockSlabSingle, glacierRockSlabDouble);
		}
		glacierRockStairs = new ECBlockStairs(glacierRock, 1).setHardness(2F).setResistance(10F);
		glacierRockStairs.setHarvestLevel("pickaxe", 2);
		glacierRockStairs.slipperiness = 0.98F;
		
		glacierRockBrickStairs = new ECBlockStairs(glacierRock, 2).setHardness(2F).setResistance(10F);
		glacierRockBrickStairs.setHarvestLevel("pickaxe", 2);
		glacierRockBrickStairs.slipperiness = 0.98F;
		
		addBlock(glacierRockStairs, "glacierrock_stairs");
		addBlock(glacierRockBrickStairs, "glacierrock_brick_stairs");
		
		// Moltenstone
		if (ElementalCaves.minestrappolation)
		{
			String[] moltenstone_types = new String[] { "raw", "cooled", "bricks", "pattern_bricks", "tiles", "road", "refined", "chiseled", null, null, null, null, null, null, null, "lamp_lava" };
			
			moltenstone = MBlockHelper.createStoneBlock(moltenstone_types, "moltenstone", 2.1F, 8.0F, 2, ElementalCaves.tabBlocks);
			moltenstoneSlabSingle = MBlockHelper.createStoneBlock("moltenstone", 2.1F, 8F, 2, ElementalCaves.tabBlocks);
			
			moltenstone.setHarvestLevel("pickaxe", 3, 1);
		}
		else
		{
			moltenstone = new BlockMoltenstone().setHardness(2.1F).setResistance(8.0F).setBlockTextureName(ECUtil.getTexture("moltenstone"));
			moltenstone.setHarvestLevel("pickaxe", 2, 0);
			moltenstone.setHarvestLevel("pickaxe", 3, 1);
			moltenstone.setHarvestLevel("pickaxe", 2, 2);
			
			String[] moltenstoneSlabSideIcons = new String[] { ECUtil.getTexture("moltenstone_slab_side"), ECUtil.getTexture("moltenstone_bricks") };
			String[] moltenstoneSlabTopIcons = new String[] { ECUtil.getTexture("moltenstone_slab_top"), ECUtil.getTexture("moltenstone_bricks") };
			moltenstoneSlabSingle = new BlockMoltenSlab(false, moltenstoneSlabSideIcons, moltenstoneSlabTopIcons).setCreativeTab(ElementalCaves.tabBlocks).setHardness(2.1F).setResistance(8.0F);
			moltenstoneSlabSingle.setHarvestLevel("pickaxe", 2);
			
			moltenstoneSlabDouble = new BlockMoltenSlab(true, moltenstoneSlabSideIcons, moltenstoneSlabTopIcons).setHardness(2.1F).setResistance(8.0F);
			moltenstoneSlabDouble.setHarvestLevel("pickaxe", 2);
			
			addBlock(moltenstone, ECItemBlockMulti.class, "moltenstone");
			addBlock(moltenstoneSlabSingle, ECItemSlab.class, "moltenstone_slab_single", moltenstoneSlabSingle, moltenstoneSlabDouble);
			addBlock(moltenstoneSlabDouble, ECItemSlab.class, "moltenstone_slab_double", moltenstoneSlabSingle, moltenstoneSlabDouble);
		}
		moltenstoneStairs = new ECBlockStairs(moltenstone, 0).setHardness(2.1F).setResistance(8.0F);
		moltenstoneStairs.setHarvestLevel("pickaxe", 2);
		
		moltenstoneBrickStairs = new ECBlockStairs(moltenstone, 2).setHardness(2.1F).setResistance(8.0F);
		moltenstoneBrickStairs.setHarvestLevel("pickaxe", 2);
		
		addBlock(moltenstoneStairs, "moltenstone_stairs");
		addBlock(moltenstoneBrickStairs, "moltenstone_brick_stairs");
		
		// Ancient Moss Stone
		if (ElementalCaves.minestrappolation)
		{
			ancientMossStone = MBlockHelper.createStoneBlock(stone_types, "ancient_moss_stone", 2F, 11F, 2, ElementalCaves.tabBlocks);
			ancientMossySlabSingle = MBlockHelper.createStoneBlock2(stone_types_2, "ancient_moss_stone", 2F, 11F, 2, ElementalCaves.tabBlocks);
		}
		else
		{
			ancientMossStone = new BlockAncientMossStone().setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECUtil.getTexture("ancient_moss_stone"));
			ancientMossStone.setHarvestLevel("pickaxe", 2);
			
			String[] ancientMossySlabSideIcons = new String[] { ECUtil.getTexture("ancient_moss_stone_slab_side"), ECUtil.getTexture("ancient_moss_stone_cracked"), ECUtil.getTexture("ancient_moss_stone_bricks") };
			String[] ancientMossySlabTopIcons = new String[] { ECUtil.getTexture("ancient_moss_stone_slab_top"), ECUtil.getTexture("ancient_moss_stone_cracked"), ECUtil.getTexture("ancient_moss_stone_bricks") };
			ancientMossySlabSingle = new ECBlockSlab(false, ancientMossySlabSideIcons, ancientMossySlabTopIcons).setCreativeTab(ElementalCaves.tabBlocks).setHardness(2F).setResistance(10F);
			ancientMossySlabSingle.setHarvestLevel("pickaxe", 2);
			
			ancientMossySlabDouble = new ECBlockSlab(true, ancientMossySlabSideIcons, ancientMossySlabTopIcons).setHardness(2F).setResistance(10F);
			ancientMossySlabDouble.setHarvestLevel("pickaxe", 2);
			
			addBlock(ancientMossStone, ECItemBlockMulti.class, "ancient_moss_stone");
			addBlock(ancientMossySlabSingle, ECItemSlab.class, "ancient_moss_stone_slab_single", ancientMossySlabSingle, ancientMossySlabDouble);
			addBlock(ancientMossySlabDouble, ECItemSlab.class, "ancient_moss_stone_slab_double", ancientMossySlabSingle, ancientMossySlabDouble);
		}
		
		ancientMossyCobbleStairs = new ECBlockStairs(ancientMossStone, 1).setHardness(2.0F).setResistance(11.0F);
		ancientMossyCobbleStairs.setHarvestLevel("pickaxe", 2);
		
		ancientMossyBrickStairs = new ECBlockStairs(ancientMossStone, 2).setHardness(2.0F).setResistance(11.0F);
		ancientMossyBrickStairs.setHarvestLevel("pickaxe", 2);
		
		addBlock(ancientMossyBrickStairs, "ancient_mossy_stonebrick_stairs");
		addBlock(ancientMossyCobbleStairs, "ancient_mossy_cobble_stairs");
	}
	
	public static void addBlock(Block block, String name)
	{
		block.setBlockName(name);
		GameRegistry.registerBlock(block, name);
	}
	
	public static void addBlock(Block block, Class<? extends ItemBlock> item, String name)
	{
		block.setBlockName(name);
		GameRegistry.registerBlock(block, item, name);
	}
	
	public static void addBlock(Block block, Class<? extends ItemBlock> item, String name, Object... args)
	{
		block.setBlockName(name);
		GameRegistry.registerBlock(block, item, name, args);
	}
}
