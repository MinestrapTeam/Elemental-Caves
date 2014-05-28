package sobiohazardous.mods.ec.lib;

import net.minecraftforge.common.config.Configuration;

public class ECConfig
{
	public static boolean	inferniumArmorEffect	= false;
	
	public static void init(Configuration config)
	{
		config.load();
		
		config.get("Misc", "Infernium Armor Fire Effect", inferniumArmorEffect);
		
		config.save();
	}
}
