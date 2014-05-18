package sobiohazardous.mods.ec.common;

import java.util.HashMap;
import java.util.Map;

import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECConfig;
import sobiohazardous.mods.ec.lib.ECItems;
import sobiohazardous.mods.ec.util.ECUtil;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;

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
				if(helmet.getItem() == ECItems.helmetInfernium && chest.getItem() == ECItems.chestplateInfernium && pants.getItem() == ECItems.leggingsInfernium && boots.getItem() == ECItems.bootsInfernium)
				{
					if(ECConfig.inferniumArmorEffect)
					{
						player.worldObj.playAuxSFX(2004, (int) player.posX, (int) player.posY, (int) player.posZ, 0);
					}
					ECUtil.melt(player.worldObj, (int) player.posX, (int) player.posY - 2, (int) player.posZ);
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
		if (bucket != null)
		{
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			return new ItemStack(bucket);
		} else
			return null;

	}
	
	@SubscribeEvent
	public void onHoe(UseHoeEvent event)
	{
		int x = event.x;
		int y = event.y;
		int z = event.z;
		
		Block block = event.world.getBlock(x, y, z);

        if (event.world.getBlock(x, y + 1, z).isAir(event.world, x, y + 1, z) && (block == ECBlocks.richGrass || block == ECBlocks.richSoil))
        {
            Block block1 = ECBlocks.richFarmland;
            
            event.world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);
            event.world.setBlock(x, y, z, block1);
            event.current.damageItem(1, event.entityPlayer);
            
        }
	}
}
