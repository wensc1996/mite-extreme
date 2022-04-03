package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;

public class ItemGuilt5 extends Item {
    public ItemGuilt5(int par1) {
        super(par1, Material.diamond, "guilt5");
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeModeTab.tabMaterials);
        this.setCraftingDifficultyAsComponent(1.0E-9F);
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("七罪其五", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("Meliodas", new Object[0]));
        }

    }
}