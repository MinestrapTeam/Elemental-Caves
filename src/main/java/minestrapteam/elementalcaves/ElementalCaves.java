package minestrapteam.elementalcaves;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.caveapi.CavesAPI;
import minestrapteam.caveapi.cavetype.CaveType;
import minestrapteam.elementalcaves.cavetype.CaveTypeFire;
import minestrapteam.elementalcaves.cavetype.CaveTypeForest;
import minestrapteam.elementalcaves.cavetype.CaveTypeIce;
import minestrapteam.elementalcaves.common.ECCommonProxy;
import minestrapteam.elementalcaves.common.ECEventHandler;
import minestrapteam.elementalcaves.creativetab.ECCreativeTabBlocks;
import minestrapteam.elementalcaves.creativetab.ECCreativeTabItems;
import minestrapteam.elementalcaves.entity.projectile.*;
import minestrapteam.elementalcaves.lib.*;
import minestrapteam.elementalcaves.world.gen.ECWorldGenerator;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid = ECReference.MODID, name = ECReference.NAME, version = ECReference.VERSION)
public class ElementalCaves
{
	@Instance(ECReference.MODID)
	public static ElementalCaves	instance;
	
	@SidedProxy(clientSide = "minestrapteam.elementalcaves.client.ECClientProxy", serverSide = "minestrapteam.elementalcaves.common.ECCommonProxy")
	public static ECCommonProxy		proxy;
	
	public static ECEventHandler	eventHandler	= new ECEventHandler();
	
	public static CreativeTabs		tabBlocks		= new ECCreativeTabBlocks("ec_blocks");
	public static CreativeTabs		tabItems		= new ECCreativeTabItems("ec_items");
	
	public static Fluid				iceFloe			= new Fluid("ice_floe").setLuminosity(6).setViscosity(2000);
	
	public static CaveType ice;
	public static CaveType fire;
	public static CaveType forest;	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		FluidRegistry.registerFluid(iceFloe);
		
		ECConfig.init(new Configuration(event.getSuggestedConfigurationFile()));
		ECBlocks.init();
		ECItems.init();
		ECRecipes.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		ECBlocks.addHarvestLevels();
		
		FMLCommonHandler.instance().bus().register(eventHandler);
		MinecraftForge.EVENT_BUS.register(eventHandler);
		
		addCaveTypes();
		GameRegistry.registerWorldGenerator(new ECWorldGenerator(), 0);
		
		EntityRegistry.registerModEntity(EntityIceShard.class, "entity_ice_shard", 2, ElementalCaves.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityFrostGem.class, "entity_frost_gem", 3, ElementalCaves.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityFireShard.class, "entity_fire_shard", 4, ElementalCaves.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityMagmaGem.class, "entity_magma_gem", 5, ElementalCaves.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityForestGem.class, "forest_gem", 6, ElementalCaves.instance, 40, 3, true);
		
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
	
	private static void addCaveTypes()
	{
		ice = new CaveTypeIce("ice");
		fire = new CaveTypeFire("fire");
		forest = new CaveTypeForest("forest");
		
		CavesAPI.registerCaveType(ice);		
		CavesAPI.registerCaveType(fire);
		CavesAPI.registerCaveType(forest);
	}
}
