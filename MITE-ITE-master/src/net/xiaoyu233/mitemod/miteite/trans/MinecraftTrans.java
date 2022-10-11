package net.xiaoyu233.mitemod.miteite.trans;

import net.minecraft.ClientPlayer;
import net.minecraft.EnumChatFormat;
import net.minecraft.Minecraft;
import net.minecraft.client.main.Main;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = Minecraft.class, priority = 900)
public abstract class MinecraftTrans {

    @Shadow
    private static boolean in_dev_mode = false;
    @Shadow
    private static boolean dev_mode_key_exists;
    @Shadow
    public static void setErrorMessage(String text) {
    }
    @Shadow
    private static String getSecretErrorMessage() { return "";};

    @Shadow
    public static ClientPlayer getClientPlayer() {
        return null;
    }

    @Overwrite
    public static boolean inDevMode() {
        if (in_dev_mode && !dev_mode_key_exists)
        {
            setErrorMessage(getSecretErrorMessage());
            in_dev_mode = false;
        }
        return (in_dev_mode || (getClientPlayer() != null && getClientPlayer().isOp()));
    }

    @Overwrite
    public static String getVersionDescriptor(boolean include_formatting) {
        String red = include_formatting ? EnumChatFormat.RED.toString() : "";
        return "1.6.4-MITE" + "-Extreme-" + Constant.MITE_ITE_VERSION + (Main.is_MITE_DS ? "-DS" : "") + " overwrite by wensc " + (Minecraft
                .inDevMode() ? red + " DEV" : "");
    }

}
