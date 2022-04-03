package net.xiaoyu233.mitemod.miteite.trans.item;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemRock.class)
public class ItemGemsTrans extends Item {
   @Overwrite
   public static int getExperienceValueWhenSacrificed(ItemStack item_stack) {
      Item item = item_stack.getItem();
      if (item == Item.dyePowder && item_stack.getItemSubtype() == 4) {
         return 40 * Configs.wenscConfig.RockExpValue.ConfigValue;
      } else {
         return item == netherQuartz ? Configs.wenscConfig.quartzExp.ConfigValue * Configs.wenscConfig.RockExpValue.ConfigValue
                 : (item == emerald ? Configs.wenscConfig.emeraldExp.ConfigValue * Configs.wenscConfig.RockExpValue.ConfigValue
                 : (item == diamond ? Configs.wenscConfig.diamondExp.ConfigValue * Configs.wenscConfig.RockExpValue.ConfigValue : 0));
      }
   }

   @Inject(
           method = "onItemRightClick(Lnet/minecraft/EntityPlayer;Lnet/minecraft/ItemStack;FZ)Z",
           at = @At(value = "INVOKE",
                   shift = At.Shift.BEFORE,
                   target = "Lnet/minecraft/EntityPlayer;causeBreakingItemEffect(Lnet/minecraft/Item;I)V"),
           cancellable = true)
   private static void injectNetherQuartzLimit(EntityPlayer player, ItemStack item_stack,float partial_tick,boolean ctrl_is_down,CallbackInfoReturnable<Boolean> callbackInfoReturnable){
      if (item_stack.getItem() == netherQuartz && player.getExperienceLevel() >= Configs.wenscConfig.quartzMaxExpLevel.ConfigValue) {
         callbackInfoReturnable.setReturnValue(false);
         callbackInfoReturnable.cancel();
      } else {
         int xp_value = getExperienceValueWhenSacrificed(item_stack);
         Item var10001 = item_stack.getItem();
         PlayerInventory var10002 = player.inventory;
         player.causeBreakingItemEffect(var10001, var10002.currentItem);
         if(ctrl_is_down) {
            player.setHeldItemStack(null);
            player.addExperience(xp_value*item_stack.stackSize);
         } else {
            player.convertOneOfHeldItem((ItemStack)null);
            player.addExperience(xp_value);
         }
         callbackInfoReturnable.setReturnValue(true);
         callbackInfoReturnable.cancel();
      }
   }
}
