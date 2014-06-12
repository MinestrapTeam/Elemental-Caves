package minestrapteam.elementalcaves.lib;

import net.minecraftforge.common.config.Configuration;

public class ECConfig
{
	public static boolean	inferniumArmorEffect	= false;
	public static int		ticksToUpdateCrystals = 100;
	
	public static void init(Configuration config)
	{
		config.load();
		
		config.get("Misc", "Infernium Armor Fire Effect", inferniumArmorEffect);
		config.get("Misc", "Ticks to update crystals", ticksToUpdateCrystals);
		
		config.save();
	}
}
