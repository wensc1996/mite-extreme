package net.xiaoyu233.mitemod.miteite.trans.block;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
@Mixin(BlockOre.class)
public class BlockOreTrans extends Block {

    protected BlockOreTrans(int par1, Material par2Material, BlockConstants constants) {
        super(par1, par2Material, constants);
    }

    @Overwrite
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        int metadata_dropped = -1;
        int quantity_dropped = 1;
        int id_dropped;
        if (info.wasExploded()) {
            if (this == oreEmerald) {
                id_dropped = Item.shardEmerald.itemID;
            } else if (this == oreDiamond) {
                id_dropped = Item.shardDiamond.itemID;
            } else if (this == oreLapis) {
                id_dropped = Item.dyePowder.itemID;
                metadata_dropped = 4;
                quantity_dropped = 3 + info.world.rand.nextInt(3);
            } else if (this == oreNetherQuartz) {
                id_dropped = Item.shardNetherQuartz.itemID;
            } else if (this == oreCoal) {
                id_dropped = -1;
            } else {
                id_dropped = this.blockID;
            }
        } else {
            if (info.wasHarvestedByPlayer() && info.getResponsiblePlayer().worldObj.areSkillsEnabled() && !info.getResponsiblePlayer().hasSkill(Skill.MINING)) {
                return super.dropBlockAsEntityItem(info);
            }

            if (this == oreCoal) {
                id_dropped = Item.coal.itemID;
            } else if (this == oreDiamond) {
                id_dropped = Item.diamond.itemID;
            } else if (this == oreLapis) {
                id_dropped = Item.dyePowder.itemID;
                metadata_dropped = 4;
                quantity_dropped = 3 + info.world.rand.nextInt(3);
            } else if (this == oreEmerald) {
                id_dropped = Item.emerald.itemID;
            } else if (this == oreNetherQuartz) {
                id_dropped = Item.netherQuartz.itemID;
            } else {
                id_dropped = this.blockID;
            }
        }

        if (metadata_dropped == -1) {
            metadata_dropped = id_dropped == this.blockID ? this.getItemSubtype(info.getMetadata()) : 0;
        }

        boolean suppress_fortune = id_dropped == this.blockID && BitHelper.isBitSet(info.getMetadata(), 1);
        if (id_dropped != -1 && info.getMetadata() == 0) {
            DedicatedServer.incrementTournamentScoringCounter(info.getResponsiblePlayer(), Item.getItem(id_dropped));
        }

        float chance = suppress_fortune ? 1.0F : 1.0F + (float)info.getHarvesterFortune() * 0.1F;
        int dx = 0, dy = 0, dz = 0, count = 0;
        int total = 0;
        for(dx = -1; dx <= 1; ++dx) {
            for(dy = -1; dy <= 1; ++dy) {
                for(dz = -1; dz <= 1; ++dz) {
//                    Block searchedBlock = info.world.getBlock(info.x + dx, info.y + dy, info.z + dz);
//                    if (searchedBlock != null && searchedBlock.blockID == id_dropped && searchedBlock.getItemSubtype(info.getMetadata()) == metadata_dropped) {
//                        info.world.setBlockToAir(info.x + dx, info.y + dy, info.z + dz);
//                        ++count;
//                    }
                    Block searchedBlock = info.world.getBlock(info.x + dx, info.y + dy, info.z + dz);
                    BlockBreakInfo entity_item = (new BlockBreakInfo(info.world, info.x + dx, info.y + dy, info.z + dz)).setHarvestedBy(info.getResponsiblePlayer());
                    if(searchedBlock != null && searchedBlock.blockID == this.blockID && entity_item.getMetadata() == metadata_dropped) {
                        if (info.world.setBlockToAir(info.x + dx, info.y + dy, info.z + dz))
                        {
                            total += super.dropBlockAsEntityItem(entity_item, id_dropped, metadata_dropped, quantity_dropped, chance);
                        }
                    }
                }
            }
        }
        return total;
    }
}
