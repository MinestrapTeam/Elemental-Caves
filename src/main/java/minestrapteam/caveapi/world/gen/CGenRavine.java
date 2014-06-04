package minestrapteam.caveapi.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class CGenRavine extends CMapGenBase
{
	private float[]	floats;
	
	public CGenRavine()
	{
		this.floats = new float[1024];
	}
	
	@Override
	protected void generate(World world, int x, int z, int x1, int z1, Block[] blocks, byte[] metadata)
	{
		if (this.rand.nextInt(50) == 0)
		{
			double d0 = x * 16 + this.rand.nextInt(16);
			double d1 = this.rand.nextInt(this.rand.nextInt(40) + 8) + 20;
			double d2 = z * 16 + this.rand.nextInt(16);
			
			float f = this.rand.nextFloat() * 3.141593F * 2.0F;
			float f1 = (this.rand.nextFloat() - 0.5F) * 0.25F;
			float f2 = (this.rand.nextFloat() * 2.0F + this.rand.nextFloat()) * 2.0F;
			this.generate(this.rand.nextLong(), x, z, blocks, metadata, d0, d1, d2, f2, f, f1);
		}
	}
	
	protected void generate(long seed, int x, int z, Block[] blocks, byte[] metadata, double x1, double y1, double z1, float rotation, float p_151540_13_, float p_151540_14_)
	{
		Random random = new Random(seed);
		double d4 = x * 16 + 8;
		double d5 = z * 16 + 8;
		float f3 = 0.0F;
		float f4 = 0.0F;
		
		int j1 = 112 - random.nextInt(28);
		
		boolean flag1 = false;
		
		float f5 = 1.0F;
		
		for (int k1 = 0; k1 < 256; ++k1)
		{
			if (k1 == 0 || random.nextInt(3) == 0)
			{
				f5 = 1.0F + random.nextFloat() * random.nextFloat() * 1.0F;
			}
			
			this.floats[k1] = f5 * f5;
		}
		
		for (int i = 0; i < j1; ++i)
		{
			double d12 = 1.5D + MathHelper.sin(i * 3.141593F / j1) * rotation * 1.0F;
			double d6 = d12 * 3D;
			d12 *= (random.nextFloat() * 0.25D + 0.75D);
			d6 *= (random.nextFloat() * 0.25D + 0.75D);
			float f6 = MathHelper.cos(p_151540_14_);
			float f7 = MathHelper.sin(p_151540_14_);
			x1 += MathHelper.cos(p_151540_13_) * f6;
			y1 += f7;
			z1 += MathHelper.sin(p_151540_13_) * f6;
			p_151540_14_ *= 0.7F;
			p_151540_14_ += f4 * 0.05F;
			p_151540_13_ += f3 * 0.05F;
			f4 *= 0.8F;
			f3 *= 0.5F;
			f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
			f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
			
			if (flag1 || random.nextInt(4) != 0)
			{
				double d7 = x1 - d4;
				double d8 = z1 - d5;
				double d9 = j1 - i;
				double d10 = rotation + 2.0F + 16.0F;
				if (d7 * d7 + d8 * d8 - (d9 * d9) > d10 * d10)
				{
					return;
				}
				if ((x1 < d4 - 16.0D - (d12 * 2.0D)) || (z1 < d5 - 16.0D - (d12 * 2.0D)) || (x1 > d4 + 16.0D + d12 * 2.0D) || (z1 > d5 + 16.0D + d12 * 2.0D))
					continue;
				int i4 = MathHelper.floor_double(x1 - d12) - (x * 16) - 1;
				int l1 = MathHelper.floor_double(x1 + d12) - (x * 16) + 1;
				int j4 = MathHelper.floor_double(y1 - d6) - 1;
				int i2 = MathHelper.floor_double(y1 + d6) + 1;
				int k4 = MathHelper.floor_double(z1 - d12) - (z * 16) - 1;
				int j2 = MathHelper.floor_double(z1 + d12) - (z * 16) + 1;
				if (i4 < 0)
				{
					i4 = 0;
				}
				if (l1 > 16)
				{
					l1 = 16;
				}
				if (j4 < 1)
				{
					j4 = 1;
				}
				if (i2 > 248)
				{
					i2 = 248;
				}
				if (k4 < 0)
				{
					k4 = 0;
				}
				if (j2 > 16)
				{
					j2 = 16;
				}
				
				boolean flag2 = false;
				for (int k2 = i4; k2 < l1; ++k2)
				{
					for (int l2 = k4; l2 < j2; ++l2)
					{
						for (int i3 = i2 + 1; i3 >= j4 - 1; --i3)
						{
							int j3 = (k2 * 16 + l2) * 256 + i3;
							
							if (i3 >= 0 && i3 < 256)
							{
								Block block = blocks[j3];
								if (isOceanBlock(blocks, j3, k2, i3, l2, x, z))
								{
									flag2 = true;
									break;
								}
								
								if (i3 == j4 - 1 || k2 == i4 || k2 == l1 - 1 || l2 == k4 || l2 == j2 - 1)
									continue;
								i3 = j4;
							}
						}
						
					}
				}
				if (flag2)
					continue;
				
				for (int k2 = i4; k2 < l1; ++k2)
				{
					double d13 = (k2 + x * 16 + 0.5D - x1) / d12;
					
					for (int j3 = k4; j3 < j2; ++j3)
					{
						double d14 = (j3 + z * 16 + 0.5D - z1) / d12;
						int k3 = (k2 * 16 + j3) * 256 + i2;
						boolean flag = false;
						
						if (d13 * d13 + d14 * d14 < 1.0D)
						{
							for (int l3 = i2 - 1; l3 >= j4; --l3)
							{
								double d11 = (l3 + 0.5D - y1) / d6;
								
								if ((d13 * d13 + d14 * d14) * this.floats[l3] + d11 * d11 / 6.0D < 1.0D)
								{
									Block block1 = blocks[k3];
									
									if (isTopBlock(blocks, k3, k2, l3, j3, x, z))
									{
										flag = true;
									}
									
									digBlock(blocks, k3, k2, l3, j3, x, z, flag);
								}
								
								--k3;
							}
						}
					}
				}
				
				if (flag1)
					return;
			}
		}
	}
	
	protected boolean isOceanBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ)
	{
		return ((data[index] == Blocks.water) || (data[index] == Blocks.flowing_water));
	}
	
	private boolean isExceptionBiome(BiomeGenBase biome)
	{
		if (biome == BiomeGenBase.mushroomIsland)
			return true;
		if (biome == BiomeGenBase.beach)
			return true;
		return (biome == BiomeGenBase.desert);
	}
	
	private boolean isTopBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ)
	{
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x + chunkX * 16, z + chunkZ * 16);
		return (data[index] == Blocks.grass);
	}
	
	protected void digBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop)
	{
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x + chunkX * 16, z + chunkZ * 16);
		Block top = (isExceptionBiome(biome)) ? Blocks.grass : biome.topBlock;
		Block filler = (isExceptionBiome(biome)) ? Blocks.dirt : biome.fillerBlock;
		Block block = data[index];
		
		if ((block != Blocks.stone) && (block != filler) && (block != top))
			return;
		if (y < 10)
		{
			data[index] = Blocks.flowing_lava;
		}
		else
		{
			data[index] = null;
			
			if ((!(foundTop)) || (data[(index - 1)] != filler))
				return;
			data[(index - 1)] = top;
		}
	}
}