package net.xiaoyu233.mitemod.miteite.trans.block;

import net.minecraft.BlockBreakInfo;
import net.minecraft.BlockLongGrass;
import net.minecraft.BlockPlant;
import net.minecraft.EntityPlayer;
import net.minecraft.EnumEntityFX;
import net.minecraft.Item;
import net.minecraft.Material;
import net.minecraft.World;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BlockLongGrass.class)
public class BlockLongGrassTrans extends BlockPlant {

    protected BlockLongGrassTrans(int id) {
        super(id, Material.grass);
        float size = 0.4F;
        this.setBlockBoundsForAllThreads((double)(0.5F - size), 0.0D, (double)(0.5F - size), (double)(0.5F + size), 0.800000011920929D, (double)(0.5F + size));
    }
    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        if (!info.wasSelfDropped() && !info.wasNotLegal()) {
            if (info.wasHarvestedByPlayer() && this.getItemSubtype(info.getMetadata()) == 1) {
                int check = Constant.GARandom.nextInt(100);
                EntityPlayer MMPlayer = info.getResponsiblePlayer().getAsEntityPlayerMP();
                if (check == 0) {
                    return this.dropBlockAsEntityItem(info, Item.pumpkinSeeds.itemID, 0, 1, 1.0F);
                } else if (check == 1) {
                    return this.dropBlockAsEntityItem(info, Item.pumpkinSeeds.itemID, 0, 1, 1.0F);
                } else {
                    if (check == 3 && MMPlayer.hasFullHealth()) {
                        MMPlayer.setHealth(MMPlayer.getHealthLimit() - 1.0F, true, (EnumEntityFX)null);
                        MMPlayer.getWorld().playSoundAtEntity(MMPlayer, "imported.random.level_drain", 1.0F);
                        MMPlayer.addChatMessage("grass.snake.msg");
                    }
                    return this.dropBlockAsEntityItem(info, Item.seeds.itemID, 0, 1, 1.0F);
                }
            } else {
                return 0;
            }
        } else {
            return super.dropBlockAsEntityItem(info);
        }
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        if (world.getBlockId(x, y - 1, z) == dirt.blockID) {
            world.setBlock(x, y - 1, z, BlockLongGrass.grass.blockID);
        }

    }
}
