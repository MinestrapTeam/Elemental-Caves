package sobiohazardous.mods.ec;

import sobiohazardous.mods.ec.common.ECCommonProxy;
import sobiohazardous.mods.ec.creativetab.ECCreativeTabBlocks;
import sobiohazardous.mods.ec.creativetab.ECCreativeTabItems;
import sobiohazardous.mods.ec.entity.projectile.EntityFrostGem;
import sobiohazardous.mods.ec.entity.projectile.EntityIceShard;
import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.lib.ECReference;
import sobiohazardous.mods.ec.world.gen.ECWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = ECReference.EC_MODID, name = ECReference.EC_NAME, version = ECReference.EC_VERSION)
public class ElementalCaves
{
	@Instance(ECReference.EC_MODID)
	public static ElementalCaves	instance;
	
	@SidedProxy(clientSide = "sobiohazardous.mods.ec.client.ECClientProxy", serverSide = "sobiohazardous.mods.ec.common.ECCommonProxy")
	public static ECCommonProxy		proxy;
	
	public static CreativeTabs		creativeTabECBlocks	= new ECCreativeTabBlocks("ec_blocks");
	public static CreativeTabs		creativeTabECItems = new ECCreativeTabItems("ec_items");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent evt)
	{
		ECBlocks.init();
		ECItems.init();
		
		EntityRegistry.registerModEntity(EntityIceShard.class, "entity_ice_shard", EntityRegistry.findGlobalUniqueEntityId(), this.instance, 40, 400, true);
		EntityRegistry.registerModEntity(EntityFrostGem.class, "entity_frost_gem", EntityRegistry.findGlobalUniqueEntityId(), this.instance, 40, 400, true);

	}
	
	@EventHandler
	public void init(FMLInitializationEvent evt)
	{
		GameRegistry.registerWorldGenerator(new ECWorldGenerator(), 0);
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent evt)
	{
		
	}
}
