package minestrapteam.elementalcaves.block;

import java.util.List;

import minestrapteam.elementalcaves.util.ECUtil;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * All pressurized sandstone types.
 * <ul>
 * <li>Meta 0: Normal
 * <li>Meta 1: Chiseled
 * <li>Meta 2: Smooth
 * <li>Meta 3: Hieroglyph
 * <li>Meta 4: Hieroglyph 2
 * <li>Meta 5: Bejeweled
 * <li>Meta 6: Bejeweled 2
 * <li>Meta 7: Gilded
 * <li>Meta 8: Gilded 2
 * </ul>
 * 
 * @author SoBiohazardous
 * @author Clashsoft
 */
public class BlockPressurizedSandstone extends ECBlock
{
	public IIcon	bottomIcon;
	public IIcon	sideIcon;
	public IIcon	sideIcon2;
	public IIcon	chiseledIcon;
	public IIcon	smoothIcon;
	public IIcon	hieroglyphIcon;
	public IIcon	hieroglyphIcon2;
	public IIcon	bejeweledIcon;
	public IIcon	bejeweledIcon2;
	public IIcon	gildedIcon;
	public IIcon	gildedIcon2;
	
	public BlockPressurizedSandstone(Material material)
	{
		super(material);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.bottomIcon = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_bottom"));
		this.blockIcon = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_top"));
		this.sideIcon = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_side"));
		this.sideIcon2 = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_side_2"));
		this.chiseledIcon = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_chiseled"));
		this.smoothIcon = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_smooth"));
		this.hieroglyphIcon = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_hieroglyph_1"));
		this.hieroglyphIcon2 = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_hieroglyph_2"));
		this.bejeweledIcon = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_bejeweled_1"));
		this.bejeweledIcon2 = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_bejeweled_2"));
		this.gildedIcon = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_gilded_1"));
		this.gildedIcon2 = iconRegister.registerIcon(ECUtil.getTexture("pressurized_sandstone_gilded_2"));
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		if (side == 0)
		{
			return this.bottomIcon;
		}
		else if (side == 1)
		{
			return this.blockIcon;
		}
		
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 0)
		{
			if (world.getBlock(x, y + 1, z) == this && world.getBlockMetadata(x, y + 1, z) == 0)
			{
				return this.sideIcon2;
			}
			return this.sideIcon;
		}
		else if (metadata == 1)
		{
			return this.chiseledIcon;
		}
		else if (metadata == 2)
		{
			return this.smoothIcon;
		}
		else if (metadata == 3)
		{
			return this.hieroglyphIcon;
		}
		else if (metadata == 4)
		{
			return this.hieroglyphIcon2;
		}
		else if (metadata == 5)
		{
			return this.bejeweledIcon;
		}
		else if (metadata == 6)
		{
			return this.bejeweledIcon2;
		}
		else if (metadata == 7)
		{
			return this.gildedIcon;
		}
		else if (metadata == 8)
		{
			return this.gildedIcon2;
		}
		return this.blockIcon;
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list)
	{
		for (int i = 0; i < 9; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}
}
