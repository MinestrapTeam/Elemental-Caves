package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.ElementalCaves;
import sobiohazardous.mods.ec.block.*;
import sobiohazardous.mods.ec.item.block.ECItemBlockMulti;
import sobiohazardous.mods.ec.item.block.ECItemSlab;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;

public class ECBlocks
{
	public static Block	crystals;
	
	public static Block	ancientIce;
	public static Block	glacierRock;
	public static Block	glacierRockStairs;
	public static Block	glacierRockBrickStairs;
	public static Block glacierRockSlabSingle;
	public static Block glacierRockSlabDouble;
	
	public static Block moltenstone;
	public static Block moltenstoneStairs;
	public static Block moltenstoneStairsBrick;
	public static Block moltenstoneSlabSingle;
	public static Block moltenstoneSlabDouble;
	
	public static Block	ancientMossStone;
	public static Block ancientMossyCobblestone;
	public static Block ancientMossyBricks;
	public static Block ancientMossySlabSingle;
	public static Block ancientMossySlabDouble;

	public static Block	richGrass;
	public static Block richSoil;
	public static Block richFarmland;
	
	public static Block	oreLapis;
	public static Block	oreFreezium;
	public static Block	oreGlistening;
	
	public static Block	iceFloe;
			
	public static void init()
	{		
		glacierRock = new BlockGlacierrock().setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECReference.getTexture("glacierrock"));
		glacierRockStairs = new ECBlockStairs(glacierRock, 1).setHardness(2F).setResistance(10F);
		glacierRockBrickStairs = new ECBlockStairs(glacierRock, 2).setHardness(2F).setResistance(10F);
		glacierRockSlabSingle = new ECBlockSlab(false, new String[]{ECReference.getTexture("glacierrock_slab_side"), ECReference.getTexture("glacierrock_cracked")}, new String[]{ECReference.getTexture("glacierrock_slab_top"), ECReference.getTexture("glacierrock_cracked")}).setCreativeTab(ElementalCaves.creativeTabECBlocks).setHardness(2F).setResistance(10F);
		glacierRockSlabDouble = new ECBlockSlab(true, new String[]{ECReference.getTexture("glacierrock_slab_side"), ECReference.getTexture("glacierrock_cracked")}, new String[]{ECReference.getTexture("glacierrock_slab_top"), ECReference.getTexture("glacierrock_cracked")}).setHardness(2F).setResistance(10F);
		
		ancientIce = new BlockAncientIce(Material.rock).setStepSound(Block.soundTypeGlass).setHardness(2F).setResistance(40000F).setBlockTextureName(ECReference.getTexture("ancient_ice"));

		moltenstone = new BlockMoltenstone().setHardness(2.1F).setResistance(8.0F).setBlockTextureName(ECReference.getTexture("moltenstone"));
		moltenstoneStairs = new ECBlockStairs(moltenstone, 0).setHardness(2.1F).setResistance(8.0F);
		moltenstoneStairsBrick = new ECBlockStairs(moltenstone, 2).setHardness(2.1F).setResistance(8.0F);
		moltenstoneSlabSingle = new ECBlockSlab(false, new String[]{ECReference.getTexture("moltenstone_slab_side")}, new String[]{ECReference.getTexture("moltenstone_slab_top")}).setCreativeTab(ElementalCaves.creativeTabECBlocks).setHardness(2.1F).setResistance(8.0F);
		moltenstoneSlabDouble = new ECBlockSlab(true, new String[]{ECReference.getTexture("moltenstone_slab_side")}, new String[]{ECReference.getTexture("moltenstone_slab_top")}).setHardness(2.1F).setResistance(8.0F);

