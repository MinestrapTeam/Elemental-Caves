package sobiohazardous.mods.ec.lib;

import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.ec.block.ECBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ECBlocks
{
	public static Block glacierRock;
	public static Block oreLapis;

	public static void init()
	{
		glacierRock = new ECBlock(Material.rock).setBlockName("glacierRock").setHardness(2.0F).setResistance(3.0F).setBlockTextureName(ECReference.TEXTURE + "glacierrock");
		GameRegistry.registerBlock(glacierRock, "glacierRock");
		
		oreLapis = new ECBlock(Material.rock).setBlockName("oreLapis").setHardness(2.5F).setResistance(3.0F).setBlockTextureName(ECReference.TEXTURE + "oreLapis");
		GameRegistry.registerBlock(oreLapis, "oreLapis");
	}
}
