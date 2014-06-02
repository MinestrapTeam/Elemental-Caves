package minestrapteam.elementalcaves.common;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import minestrapteam.elementalcaves.lib.ECBlocks;
import minestrapteam.elementalcaves.lib.ECConfig;
import minestrapteam.elementalcaves.lib.ECItems;
import minestrapteam.elementalcaves.util.ECUtil;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ECEventHandler
{
	public static ECEventHandler	INSTANCE	= new ECEventHandler();
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event)
	{
		EntityPlayer player = event.player;
		if (event.phase != Phase.START || player.worldObj.isRemote)
		{
			return;
		}
		
		ItemStack helmet = player.getCurrentArmor(3);
		ItemStack chest = player.getCurrentArmor(2);
		ItemStack pants = player.getCurrentArmor(1);
		ItemStack boots = player.getCurrentArmor(0);
		
		if (helmet != null && chest != null && pants != null && boots != null)
		{
			if (helmet.getItem() == ECItems.helmetFreezium && chest.getItem() == ECItems.chestplateFreezium && pants.getItem() == ECItems.leggingsFreezium && boots.getItem() == ECItems.bootsFreezium)
			{
				ECUtil.freeze(player.worldObj, (int) player.posX, (int) player.posY - 1, (int) player.posZ);
				
				if (player.isBurning())
				{
					helmet.damageItem(1, player);
					chest.damageItem(1, player);
					pants.damageItem(1, player);
					boots.damageItem(1, player);
				}
			}
			
			if (helmet.getItem() == ECItems.helmetInfernium && chest.getItem() == ECItems.chestplateInfernium && pants.getItem() == ECItems.leggingsInfernium && boots.getItem() == ECItems.bootsInfernium)
			{
				if (ECConfig.inferniumArmorEffect)
				{
					player.worldObj.playAuxSFX(2004, (int) player.posX - 1, (int) player.posY + 1, (int) player.posZ, 0);
				}
				ECUtil.melt(player.worldObj, (int) player.posX, (int) player.posY - 1, (int) player.posZ);
				
				if (player.isInWater())
				{
					helmet.damageItem(1, player);
					chest.damageItem(1, player);
					pants.damageItem(1, player);
					boots.damageItem(1, player);
				}
			}
			
			if (helmet.getItem() == ECItems.helmetEarth && chest.getItem() == ECItems.chestplateEarth && pants.getItem() == ECItems.leggingsEarth && boots.getItem() == ECItems.bootsEarth)
			{
				ECUtil.grow(player.worldObj, (int) player.posX, (int) player.posY - 1, (int) player.posZ);
			}
		}
	}
	
	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event)
	{
		Block block = event.world.getBlock(event.target.blockX, event.target.blockY, event.target.blockZ);
		if (block == ECBlocks.iceFloe)
		{
			event.result = new ItemStack(ECItems.bucketIceFloe);
			event.setResult(Result.ALLOW);
		}
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
			
			event.world.playSoundEffect(x + 0.5D, y + 0.5D, z + 0.5D, block1.stepSound.getStepResourcePath(), (block1.stepSound.getVolume() + 1.0F) / 2.0F, block1.stepSound.getPitch() * 0.8F);
			event.world.setBlock(x, y, z, block1);
			event.current.damageItem(1, event.entityPlayer);
		}
	}
}
