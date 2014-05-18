package sobiohazardous.mods.ec.block;

import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECReference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockAncientMossStone extends ECBlock
{
	private IIcon topbottom;
	
	public BlockAncientMossStone(Material material)
	{
		super(material);
	}
	
	public void registerBlockIcons(IIconRegister ir)
	{
		this.blockIcon = ir.registerIcon(ECReference.getTexture("ancientMossStoneSide"));
		this.topbottom = ir.registerIcon(ECReference.getTexture("ancientMossStone"));
	}
	
    public IIcon getIcon(int side, int meta)
    {
    	return side == 0 ? this.topbottom : side == 1 ? this.topbottom : this.blockIcon;
    }
    
    public Item getItemDropped(int par1, Random rand, int fortune)
    {
    	return Item.getItemFromBlock(ECBlocks.ancientMossyCobblestone);
    }
}
