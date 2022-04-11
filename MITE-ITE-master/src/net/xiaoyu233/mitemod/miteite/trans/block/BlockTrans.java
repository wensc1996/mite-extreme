package net.xiaoyu233.mitemod.miteite.trans.block;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.block.BlockColorful;
import net.xiaoyu233.mitemod.miteite.item.Materials;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import net.xiaoyu233.mitemod.miteite.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.lang.ref.Reference;

@Mixin(Block.class)
public abstract class BlockTrans {
   private double price = -1D;
   private boolean isCanBuy = false;

   @Shadow protected Block setResistance(float par1){
      return null;
   };

   public String getItemDisplayName(ItemStack itemStack){
      return ("" + LocaleI18n.translateToLocal(itemStack.getItem().getUnlocalizedNameInefficiently(itemStack) + ".name")).trim();
   }

   public Block setBlockCanBuy(boolean isCanBuy){
      return this.setCanBuy(isCanBuy);
   }

   public Block setCanBuy(boolean isCanBuy){
      this.isCanBuy = isCanBuy;
      return  (Block) ReflectHelper.dyCast(this);
   }

   public boolean getCanBuy(){
      return this.isCanBuy;
   }

   public double getPrice(){
      return this.price;
   }

   public Block setBlockPrice(double price){
      return this.setPrice(price);
   }

   public Block setPrice(double price){
      this.price = price;
      return (Block) ReflectHelper.dyCast(this);
   }

   public Block setBlockHardness(float resistance) {
      return this.setHardness(resistance);
   }

   public Block setExplosionResistance(float v) {
      return this.setResistance(v);
   }

   public Block setBlockLightLevel(float v){
      return this.setLightValue(v);
   }

   @Shadow
   protected Block setHardness(float par1) {
      return null;
   }

   @Shadow
   protected Block setLightValue(float exp) {
      return null;
   }

   public Block setResourceLocation(String location) {
      return this.setTextureName(location);
   }

   @Shadow
   protected Block setStepSound(StepSound par1StepSound) {
      return null;
   }

   public Block setStepSound_(StepSound stepSound) {
      return this.setStepSound(stepSound);
   }

   @Shadow
   protected Block setTextureName(String par1Str) {
      return null;
   }
}
