package sobiohazardous.mods.ec.client;

import net.minecraft.client.renderer.entity.RenderSnowball;
import cpw.mods.fml.client.registry.RenderingRegistry;
import sobiohazardous.mods.ec.common.ECCommonProxy;
import sobiohazardous.mods.ec.entity.projectile.EntityIceShard;
import sobiohazardous.mods.ec.lib.ECItems;

public class ECClientProxy extends ECCommonProxy
{
	@Override
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityIceShard.class, new RenderSnowball(ECItems.iceShard));
	}
}
