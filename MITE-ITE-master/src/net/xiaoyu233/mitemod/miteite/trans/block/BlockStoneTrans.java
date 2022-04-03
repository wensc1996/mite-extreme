//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.xiaoyu233.mitemod.miteite.trans.block;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.block.Blocks;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;


@Mixin(BlockStone.class)
public class BlockStoneTrans extends Block {

    public BlockStoneTrans(int par1) {
        super(par1, Material.stone, new BlockConstants());
        this.setCreativeTab(CreativeModeTab.tabBlock);
        this.setMaxStackSize(64);
    }

    public Block setBlockHardness(float resistance) {
        this.setMaxStackSize(64);
        // super.a(resistance / 10.0F); 经验
        return null;
    }

    public int dropBlockAsEntityItem(BlockBreakInfo info) {
//        int max = true;
//        int min = true;
        EntityPlayer MMPlayer = null;

        try {
            MMPlayer = info.getHarvester().getAsEntityPlayerMP();
        } catch (Exception var18) {
            var18.printStackTrace();
        }

        if (!info.wasExploded() && MMPlayer != null) {
            int x = info.x;
            int y = info.y;
            int z = info.z;
            int II = 0;
            int count = 0;
            int nowDamage = 0;
            int maxDamage = 0;

            try {
                II = info.getHarvesterItem().itemID;
                nowDamage = info.getHarvesterItemStack().getItemDamage();
                maxDamage = info.getHarvesterItemStack().getMaxDamage();
            } catch (Exception var17) {
                var17.printStackTrace();
            }

            if ((double)nowDamage < 0.9D * (double)maxDamage || II != Items.B_PICKAXE.itemID && II != Items.C_PICKAXE.itemID && II != Items.D_PICKAXE.itemID && II != Items.E_PICKAXE.itemID) {
                String var12;
                byte var13;
                int dx;
                if (II == Items.B_PICKAXE.itemID && info.y >= MathHelper.floor_double(MMPlayer.posY - (double)MMPlayer.yOffset)) {
                    var12 = MMPlayer.getDirectionFromYaw().toString();
                    var13 = -1;
                    switch(var12.hashCode()) {
                        case 2120701:
                            if (var12.equals("EAST")) {
                                var13 = 0;
                            }
                            break;
                        case 2660783:
                            if (var12.equals("WEST")) {
                                var13 = 1;
                            }
                            break;
                        case 74469605:
                            if (var12.equals("NORTH")) {
                                var13 = 2;
                            }
                            break;
                        case 79090093:
                            if (var12.equals("SOUTH")) {
                                var13 = 3;
                            }
                    }

                    label548:
                    switch(var13) {
                        case 0:
                            dx = 0;

                            while(true) {
                                if (dx > 2) {
                                    break label548;
                                }

                                if (info.world.getBlockId(x + dx, y, z) == 1) {
                                    info.world.setBlock(x + dx, y, z, 0, 8, 3);
                                    ++count;
                                }

                                ++dx;
                            }
                        case 1:
                            dx = -2;

                            while(true) {
                                if (dx > 0) {
                                    break label548;
                                }

                                if (info.world.getBlockId(x + dx, y, z) == 1) {
                                    info.world.setBlock(x + dx, y, z, 0, 8, 3);
                                    ++count;
                                }

                                ++dx;
                            }
                        case 2:
                            dx = -2;

                            while(true) {
                                if (dx > 0) {
                                    break label548;
                                }

                                if (info.world.getBlockId(x, y, z + dx) == 1) {
                                    info.world.setBlock(x, y, z + dx, 0, 8, 3);
                                    ++count;
                                }

                                ++dx;
                            }
                        case 3:
                            for(dx = 0; dx <= 2; ++dx) {
                                if (info.world.getBlockId(x, y, z + dx) == 1) {
                                    info.world.setBlock(x, y, z + dx, 0, 8, 3);
                                    ++count;
                                }
                            }
                    }
                }

                int dy;
                if (II == Items.C_PICKAXE.itemID && info.y >= MathHelper.floor_double(MMPlayer.posY - (double)MMPlayer.yOffset)) {
                    var12 = MMPlayer.getDirectionFromYaw().toString();
                    var13 = -1;
                    switch(var12.hashCode()) {
                        case 2120701:
                            if (var12.equals("EAST")) {
                                var13 = 0;
                            }
                            break;
                        case 2660783:
                            if (var12.equals("WEST")) {
                                var13 = 1;
                            }
                            break;
                        case 74469605:
                            if (var12.equals("NORTH")) {
                                var13 = 2;
                            }
                            break;
                        case 79090093:
                            if (var12.equals("SOUTH")) {
                                var13 = 3;
                            }
                    }

                    label518:
                    switch(var13) {
                        case 0:
                            for(dx = 0; dx <= 2; ++dx) {
                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x + dx, y + dy, z) == 1) {
                                        info.world.setBlock(x + dx, y + dy, z, 0, 8, 3);
                                        ++count;
                                    }
                                }
                            }
                            break;
                        case 1:
                            dx = -2;

                            while(true) {
                                if (dx > 0) {
                                    break label518;
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x + dx, y + dy, z) == 1) {
                                        info.world.setBlock(x + dx, y + dy, z, 0, 8, 3);
                                        ++count;
                                    }
                                }

                                ++dx;
                            }
                        case 2:
                            dx = -2;