		ancientMossStone = new BlockAncientMossStone(Material.rock).setHardness(2.0F).setResistance(11.0F);
		ancientMossyCobblestone = new ECBlock(Material.rock).setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECReference.getTexture("ancientMossyCobblestone"));
		ancientMossyBricks = new ECBlock(Material.rock).setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECReference.getTexture("ancientMossStoneBricks"));
		ancientMossySlabSingle = new ECBlockSlab(false, new String[]{ECReference.getTexture("ancientMossStoneSlabSide"), ECReference.getTexture("ancientMossyCobblestone"), ECReference.getTexture("ancientMossStoneBricks")}, new String[]{ECReference.getTexture("ancientMossStoneSlabTop"), ECReference.getTexture("ancientMossyCobblestone"), ECReference.getTexture("ancientMossStoneBricks")}).setCreativeTab(ElementalCaves.creativeTabECBlocks).setHardness(2F).setResistance(10F);
		ancientMossySlabDouble = new ECBlockSlab(true, new String[]{ECReference.getTexture("ancientMossStoneSlabSide"), ECReference.getTexture("ancientMossyCobblestone"),ECReference.getTexture("ancientMossStoneBricks")}, new String[]{ECReference.getTexture("ancientMossStoneSlabTop"), ECReference.getTexture("ancientMossyCobblestone"), ECReference.getTexture("ancientMossStoneBricks")}).setHardness(2F).setResistance(10F);

		richGrass = new BlockRichGrass(Material.grass).setHardness(0.6F).setStepSound(Block.soundTypeGrass);
		richSoil = new ECBlock(Material.ground).setHardness(0.5F).setBlockTextureName(ECReference.getTexture("richSoil")).setStepSound(Block.soundTypeGravel);
		richFarmland = new BlockRichFarmland().setHardness(0.6F).setStepSound(Block.soundTypeGravel);
		
		oreLapis = new ECBlockOre().setHardness(3F).setResistance(5.0F).setBlockTextureName(ECReference.getTexture("lapis_ore_glacier"));
		oreFreezium = new ECBlockOre().setHardness(3.5F).setResistance(6F).setBlockTextureName(ECReference.getTexture("freezium_ore"));
		oreGlistening = new ECBlockOre(0.6F).setHardness(3.0F).setResistance(15.0F).setLightLevel(0.6F).setBlockTextureName(ECReference.getTexture("glistening_ore"));
		
		crystals = new BlockCrystals().setHardness(5F).setResistance(8F).setBlockTextureName(ECReference.getTexture("crystal"));

		iceFloe = new BlockIceFloe();
						
		//TODO Cave specific vanilla ores
		
		addBlock(glacierRock, ECItemBlockMulti.class, "glacierrock");
		addBlock(glacierRockStairs, "glacierrock_stairs");
		addBlock(glacierRockBrickStairs, "glacierrock_brick_stairs");
		addBlock(glacierRockSlabSingle, ECItemSlab.class, "glacierrock_slab_single", glacierRockSlabSingle, glacierRockSlabDouble);
		addBlock(glacierRockSlabDouble, ECItemSlab.class, "glacierrock_slab_double", glacierRockSlabSingle, glacierRockSlabDouble);

		addBlock(ancientIce, "ancient_ice");

		addBlock(moltenstone, ECItemBlockMulti.class, "molten_stone");
		addBlock(moltenstoneStairs, "molten_stone_stairs");
		addBlock(moltenstoneStairsBrick, "molten_brick_stairs");
		addBlock(moltenstoneSlabSingle, ECItemSlab.class, "molten_slab_single", moltenstoneSlabSingle, moltenstoneSlabDouble);
		addBlock(moltenstoneSlabDouble, ECItemSlab.class, "molten_slab_double", moltenstoneSlabSingle, moltenstoneSlabDouble);

		addBlock(ancientMossStone, "ancient_moss_stone");
		addBlock(ancientMossyCobblestone, "ancient_mossy_cobblestone");
		addBlock(ancientMossyBricks, "ancient_mossy_bricks");
		addBlock(ancientMossySlabSingle, ECItemSlab.class, "ancientmossy_slab_single", ancientMossySlabSingle, ancientMossySlabDouble);
		addBlock(ancientMossySlabDouble, ECItemSlab.class, "ancientmossy_slab_double", ancientMossySlabSingle, ancientMossySlabDouble);

		addBlock(richGrass, "rich_grass");
		addBlock(richSoil, "rich_soil");
		addBlock(richFarmland, "rich_farmland");
		
		addBlock(oreLapis, "lapis_ore_glacier");
		addBlock(oreFreezium, "freezium_ore");
		addBlock(oreGlistening, "glistening_ore");
		
		addBlock(crystals, ECItemBlockMulti.class, "crystal");

		addBlock(iceFloe, "ice_floe");		
	}
	
	public static void addHarvestLevels()
	{
		ancientIce.setHarvestLevel("pickaxe", 2);
		crystals.setHarvestLevel("pickaxe", 3);
		
		glacierRock.setHarvestLevel("pickaxe", 2);
		glacierRockStairs.setHarvestLevel("pickaxe", 2);
		glacierRockBrickStairs.setHarvestLevel("pickaxe", 2);
		glacierRockSlabSingle.setHarvestLevel("pickaxe", 2);
		glacierRockSlabDouble.setHarvestLevel("pickaxe", 2);
		
		moltenstone.setHarvestLevel("pickaxe", 2, 0);
		moltenstone.setHarvestLevel("pickaxe", 3, 1);
		moltenstone.setHarvestLevel("pickaxe", 2, 2);
		moltenstoneStairs.setHarvestLevel("pickaxe", 2);
		moltenstoneStairsBrick.setHarvestLevel("pickaxe", 2);
		moltenstoneSlabSingle.setHarvestLevel("pickaxe", 2);
		moltenstoneSlabDouble.setHarvestLevel("pickaxe", 2);

		ancientMossStone.setHarvestLevel("pickaxe", 2);
		
		oreLapis.setHarvestLevel("pickaxe", 2);
		oreFreezium.setHarvestLevel("pickaxe", 3);
		oreGlistening.setHarvestLevel("pickaxe", 3);
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
	
	public static void addBlock(Block block, Class<? extends ItemBlock> item, String name, Object... construcArgs)
	{
		block.setBlockName(name);
		GameRegistry.registerBlock(block, item, name, construcArgs);
	}
}
