package net.xiaoyu233.mitemod.miteite.trans.container;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.ReflectHelper;
import org.apache.commons.lang3.StringUtils;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.Map;

@Mixin(ContainerAnvil.class)
public abstract class ContainerAnvilTrans extends Container {

    public ContainerAnvilTrans(EntityPlayer player) {
        super(player);
    }

    @Override
    @Shadow
    public boolean canInteractWith(EntityPlayer var1) {
        return false;
    }

    @Inject(method = "isRepairing",
            at = @At(value = "FIELD",target = "Lnet/minecraft/ContainerAnvil;repair_fail_condition:I",shift = At.Shift.AFTER,opcode = Opcodes.PUTFIELD),
    slice = @Slice(from = @At(value = "INVOKE",target = "Lnet/minecraft/Item;hasQuality()Z")))
    private void removeRepairExpReq(boolean b, CallbackInfoReturnable<Boolean> callbackInfo){
        this.repair_fail_condition = 0;
    }

    @Redirect(method = "updateRepairOutput",at = @At(value = "INVOKE",target = "Lnet/minecraft/ItemStack;isItemEnchanted()Z"))
    public boolean updateRepairOutput(ItemStack item_stack_in_first_slot) {
        return false;
    }
}
