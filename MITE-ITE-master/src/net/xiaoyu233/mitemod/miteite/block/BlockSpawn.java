package net.xiaoyu233.mitemod.miteite.block;

import net.minecraft.*;

public class BlockSpawn extends Block {
    String belongto = "";
    ChunkCoordinates spawnPoint = null;

    BlockSpawn(int par1, Material material) {
        super(par1, material, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
        this.setMaxStackSize(1);
        this.setHardness(2F);
        this.setCreativeTab(CreativeModeTab.tabBlock);
        this.setStepSound(Block.soundStoneFootstep);
    }

    public void onBlockAboutToBeBroken(BlockBreakInfo info) {
        EntityPlayer entityPlayer = info.getResponsiblePlayer();
        entityPlayer.spawnStoneWorldId = -999;
    }

    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
        if(par1World.isRemote) {
            if(par5EntityPlayer.spawnStoneWorldId != -999 && (par5EntityPlayer.getWorld().getDimensionId() == par5EntityPlayer.spawnStoneWorldId)) {
                Block block = par5EntityPlayer.getWorld().getBlock(par5EntityPlayer.spawnStoneX, par5EntityPlayer.spawnStoneY - 1, par5EntityPlayer.spawnStoneZ);
                if(block != null && block instanceof BlockSpawn) {
                    this.setHardness(2F);
                    this.setMinHarvestLevel(2);
                }
            } else {
                this.setHardness(-1.0F);
                this.setMinHarvestLevel(100);
            }
        }
    }

    public boolean tryPlaceBlock(World world, int x, int y, int z, EnumFace face, int metadata, Entity placer, boolean perform_placement_check, boolean drop_existing_block, boolean test_only) {
        if (!test_only && placer instanceof EntityPlayer) {
            if(((EntityPlayer) placer).spawnStoneWorldId == -999) {
                this.spawnPoint = new ChunkCoordinates(x, y, z);
                ((EntityPlayer) placer).spawnStoneX = x;
                ((EntityPlayer) placer).spawnStoneY = y + 1;
                ((EntityPlayer) placer).spawnStoneZ = z;
                ((EntityPlayer) placer).setSpawnStoneWorldId(world.provider.dimensionId);
                this.belongto = placer.getEntityName();
                return super.tryPlaceBlock(world, x, y, z, face, metadata, placer, perform_placement_check, drop_existing_block, test_only);
            } else {
                ((EntityPlayer) placer).addChatMessage("复活传送阵已设置，不可重复放置");
                return false;
            }
        } else {
            return super.tryPlaceBlock(world, x, y, z, face, metadata, placer, perform_placement_check, drop_existing_block, test_only);
        }
    }
}
