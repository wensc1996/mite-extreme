package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityCreeper.class)
public class EntityCreeperTrans extends EntityMonster {
   @Shadow
   protected float explosionRadius;
   @Shadow
   private int fuseTime;

   public EntityCreeperTrans(World par1World) {
      super(par1World);
   }

   @Overwrite
   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      int day = this.getWorld() != null ? Math.max(this.getWorld().getDayOfOverworld(), 0) : 0;
      this.setEntityAttribute(GenericAttributes.movementSpeed).setAttribute(0.25D);
      this.setEntityAttribute(GenericAttributes.maxHealth, 20 + (double)day / 8.0D);
      this.setEntityAttribute(GenericAttributes.followRange, 64.0D);
   }

   @Inject(method = "<init>",at = @At("RETURN"))
   private void injectInit(CallbackInfo callbackInfo){
      int day = this.getWorld() != null ? Math.max(this.getWorld().getDayOfOverworld(), 0) : 0;
      this.explosionRadius = 1.25f;
      this.setExplosionTime(Math.max(this.getExplosionTime() * 3 - (int)((double)day * 0.6D), 40));
   }
   @Override
   public int getExperienceValue() {
      if(Configs.wenscConfig.isDropCreeper.ConfigValue) {
         if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
            this.dropItem(Items.Creeper_Baby);
         }
      }

      int baseExp = 5;
      int day = Math.max(this.getWorld().getDayOfWorld(), 1);
      int Temp = baseExp * day;
      int exp1 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
      int level = 0;
      if (this.getLastHarmingEntity() instanceof EntityPlayer) {
         level = this.getLastHarmingEntity().getAsPlayer().getExperienceLevel();
      }

      Temp = baseExp * Math.max(level, 1);
      int exp2 = Math.min(Temp, Configs.wenscConfig.ExpModifier.ConfigValue) * Configs.wenscConfig.MobExpValue.ConfigValue / 100;
      if (Configs.wenscConfig.ExpMod.ConfigValue.equals("1")) {
         return exp1;
      } else {
         return Configs.wenscConfig.ExpMod.ConfigValue.equals("2") ? exp2 : baseExp;
      }
   }

   public int getExplosionTime() {
      return this.fuseTime;
   }

   public void setExplosionTime(int br) {
      this.fuseTime = br;
   }
}
