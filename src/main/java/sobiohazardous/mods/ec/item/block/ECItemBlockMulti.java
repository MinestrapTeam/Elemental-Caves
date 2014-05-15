package sobiohazardous.mods.ec.item.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ECItemBlockMulti extends ItemBlock
{
	public ECItemBlockMulti(Block block)
	{
		super(block);
	}
	
	@Override
	public IIcon getIconFromDamage(int metadata)
	{
		return this.field_150939_a.getIcon(1, metadata);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "." + stack.getItemDamage();
	}
	
	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}
}
