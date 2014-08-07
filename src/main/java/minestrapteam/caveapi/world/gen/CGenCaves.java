package minestrapteam.caveapi.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class CGenCaves extends CMapGenBase
{
	@Override
	protected void generate(World world, int x, int z, int xSeed, int ySeed, Block[] blocks, byte[] metadata)
	{		
		// No caves
		if (this.rand.nextInt(7) != 0)
		{
			return;
		}
		
		int i1 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(15) + 1) + 1);
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
				float f1 = (this.rand.nextFloat() - 0.5F) * 0.25F;
				float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat();
				
				if (this.rand.nextInt(10) == 0)
				{
					f2 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F + 1.0F;
				}
				
				this.generate(this.rand.nextLong(), xSeed, ySeed, blocks, d0, d1, d2, f2, f, f1, 0, 0, 1.0D);
			}
		}
	}
	
	protected void generate(long seed, int x, int z, Block[] blocks, double dx, double dy, double dz)
	{
		this.generate(seed, x, z, blocks, dx, dy, dz, 1.0F + this.rand.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
	}
	
	protected void generate(long seed, int x, int z, Block[] blocks, double dx, double dy, double dz, float f1, float f2, float f3, int r1, int r2, double d)
	{
		double chunkCenterX = x * 16 + 8;
		double chunkCenterZ = z * 16 + 8;
		float f4 = 0.0F;
		float f5 = 0.0F;
		Random random = new Random(seed);
		
		if (r2 <= 0)
		{
			int j1 = this.range * 16 - 16;
			r2 = j1 - random.nextInt(j1 / 4);
		}
		
		boolean flag2 = false;
		
		if (r1 == -1)
		{
			r1 = r2 / 2;
			flag2 = true;
		}
		
		int k1 = random.nextInt(r2 / 2) + r2 / 4;
		
		for (boolean flag = random.nextInt(6) == 0; r1 < r2; ++r1)
		{
			double d6 = 1.5D + MathHelper.sin(r1 * 3.141593F / r2) * f1 * 1.0F;
			double d7 = d6 * d;
			float f6 = MathHelper.cos(f3);
			float f7 = MathHelper.sin(f3);
			dx += MathHelper.cos(f2) * f6;
			dy += f7;
			dz += MathHelper.sin(f2) * f6;
			
			if (flag)
			{
				f3 *= 0.92F;
			}
			else
			{
				f3 *= 0.7F;
			}
			
			f3 += f5 * 0.1F;
			f2 += f4 * 0.1F;
			f5 *= 0.9F;
			f4 *= 0.75F;
			f5 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
			f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
			
			// Seems like it splits the cave
			if (!flag2 && r1 == k1 && f1 > 1.0F && r2 > 0)
			{
				this.generate(random.nextLong(), x, z, blocks, dx, dy, dz, random.nextFloat() * 0.5F + 0.5F, f2 - 1.570796F, f3 / 3.0F, r1, r2, 1.0D);
				this.generate(random.nextLong(), x, z, blocks, dx, dy, dz, random.nextFloat() * 0.5F + 0.5F, f2 + 1.570796F, f3 / 3.0F, r1, r2, 1.0D);
				return;
			}
			
			// Creates a Dead end
			if (!flag2 && random.nextInt(4) == 0)
			{
				continue;
			}
			
			double d8 = dx - chunkCenterX;
			double d9 = dz - chunkCenterZ;
			double d10 = r2 - r1;
			double d11 = f1 + 2.0F + 16.0F;
			
			if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11)
			{
				return;
			}
			
			if (dx < chunkCenterX - 16.0D - d6 * 2.0D || dz < chunkCenterZ - 16.0D - d6 * 2.0D || dx > chunkCenterX + 16.0D + d6 * 2.0D || dz > chunkCenterZ + 16.0D + d6 * 2.0D)
			{
				continue;
			}
			int xmin = MathHelper.floor_double(dx - d6) - x * 16 - 1;
			int xmax = MathHelper.floor_double(dx + d6) - x * 16 + 1;
			int ymin = MathHelper.floor_double(dy - d7) - 1;
			int ymax = MathHelper.floor_double(dy + d7) + 1;
			int zmin = MathHelper.floor_double(dz - d6) - z * 16 - 1;
			int zmax = MathHelper.floor_double(dz + d6) - z * 16 + 1;
			
			if (xmin < 0)
			{
				xmin = 0;
			}
			
			if (xmax > 16)
			{
				xmax = 16;
			}
			
			if (ymin < 1)
			{
				ymin = 1;
			}
			
			if (ymax > 248)
			{
				ymax = 248;
			}
			
			if (zmin < 0)
			{
				zmin = 0;
			}
			
			if (zmax > 16)
			{
				zmax = 16;
			}
			
			boolean oceanBlock = false;
			
			for (int x1 = xmin; !oceanBlock && x1 < xmax; ++x1)
			{
				for (int z1 = zmin; !oceanBlock && z1 < zmax; ++z1)
				{
					for (int y1 = ymax + 1; !oceanBlock && y1 >= ymin - 1; --y1)
					{
						int index = x1 << 12 | z1 << 8 | y1;
						
						if (y1 >= 0 && y1 < 256)
						{
							if (this.isOceanBlock(blocks, index, x1, y1, z1, x, z))
							{
								oceanBlock = true;
							}
							if (y1 == ymin - 1 || x1 == xmin || x1 == xmax - 1 || z1 == zmin || z1 == zmax - 1)
							{
								continue;
							}
							y1 = ymin;
						}
					}
				}
			}
			
			if (!oceanBlock)
			{
				// X loop
				for (int x1 = xmin; x1 < xmax; ++x1)
				{
					double d13 = (x1 + x * 16 + 0.5D - dx) / d6;
					
					// Z loop
					for (int z1 = zmin; z1 < zmax; ++z1)
					{
						double d14 = (z1 + z * 16 + 0.5D - dz) / d6;
						
						// Check if it is within the radius
						if (d13 * d13 + d14 * d14 >= 1.0D)
						{
							continue;
						}
						
						int index = x1 << 12 | z1 << 8 | ymax;
						boolean topBlock = false;
						
						// Y loop
						for (int l3 = ymax - 1; l3 >= ymin; --l3)
						{
							double d12 = (l3 + 0.5D - dy) / d7;
							
							if (d12 > -0.7D && d13 * d13 + d12 * d12 + d14 * d14 < 1.0D)
							{
								if (this.isTopBlock(blocks, index, x1, l3, z1, x, z))
								{
									topBlock = true;
								}
								this.digBlock(blocks, index, x1, l3, z1, x, z, topBlock);
							}
							
							--index;
						}
					}
				}
				
				if (flag2)
				{
					return;
				}
			}
		}
	}
	
	protected boolean isOceanBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ)
	{
		return data[index] == Blocks.flowing_water || data[index] == Blocks.water;
	}
	
	private static boolean isExceptionBiome(BiomeGenBase biome)
	{
		if (biome == BiomeGenBase.mushroomIsland)
		{
			return true;
		}
		if (biome == BiomeGenBase.beach)
		{
			return true;
		}
		return biome == BiomeGenBase.desert;
	}
	
	private boolean isTopBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ)
	{
		return data[index] == Blocks.grass;
	}
	
	protected void digBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop)
	{
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x + chunkX * 16, z + chunkZ * 16);
		Block top = isExceptionBiome(biome) ? Blocks.grass : biome.topBlock;
		Block filler = isExceptionBiome(biome) ? Blocks.dirt : biome.fillerBlock;
		Block block = data[index];
		
		if (block == Blocks.stone || block == filler || block == top)
		{
			if (y < 10)
			{
				data[index] = Blocks.lava;
			}
			else
			{
				data[index] = null;
				
				if (foundTop && data[index - 1] == filler)
				{
					data[index - 1] = top;
				}
			}
		}
	}
}
