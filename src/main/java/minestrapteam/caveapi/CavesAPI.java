package minestrapteam.caveapi;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import minestrapteam.caveapi.cavetype.CaveType;
import minestrapteam.caveapi.world.gen.CGenCaves;
import minestrapteam.caveapi.world.gen.CGenRavine;
import minestrapteam.caveapi.world.gen.CWorldGenerator;

import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraftforge.event.terraingen.ChunkProviderEvent.ReplaceBiomeBlocks;

@Mod(modid = CavesAPI.MODID, name = CavesAPI.NAME, version = CavesAPI.VERSION)
public class CavesAPI
{
	public static final String		MODID		= "CavesAPI";
	public static final String		NAME		= "Caves API";
	public static final String		VERSION		= "1.0";
	
	public static List<CaveType>	caveTypes	= new ArrayList();
	
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		GameRegistry.registerWorldGenerator(new CWorldGenerator(), 0);
	}
	
	public static void registerCaveType(CaveType caveType)
	{
		caveTypes.add(caveType);
	}
	
	@SubscribeEvent
	public void replaceBiomeBlocks(ReplaceBiomeBlocks event)
	{
		IChunkProvider provider = event.chunkProvider;
		if (provider instanceof ChunkProviderGenerate)
		{
			// Cave Gen Field ID: 15
			// Ravine Gen Field ID: 20
			
			setField(ChunkProviderGenerate.class, provider, 15, new CGenCaves());
			setField(ChunkProviderGenerate.class, provider, 20, new CGenRavine());
		}
	}
	
	private static void setField(Class clazz, Object instance, int fieldID, Object value)
	{
		try
		{
			Field f = clazz.getDeclaredFields()[fieldID];
			f.setAccessible(true);
			f.set(instance, value);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
