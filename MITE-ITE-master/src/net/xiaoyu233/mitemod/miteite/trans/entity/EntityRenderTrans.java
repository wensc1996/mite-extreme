package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityRenderer.class)
public class EntityRenderTrans {
    public EntityRenderTrans(Minecraft par1Minecraft) {

    }
    @Overwrite
    private float a(EntityPlayer par1EntityPlayer, float par2) {
//        int var3 = par1EntityPlayer.getActivePotionEffect(MobEffectList.nightVision).getDuration();
//        return var3 > 200 ? 1.0F : 0.7F + MathHelper.sin(((float)var3 - par2) * 3.1415927F * 0.2F) * 0.3F;
//       // MathHelper.sin(((float)100 - par2) * 3.1415927F * 0.2F) * 0.3F
        return 0.3F;
    }
}
