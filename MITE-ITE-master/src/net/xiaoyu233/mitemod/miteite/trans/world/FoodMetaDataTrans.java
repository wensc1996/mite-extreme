//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.xiaoyu233.mitemod.miteite.trans.world;
import net.minecraft.EntityPlayer;
import net.minecraft.FoodMetaData;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(FoodMetaData.class)
public class FoodMetaDataTrans {
    @Shadow
    private EntityPlayer player;

    @Overwrite
    public int getNutritionLimit() {
        return Configs.wenscConfig.BlnNutrition.ConfigValue ? Math.max(Math.min(6 + this.player.getExperienceLevel() / 5 * 2, 200), 6) : Math.max(Math.min(6 + this.player.getExperienceLevel() / 5 * 2, 20), 6);
    }
}
