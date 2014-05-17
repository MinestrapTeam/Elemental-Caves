package sobiohazardous.mods.ec.common;

import java.util.HashMap;
import java.util.Map;

import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;

public class ECEventHandler
{
	public static ECEventHandler INSTANCE = new ECEventHandler();
	public Map<Block, Item> buckets = new HashMap<Block, Item>();
	
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
					ECUtil.freeze(player.worldObj, (int) player.posX, (int) player.posY - 2, (int) player.posZ);
				}
			}
		}
	}

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		ItemStack result = fillCustomBucket(event.world, event.target);

		if (result == null)
			return;

		event.result = result;
		event.setResult(Result.ALLOW);
	}

	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos)
	{
		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

		Item bucket = buckets.get(block);
		if (bucket != null && world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			return new ItemStack(bucket);
		} else
			return null;

	}
}
