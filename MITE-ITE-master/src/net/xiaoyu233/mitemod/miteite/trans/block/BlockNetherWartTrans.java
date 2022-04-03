//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.xiaoyu233.mitemod.miteite.trans.block;

import java.util.Random;
import net.minecraft.BlockNetherWart;
import net.minecraft.BlockPlant;
import net.minecraft.World;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockNetherWart.class)
public class BlockNetherWartTrans extends BlockPlant {

    protected BlockNetherWartTrans(int par1) {
        super(par1);
    }

    public boolean updateTick(World world, int x, int y, int z, Random random) {
        if (super.updateTick(world, x, y, z, random)) {
            return true;
        } else {
            int metadata = world.getBlockMetadata(x, y, z);
            if (metadata < 3 && random.nextInt(8 * Configs.wenscConfig.netherWartDifficulty.ConfigValue) == 0) {
                ++metadata;
                return world.setBlockMetadata(x, y, z, metadata, 2);
            } else {
                return false;
            }
        }
    }

    public boolean canBePlacedAt(World world, int x, int y, int z, int metadata) {
        return super.canBePlacedAt(world, x, y, z, metadata);
    }

}
