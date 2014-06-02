package minestrapteam.elementalcaves.item.block;

import minestrapteam.elementalcaves.block.ECBlockSlab;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;

public class ECItemSlab extends ItemSlab
{
	public ECItemSlab(Block block, ECBlockSlab slab, ECBlockSlab doubleslab)
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
