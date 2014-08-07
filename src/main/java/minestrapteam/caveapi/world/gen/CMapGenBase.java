package minestrapteam.caveapi.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;

public abstract class CMapGenBase extends MapGenBase
{
	/**
	 * The metadata byte array for the currently processed chunk.
	 */
	private byte[]	metadata;
	
	public CMapGenBase()
	{
		this.range = 8;
		this.rand = new Random();
	}
	
	public void setMetadata(byte[] metadata)
	{
		this.metadata = metadata;
	}
	
	@Override
	public void func_151539_a(IChunkProvider provider, World world, int x, int y, Block[] blocks)
	{
		this.generate(provider, world, x, y, blocks, this.metadata);
	}
	
	public void generate(IChunkProvider provider, World world, int x, int y, Block[] blocks, byte[] metadata)
	{
		int i = this.range;
		this.worldObj = world;
		
		this.rand.setSeed(world.getSeed());
		long l1 = this.rand.nextLong();
		long l2 = this.rand.nextLong();
		
		for (int j = x - i; j <= x + i; ++j)
		{
			for (int k = y - i; k <= y + i; ++k)
			{
				long l3 = j * l1;
				long l4 = k * l2;
				this.rand.setSeed(l3 ^ l4 ^ world.getSeed());
				this.generate(world, j, k, x, y, blocks, metadata);
			}
		}
	}
	
	protected abstract void generate(World world, int x, int z, int x1, int z1, Block[] blocks, byte[] metadata);
}