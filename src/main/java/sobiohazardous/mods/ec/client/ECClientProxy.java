package sobiohazardous.mods.ec.client;

import net.minecraft.client.renderer.entity.RenderSnowball;

import cpw.mods.fml.client.registry.RenderingRegistry;
import sobiohazardous.mods.ec.common.ECCommonProxy;
import sobiohazardous.mods.ec.entity.projectile.*;
import sobiohazardous.mods.ec.lib.ECItems;

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
	}
	
	@Override
	public int addArmor(String armor)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
