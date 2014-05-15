package sobiohazardous.mods.ec;

import sobiohazardous.mods.ec.common.ECCommonProxy;
import sobiohazardous.mods.ec.creativetab.ECCreativeTabBlocks;
import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECReference;
import sobiohazardous.mods.ec.world.gen.ECWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = ECReference.EC_MODID, name = ECReference.EC_NAME, version = ECReference.EC_VERSION)
public class ElementalCaves
{
	@Instance(ECReference.EC_MODID)
	public static ElementalCaves	instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.ec.client.ECClientProxy", serverSide = "sobiohazardous.mods.ec.common.ECCommonProxy")
	public static ECCommonProxy		proxy;
	
	public static CreativeTabs		creativeTabECBlocks	= new ECCreativeTabBlocks("ec_blocks");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		ECBlocks.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent evt)
	{
		GameRegistry.registerWorldGenerator(new ECWorldGenerator(), 0);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{
		
	}
}
