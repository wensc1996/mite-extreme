package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntitySpider.class)
public class EntitySpiderTrans extends EntityArachnid {

   public EntitySpiderTrans(World par1World, float scaling) {
      super(par1World, scaling);
   }

   @Override
   public int getExperienceValue() {
      if(Configs.wenscConfig.isDropSpiderLegs.ConfigValue) {
         if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
            this.dropItem(Items.Spider_Leg);
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

   @Overwrite
   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      int day = this.getWorld() != null ? Math.max(this.getWorld().getDayOfOverworld() - 32, 0) : 0;
      this.setEntityAttribute(GenericAttributes.maxHealth, this.getEntityAttributeValue(GenericAttributes.maxHealth) * 1.5D + (double)day / 24.0D);
      this.setEntityAttribute(GenericAttributes.attackDamage, this.getEntityAttributeValue(GenericAttributes.attackDamage) + (double)day / 24.0D);
      this.setEntityAttribute(GenericAttributes.followRange, 64.0D);
   }
}
