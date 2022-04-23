package net.xiaoyu233.mitemod.miteite.trans.gui;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.network.CPacketSyncItems;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(axv.class)
public class GuiPlayerInventory extends axp {
   public GuiPlayerInventory(EntityPlayer par1EntityPlayer) {
      super(par1EntityPlayer.inventoryContainer);
      this.j = true;
      par1EntityPlayer.addStat(AchievementList.openInventory, 1);
      par1EntityPlayer.incrementStatForThisWorldFromClient(AchievementList.openInventory);
      par1EntityPlayer.sendPacket(new CPacketSyncItems());
   }

   @Inject(method = "a(FII)V", at = @At("HEAD"))
   protected void InjectA(float par1, int par2, int par3, CallbackInfo callbackInfo) {
      this.c = 208;
   }

   public void  b(int par1,
                  int par2,
                  int par3,
                  int par4,
                  int par5,
                  int par6){
      if(par3 == 176) {
         super.b(par1, par2, 145, 200, par5, par6);
      } else {
         super.b(par1, par2, par3, par4, par5, par6);
      }
   }

   @Shadow
   protected void a(float v, int i, int i1) {
   }
}
