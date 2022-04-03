package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityEnderman.class)
public class EntityEndermanTrans extends EntityMonster {
   public EntityEndermanTrans(World par1World) {
      super(par1World);
   }

   @Overwrite
   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      int day = this.getWorld() != null ? this.getWorld().getDayOfOverworld() : 0;
      this.getEntityAttribute(GenericAttributes.maxHealth).setAttribute(100.0D + day / 20D);
      this.getEntityAttribute(GenericAttributes.movementSpeed).setAttribute(0.3D);
      this.getEntityAttribute(GenericAttributes.attackDamage).setAttribute(30.0D + day / 20D);
   }

   public EntityDamageResult attackEntityAsMob(Entity target) {
      this.worldObj.setEntityState(this, EnumEntityState.golem_throw);
      EntityDamageResult result = target.attackEntityFrom(new Damage(DamageSource.causeMobDamage(this), (float)this.getEntityAttributeValue(GenericAttributes.attackDamage)));
      if (result != null && result.entityWasKnockedBack()) {
         target.motionY += 0.6D;
      }

      return result;
   }
   @Override
   public int getExperienceValue() {
      if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
         this.dropItem(Item.egg, Constant.GARandom.nextInt(3) + 1);
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
}
