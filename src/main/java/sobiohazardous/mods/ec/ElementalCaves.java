package sobiohazardous.mods.ec;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.ec.common.ECCommonProxy;
import sobiohazardous.mods.ec.creativetab.ECCreativeTabBlocks;
import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECReference;
import sobiohazardous.mods.ec.world.gen.ECWorldGenerator;

@Mod(modid = ECReference.EC_ID, name = ECReference.EC_NAME, version = ECReference.EC_VERSION)
public class ElementalCaves
{
	@SidedProxy(clientSide="sobiohazardous.mods.ec.client.ECClientProxy", serverSide="sobiohazardous.mods.ec.common.ECCommonProxy")
	static ECCommonProxy proxy;
	
	public static CreativeTabs creativeTabECBlocks = new ECCreativeTabBlocks(CreativeTabs.getNextID(), "ec.creativetab.blocks");
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		ECBlocks.init();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent evt)
	{
		GameRegistry.registerWorldGenerator(new ECWorldGenerator(), 0);
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{
		
	}
}
