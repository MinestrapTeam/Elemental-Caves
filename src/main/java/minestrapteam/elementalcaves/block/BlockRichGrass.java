package minestrapteam.elementalcaves.block;

import java.util.Random;

import minestrapteam.elementalcaves.lib.ECBlocks;
import minestrapteam.elementalcaves.util.ECUtil;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRichGrass extends ECBlock implements IGrowable
{
	private IIcon	top;
	private IIcon	bottom;
	
	public BlockRichGrass(Material material)
	{
		super(material);
		this.setStepSound(Block.soundTypeGrass);
		this.setLightLevel(0.6F);
		this.setTickRandomly(true);
	}
	
	@Override
	public boolean canSilkHarvest()
	{
		return true;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		this.blockIcon = iconRegister.registerIcon(ECUtil.getTexture("rich_grass_side"));
		this.top = iconRegister.registerIcon(ECUtil.getTexture("rich_grass_top"));
		this.bottom = iconRegister.registerIcon(ECUtil.getTexture("rich_soil"));
	}
	
	@Override
	public IIcon getIcon(int side, int metadata)
	{
		return side == 0 ? this.bottom : side == 1 ? this.top : this.blockIcon;
	}
	
	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (rand.nextInt(16) == 0)
		{
			ECUtil.grow(world, x, y, z);
		}
		
		if (!world.isRemote)
		{
			int lightValue = world.getBlockLightValue(x, y + 1, z);
			if (lightValue < 4 && world.getBlockLightOpacity(x, y + 1, z) > 2)
			{
				world.setBlock(x, y, z, ECBlocks.richSoil);
			}
			else if (lightValue >= 9)
			{
				for (int l = 0; l < 4; ++l)
				{
					int i1 = x + rand.nextInt(3) - 1;
					int j1 = y + rand.nextInt(5) - 3;
					int k1 = z + rand.nextInt(3) - 1;
					
					if (world.getBlock(i1, j1, k1) == ECBlocks.richSoil && world.getBlockMetadata(i1, j1, k1) == 0 && world.getBlockLightValue(i1, j1 + 1, k1) >= 4 && world.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
					{
						world.setBlock(i1, j1, k1, ECBlocks.richGrass);
					}
				}
			}
		}
	}
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune)
	{
		return ECBlocks.richSoil.getItemDropped(metadata, rand, fortune);
	}
	
	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean flag)
	{
		return true;
	}
	
	@Override
	public boolean func_149852_a(World world, Random random, int x, int y, int z)
	{
		return true;
	}
	
	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z)
	{
		int l = 0;
		
		while (l < 128)
		{
			int i1 = x;
			int j1 = y + 1;
			int k1 = z;
			int l1 = 0;
			
			while (true)
			{
				if (l1 < l / 16)
				{
					i1 += random.nextInt(3) - 1;
					j1 += (random.nextInt(3) - 1) * random.nextInt(3) / 2;
					k1 += random.nextInt(3) - 1;
					
					if (world.getBlock(i1, j1 - 1, k1) == ECBlocks.richGrass && !world.getBlock(i1, j1, k1).isNormalCube())
					{
						++l1;
						continue;
					}
				}
				else if (world.getBlock(i1, j1, k1).getMaterial() == Material.air)
				{
					if (random.nextInt(8) != 0)
					{
						if (Blocks.tallgrass.canBlockStay(world, i1, j1, k1))
						{
							world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
						}
					}
					else
					{
						world.getBiomeGenForCoords(i1, k1).plantFlower(world, random, i1, j1, k1);
					}
				}
				
				++l;
				break;
			}
		}
	}
	
	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
	{
		return true;
	}
}
