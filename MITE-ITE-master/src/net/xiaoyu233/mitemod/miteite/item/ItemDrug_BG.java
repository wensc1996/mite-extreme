package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;

public class ItemDrug_BG extends ItemFood {
    public ItemDrug_BG(int par1) {
        super(par1, Material.chicken_soup, 1, 20, false, false, false, "drug_bg");
        this.setPotionEffect(MobEffectList.field_76443_y.id, 600, 0, 1.0F);
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(1.0F);
        this.setCreativeTab(CreativeModeTab.tabFood);
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
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("+600秒饱和", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("虚度周而复始的时光", new Object[0]));
        }

    }
}
