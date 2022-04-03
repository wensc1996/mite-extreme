package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.SoftOverride;

@Mixin(EntityLongdeadGuardian.class)
public class EntityLongdeadGuardianTrans extends EntityLongdeadTrans {
   public EntityLongdeadGuardianTrans(World world) {
      super(world);
   }

   @Overwrite
   public void addRandomWeapon() {
      super.addRandomWeapon();
   }

   @Overwrite
   public void onLivingUpdate() {
      super.onLivingUpdate();
   }

   @Overwrite
   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
      super.readEntityFromNBT(par1NBTTagCompound);
   }

   @Overwrite
   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
      super.writeEntityToNBT(par1NBTTagCompound);
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
   }

   @SoftOverride
   protected void enchantEquipment(ItemStack item_stack) {
      if ((double)this.getRNG().nextFloat() <= 0.2D + (double)this.getWorld().getDayOfOverworld() / 64.0D / 10.0D) {
         EnchantmentManager.addRandomEnchantment(this.getRNG(), item_stack, (int)(5.0F + (float)(this.getRNG().nextInt(15 + this.getWorld().getDayOfOverworld() / 32) / 10) * (float)this.getRNG().nextInt(18)));
      }

   }

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
