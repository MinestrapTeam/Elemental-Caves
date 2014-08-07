package minestrapteam.caveapi.common;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import minestrapteam.caveapi.world.gen.CGenCaves;
import minestrapteam.caveapi.world.gen.CGenRavine;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;
import net.minecraftforge.event.terraingen.InitMapGenEvent;
import net.minecraftforge.event.terraingen.InitMapGenEvent.EventType;

/**
 * Hacky class to override the vanilla Minecraft cave gen system with our own
 * metadata-sensitive system.
 * 
 * @author Clashsoft
 */
public class CEventHandler
{
	public static CEventHandler	instance	= new CEventHandler();
	
	private CGenCaves			caveGen		= new CGenCaves();
	private CGenRavine			ravineGen	= new CGenRavine();
	
	public static void register()
	{
		MinecraftForge.TERRAIN_GEN_BUS.register(instance);
	}
	
	@SubscribeEvent
	public void replaceBiomes(ReplaceBiomeBlocks event)
	{
		this.caveGen.setMetadata(event.metaArray);
		this.ravineGen.setMetadata(event.metaArray);
	}
	
	@SubscribeEvent
	public void moddedMapGen(InitMapGenEvent event)
	{
		if (event.type == EventType.CAVE)
		{
			event.newGen = this.caveGen;
		}
		else if (event.type == EventType.RAVINE)
		{
			event.newGen = this.ravineGen;
		}
	}
}
