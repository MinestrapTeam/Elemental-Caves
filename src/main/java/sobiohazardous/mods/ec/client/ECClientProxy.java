package sobiohazardous.mods.ec.client;

import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;
import sobiohazardous.mods.ec.common.ECCommonProxy;
import sobiohazardous.mods.ec.entity.projectile.EntityFireShard;
import sobiohazardous.mods.ec.entity.projectile.EntityFrostGem;
import sobiohazardous.mods.ec.entity.projectile.EntityIceShard;
import sobiohazardous.mods.ec.entity.projectile.EntityMagmaGem;
import sobiohazardous.mods.ec.lib.ECItems;

public class ECClientProxy extends ECCommonProxy
{
	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityIceShard.class, new RenderSnowball(ECItems.iceShard));
		RenderingRegistry.registerEntityRenderingHandler(EntityFrostGem.class, new RenderSnowball(ECItems.iceGem));
		RenderingRegistry.registerEntityRenderingHandler(EntityFireShard.class, new RenderSnowball(ECItems.fireShard));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagmaGem.class, new RenderSnowball(ECItems.magmaGem));
	}
}
