//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;

public class ItemCreeper_Baby extends ItemFood {
    public ItemCreeper_Baby(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "creeper_baby");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(1.0F);
        this.setCreativeTab(CreativeModeTab.tabFood);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new MobEffect(MobEffectList.digSpeed.id, 10800, 0));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 1, true);
        }

    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+1的饱和度", new Object[0]));
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+540秒急迫I", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("Bom!", new Object[0]));
        }

    }
}
