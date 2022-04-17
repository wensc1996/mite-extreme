package net.xiaoyu233.mitemod.miteite.block;

import net.minecraft.*;

import java.util.Iterator;

public class BlockSpawn extends Block {
    String belongto = "";
    ChunkCoordinates spawnPoint = null;

    BlockSpawn(int par1, Material material) {
        super(par1, material, (new BlockConstants()).setNeverHidesAdjacentFaces().setNotAlwaysLegal());
        this.setMaxStackSize(1);
        this.setHardness(2F);
        this.setMinHarvestLevel(2);
        this.setResistance(60000F);
        this.setCreativeTab(CreativeModeTab.tabBlock);
        this.setStepSound(Block.soundStoneFootstep);
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        EntityPlayer entityPlayer = info.getResponsiblePlayer();
        if (entityPlayer.spawnStoneWorldId != -999) {
            if (info.x == entityPlayer.spawnStoneX && info.y == (entityPlayer.spawnStoneY - 1) && info.z == entityPlayer.spawnStoneZ) {
                entityPlayer.spawnStoneWorldId = -999;
                return super.dropBlockAsEntityItem(info);
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

//    public void onBlockAboutToBeBroken(BlockBreakInfo info) {
//        EntityPlayer entityPlayer = info.getResponsiblePlayer();
//
//    }

//    public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer entityPlayer) {
//        if(!par1World.isRemote) {
//            if (entityPlayer != null) {
//                if (entityPlayer.spawnStoneWorldId != -999) {
//                    if (par2 == entityPlayer.spawnStoneX && par3 == (entityPlayer.spawnStoneY - 1) && par4 == entityPlayer.spawnStoneZ) {
//                        this.setBlockHardness(2F);
//                        this.setMinHarvestLevel(2);
//                    } else {
//                        if(entityPlayer.getHeldItem() instanceof ItemArmor || entityPlayer.getHeldItem() instanceof ItemWarHammer) {
//                            ItemStack item_stack_to_drop = entityPlayer.getHeldItemStack();
//                            entityPlayer.dropPlayerItem(item_stack_to_drop);
//                        }
//                    }
//                } else {
//                    if(entityPlayer.getHeldItem() instanceof ItemArmor || entityPlayer.getHeldItem() instanceof ItemWarHammer) {
//                        ItemStack item_stack_to_drop = entityPlayer.getHeldItemStack();
//                        entityPlayer.dropPlayerItem(item_stack_to_drop);
//                    }
//                }
//            }
//        }
//    }

    public boolean tryPlaceBlock(World world, int x, int y, int z, EnumFace face, int metadata, Entity placer, boolean perform_placement_check, boolean drop_existing_block, boolean test_only) {
        if(!world.isRemote) {
            EntityPlayer entityPlayer = (EntityPlayer) placer;
            if(entityPlayer != null) {
                entityPlayer.plusMoney(1D);
                if(entityPlayer.spawnStoneWorldId == -999) {
                    this.spawnPoint = new ChunkCoordinates(x, y, z);
                    entityPlayer.spawnStoneX = x;
                    entityPlayer.spawnStoneY = y + 1;
                    entityPlayer.spawnStoneZ = z;
                    entityPlayer.setSpawnStoneWorldId(world.provider.dimensionId);
                    this.belongto = entityPlayer.getEntityName();
                } else {
                    entityPlayer.addChatMessage("已经放置复活传送阵，请勿重复放置");
                    return false;
                }
            }
        }
        return super.tryPlaceBlock(world, x, y, z, face, metadata, placer, perform_placement_check, drop_existing_block, test_only);
    }
}
