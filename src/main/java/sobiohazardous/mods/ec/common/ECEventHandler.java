package sobiohazardous.mods.ec.common;

import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ECEventHandler
{
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		if (event.phase == Phase.START)
		{
			EntityPlayer player = event.player;
			
			ItemStack helmet = player.getCurrentArmor(3);
			ItemStack chest = player.getCurrentArmor(2);
			ItemStack pants = player.getCurrentArmor(1);
			ItemStack boots = player.getCurrentArmor(0);
			
			if (helmet != null && chest != null && pants != null && boots != null)
			{
				if (helmet.getItem() == ECItems.helmetFreezium && chest.getItem() == ECItems.chestplateFreezium && pants.getItem() == ECItems.leggingsFreezium && boots.getItem() == ECItems.bootsFreezium)
				{
					ECUtil.freeze(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
				}
			}
		}
	}
}
