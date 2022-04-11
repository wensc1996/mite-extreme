//package net.xiaoyu233.mitemod.miteite.trans.gui;
//
//import net.minecraft.axm;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(axm.class)
//public class GuiContainerCreativeTrans {
//
//
//    @Inject(method = "a", at=@At("HEAD"))
//    protected void a(float par1, int par2, int par3, CallbackInfo callbackInfo) {
//        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
//        for(StackTraceElement stackTraceElement : stackTraceElements) {
//            Minecraft.setErrorMessage("调用链创造:"+stackTraceElement.toString());
//        }
//    }
//
//}
