package sobiohazardous.mods.ec.lib;

import sobiohazardous.mods.ec.item.ECItem;
import sobiohazardous.mods.ec.item.ECItemAxe;
import sobiohazardous.mods.ec.item.ECItemHoe;
import sobiohazardous.mods.ec.item.ECItemShovel;
import sobiohazardous.mods.ec.item.ECItemSword;
import sobiohazardous.mods.ec.item.ItemFrostGem;
import sobiohazardous.mods.ec.item.ItemIceShard;
import sobiohazardous.mods.ec.item.ECItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class ECItems
{
	public static ToolMaterial materialFreezium = EnumHelper.addToolMaterial("freezium", 3, 1561, 7.0F, 3.0F, 13);
	
	public static Item gemClear;
	public static Item gemFrost;
	public static Item iceShard;
	
	public static Item pickaxeFreezium;
	public static Item swordFreezium;
	public static Item axeFreezium;
	public static Item hoeFreezium;
	public static Item shovelFreezium;
	
	public static void init()
	{
		gemClear = new ECItem().setTextureName(ECReference.getTexture("clear_gem"));
		addItem(gemClear, "clear_gem");
		
		gemFrost = new ItemFrostGem().setTextureName(ECReference.getTexture("ice_gem"));
		addItem(gemFrost, "ice_gem");
		
		iceShard = new ItemIceShard().setTextureName(ECReference.getTexture("ice_shard"));
		addItem(iceShard, "ice_shard");
		
		pickaxeFreezium = new ECItemPickaxe(materialFreezium).setTextureName(ECReference.getTexture("ice_pickaxe"));
		addItem(pickaxeFreezium, "ice_pickaxe");
		
		swordFreezium = new ECItemSword(materialFreezium).setTextureName(ECReference.getTexture("ice_sword"));
		addItem(swordFreezium, "ice_sword");
		
		axeFreezium = new ECItemAxe(materialFreezium).setTextureName(ECReference.getTexture("ice_axe"));
		addItem(axeFreezium, "axe_freezium");
		
		hoeFreezium = new ECItemHoe(materialFreezium).setTextureName(ECReference.getTexture("ice_hoe"));
		addItem(hoeFreezium, "hoe_freezium");
		
		shovelFreezium = new ECItemShovel(materialFreezium).setTextureName(ECReference.getTexture("ice_shovel"));
		addItem(shovelFreezium, "shovel_freezium");
	}
	
	public static void addItem(Item item, String name)
	{
		item.setUnlocalizedName(name);
		GameRegistry.registerItem(item, name);
	}
}
