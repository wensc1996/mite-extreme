package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;

public class ItemBadApple extends Item {
    public ItemBadApple(int par1) {
        super(par1, Material.seed, "bad_apple");
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeModeTab.tabMaterials);
        this.setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("BAD APPLE ! !", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("Lotus Land Story", new Object[0]));
        }

    }
}
