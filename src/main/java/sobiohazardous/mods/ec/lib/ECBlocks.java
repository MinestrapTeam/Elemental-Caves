package sobiohazardous.mods.ec.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.ec.block.ECBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ECBlocks
{
	public static Block	oreGlistening;
	
	public static Block	glacierRock;
	public static Block	crackedGlacierrock;
	public static Block	oreLapis;
	
	public static void init()
	{
		glacierRock = new ECBlock(Material.rock).setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECReference.getTexture("glacierrock"));
		crackedGlacierrock = new ECBlock(Material.rock).setHardness(1.5F).setResistance(10.0F).setBlockTextureName(ECReference.getTexture("crackedGlacierrock"));
		
		oreLapis = new ECBlock(Material.rock).setHardness(3F).setResistance(5.0F).setBlockTextureName(ECReference.getTexture("oreLapis"));
		oreGlistening = new ECBlock(Material.rock).setHardness(3.0F).setResistance(15.0F).setBlockTextureName(ECReference.getTexture("oreGlistening"));
		
		addBlock(glacierRock, "glacierRock");
		addBlock(crackedGlacierrock, "crackedGlacierrock");
		addBlock(oreLapis, "oreLapisGlacier");
		addBlock(oreGlistening, "oreGlistening");
	}
	
	public static void addBlock(Block block, String name)
	{
		block.setBlockName(name);
		GameRegistry.registerBlock(block, name);
	}
}
