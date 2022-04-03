package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Configs;

public class ItemZombie_Soup extends ItemFood {
    public ItemZombie_Soup(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "zombie_soup");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(1.0F);
        this.setCreativeTab(CreativeModeTab.tabFood);
    }

    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return Configs.wenscConfig.enchantedGoldenAppleEatTime.ConfigValue;
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new MobEffect(MobEffectList.heal.id, 300, 0));
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 8, true);
            par3EntityPlayer.getFoodStats().setNutrition(par3EntityPlayer.getNutrition() + 4, true);
        }
    }

    public boolean isHarmedByPepsin() {
        return false;
    }

    public boolean isHarmedByAcid() {
        return false;
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+8的饱和度", new Object[0]));
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+4的饱食度", new Object[0]));
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+15秒瞬间回血", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("信春哥!", new Object[0]));
        }
    }
}
