package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;

public class ItemColorBag extends Item {
    public ItemColorBag(int id, Material material, String texture) {
        super(id, material, texture);
        this.setMaxStackSize(64);
        this.setCraftingDifficultyAsComponent(getCraftingDifficultyAsComponent(material));
        this.setCreativeTab(CreativeModeTab.tabMaterials);
    }

    public static float getCraftingDifficultyAsComponent(Material material) {
        return 100.0F;
    }

    public static int getExperienceValueWhenSacrificed(ItemStack item_stack) {
//        Item item = item_stack.b();
        return 0;
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        return onItemRightClick(player, player.getHeldItemStack(), partial_tick, ctrl_is_down);
    }

    public static boolean onItemRightClick(EntityPlayer player, ItemStack item_stack, float partial_tick, boolean ctrl_is_down) {
        int xp_value = getExperienceValueWhenSacrificed(item_stack);
        if (player.onServer()) {
            player.causeBreakingItemEffect(item_stack.getItem(), player.inventory.currentItem);
            player.convertOneOfHeldItem((ItemStack)null);
            player.addExperience(xp_value);

            for(int i = 0; i < 16; ++i) {
                player.inventory.addItemStackToInventoryOrDropIt(new ItemStack(Item.dyePowder, 1, i));
            }
        } else {
            player.bobItem();
        }

        return true;
    }

    public void addInformation(ItemStack item_stack, EntityPlayer player, List info, boolean extended_info, Slot slot) {
        if (extended_info) {
            info.add(" ");
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("豪德寺三花的卡片", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("虹龙洞的隐秘道具", new Object[0]));
        }

    }
}
