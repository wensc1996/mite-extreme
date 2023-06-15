package net.xiaoyu233.mitemod.miteite.trans;

import net.minecraft.EnumChatFormat;
import net.minecraft.Minecraft;
import net.minecraft.client.main.Main;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Minecraft.class)
public abstract class MinecraftTrans {

    @Overwrite
    public static String getVersionDescriptor(boolean include_formatting) {
        String red = include_formatting ? EnumChatFormat.RED.toString() : "";
        return "1.6.4-MITE" + "-Extreme-" + Constant.MITE_ITE_VERSION + (Main.is_MITE_DS ? "-DS" : "") + " overwrite by wensc,洛小雨" + (Minecraft
                .inDevMode() ? red + " DEV" : "");
    }

}
