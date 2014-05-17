package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.block.*;
import sobiohazardous.mods.ec.item.block.ECItemBlockMulti;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;

public class ECBlocks
{
	public static Block	ancientIce;
	public static Block	crystalIce;
	
	public static Block	glacierRock;
	
	public static Block	glacierRockStairs;
	public static Block	glacierRockBrickStairs;
	
	public static Block	oreLapis;
	public static Block	oreFreezium;
	
	public static Block	oreGlistening;
	
	public static Block	iceFloe;
	
	public static void init()
	{
		ancientIce = new BlockAncientIce(Material.rock).setStepSound(Block.soundTypeGlass).setHardness(2F).setResistance(40000F).setBlockTextureName(ECReference.getTexture("ancient_ice"));
		crystalIce = new BlockIceCrystal().setHardness(5F).setResistance(8F).setBlockTextureName(ECReference.getTexture("crystal_ice"));
		
		glacierRock = new BlockGlacierrock().setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECReference.getTexture("glacierrock"));
		
		glacierRockStairs = new EDBlockStairs(glacierRock, 1).setHardness(2F).setResistance(10F);
		glacierRockBrickStairs = new EDBlockStairs(glacierRock, 2).setHardness(2F).setResistance(10F);
		
		oreLapis = new ECBlockOre().setHardness(3F).setResistance(5.0F).setBlockTextureName(ECReference.getTexture("lapis_ore_glacier"));
		oreFreezium = new ECBlockOre().setHardness(3.5F).setResistance(6F).setBlockTextureName(ECReference.getTexture("freezium_ore"));
		oreGlistening = new ECBlockOre(0.6F).setHardness(3.0F).setResistance(15.0F).setLightLevel(0.6F).setBlockTextureName(ECReference.getTexture("glistening_ore"));
		
		iceFloe = new BlockIceFloe();
		
		addBlock(ancientIce, "ancient_ice");
		addBlock(crystalIce, "crystal_ice");
		
		addBlock(glacierRock, ECItemBlockMulti.class, "glacierrock");
		
		addBlock(glacierRockStairs, "glacierrock_stairs");
		addBlock(glacierRockBrickStairs, "glacierrock_brick_stairs");
		
		addBlock(oreLapis, "lapis_ore_glacier");
		addBlock(oreFreezium, "freezium_ore");
		addBlock(oreGlistening, "glistening_ore");
		
		addBlock(iceFloe, "ice_floe");
	}
	
	public static void addHarvestLevels()
	{
		ancientIce.setHarvestLevel("pickaxe", 2);
		crystalIce.setHarvestLevel("pickaxe", 3);
		glacierRock.setHarvestLevel("pickaxe", 2);
		glacierRockStairs.setHarvestLevel("pickaxe", 2);
		glacierRockBrickStairs.setHarvestLevel("pickaxe", 2);
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
}
