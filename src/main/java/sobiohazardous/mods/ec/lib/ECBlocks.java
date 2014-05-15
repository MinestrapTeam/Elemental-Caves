package sobiohazardous.mods.ec.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.ec.block.ECBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ECBlocks
{
	public static Block oreGlistening;

	public static Block glacierRock;
	public static Block crackedGlacierrock;
	public static Block oreLapis;

	public static void init()
	{
		oreGlistening = new ECBlock(Material.rock).setBlockName("oreGlistening").setHardness(3.0F).setResistance(15.0F).setBlockTextureName(ECReference.TEXTURE + "oreGlistening");
		GameRegistry.registerBlock(oreGlistening, "oreGlistening");
		
		glacierRock = new ECBlock(Material.rock).setBlockName("glacierRock").setHardness(2.0F).setResistance(11.0F).setBlockTextureName(ECReference.TEXTURE + "glacierrock");
		GameRegistry.registerBlock(glacierRock, "glacierRock");
		
		crackedGlacierrock = new ECBlock(Material.rock).setBlockName("crackedGlacierrock").setHardness(1.5F).setResistance(10.0F).setBlockTextureName(ECReference.TEXTURE + "crackedGlacierrock");
		GameRegistry.registerBlock(crackedGlacierrock, "crackedGlacierrock");
		
		oreLapis = new ECBlock(Material.rock).setBlockName("oreLapisGlacier").setHardness(3F).setResistance(5.0F).setBlockTextureName(ECReference.TEXTURE + "oreLapis");
		GameRegistry.registerBlock(oreLapis, "oreLapisGlacier");
	}
}
