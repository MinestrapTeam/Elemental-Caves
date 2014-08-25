package minestrapteam.elementalcaves.addons;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public abstract class Addon
{
	public boolean addonLoaded = false;
	
	public static List<Addon>addons = new ArrayList<Addon>();
	
	public abstract void preInit(FMLPreInitializationEvent event);
	public abstract void init(FMLInitializationEvent event);
	public abstract void postInit(FMLPostInitializationEvent event);
	public abstract String getModForAddon();
	
	public static void registerAddon(Addon addon)
	{
		addons.add(addon);
	}
}
