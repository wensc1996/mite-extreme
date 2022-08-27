package net.xiaoyu233.mitemod.miteite.trans.container;

import net.minecraft.ContainerAnvil;
import net.minecraft.InventorySubcontainer;
import net.minecraft.ItemStack;

class vbNew extends InventorySubcontainer {
    ContainerAnvil repairContainer;
    vbNew(ContainerAnvil var1, String var2, boolean var3, int var4) {
        super(var2, var3, var4);
        this.repairContainer = var1;
    }

    public void onInventoryChanged() {
        super.onInventoryChanged();
        this.repairContainer.onCraftMatrixChanged(this);
    }

    public boolean isItemValidForSlot(int var1, ItemStack var2) {
        return true;
    }
}
