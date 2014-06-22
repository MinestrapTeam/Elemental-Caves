package minestrapteam.elementalcaves.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.elementalcaves.lib.ECBlocks;
import minestrapteam.elementalcaves.util.ECUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

/**
 * All pressurized sandstone types. 
 * <ul>
 * <li>Meta 0: Normal
 * <li>Meta 1: Normal Connected
 * <li>Meta 2: Chiseled
 * <li>Meta 3: Smooth
 * <li>Meta 4: Hieroglyph
 * <li>Meta 5: Hieroglyph2
 * <li>Meta 6: Bejeweled
 * <li>Meta 7: Bejeweled2
 * </ul>
 * @author SoBiohazardous
 *
 */
public class BlockPressurizedSandstone extends ECBlock
{
	public IIcon bottom;
	public IIcon top;
	public IIcon sideCap;
	public IIcon sideConnect;
	public IIcon sideChiseled;
	public IIcon sideSmooth;
	public IIcon sideAncientHieroglyph;
	public IIcon sideAncientHieroglyph2;
	public IIcon sideBejeweledHieroglyph;
	public IIcon sideBejeweledHieroglyph2;

	public BlockPressurizedSandstone(Material material)
	{
		super(material);
	}
	
	public void registerBlockIcons(IIconRegister ir)
	{
		this.bottom = ir.registerIcon(ECUtil.getTexture("pressurized_sandstone_bottom"));
		this.top = ir.registerIcon(ECUtil.getTexture("pressurized_sandstone_top"));
		this.sideCap = ir.registerIcon(ECUtil.getTexture("pressurized_sandstone_side_cap"));
		this.sideConnect = ir.registerIcon(ECUtil.getTexture("pressurized_sandstone_side_connect"));
		this.sideChiseled = ir.registerIcon(ECUtil.getTexture("chiseled_pressurized_sandstone_side"));
		this.sideSmooth = ir.registerIcon(ECUtil.getTexture("smooth_pressurized_sandstone_side"));
		this.sideAncientHieroglyph = ir.registerIcon(ECUtil.getTexture("ancient_hieroglyph_1"));
		this.sideAncientHieroglyph2 = ir.registerIcon(ECUtil.getTexture("ancient_hieroglyph_2"));
		this.sideBejeweledHieroglyph = ir.registerIcon(ECUtil.getTexture("bejeweled_ancient_hieroglyph_1"));
		this.sideBejeweledHieroglyph2 = ir.registerIcon(ECUtil.getTexture("bejeweled_ancient_hieroglyph_2"));
	}

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 0 ? this.bottom : side == 1 ? this.top  : meta == 1 ? this.sideConnect : meta == 2 ? this.sideChiseled : meta == 3 ? this.sideSmooth : meta == 4 ? this.sideAncientHieroglyph : meta == 5 ? this.sideAncientHieroglyph2 : meta == 6 ? this.sideBejeweledHieroglyph : meta == 7 ? this.sideBejeweledHieroglyph2 : this.sideCap;
    }
    
    public void onBlockAdded(World world, int x, int y, int z) 
    {
    	this.updateMetaForTextures(world, x, y, z);
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbor)
    {
    	this.updateMetaForTextures(world, x, y, z);
    }
    
    private void updateMetaForTextures(World world, int x, int y, int z)
    {
    	if(world.getBlockMetadata(x, y, z) == 0 && world.getBlock(x, y + 1, z) == ECBlocks.pressurizedSandstone)
    	{
    		world.setBlock(x, y, z, ECBlocks.pressurizedSandstone, 1, 3);
    	}
    	else if (world.getBlockMetadata(x, y, z) == 1 && world.getBlock(x, y + 1, z) == Blocks.air)
    	{
    		world.setBlock(x, y, z, ECBlocks.pressurizedSandstone, 0, 3);
    	} 		
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
    	list.add(new ItemStack(item, 1, 0));
    	list.add(new ItemStack(item, 1, 2));
    	list.add(new ItemStack(item, 1, 3));
    	list.add(new ItemStack(item, 1, 4));
    	list.add(new ItemStack(item, 1, 5));
    	list.add(new ItemStack(item, 1, 6));
    	list.add(new ItemStack(item, 1, 7));
    }
}
