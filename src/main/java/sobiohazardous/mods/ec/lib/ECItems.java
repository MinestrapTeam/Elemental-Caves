package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.item.ECItem;
import sobiohazardous.mods.ec.item.ItemIceShard;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECItems
{
	public static Item gemClear;
	public static Item gemFrost;
	public static Item iceShard;
	
	public static void init()
	{
		gemClear = new ECItem().setTextureName(ECReference.getTexture("clear_gem"));
		addItem(gemClear, "clear_gem");
		
		gemFrost = new ECItem().setTextureName(ECReference.getTexture("ice_gem"));
		addItem(gemFrost, "ice_gem");
		
		iceShard = new ItemIceShard().setTextureName(ECReference.getTexture("ice_shard"));
		addItem(iceShard, "ice_shard");
	}
	
	public static void addItem(Item item, String name)
	{
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);
	}
}
