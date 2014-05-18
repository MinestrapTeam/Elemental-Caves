package sobiohazardous.mods.ec.cavetype;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import sobiohazardous.mods.ec.lib.ECBlocks;

public class CaveTypeForest extends CaveType
{
	public CaveTypeForest(String name)
	{
		super(name, ECBlocks.ancientMossStone);
		
		this.getWallGen().addReplacement(Blocks.dirt, ECBlocks.richSoil);
		this.getWallGen().addReplacement(Blocks.gravel, ECBlocks.richSoil);
		
		this.setFloorAddonSpawnWeight(0.5F);
		
		//TODO Add ores
	}
	
	public void generateFloorAddons(World world, Random random, int x, int y, int z)
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
                        world.setBlock(i1, j1, k1, Blocks.tallgrass, 1, 3);
                        
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
	public void generateFloor(World world, Random random, int x, int y, int z)
	{
		world.setBlock(x, y, z, ECBlocks.richGrass, 0, 3);
		world.setBlock(x, y - 1, z, ECBlocks.richSoil, 0, 3);
		world.setBlock(x, y - 2, z, ECBlocks.richSoil, 0, 3);
	}

	public boolean canGenerateInBiome(BiomeGenBase biome)
	{
		return biome == BiomeGenBase.forest || biome == BiomeGenBase.forestHills || biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleEdge || biome == BiomeGenBase.jungleHills;
	}
}
