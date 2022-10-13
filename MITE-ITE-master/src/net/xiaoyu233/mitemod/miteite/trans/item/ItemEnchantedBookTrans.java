package net.xiaoyu233.mitemod.miteite.trans.item;

import net.minecraft.Item;
import net.minecraft.ItemEnchantedBook;
import net.xiaoyu233.mitemod.miteite.item.Materials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEnchantedBook.class)
public class ItemEnchantedBookTrans extends Item {

    @Inject(method = "<init>", at=@At("RETURN"))
    public void changeMaterial(CallbackInfo callbackInfo) {
        this.setMaterial(Materials.vibranium);
    }
}
