package sobiohazardous.mods.ec.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import sobiohazardous.mods.ec.entity.projectile.EntityFireShard;
import sobiohazardous.mods.ec.entity.projectile.EntityIceShard;

public class ItemFireShard extends ECItem
{
	public ItemFireShard()
    {
        this.maxStackSize = 16;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }

        world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!world.isRemote)
        {
            world.spawnEntityInWorld(new EntityFireShard(world, player));
        }

        return stack;
    }
}
