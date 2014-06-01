package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.api.CavesAPI;
import sobiohazardous.mods.ec.api.cavetype.CaveType;
import sobiohazardous.mods.ec.cavetype.CaveTypeFire;
import sobiohazardous.mods.ec.cavetype.CaveTypeForest;
import sobiohazardous.mods.ec.cavetype.CaveTypeIce;

public class ECCaveTypes
{
	public static CaveType ice;
	public static CaveType fire;
	public static CaveType forest;				
	
	public static void init()
	{
		ice = new CaveTypeIce("ice");
		CavesAPI.registerCaveType(ice);
		
		fire = new CaveTypeFire("fire");
		CavesAPI.registerCaveType(fire);

		forest = new CaveTypeForest("forest");
		CavesAPI.registerCaveType(forest);

	}
}
