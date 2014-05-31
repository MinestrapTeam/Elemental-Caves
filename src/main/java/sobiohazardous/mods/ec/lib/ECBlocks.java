package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.block.*;
import sobiohazardous.mods.ec.item.block.ECItemBlockMulti;
import sobiohazardous.mods.ec.item.block.ECItemSlab;
import sobiohazardous.mods.ec.item.block.ItemBlockMoltenSlab;
import sobiohazardous.mods.ec.util.ECUtil;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class ECBlocks
{
	public static Block	crystals;
	
	public static Block	ancientIce;
	public static Block	glacierRock;
	public static Block	glacierRockStairs;
	public static Block	glacierRockBrickStairs;
	public static Block	glacierRockSlabSingle;
	public static Block	glacierRockSlabDouble;
	
	public static Block	moltenstone;
	public static Block	moltenstoneStairs;
	public static Block	moltenstoneBrickStairs;
	public static Block	moltenstoneSlabSingle;
	public static Block	moltenstoneSlabDouble;
	
	public static Block	ancientMossStone;
	public static Block	ancientMossySlabSingle;
	public static Block	ancientMossySlabDouble;
	public static Block	ancientMossyStonebrickStairs;
	public static Block	ancientMossyCobbleStairs;
	
	public static Block	richGrass;
	public static Block	richSoil;
	public static Block	richFarmland;
	
	public static Block	oreLapis;
	public static Block	oreFreezium;
	public static Block	oreGlistening;
	public static Block	oreDiamond;
	public static Block	oreFertile;
	
	public static Block	iceFloe;
	
	public static void init()
	{
		glacierRock = new BlockGlacierrock().setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECUtil.getTexture("glacierrock"));
		glacierRockStairs = new ECBlockStairs(glacierRock, 1).setHardness(2F).setResistance(10F);
		glacierRockBrickStairs = new ECBlockStairs(glacierRock, 2).setHardness(2F).setResistance(10F);
		
		String[] glacierRockSlabSideIcons = new String[] { ECUtil.getTexture("glacierrock_slab_side"), ECUtil.getTexture("glacierrock_cracked"), ECUtil.getTexture("glacierrock_bricks") };
		String[] glacierRockSlabTopIcons = new String[] { ECUtil.getTexture("glacierrock_slab_top"), ECUtil.getTexture("glacierrock_cracked"), ECUtil.getTexture("glacierrock_bricks") };
		glacierRockSlabSingle = new ECBlockSlab(false, glacierRockSlabSideIcons, glacierRockSlabTopIcons).setCreativeTab(ElementalCaves.tabBlocks).setHardness(2F).setResistance(10F);
		glacierRockSlabDouble = new ECBlockSlab(true, glacierRockSlabSideIcons, glacierRockSlabTopIcons).setHardness(2F).setResistance(10F);
		
		ancientIce = new BlockAncientIce(Material.rock).setStepSound(Block.soundTypeGlass).setHardness(2F).setResistance(40000F).setBlockTextureName(ECUtil.getTexture("ancient_ice"));
		
		moltenstone = new BlockMoltenstone().setHardness(2.1F).setResistance(8.0F).setBlockTextureName(ECUtil.getTexture("moltenstone"));
		moltenstoneStairs = new ECBlockStairs(moltenstone, 0).setHardness(2.1F).setResistance(8.0F);
		moltenstoneBrickStairs = new ECBlockStairs(moltenstone, 2).setHardness(2.1F).setResistance(8.0F);
		
		String[] moltenstoneSlabSideIcons = new String[] { ECUtil.getTexture("moltenstone_slab_side"), ECUtil.getTexture("moltenstone_bricks") };
		String[] moltenstoneSlabTopIcons = new String[] { ECUtil.getTexture("moltenstone_slab_top"), ECUtil.getTexture("moltenstone_bricks") };
		moltenstoneSlabSingle = new BlockMoltenSlab(false, moltenstoneSlabSideIcons, moltenstoneSlabTopIcons).setCreativeTab(ElementalCaves.tabBlocks).setHardness(2.1F).setResistance(8.0F);
		moltenstoneSlabDouble = new BlockMoltenSlab(true, moltenstoneSlabSideIcons, moltenstoneSlabTopIcons).setHardness(2.1F).setResistance(8.0F);
		
		ancientMossStone = new BlockAncientMossStone().setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECUtil.getTexture("ancient_moss_stone"));
		
		String[] ancientMossySlabSideIcons = new String[] { ECUtil.getTexture("ancient_moss_stone_slab_side"), ECUtil.getTexture("ancient_moss_stone_cracked"), ECUtil.getTexture("ancient_moss_stone_bricks") };
		String[] ancientMossySlabTopIcons = new String[] { ECUtil.getTexture("ancient_moss_stone_slab_top"), ECUtil.getTexture("ancient_moss_stone_cracked"), ECUtil.getTexture("ancient_moss_stone_bricks") };
		ancientMossySlabSingle = new ECBlockSlab(false, ancientMossySlabSideIcons, ancientMossySlabTopIcons).setCreativeTab(ElementalCaves.tabBlocks).setHardness(2F).setResistance(10F);
		ancientMossySlabDouble = new ECBlockSlab(true, ancientMossySlabSideIcons, ancientMossySlabTopIcons).setHardness(2F).setResistance(10F);
		ancientMossyStonebrickStairs = new ECBlockStairs(ancientMossStone, 2).setHardness(2.0F).setResistance(11.0F);
		ancientMossyCobbleStairs = new ECBlockStairs(ancientMossStone, 1).setHardness(2.0F).setResistance(11.0F);
		
		richGrass = new BlockRichGrass(Material.grass).setHardness(0.6F);
		richSoil = new BlockRichSoil(Material.ground).setHardness(0.5F).setBlockTextureName(ECUtil.getTexture("rich_soil")).setStepSound(Block.soundTypeGravel);
		richFarmland = new BlockRichFarmland().setHardness(0.6F).setStepSound(Block.soundTypeGravel).setBlockTextureName(ECUtil.getTexture("rich_farmland"));
		
		oreLapis = new ECBlockOre(0.98F).setHardness(3F).setResistance(5.0F).setBlockTextureName(ECUtil.getTexture("lapis_ore_glacier"));
		oreFreezium = new ECBlockOre(0.98F).setHardness(3.5F).setResistance(6F).setBlockTextureName(ECUtil.getTexture("freezium_ore"));
		oreGlistening = new ECBlockOre().setHardness(3.0F).setResistance(15.0F).setLightLevel(0.6F).setBlockTextureName(ECUtil.getTexture("glistening_ore"));
		oreDiamond = new ECBlockOre().setHardness(3.5F).setResistance(5.0F).setStepSound(Block.soundTypePiston).setBlockTextureName(ECUtil.getTexture("diamond_ore_molten"));
		oreFertile = new ECBlockOre().setHardness(3F).setResistance(5.0F).setBlockTextureName(ECUtil.getTexture("fertile_ore"));
		
		crystals = new BlockCrystals().setHardness(5F).setResistance(8F).setBlockTextureName(ECUtil.getTexture("crystal"));
		
		iceFloe = new BlockIceFloe();
		
		// TODO Cave specific vanilla ores
		
		addBlock(glacierRock, ECItemBlockMulti.class, "glacierrock");
		addBlock(glacierRockStairs, "glacierrock_stairs");
		addBlock(glacierRockBrickStairs, "glacierrock_brick_stairs");
		addBlock(glacierRockSlabSingle, ECItemSlab.class, "glacierrock_slab_single", glacierRockSlabSingle, glacierRockSlabDouble);
		addBlock(glacierRockSlabDouble, ECItemSlab.class, "glacierrock_slab_double", glacierRockSlabSingle, glacierRockSlabDouble);
		
		addBlock(ancientIce, "ancient_ice");
		
		addBlock(moltenstone, ECItemBlockMulti.class, "moltenstone");
		addBlock(moltenstoneStairs, "moltenstone_stairs");
		addBlock(moltenstoneBrickStairs, "moltenstone_brick_stairs");
		addBlock(moltenstoneSlabSingle, ItemBlockMoltenSlab.class, "moltenstone_slab_single", moltenstoneSlabSingle, moltenstoneSlabDouble);
		addBlock(moltenstoneSlabDouble, ItemBlockMoltenSlab.class, "moltenstone_slab_double", moltenstoneSlabSingle, moltenstoneSlabDouble);
		
		addBlock(ancientMossStone, ECItemBlockMulti.class, "ancient_moss_stone");
		addBlock(ancientMossySlabSingle, ECItemSlab.class, "ancient_moss_stone_slab_single", ancientMossySlabSingle, ancientMossySlabDouble);
		addBlock(ancientMossySlabDouble, ECItemSlab.class, "ancient_moss_stone_slab_double", ancientMossySlabSingle, ancientMossySlabDouble);
		addBlock(ancientMossyStonebrickStairs, "ancient_mossy_stonebrick_stairs");
		addBlock(ancientMossyCobbleStairs, "ancient_mossy_cobble_stairs");
		
		addBlock(richGrass, "rich_grass");
		addBlock(richSoil, "rich_soil");
		addBlock(richFarmland, "rich_farmland");
		
		addBlock(oreLapis, "lapis_ore_glacier");
		addBlock(oreFreezium, "freezium_ore");
		addBlock(oreGlistening, "glistening_ore");
		addBlock(oreDiamond, "diamond_ore_infernium");
		addBlock(oreFertile, "fertile_ore");
		
		addBlock(crystals, ECItemBlockMulti.class, "crystal");
		
		addBlock(iceFloe, "ice_floe");
	}
	
	public static void addHarvestLevels()
	{
		ancientIce.setHarvestLevel("pickaxe", 2);
		crystals.setHarvestLevel("pickaxe", 3);
		
		glacierRock.setHarvestLevel("pickaxe", 2);
		glacierRockStairs.setHarvestLevel("pickaxe", 2);
		glacierRockStairs.slipperiness = 0.98F;
		glacierRockBrickStairs.setHarvestLevel("pickaxe", 2);
		glacierRockBrickStairs.slipperiness = 0.98F;
		glacierRockSlabSingle.setHarvestLevel("pickaxe", 2);
		glacierRockSlabSingle.slipperiness = 0.98F;
		glacierRockSlabDouble.setHarvestLevel("pickaxe", 2);
		glacierRockSlabDouble.slipperiness = 0.98F;
		
		moltenstone.setHarvestLevel("pickaxe", 2, 0);
		moltenstone.setHarvestLevel("pickaxe", 3, 1);
		moltenstone.setHarvestLevel("pickaxe", 2, 2);
		moltenstoneStairs.setHarvestLevel("pickaxe", 2);
		moltenstoneBrickStairs.setHarvestLevel("pickaxe", 2);
		moltenstoneSlabSingle.setHarvestLevel("pickaxe", 2);
		moltenstoneSlabDouble.setHarvestLevel("pickaxe", 2);
		
		ancientMossStone.setHarvestLevel("pickaxe", 2);
		ancientMossySlabSingle.setHarvestLevel("pickaxe", 2);
		ancientMossySlabDouble.setHarvestLevel("pickaxe", 2);
		
		richGrass.setHarvestLevel("shovel", 0);
		richSoil.setHarvestLevel("shovel", 0);
		richFarmland.setHarvestLevel("shovel", 0);
		
		oreLapis.setHarvestLevel("pickaxe", 2);
		oreFreezium.setHarvestLevel("pickaxe", 3);
		oreGlistening.setHarvestLevel("pickaxe", 3);
		oreDiamond.setHarvestLevel("pickaxe", 2);
		oreFertile.setHarvestLevel("pickaxe", 2);
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
