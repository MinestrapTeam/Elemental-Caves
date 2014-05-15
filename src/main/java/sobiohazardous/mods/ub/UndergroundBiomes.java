package sobiohazardous.mods.ub;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import sobiohazardous.mods.ub.common.UBCommonProxy;
import sobiohazardous.mods.ub.lib.UBReference;

@Mod(modid = UBReference.UB_ID, name = UBReference.UB_NAME, version = UBReference.UB_VERSION)
public class UndergroundBiomes
{
	@SidedProxy(clientSide="sobiohazardous.mods.ub.client.UBClientProxy", serverSide="sobiohazardous.mods.ub.common.UBCommonProxy")
	static UBCommonProxy proxy;
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent evt)
	{
		
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{
		
	}
}
