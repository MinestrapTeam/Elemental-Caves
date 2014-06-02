package sobiohazardous.mods.ec.api;

import java.util.ArrayList;
import java.util.List;

import sobiohazardous.mods.ec.api.cavetype.CaveType;
import sobiohazardous.mods.ec.api.world.gen.CWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = CavesAPI.MODID, name = CavesAPI.NAME, version = CavesAPI.VERSION)
public class CavesAPI
{
	public static final String		MODID		= "CavesAPI";
	public static final String		NAME		= "Caves API";
	public static final String		VERSION		= "1.0";
	
	public static List<CaveType>	caveTypes	= new ArrayList();
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new CWorldGenerator(), 0);
	}
	
	public static void registerCaveType(CaveType caveType)
	{
		caveTypes.add(caveType);
	}
}
