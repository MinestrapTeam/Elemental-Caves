package minestrapteam.elementalcaves.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.elementalcaves.ElementalCaves;
import minestrapteam.elementalcaves.lib.ECBlocks;
import minestrapteam.elementalcaves.util.ECUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class ECBlockSand extends BlockFalling
{
	public IIcon sandDarkIcon;
	public IIcon sandQuickIcon;
	
	public ECBlockSand(Material mat)
	{
		super(mat);
		this.setStepSound(Block.soundTypeSand);
		this.setCreativeTab(ElementalCaves.tabBlocks);
	}
	
    public IIcon getIcon(int side, int meta)
    {
    	return meta == 1 ? sandQuickIcon : sandDarkIcon;
    }
    
    public void registerBlockIcons(IIconRegister ir)
    {
    	sandDarkIcon = ir.registerIcon(ECUtil.getTexture("dark_sand"));
    	sandQuickIcon = ir.registerIcon(ECUtil.getTexture("quick_sand"));
    }
	
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
    {
    	super.onNeighborBlockChange(world, x, y, z, neighbor);
    	if(world.getBlockMetadata(x, y, z) == 0)
    	{
    		if(neighbor == Blocks.water || neighbor == Blocks.flowing_water)
    		{
    			world.setBlock(x, y, z, ECBlocks.sand, 1, 3);
    		}
    	}
    }
    
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
    {
        Block plant = plantable.getPlant(world, x, y + 1, z);
        EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
        
        if(plantType == plantType.Desert)
        {
        	return true;
        }
        
        if (plant == Blocks.cactus && this == Blocks.cactus)
        {
            return true;
        }

        if (plant == Blocks.reeds && this == Blocks.reeds)
        {
            return true;
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
    }
}
