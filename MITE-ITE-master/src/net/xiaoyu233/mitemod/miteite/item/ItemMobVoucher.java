package net.xiaoyu233.mitemod.miteite.item;

import net.minecraft.*;

import java.util.List;

public class ItemMobVoucher extends Item {
    String entityName = "";
    public ItemMobVoucher(int id, String entityName) {
        super(id, Materials.diamond, "voucher/voucher_" + entityName);
        this.entityName = entityName;
        this.setMaxStackSize(8);
        this.setCreativeTab(CreativeModeTab.tabMaterials);
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            if(this.entityName == "core") {
                info.add(EnumChatFormat.BROWN + Translator.getFormatted("振金锭材料之一", new Object[0]));
                info.add(EnumChatFormat.BLUE + Translator.getFormatted("由怪物击杀凭证合成", new Object[0]));
            } else {
                info.add(EnumChatFormat.BROWN + Translator.getFormatted("振金核心材料之一", new Object[0]));
                info.add(EnumChatFormat.BLUE + Translator.getFormatted("击杀特定怪物1/5概率掉落", new Object[0]));
            }
        }
    }
}
