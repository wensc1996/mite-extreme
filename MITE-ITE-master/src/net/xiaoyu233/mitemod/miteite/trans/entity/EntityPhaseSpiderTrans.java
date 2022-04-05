package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.Items;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityPhaseSpider.class)
public class EntityPhaseSpiderTrans extends EntityWoodSpider {

    public EntityPhaseSpiderTrans(World world) {
        super(world);
    }


}