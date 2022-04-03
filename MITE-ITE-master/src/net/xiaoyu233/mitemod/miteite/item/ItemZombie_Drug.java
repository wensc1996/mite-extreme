package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;

public class ItemZombie_Drug extends ItemFood {
    public ItemZombie_Drug(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "zombie_drug");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(1.0F);
        this.setCreativeTab(CreativeModeTab.tabFood);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new MobEffect(MobEffectList.nightVision.getId(), 7200, 0));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 3, true);
            par3EntityPlayer.getAsEntityPlayerMP().setPhytonutrients(par3EntityPlayer.getAsEntityPlayerMP().getPhytonutrients() + 2700);
        }

    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+3的饱和度", new Object[0]));
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+360秒夜视", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("用了就离不开它", new Object[0]));
        }

    }
}
