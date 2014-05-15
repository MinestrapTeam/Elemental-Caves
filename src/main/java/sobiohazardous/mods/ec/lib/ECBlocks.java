package sobiohazardous.mods.ec.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.ec.block.BlockSlippery;
import sobiohazardous.mods.ec.block.ECBlockOre;
import sobiohazardous.mods.ec.block.ECBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ECBlocks
{
	public static Block	glacierRock;
	public static Block	glacierRockCracked;
	public static Block glacierRockBricks;
	
	public static Block	oreLapis;
	public static Block oreFreezium;
	
	public static Block	oreGlistening;
	
	public static void init()
	{
		glacierRock = new BlockSlippery(Material.rock).setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECReference.getTexture("glacierrock"));
		glacierRockCracked = new BlockSlippery(Material.rock).setHardness(1.5F).setResistance(10.0F).setBlockTextureName(ECReference.getTexture("galcierrock_cracked"));
		glacierRockBricks = new BlockSlippery(Material.rock).setHardness(1.5F).setResistance(10.0F).setBlockTextureName(ECReference.getTexture("glacierrock_bricks"));
		
		oreLapis = new ECBlockOre().setHardness(3F).setResistance(5.0F).setBlockTextureName(ECReference.getTexture("lapis_ore_glacierrock"));
		oreFreezium = new ECBlockOre().setHardness(3.5F).setResistance(6F).setBlockTextureName(ECReference.getTexture("freezium_ore"));
		oreGlistening = new ECBlock(Material.rock).setHardness(3.0F).setResistance(15.0F).setBlockTextureName(ECReference.getTexture("glistening_ore"));
		
		addBlock(glacierRock, "glacierrock");
		addBlock(glacierRockCracked, "glacierrock_cracked");
		addBlock(glacierRockBricks, "glacierrock_bricks");
		addBlock(oreLapis, "lapis_ore_glacierrock");
		addBlock(oreGlistening, "glistening_ore");
	}
	
	public static void addBlock(Block block, String name)
	{
		block.setBlockName(name);
		GameRegistry.registerBlock(block, name);
	}
}
