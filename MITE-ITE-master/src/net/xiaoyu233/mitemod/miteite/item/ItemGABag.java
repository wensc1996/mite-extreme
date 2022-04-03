package net.xiaoyu233.mitemod.miteite.item;

import java.util.List;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.block.Blocks;

public class ItemGABag extends ItemIngot {
    private int a;

    public ItemGABag(int par1, Material material) {
        super(par1, material);
        this.a = Blocks.GotchaBox.blockID;
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeModeTab.tabMaterials);
        this.setCraftingDifficultyAsComponent(getCraftingDifficultyAsComponent(material));
    }

    public boolean onItemRightClick(EntityPlayer player, float partial_tick, boolean ctrl_is_down) {
        RaycastCollision rc = player.getSelectedObject(partial_tick, false);
        if (rc != null && rc.isBlock()) {
            return player.worldObj.areSkillsEnabled() && this.a == Blocks.GotchaBox.blockID && !player.hasSkill(Skill.FARMING) ? false : player.tryPlaceHeldItemAsBlock(rc, Block.getBlock(this.a));
        } else {
            return false;
        }
    }

    public boolean tryPlaceAsBlock(RaycastCollision rc, Block block, EntityPlayer player, ItemStack item_stack) {
        if (block == Block.netherrack) {
            int x;
            int y;
            int z;
            if (rc.getBlockHit() == block) {
                x = rc.block_hit_x;
                y = rc.block_hit_y;
                z = rc.block_hit_z;
                ++y;
            }

            x = rc.neighbor_block_x;
            y = rc.neighbor_block_y;
            z = rc.neighbor_block_z;
            if (rc.world.getBlock(x, y, z) != block) {
                return super.tryPlaceAsBlock(rc, block, player, item_stack);
            }

            if (block.isLegalAt(rc.world, rc.block_hit_x, rc.block_hit_y, rc.block_hit_z, 0) && block.canReplaceBlock(0, rc.getBlockHit(), rc.block_hit_metadata)) {
                return super.tryPlaceAsBlock(rc, block, player, item_stack);
            }

            ++y;
            if (Block.netherrack.tryPlaceBlock(rc.world, x, y, z, EnumFace.TOP, 0, player, true, true)) {
                return true;
            }
        }

        return super.tryPlaceAsBlock(rc, block, player, item_stack);
    }

    public boolean canCatchFire() {
        return false;
    }

    public boolean isHarmedByFire() {
        return false;
    }

    public boolean isHarmedByLava() {
        return false;
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
            info.add(EnumChatFormat.BROWN + Translator.getFormatted("方便又好用", new Object[0]));
            info.add(EnumChatFormat.DARK_PURPLE + Translator.getFormatted("大家都说好", new Object[0]));
        }

    }
}
