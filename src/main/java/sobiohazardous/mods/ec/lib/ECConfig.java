package sobiohazardous.mods.ec.lib;

import net.minecraftforge.common.config.Configuration;

public class ECConfig
{
	public static boolean inferniumArmorEffect = true;
	
	public static void init(Configuration config)
	{
		config.load();
		
		config.get("Misc", "Infernium Armor Fire Effect", inferniumArmorEffect);
		
		config.save();
	}
}