                            while(true) {
                                if (dx > 0) {
                                    break label518;
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x, y + dy, z + dx) == 1) {
                                        info.world.setBlock(x, y + dy, z + dx, 0, 8, 3);
                                        ++count;
                                    }
                                }

                                ++dx;
                            }
                        case 3:
                            for(dx = 0; dx <= 2; ++dx) {
                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x, y + dy, z + dx) == 1) {
                                        info.world.setBlock(x, y + dy, z + dx, 0, 8, 3);
                                        ++count;
                                    }
                                }
                            }
                    }
                }

                if (II == Items.D_PICKAXE.itemID && info.y >= MathHelper.floor_double(MMPlayer.posY - (double)MMPlayer.yOffset)) {
                    var12 = MMPlayer.getDirectionFromYaw().toString();
                    var13 = -1;
                    switch(var12.hashCode()) {
                        case 2120701:
                            if (var12.equals("EAST")) {
                                var13 = 0;
                            }
                            break;
                        case 2660783:
                            if (var12.equals("WEST")) {
                                var13 = 1;
                            }
                            break;
                        case 74469605:
                            if (var12.equals("NORTH")) {
                                var13 = 2;
                            }
                            break;
                        case 79090093:
                            if (var12.equals("SOUTH")) {
                                var13 = 3;
                            }
                    }

                    label462:
                    switch(var13) {
                        case 0:
                            for(dx = 0; dx <= 2; ++dx) {
                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x + dx, y + dy, z) == 1) {
                                        info.world.setBlock(x + dx, y + dy, z, 0, 8, 3);
                                        ++count;
                                    }
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x + dx, y, z + dy) == 1) {
                                        info.world.setBlock(x + dx, y, z + dy, 0, 8, 3);
                                        ++count;
                                    }
                                }
                            }
                            break;
                        case 1:
                            dx = -2;

                            while(true) {
                                if (dx > 0) {
                                    break label462;
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x + dx, y + dy, z) == 1) {
                                        info.world.setBlock(x + dx, y + dy, z, 0, 8, 3);
                                        ++count;
                                    }
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x + dx, y, z + dy) == 1) {
                                        info.world.setBlock(x + dx, y, z + dy, 0, 8, 3);
                                        ++count;
                                    }
                                }

                                ++dx;
                            }
                        case 2:
                            dx = -2;

                            while(true) {
                                if (dx > 0) {
                                    break label462;
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x, y + dy, z + dx) == 1) {
                                        info.world.setBlock(x, y + dy, z + dx, 0, 8, 3);
                                        ++count;
                                    }
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x + dy, y, z + dx) == 1) {
                                        info.world.setBlock(x + dy, y, z + dx, 0, 8, 3);
                                        ++count;
                                    }
                                }

                                ++dx;
                            }
                        case 3:
                            for(dx = 0; dx <= 2; ++dx) {
                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x, y + dy, z + dx) == 1) {
                                        info.world.setBlock(x, y + dy, z + dx, 0, 8, 3);
                                        ++count;
                                    }
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    if (info.world.getBlockId(x + dy, y, z + dx) == 1) {
                                        info.world.setBlock(x + dy, y, z + dx, 0, 8, 3);
                                        ++count;
                                    }
                                }
                            }
                    }
                }

                if (II == Items.E_PICKAXE.itemID && info.y >= MathHelper.floor_double(MMPlayer.posY - (double)MMPlayer.yOffset)) {
                    var12 = MMPlayer.getDirectionFromYaw().toString();
                    var13 = -1;
                    switch(var12.hashCode()) {
                        case 2120701:
                            if (var12.equals("EAST")) {
                                var13 = 0;
                            }
                            break;
                        case 2660783:
                            if (var12.equals("WEST")) {
                                var13 = 1;
                            }
                            break;
                        case 74469605:
                            if (var12.equals("NORTH")) {
                                var13 = 2;
                            }
                            break;
                        case 79090093:
                            if (var12.equals("SOUTH")) {
                                var13 = 3;
                            }
                    }

                    int dz;
                    label388:
                    switch(var13) {
                        case 0:
                            for(dx = 0; dx <= 2; ++dx) {
                                for(dy = -1; dy <= 1; ++dy) {
                                    for(dz = -1; dz <= 1; ++dz) {
                                        if (info.world.getBlockId(x + dx, y + dy, z + dz) == 1) {
                                            info.world.setBlock(x + dx, y + dy, z + dz, 0, 8, 3);
                                            ++count;
                                        }
                                    }
                                }
                            }
                            break;
                        case 1:
                            dx = -2;

                            while(true) {
                                if (dx > 0) {
                                    break label388;
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    for(dz = -1; dz <= 1; ++dz) {
                                        if (info.world.getBlockId(x + dx, y + dy, z + dz) == 1) {
                                            info.world.setBlock(x + dx, y + dy, z + dz, 0, 8, 3);
                                            ++count;
                                        }
                                    }
                                }

                                ++dx;
                            }
                        case 2:
                            dx = -1;

                            while(true) {
                                if (dx > 1) {
                                    break label388;
                                }

                                for(dy = -1; dy <= 1; ++dy) {
                                    for(dz = -2; dz <= 0; ++dz) {
                                        if (info.world.getBlockId(x + dx, y + dy, z + dz) == 1) {
                                            info.world.setBlock(x + dx, y + dy, z + dz, 0, 8, 3);
                                            ++count;
                                        }
                                    }
                                }

                                ++dx;
                            }
                        case 3:
                            for(dx = -1; dx <= 1; ++dx) {
                                for(dy = -1; dy <= 1; ++dy) {
                                    for(dz = 0; dz <= 2; ++dz) {
                                        if (info.world.getBlockId(x + dx, y + dy, z + dz) == 1) {
                                            info.world.setBlock(x + dx, y + dy, z + dz, 0, 8, 3);
                                            ++count;
                                        }
                                    }
                                }
                            }
                    }
                }

                int M1;
                for(M1 = 0; M1 <= count; ++M1) {
                    if (Constant.GARandom.nextInt(100) == 0) {
                        if(Configs.wenscConfig.isDropBlueGem.ConfigValue) {
                            MMPlayer.dropItem(Items.Gem_Blue, 1);
                            MMPlayer.addExperience(100, true, true);
                        }
                        --count;
                    }
                }

                if (count > 0) {
                    M1 = Constant.GARandom.nextInt(100);
                    int M2 = Constant.GARandom.nextInt(80);
                    if (M1 == 0) {
                        MMPlayer.addChatMessage("a_pickaxe.msg." + M2);
                    }

                    MMPlayer.tryDamageHeldItem(DamageSource.generic, count * 240);
                    MMPlayer.StoneCount += (long)count;
                    MMPlayer.addExperience(count, true, true);
                }
            } else {
                MMPlayer.getWorld().playSoundAtEntity(MMPlayer, "imported.random.level_drain", 1.0F);
                MMPlayer.addChatMessage("a_pickaxe.msg.repair");
            }
        }
        if(Configs.wenscConfig.isDropBlueGem.ConfigValue && Configs.wenscConfig.isDropGAStones.ConfigValue) {
            return Constant.GARandom.nextInt(100) == 0 ? this.dropBlockAsEntityItem(info, Items.Gem_Blue.itemID) : this.dropBlockAsEntityItem(info, Items.Stones.itemID);
        } else if(Configs.wenscConfig.isDropBlueGem.ConfigValue) {
            if(Constant.GARandom.nextInt(100) == 0) {
                return this.dropBlockAsEntityItem(info, Items.Gem_Blue.itemID);
            } else {
                return this.dropBlockAsEntityItem(info, Blocks.cobblestone.blockID);
            }
        } else if(Configs.wenscConfig.isDropGAStones.ConfigValue) {
            return this.dropBlockAsEntityItem(info, Items.Stones.itemID);
        } else {
            return this.dropBlockAsEntityItem(info, Blocks.cobblestone.blockID);
        }
    }
}
