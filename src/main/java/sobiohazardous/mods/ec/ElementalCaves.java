package sobiohazardous.mods.ec;

import sobiohazardous.mods.ec.common.ECCommonProxy;
import sobiohazardous.mods.ec.common.ECEventHandler;
import sobiohazardous.mods.ec.creativetab.ECCreativeTabBlocks;
import sobiohazardous.mods.ec.creativetab.ECCreativeTabItems;
import sobiohazardous.mods.ec.entity.projectile.EntityFireShard;
import sobiohazardous.mods.ec.entity.projectile.EntityFrostGem;
import sobiohazardous.mods.ec.entity.projectile.EntityIceShard;
import sobiohazardous.mods.ec.entity.projectile.EntityMagmaGem;
import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECConfig;
import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.lib.ECRecipes;
import sobiohazardous.mods.ec.lib.ECReference;
import sobiohazardous.mods.ec.world.gen.ECWorldGenerator;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

@Mod(modid = ECReference.EC_MODID, name = ECReference.EC_NAME, version = ECReference.EC_VERSION)
public class ElementalCaves
{
	@Instance(ECReference.EC_MODID)
	public static ElementalCaves	instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.ec.client.ECClientProxy", serverSide = "sobiohazardous.mods.ec.common.ECCommonProxy")
	public static ECCommonProxy		proxy;
	
	public static ECEventHandler eventHandler = new ECEventHandler();
	
	public static CreativeTabs		creativeTabECBlocks	= new ECCreativeTabBlocks("ec_blocks");
	public static CreativeTabs		creativeTabECItems	= new ECCreativeTabItems("ec_items");
	
	public static Fluid				iceFloe				= new Fluid("ice_floe").setLuminosity(6).setViscosity(2000);
	
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
		eventHandler.INSTANCE.buckets.put(ECBlocks.iceFloe, ECItems.bucketIceFloe);
		GameRegistry.registerWorldGenerator(new ECWorldGenerator(), 0);
		
		EntityRegistry.registerModEntity(EntityIceShard.class, "entity_ice_shard", 2, this.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityFrostGem.class, "entity_frost_gem", 3, this.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityFireShard.class, "entity_fire_shard", 4, this.instance, 40, 3, true);
		EntityRegistry.registerModEntity(EntityMagmaGem.class, "entity_magma_gem", 5, this.instance, 40, 3, true);
		
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}
