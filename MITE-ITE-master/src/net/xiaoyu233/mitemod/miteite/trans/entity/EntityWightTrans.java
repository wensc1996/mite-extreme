package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EntityWight.class)
public class EntityWightTrans extends EntityMonster {

    public EntityWightTrans(World par1World) {
        super(par1World);
    }
    @Override
    public int getExperienceValue() {
        int baseExp = 10;
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