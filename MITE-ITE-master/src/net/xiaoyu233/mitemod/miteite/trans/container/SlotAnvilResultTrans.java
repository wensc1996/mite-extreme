package net.xiaoyu233.mitemod.miteite.trans.container;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net/minecraft/SlotAnvilResult")
public abstract class SlotAnvilResultTrans extends Slot {
    @Shadow
    final ContainerAnvil repairContainer = null;

    public SlotAnvilResultTrans(IInventory inventory, int slot_index, int display_x, int display_y) {
        super(inventory, slot_index, display_x, display_y);
    }

    public SlotAnvilResultTrans(IInventory inventory, int slot_index, int display_x, int display_y, boolean accepts_large_items) {
        super(inventory, slot_index, display_x, display_y, accepts_large_items);
    }

    @Inject(method = "onPickupFromSlot", at = @At("RETURN"))
    public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack, CallbackInfo callbackInfo) {
        par1EntityPlayer.addChatMessage("经验前：" + par1EntityPlayer.experience);
        ItemStack var1 = repairContainer.getSlot(0).getStack();
        ItemStack var2 = repairContainer.getSlot(1).getStack();
        if(var1 != null && var2 != null && var2.getItem() instanceof ItemEnchantedBook) {
            par1EntityPlayer.experience -= (var1.getEnhanceTotalLevel() + var2.getEnhanceTotalLevel()) * 1000;
        }
        par1EntityPlayer.addChatMessage("经验后：" + par1EntityPlayer.experience);
    }
}
