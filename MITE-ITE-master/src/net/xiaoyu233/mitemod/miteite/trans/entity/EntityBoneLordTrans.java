package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.MonsterUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityBoneLord.class)
public class EntityBoneLordTrans extends EntitySkeletonTrans {
   public EntityBoneLordTrans(World par1World) {
      super(par1World);
   }

   @Overwrite
   protected void addRandomEquipment() {
      this.addRandomWeapon();
      int day = this.getWorld() != null ? Math.max(this.getWorld().getDayOfOverworld(), 0) : 0;
      if (day < 96) {
         this.setBoots((new ItemStack(Item.bootsIron)).randomizeForMob(this, true));
         this.setLeggings((new ItemStack(Item.legsIron)).randomizeForMob(this, true));
         this.setCuirass((new ItemStack(Item.plateIron)).randomizeForMob(this, true));
         this.setHelmet((new ItemStack(Item.helmetIron)).randomizeForMob(this, true));
      } else {
         MonsterUtil.addDefaultArmor(day, this, true);
      }
      this.initStockedWeapon();

   }

   @Override
   protected boolean willChangeWeapon() {
      return Configs.wenscConfig.boneLordAndLongdeadChangeWeaponChance.ConfigValue > this.rand.nextFloat();
   }

   @Overwrite
   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      boolean boneLordTweak = Configs.wenscConfig.boneLordTweak.ConfigValue;
      int day = this.getWorld() != null ? this.getWorld().getDayOfOverworld() : 0;
      this.setEntityAttribute(GenericAttributes.followRange, 44.0D);
      this.setEntityAttribute(GenericAttributes.movementSpeed, 0.27000001072883606D);
      this.setEntityAttribute(GenericAttributes.attackDamage, boneLordTweak ? 10 + day /20D : 3.5D);
      this.setEntityAttribute(GenericAttributes.maxHealth, boneLordTweak ? 35 + day / 16D : 22.0D);
   }

   protected void enchantEquipment(ItemStack item_stack) {
      if ((double)this.getRNG().nextFloat() <= 0.2D + (double)this.getWorld().getDayOfOverworld() / 64.0D / 10.0D) {
         EnchantmentManager.addRandomEnchantment(this.getRNG(), item_stack, (int)(5.0F + (float)((this.getRNG().nextInt(15 + this.getWorld().getDayOfOverworld() / 24) + 3) / 10) * (float)this.getRNG().nextInt(18)));
      }

   }

//   @Overwrite
//   public int getExperienceValue() {
//      return Configs.Entities.BONE_LORD_TWEAK.get() ? super.getExperienceValue() * 6 : super.getExperienceValue() * 3;
//   }

   @Override
   public int getExperienceValue() {
      int baseExp = 30;
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
