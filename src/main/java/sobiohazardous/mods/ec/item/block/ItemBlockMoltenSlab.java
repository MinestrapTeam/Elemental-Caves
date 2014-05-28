package sobiohazardous.mods.ec.item.block;

import sobiohazardous.mods.ec.block.BlockMoltenSlab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ItemBlockMoltenSlab extends ItemSlab
{
	public ItemBlockMoltenSlab(Block block, BlockMoltenSlab slab, BlockMoltenSlab doubleslab)
	{
		super(block, slab, doubleslab, block == doubleslab);
		doubleslab.setOtherSlab(slab);
		this.hasSubtypes = true;
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
