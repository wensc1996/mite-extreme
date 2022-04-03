package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Constant;

public class ItemSpider_Leg extends ItemFood {
    public ItemSpider_Leg(int par1) {
        super(par1, Material.chicken_soup, 0, 0, false, false, false, "spider_leg");
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(1.0F);
        this.setCreativeTab(CreativeModeTab.tabFood);
    }

    protected void onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
        if (!par2World.isRemote) {
            int Buff = Constant.GARandom.nextInt(100);
            if (Buff < 25) {
                par3EntityPlayer.addPotionEffect(new MobEffect(MobEffectList.moveSpeed.id, 7200, 2));
            }
//            int k = EnchantmentManager.getEnchantmentLevel(Enchantment.speed, par3EntityPlayer.bn.b[0]);
//            if (k > 0 && Constant.GARandom.nextInt(100) < k) {
//                par3EntityPlayer.dropItem(Items.Powder_Feng.cv, 1, 1.0F);
//            }
            par3EntityPlayer.getFoodStats().setSatiation(par3EntityPlayer.getSatiation() + 1, true);
        }

    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+1的饱和度", new Object[0]));
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+百分之25几率360秒急速", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("幽魂之地的特产", new Object[0]));
        }

    }
}
