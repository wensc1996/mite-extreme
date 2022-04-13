package net.xiaoyu233.mitemod.miteite.block;

import net.minecraft.*;

public class BlockSpawn extends Block {
    String belongto = "";
    ChunkCoordinates spawnPoint = null;

    BlockSpawn(int par1, Material material) {
        super(par1, material, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
        this.setMaxStackSize(1);
        this.setBlockHardness(2F);
        this.setCreativeTab(CreativeModeTab.tabBlock);
        this.setStepSound(Block.soundStoneFootstep);
    }

    public void onBlockAboutToBeBroken(BlockBreakInfo info) {
        EntityPlayer entityPlayer = info.getResponsiblePlayer();
        if(entityPlayer.getEntityName() == this.belongto) {
            entityPlayer.spawnStoneWorldId = -999;
        }
    }

    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
        if(!par1World.isRemote) {
            if(par5EntityPlayer.getEntityName() == this.belongto) {
                this.setBlockHardness(0);
                this.setMinHarvestLevel(0);
            } else {
                this.setBlockHardness(-1.0F);
                this.setMinHarvestLevel(100);
            }
        }
    }

    public boolean tryPlaceBlock(World world, int x, int y, int z, EnumFace face, int metadata, Entity placer, boolean perform_placement_check, boolean drop_existing_block, boolean test_only) {
        if (!test_only && placer instanceof EntityPlayer) {
             this.spawnPoint = new ChunkCoordinates(x, y, z);
             ((EntityPlayer) placer).spawnStoneX = x;
             ((EntityPlayer) placer).spawnStoneY = y + 1;
             ((EntityPlayer) placer).spawnStoneZ = z;
            ((EntityPlayer) placer).setSpawnStoneWorldId(world.provider.dimensionId);
            this.belongto = placer.getEntityName();
        }

        return super.tryPlaceBlock(world, x, y, z, face, metadata, placer, perform_placement_check, drop_existing_block, test_only);
    }
}
