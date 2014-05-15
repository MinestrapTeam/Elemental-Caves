package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.block.BlockSlippery;
import sobiohazardous.mods.ec.block.BlockTransparent;
import sobiohazardous.mods.ec.block.ECBlock;
import sobiohazardous.mods.ec.block.ECBlockOre;
import sobiohazardous.mods.ec.block.EDBlockStairs;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ECBlocks
{
	public static Block ancientIce;
	public static Block crystalIce;
	
	public static Block	glacierRock;
	public static Block	glacierRockCracked;
	public static Block	glacierRockBricks;
	
	public static Block	glacierRockStairs;
	public static Block	glacierRockBrickStairs;
	
	public static Block	oreLapis;
	public static Block	oreFreezium;
	
	public static Block	oreGlistening;
	
	public static void init()
	{
		ancientIce = new BlockSlippery(Material.rock).setStepSound(Block.soundTypeGlass).setHardness(2F).setResistance(4F).setBlockTextureName(ECReference.getTexture("ancient_ice"));
		crystalIce = new BlockTransparent().setStepSound(Block.soundTypeGlass).setHardness(2F).setResistance(4F).setBlockTextureName(ECReference.getTexture("crystal_ice"));
		
		glacierRock = new BlockSlippery(Material.rock).setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECReference.getTexture("glacierrock"));
		glacierRockCracked = new BlockSlippery(Material.rock).setHardness(1.5F).setResistance(10.0F).setBlockTextureName(ECReference.getTexture("glacierrock_cracked"));
		glacierRockBricks = new BlockSlippery(Material.rock).setHardness(1.5F).setResistance(10.0F).setBlockTextureName(ECReference.getTexture("glacierrock_bricks"));
		
		glacierRockStairs = new EDBlockStairs(glacierRockCracked).setHardness(2F).setResistance(10F);
		glacierRockBrickStairs = new EDBlockStairs(glacierRockBricks).setHardness(2F).setResistance(10F);
		
		oreLapis = new ECBlockOre().setHardness(3F).setResistance(5.0F).setBlockTextureName(ECReference.getTexture("lapis_ore_glacier"));
		oreFreezium = new ECBlockOre().setHardness(3.5F).setResistance(6F).setBlockTextureName(ECReference.getTexture("freezium_ore"));
		oreGlistening = new ECBlock(Material.rock).setHardness(3.0F).setResistance(15.0F).setBlockTextureName(ECReference.getTexture("glistening_ore"));
		
		addBlock(ancientIce, "ancient_ice");
		addBlock(crystalIce, "crystal_ice");
		
		addBlock(glacierRock, "glacierrock");
		addBlock(glacierRockCracked, "glacierrock_cracked");
		addBlock(glacierRockBricks, "glacierrock_bricks");
		
		addBlock(glacierRockStairs, "glacierrock_stairs");
		addBlock(glacierRockBrickStairs, "glacierrock_brick_stairs");
		
		addBlock(oreLapis, "lapis_ore_glacier");
		addBlock(oreFreezium, "freezium_ore");
		addBlock(oreGlistening, "glistening_ore");
	}
	
	public static void addBlock(Block block, String name)
	{
		block.setBlockName(name);
		GameRegistry.registerBlock(block, name);
	}
}
