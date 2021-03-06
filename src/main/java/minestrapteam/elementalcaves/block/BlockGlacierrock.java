package minestrapteam.elementalcaves.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import minestrapteam.elementalcaves.lib.ECBlocks;
import minestrapteam.elementalcaves.util.ECUtil;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockGlacierrock extends ECBlockMulti
{
	public static final String[]	types	= new String[] { null, "cracked", "bricks" };
	
	public IIcon					icySideIcon;
	
	public BlockGlacierrock()
	{
		super(Material.rock, types);
		this.slipperiness = 0.98F;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return metadata == 0 ? 1 : metadata;
	}
	
	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata == 0 && side > 1 && world.getBlock(x, y + 1, z) == ECBlocks.ancientIce)
		{
			return this.icySideIcon;
		}
		return this.getIcon(side, metadata);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		super.registerBlockIcons(iconRegister);
		this.icySideIcon = iconRegister.registerIcon(ECUtil.getTexture("glacierrock_icy"));
	}
}
