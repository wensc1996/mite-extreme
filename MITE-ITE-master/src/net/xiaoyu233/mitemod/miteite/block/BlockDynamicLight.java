package net.xiaoyu233.mitemod.miteite.block;

import net.minecraft.*;

public class BlockDynamicLight extends Block {
    public BlockDynamicLight(int par1)
    {
        super(par1, Material.air, (new BlockConstants()).setNeverHidesAdjacentFaces());
        this.setLightValue(1F);
        this.setTickRandomly(true);
        this.setMaxStackSize(1);
        this.setCushioning(0);
        this.setCreativeTab(CreativeModeTab.tabDecorations);
        this.setBlockUnbreakable();
        this.setBlockBounds(0,0,0,0,0,0, true);
    }

    public String getMetadataNotes()
    {
        return "light:0";
    }

    public boolean isValidMetadata(int metadata)
    {
        return metadata == 0;
    }


    public void addItemBlockMaterials(ItemBlock item_block)
    {
        item_block.addMaterial(new Material[] {Material.wood, Material.coal});
    }

    public boolean isSolid(boolean[] is_solid, int metadata)
    {
        return false;
    }

    public boolean isStandardFormCube(boolean[] is_standard_form_cube, int metadata)
    {
        return false;
    }

    public boolean canReplaceBlock(int metadata, Block existing_block, int existing_block_metadata) {
        return false;
    }

    public boolean isAlwaysReplaceable() {
        return false;
    }
}
