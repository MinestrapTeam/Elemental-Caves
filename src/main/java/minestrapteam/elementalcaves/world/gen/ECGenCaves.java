package minestrapteam.elementalcaves.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.MapGenBase;

/**
 * WIP class for generating custom stand-alone caves.
 *
 */
public class ECGenCaves extends MapGenBase
{
	@Override
	protected void func_151538_a(World world, int x, int z, int xSeed, int ySeed, Block[] blocks)
	{
		int i1 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
		
		if (this.rand.nextInt(7) != 0)
		{
			i1 = 0;
		}
		
		for (int j1 = 0; j1 < i1; ++j1)
		{
			double d0 = x * 16 + this.rand.nextInt(16);
			double d1 = this.rand.nextInt(this.rand.nextInt(120) + 8);
			double d2 = z * 16 + this.rand.nextInt(16);
			int k1 = 1;
			
			if (this.rand.nextInt(4) == 0)
			{
				this.generate(this.rand.nextLong(), xSeed, ySeed, blocks, d0, d1, d2);
				k1 += this.rand.nextInt(4);
			}
			
			for (int l1 = 0; l1 < k1; ++l1)
			{
				float f = this.rand.nextFloat() * 3.141593F * 2.0F;
				float f1 = (this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
				float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();
				
				if (this.rand.nextInt(10) == 0)
				{
					f2 *= (this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F);
				}
				
				this.generate(this.rand.nextLong(), xSeed, ySeed, blocks, d0, d1, d2, f2, f, f1, 0, 0, 1.0D);
			}
		}
	}
	
	protected void generate(long seed, int x, int z, Block[] blocks, double dx, double dy, double dz)
	{
		generate(seed, x, z, blocks, dx, dy, dz, 1.0F + this.rand.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
	}
	
	protected void generate(long seed, int x, int z, Block[] blocks, double dx, double dy, double dz, float f1, float p_151541_13_, float p_151541_14_, int p_151541_15_, int p_151541_16_, double p_151541_17_)
	{
		double d4 = x * 16 + 8;
		double d5 = z * 16 + 8;
		float f3 = 0.0F;
		float f4 = 0.0F;
		Random random = new Random(seed);
		
		if (p_151541_16_ <= 0)
		{
			int j1 = this.range * 16 - 16;
			p_151541_16_ = j1 - random.nextInt(j1 / 4);
		}
		
		boolean flag2 = false;
		
		if (p_151541_15_ == -1)
		{
			p_151541_15_ = p_151541_16_ / 2;
			flag2 = true;
		}
		
		int k1 = random.nextInt(p_151541_16_ / 2) + p_151541_16_ / 4;
		
		for (boolean flag = random.nextInt(6) == 0; p_151541_15_ < p_151541_16_; ++p_151541_15_)
		{
			double d6 = 1.5D + MathHelper.sin(p_151541_15_ * 3.141593F / p_151541_16_) * f1 * 1.0F;
			double d7 = d6 * p_151541_17_;
			float f5 = MathHelper.cos(p_151541_14_);
			float f6 = MathHelper.sin(p_151541_14_);
			dx += MathHelper.cos(p_151541_13_) * f5;
			dy += f6;
			dz += MathHelper.sin(p_151541_13_) * f5;
			
			if (flag)
			{
				p_151541_14_ *= 0.92F;
			}
			else
			{
				p_151541_14_ *= 0.7F;
			}
			
			p_151541_14_ += f4 * 0.1F;
			p_151541_13_ += f3 * 0.1F;
			f4 *= 0.9F;
			f3 *= 0.75F;
			f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
			f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
			
			if (!flag2 && (p_151541_15_ == k1) && (f1 > 1.0F) && (p_151541_16_ > 0))
			{
				generate(random.nextLong(), x, z, blocks, dx, dy, dz, random.nextFloat() * 0.5F + 0.5F, p_151541_13_ - 1.570796F, p_151541_14_ / 3.0F, p_151541_15_, p_151541_16_, 1.0D);
				generate(random.nextLong(), x, z, blocks, dx, dy, dz, random.nextFloat() * 0.5F + 0.5F, p_151541_13_ + 1.570796F, p_151541_14_ / 3.0F, p_151541_15_, p_151541_16_, 1.0D);
				return;
			}
			
			if (!flag2 && (random.nextInt(4) == 0))
				continue;
			double d8 = dx - d4;
			double d9 = dz - d5;
			double d10 = p_151541_16_ - p_151541_15_;
			double d11 = f1 + 2.0F + 16.0F;
			
			if (d8 * d8 + d9 * d9 - (d10 * d10) > d11 * d11)
			{
				return;
			}
			
			if ((dx < d4 - 16.0D - (d6 * 2.0D)) || (dz < d5 - 16.0D - (d6 * 2.0D)) || (dx > d4 + 16.0D + d6 * 2.0D) || (dz > d5 + 16.0D + d6 * 2.0D))
				continue;
			int i4 = MathHelper.floor_double(dx - d6) - (x * 16) - 1;
			int l1 = MathHelper.floor_double(dx + d6) - (x * 16) + 1;
			int j4 = MathHelper.floor_double(dy - d7) - 1;
			int i2 = MathHelper.floor_double(dy + d7) + 1;
			int k4 = MathHelper.floor_double(dz - d6) - (z * 16) - 1;
			int j2 = MathHelper.floor_double(dz + d6) - (z * 16) + 1;
			
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
			
			boolean flag3 = false;
			
			for (int k2 = i4; !flag3 && k2 < l1; ++k2)
			{
				for (int l2 = k4; !flag3 && l2 < j2; ++l2)
				{
					for (int i3 = i2 + 1; !flag3 && i3 >= j4 - 1; --i3)
					{
						int j3 = (k2 * 16 + l2) * 256 + i3;
						
						if (i3 >= 0 && i3 < 256)
						{
							if (this.isOceanBlock(blocks, j3, k2, i3, l2, x, z))
							{
								flag3 = true;
							}
							if (i3 == j4 - 1 || k2 == i4 || k2 == l1 - 1 || l2 == k4 || l2 == j2 - 1)
								continue;
							i3 = j4;
						}
					}
				}
			}
			
			if (!flag3)
			{
				for (int k2 = i4; k2 < l1; ++k2)
				{
					double d13 = (k2 + x * 16 + 0.5D - dx) / d6;
					
					for (int j3 = k4; j3 < j2; ++j3)
					{
						double d14 = (j3 + z * 16 + 0.5D - dz) / d6;
						int k3 = (k2 * 16 + j3) * 256 + i2;
						boolean flag1 = false;
						
						if (d13 * d13 + d14 * d14 < 1.0D)
						{
							for (int l3 = i2 - 1; l3 >= j4; --l3)
							{
								double d12 = (l3 + 0.5D - dy) / d7;
								
								if ((d12 > -0.7D) && (d13 * d13 + d12 * d12 + d14 * d14 < 1.0D))
								{
									if (isTopBlock(blocks, k3, k2, l3, j3, x, z))
									{
										flag1 = true;
									}
									digBlock(blocks, k3, k2, l3, j3, x, z, flag1);
								}
								
								--k3;
							}
						}
					}
					
				}
				
				if (flag2)
					return;
			}
		}
	}
	
	protected boolean isOceanBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ)
	{
		return ((data[index] == Blocks.flowing_water) || (data[index] == Blocks.water));
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
			data[index] = Blocks.lava;
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
