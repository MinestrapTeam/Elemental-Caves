package sobiohazardous.mods.ec.api;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import sobiohazardous.mods.ec.api.cavetype.CaveType;
import sobiohazardous.mods.ec.api.lib.CReference;
import sobiohazardous.mods.ec.api.world.gen.CWorldGenerator;

@Mod(modid=CReference.CAPI_MODID, name=CReference.CAPI_NAME, version=CReference.CAPI_VERSION)
public class CavesAPI
{
	@EventHandler
	public void load(FMLInitializationEvent evt)
	{
		GameRegistry.registerWorldGenerator(new CWorldGenerator(), 0);
	}
	
	public static void registerCaveType(CaveType caveType)
	{
		CaveType.caveTypes.add(caveType);
	}	
}
