//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.xiaoyu233.mitemod.miteite.trans.world;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.block.Blocks;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.SoftOverride;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DedicatedServer.class)
public class DedicatedServerTrans {

    public DedicatedServerTrans() {}

    @Inject(method = "playerLoggedIn",at = @At("RETURN"))
    public void playerLoggedIn(ServerPlayer par1EntityPlayerMP, CallbackInfo callbackInfo) {
        par1EntityPlayerMP.sendChatToPlayer(ChatMessage.createFromTranslationKey("[MITE-Extreme]:").setColor(EnumChatFormat.WHITE)
                .appendComponent(ChatMessage.createFromTranslationKey("MITE-Extreme由 ")
                        .appendComponent(ChatMessage.createFromTranslationKey("wensc").setColor(EnumChatFormat.WHITE)))
                .addText(" 重写,开放下载地址:").setColor(EnumChatFormat.DARK_RED)
                .appendComponent(ChatMessage.createFromTranslationKey("https://www.wensc.cn").setColor(EnumChatFormat.DARK_GREEN)));
        if (par1EntityPlayerMP.isFirstLogin == true) {
            par1EntityPlayerMP.isFirstLogin = false;
        }
        this.updatePlayersFile();
    }
    @Shadow
    public void updatePlayersFile() {
    }
}
