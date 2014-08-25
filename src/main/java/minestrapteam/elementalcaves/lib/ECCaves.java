package minestrapteam.elementalcaves.lib;

import minestrapteam.caveapi.CavesAPI;
import minestrapteam.caveapi.cavetype.CaveType;
import minestrapteam.elementalcaves.cavetype.CaveTypeDesert;
import minestrapteam.elementalcaves.cavetype.CaveTypeFire;
import minestrapteam.elementalcaves.cavetype.CaveTypeForest;
import minestrapteam.elementalcaves.cavetype.CaveTypeIce;

public class ECCaves
{
	public static CaveType ice;
	public static CaveType fire;
	public static CaveType forest;	
	public static CaveType desert;
	
	public static void addCaveTypes()
	{
		ice = new CaveTypeIce("ice");
		fire = new CaveTypeFire("fire");
		forest = new CaveTypeForest("forest");
		desert = new CaveTypeDesert("desert");
		
		CavesAPI.registerCaveType(ice);		
		CavesAPI.registerCaveType(fire);
		CavesAPI.registerCaveType(forest);
		CavesAPI.registerCaveType(desert);
	}
}
