package net.xiaoyu233.mitemod.miteite.trans.block;

import java.util.Random;
import net.minecraft.AchievementList;
import net.minecraft.Block;
import net.minecraft.BlockBreakInfo;
import net.minecraft.BlockConstants;
import net.minecraft.BlockFalling;
import net.minecraft.BlockGravel;
import net.minecraft.BlockSubtypes;
import net.minecraft.DedicatedServer;
import net.minecraft.IBlockWithSubtypes;
import net.minecraft.IIcon;
import net.minecraft.Item;
import net.minecraft.Material;
import net.minecraft.mt;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(BlockGravel.class)
public abstract class BlockGravelTrans extends BlockFalling implements IBlockWithSubtypes {

    public BlockGravelTrans(int par1) {
        super(par1, Material.sand, (new BlockConstants()).setUseNewSandPhysics());
    }

    @Overwrite
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (info.getMetadata() == 1) {
            return super.dropBlockAsEntityItem(info);
        } else if (!info.wasExploded() && info.wasHarvestedByPlayer()) {
            int fortune = info.getHarvesterFortune();
            if (fortune > 3) {
                fortune = 3;
            }
            Random rand = info.world.rand;
            int id_dropped;
            if (Configs.wenscConfig.BlnGravel.ConfigValue) {
                if (rand.nextInt(4 - fortune) > 2) {
                    return super.dropBlockAsEntityItem(info);
                }

                if (rand.nextInt(3) > 0) {
                    if (rand.nextInt(16) > 7) {
                        id_dropped = info.wasExploded() ? Item.chipFlint.itemID : Item.flint.itemID;
                    } else {
                        if (info.wasExploded()) {
                            return super.dropBlockAsEntityItem(info);
                        }

                        id_dropped = Item.copperNugget.itemID;
                    }
                } else if (rand.nextInt(2) > 0) {
                    id_dropped = Item.silverNugget.itemID;
                } else if (rand.nextInt(2) > 0) {
                    id_dropped = Item.goldNugget.itemID;
                } else if (rand.nextInt(2) > 0) {
                    id_dropped = info.wasExploded() ? -1 : Item.shardObsidian.itemID;
                } else if (rand.nextInt(2) > 0) {
                    id_dropped = info.wasExploded() ? -1 : Item.shardEmerald.itemID;
                } else if (rand.nextInt(2) > 0) {
                    id_dropped = info.wasExploded() ? -1 : Item.shardDiamond.itemID;
                } else if (rand.nextInt(2) > 0) {
                    id_dropped = Item.mithrilNugget.itemID;
                } else if (rand.nextInt(2) > 0) {
                    id_dropped = Item.adamantiumNugget.itemID;
                } else {
                    id_dropped = Items.VIBRANIUM_NUGGET.itemID;
                }
            } else {
                if (rand.nextInt(12 - fortune * 2) > 2) {
                    return super.dropBlockAsEntityItem(info);
                }

                if (rand.nextInt(3) > 0) {
                    if (rand.nextInt(16) == 0) {
                        id_dropped = info.wasExploded() ? Item.chipFlint.itemID : Item.flint.itemID;
                    } else {
                        if (info.wasExploded()) {
                            return super.dropBlockAsEntityItem(info);
                        }

                        id_dropped = Item.chipFlint.itemID;
                    }
                } else if (rand.nextInt(3) > 0) {
                    id_dropped = Item.copperNugget.itemID;
                } else if (rand.nextInt(3) > 0) {
                    id_dropped = Item.silverNugget.itemID;
                } else if (rand.nextInt(3) > 0) {
                    id_dropped = Item.goldNugget.itemID;
                } else if (rand.nextInt(3) > 0) {
                    id_dropped = info.wasExploded() ? -1 : Item.shardObsidian.itemID;
                } else if (rand.nextInt(3) > 0) {
                    id_dropped = info.wasExploded() ? -1 : Item.shardEmerald.itemID;
                } else if (rand.nextInt(3) > 0) {
                    id_dropped = info.wasExploded() ? -1 : Item.shardDiamond.itemID;
                } else if (rand.nextInt(3) > 0) {
                    id_dropped = Item.mithrilNugget.itemID;
                } else {
                    id_dropped = Item.adamantiumNugget.itemID;
                }
            }

            if (this.isNetherGravel(info.getMetadata())) {
                if (id_dropped != Item.copperNugget.itemID && id_dropped != Item.silverNugget.itemID && id_dropped != Item.mithrilNugget.itemID && id_dropped != Item.adamantiumNugget.itemID) {
                    if (id_dropped == Item.shardObsidian.itemID || id_dropped == Item.shardEmerald.itemID || id_dropped == Item.shardDiamond.itemID) {
                        id_dropped = Item.shardNetherQuartz.itemID;
                    }
                } else {
                    id_dropped = Item.goldNugget.itemID;
                }
            }

            if (id_dropped != -1) {
                DedicatedServer.incrementTournamentScoringCounter(info.getResponsiblePlayer(), Item.getItem(id_dropped));
            }

            if (info.wasHarvestedByPlayer() && (id_dropped == Item.chipFlint.itemID || id_dropped == Item.flint.itemID)) {
                info.getResponsiblePlayer().triggerAchievement(AchievementList.flintFinder);
            }

            return this.dropBlockAsEntityItem(info, id_dropped);
        } else {
            return super.dropBlockAsEntityItem(info);
        }
    }
    @Shadow
    public boolean isNetherGravel(int metadata) {
        return isNetherGravel(this, metadata);
    }
    @Shadow
    public static boolean isNetherGravel(Block block, int metadata) {
        return block == gravel && block.getBlockSubtype(metadata) == 1;
    }
}
