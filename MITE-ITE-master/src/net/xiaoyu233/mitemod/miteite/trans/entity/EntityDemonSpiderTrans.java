package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.*;

@Mixin(EntityDemonSpider.class)
public class EntityDemonSpiderTrans extends EntityArachnid {

    public EntityDemonSpiderTrans(World par1World) {
        super(par1World, 1.0F);
        this.tasks.addTask(4, new EntityAIGetOutOfLava(this, 1.0F));
    }
    @Override
    public int getExperienceValue() {
        if (Constant.GARandom.nextInt(100) < Configs.wenscConfig.MobDropValue.ConfigValue) {
            this.dropItem(Items.Spider_Leg);
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
