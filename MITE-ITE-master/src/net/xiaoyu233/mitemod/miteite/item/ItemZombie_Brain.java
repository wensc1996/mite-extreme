package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Constant;

public class ItemZombie_Brain extends ItemFood {
    public ItemZombie_Brain(int par1) {
        super(par1, Material.meat, 0, 0, false, false, false, "zombie_brain");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(1.0F);
        this.setCreativeTab(CreativeModeTab.tabFood);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            if (Constant.GARandom.nextInt(100) < 90) {
                par3EntityPlayer.addPotionEffect(new MobEffect(MobEffectList.nightVision.id, 1800, 0));
            }
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 1, true);
        }
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isHarmedByFire() {
        return false;
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+1的饱和度", new Object[0]));
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+90几率90秒夜视", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("歪比歪比", new Object[0]));
        }

    }
}
