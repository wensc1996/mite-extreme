package net.xiaoyu233.mitemod.miteite.ga;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;

public class BlockGotchaChest extends BlockEnderChest {
    public BlockGotchaChest(int par1) {
        super(par1);
        this.setMinHarvestLevel(0);
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, EnumFace face, float offset_x, float offset_y, float offset_z) {
        if (player.onServer()) {
            if (this.canOpenChest(world, x, y, z, player)) {
                InventoryEnderChestTrans inventory = player.getInventoryEnderChestTrans();
                TileEntityEnderChest tile_entity = (TileEntityEnderChest)world.getBlockTileEntity(x, y, z);
                if (inventory != null && tile_entity != null) {
                    inventory.setAssociatedChest(tile_entity);
                    player.displayGUIChest(x, y, z, inventory);
                }
            } else {
                world.playSoundAtBlock(x, y, z, "imported.random.chest_locked", 0.2F);
            }
        }
        return true;
    }
    @Override
    public int dropBlockAsEntityItem(BlockBreakInfo info) {
        return this.dropBlockAsEntityItem(info, Items.GABag.itemID, 0, 1, 1.0F);
    }
}
