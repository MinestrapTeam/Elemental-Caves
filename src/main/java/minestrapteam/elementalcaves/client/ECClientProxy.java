package minestrapteam.elementalcaves.client;

import minestrapteam.elementalcaves.common.ECCommonProxy;
import minestrapteam.elementalcaves.entity.projectile.*;
import minestrapteam.elementalcaves.lib.ECItems;

import net.minecraft.client.renderer.entity.RenderSnowball;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ECClientProxy extends ECCommonProxy
{
	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostGem.class, new RenderSnowball(ECItems.gems, 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaGem.class, new RenderSnowball(ECItems.gems, 2));
		RenderingRegistry.registerEntityRenderingHandler(EntityForestGem.class, new RenderSnowball(ECItems.gems, 3));
		RenderingRegistry.registerEntityRenderingHandler(EntityIceShard.class, new RenderSnowball(ECItems.shards, 1));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireShard.class, new RenderSnowball(ECItems.shards, 2));
		
		freezium = this.addArmor("ice");
		infernium = this.addArmor("fire");
		earth = this.addArmor("forest");
	}
	
	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
