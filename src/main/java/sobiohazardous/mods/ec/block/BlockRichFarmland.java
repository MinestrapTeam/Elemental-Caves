package sobiohazardous.mods.ec.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import sobiohazardous.mods.ec.lib.ECBlocks;
import sobiohazardous.mods.ec.lib.ECReference;
import sobiohazardous.mods.ec.util.ECUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFarmland;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockRichFarmland extends BlockFarmland
{
    @SideOnly(Side.CLIENT)
    private IIcon top;

    public BlockRichFarmland()
    {
        super();
        this.setTickRandomly(true);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);
        this.setLightOpacity(255);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        return AxisAlignedBB.getAABBPool().getAABB((double)(p_149668_2_ + 0), (double)(p_149668_3_ + 0), (double)(p_149668_4_ + 0), (double)(p_149668_2_ + 1), (double)(p_149668_3_ + 1), (double)(p_149668_4_ + 1));
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
    	return side == 0 ? this.top : this.blockIcon;
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random rand)
    {
    	ECUtil.grow(world, x, y + 1, z);
    	
        if (!this.func_149821_m(world, x, y, z) && !world.canLightningStrikeAt(x, y + 1, z))
        {
            int l = world.getBlockMetadata(x, y, z);

            if (l > 0)
            {
                world.setBlockMetadataWithNotify(x, y, z, l - 1, 2);
            }
            else if (!this.func_149822_e(world, x, y, z))
            {
                world.setBlock(x, y, z, ECBlocks.richSoil);
            }
        }
        else
        {
            world.setBlockMetadataWithNotify(x, y, z, 7, 2);
        }
    }

    /**
     * Block's chance to react to an entity falling on it.
     */
    public void onFallenUpon(World world, int x, int y, int z, Entity force, float velocity)
    {
        if (!world.isRemote && world.rand.nextFloat() < velocity - 0.5F)
        {
            if (!(force instanceof EntityPlayer) && !world.getGameRules().getGameRuleBooleanValue("mobGriefing"))
            {
                return;
            }

            world.setBlock(x, y, z, ECBlocks.richSoil);
        }
    }

    private boolean func_149822_e(World world, int x, int y, int z)
    {
        byte b0 = 0;

        for (int l = x - b0; l <= x + b0; ++l)
        {
            for (int i1 = z - b0; i1 <= z + b0; ++i1)
            {
                Block block = world.getBlock(l, y + 1, i1);

                if (block instanceof IPlantable && canSustainPlant(world, x, y, z, ForgeDirection.UP, (IPlantable)block))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean func_149821_m(World world, int x, int y, int z)
    {
        for (int l = x - 4; l <= x + 4; ++l)
        {
            for (int i1 = y; i1 <= y + 1; ++i1)
            {
                for (int j1 = z - 4; j1 <= z + 4; ++j1)
                {
                    if (world.getBlock(l, i1, j1).getMaterial() == Material.water)
                    {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World world, int x, int y, int z, Block changed)
    {
        super.onNeighborBlockChange(world, x, y, z, changed);
        Material material = world.getBlock(x, y + 1, z).getMaterial();

        if (material.isSolid())
        {
            world.setBlock(x, y, z, ECBlocks.richSoil);
        }
    }

    public Item getItemDropped(int meta, Random rand, int fortune)
    {
        return ECBlocks.richSoil.getItemDropped(0, rand, fortune);
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z)
    {
        return Item.getItemFromBlock(ECBlocks.richSoil);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister ir)
    {
    	this.blockIcon = ir.registerIcon(ECReference.getTexture("richSoil"));
        this.top = ir.registerIcon(ECReference.getTexture("richFarmlandTop"));
    }
    
    public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
    {
        EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);
        if(plantType == plantType.Crop)
        {
        	return true;
        }
        return false;
    }
}