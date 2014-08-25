package minestrapteam.elementalcaves.lib;

import minestrapteam.elementalcaves.addons.Addon;
import minestrapteam.elementalcaves.addons.minestrappolation.AddonMinestrappolation;

public class ECAddons
{
	public static Addon addonMinestrap = new AddonMinestrappolation();
	
	public static void loadAddons()
	{
		Addon.registerAddon(addonMinestrap);
	}
}
