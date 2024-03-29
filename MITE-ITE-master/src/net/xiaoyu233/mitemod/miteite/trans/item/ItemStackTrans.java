package net.xiaoyu233.mitemod.miteite.trans.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.item.*;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import net.xiaoyu233.mitemod.miteite.util.ReflectHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mixin(ItemStack.class)
public class ItemStackTrans {
   @Shadow
   public int animationsToGo;
   @Shadow
   public int itemID;
   @Shadow
   public int stackSize;
   @Shadow
   public NBTTagCompound stackTagCompound;
   @Shadow
   private int damage;
   @Shadow
   private boolean is_artifact;
   @Shadow
   private EnumQuality quality;
   @Shadow
   private int subtype;
   private boolean toolNbtFixed;

   public ItemStackTrans(int id, int stack_size, int subtype) {
      this.itemID = id;
      this.stackSize = stack_size;
      this.setItemSubtype(subtype);
   }

   // 重复附魔的问题，书可以附魔的问题
   @Inject(method = "isEnchantable", at = @At("HEAD"), cancellable = true)
   public void isEnchantable(CallbackInfoReturnable callbackInfoReturnable) {
      if (this.getItem() == Item.book) {
         callbackInfoReturnable.setReturnValue(false);
         callbackInfoReturnable.cancel();
      }
   }

   @Inject(method = "splitStack", at = @At("RETURN"), cancellable = true)
   public void splitStack(CallbackInfoReturnable<ItemStack>callbackInfoReturnable) {
      ItemStack itemStack = callbackInfoReturnable.getReturnValue();
      callbackInfoReturnable.setReturnValue(itemStack);
      callbackInfoReturnable.cancel();
   }

   @Redirect(method = "getTooltip",at = @At(value = "INVOKE",target = "Lnet/minecraft/Translator;addToList(Lnet/minecraft/EnumChatFormat;Ljava/lang/String;Ljava/util/List;)V",ordinal = 0))
   private void removeChangeQualityInfo(EnumChatFormat enum_chat_formatting, String key, List list){
      //Do nothing to remove
      list.remove(list.size() - 1);
   }
   @Shadow
   public int getMaxStackSize() {
      return this.getItem().getItemStackLimit(this.subtype, this.damage);
   }

   @Shadow
   public boolean isItemEnchanted() {
      return this.stackTagCompound != null && this.stackTagCompound.hasKey("ench");
   }

   @Overwrite
   public boolean isRepairItem() {
      return this.getItem() instanceof ItemNugget || this.getItem() instanceof ItemRedstone;
   }

   @Shadow
   public NBTTagList getStoredEnchantmentTagList() {
      return null;
   }

   @Overwrite
   public ItemStack copy() {
      ItemStack var1 = new ItemStack(this.itemID, this.stackSize, this.subtype);
      var1.setItemDamage(this.damage);
      var1.setQuality(this.getQuality());
      var1.setIsArtifact(this.is_artifact);
      if (this.stackTagCompound != null) {
         var1.stackTagCompound = (NBTTagCompound)this.stackTagCompound.copy();
      }

      if (this.getItem().hasExpAndLevel()) {
         var1.fixNBT();
      }

      return ReflectHelper.dyCast(var1);
   }

   public void fixNBT() {
      if (!this.toolNbtFixed) {
         this.toolNbtFixed = true;
         if (this.stackTagCompound == null) {
            this.setTagCompound(new NBTTagCompound());
            this.stackTagCompound.setInteger("tool_level", 0);
            this.stackTagCompound.setInteger("tool_exp", 0);
            this.stackTagCompound.setCompoundTag("modifiers", new NBTTagCompound());
         } else if (!this.stackTagCompound.hasKey("tool_level")) {
            this.stackTagCompound.setInteger("tool_level", 0);
            this.stackTagCompound.setInteger("tool_exp", 0);
            this.stackTagCompound.setCompoundTag("modifiers", new NBTTagCompound());
         }

         if (this.stackTagCompound.hasKey("modifiers")) {
            NBTTagCompound compound = this.stackTagCompound.getCompoundTag("modifiers");
            int var3;
            int var4;
            float origin;
            if (this.getItem() instanceof ItemArmor) {
               if (!compound.hasNoTags()) {
                  ArmorModifierTypes[] var2 = ArmorModifierTypes.values();
                  var3 = var2.length;

                  for(var4 = 0; var4 < var3; ++var4) {
                     ArmorModifierTypes value = var2[var4];
                     if (compound.getTag(value.nbtName) instanceof NBTTagFloat) {
                        origin = compound.getFloat(value.nbtName);
                        compound.setInteger(value.nbtName, (int)(origin / value.levelAddition));
                     }
                  }
               }
            } else if (!compound.hasNoTags()) {
               ToolModifierTypes[] var7 = ToolModifierTypes.values();
               var3 = var7.length;

               for(var4 = 0; var4 < var3; ++var4) {
                  ToolModifierTypes value = var7[var4];
                  if (compound.getTag(value.nbtName) instanceof NBTTagFloat) {
                     origin = compound.getFloat(value.nbtName);
                     compound.setInteger(value.nbtName, (int)(origin / value.levelAddition));
                  }
               }
            }
         }
      }

   }

   @Overwrite
   public Multimap<String, AttributeModifier> getAttributeModifiers() {
      Multimap<String, AttributeModifier> var1 = HashMultimap.create();

      if (this.hasTagCompound() && this.stackTagCompound.hasKey("AttributeModifiers")) {
         NBTTagList var2 = this.stackTagCompound.getTagList("AttributeModifiers");

         for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            AttributeModifier var5 = GenericAttributes.func_111259_a(var4);
            if (var5.getID().getLeastSignificantBits() != 0L && var5.getID().getMostSignificantBits() != 0L) {
               var1.put(var4.getString("AttributeName"), var5);
            }
         }
      } else {
//         if(!(this.getItem() instanceof ItemRingKiller)) {
//
//         }
         var1.putAll(this.getItem().getAttrModifiers(ReflectHelper.dyCast(this)));
      }

      return var1;
   }

   public double getEnhanceFactor() {
      return Constant.ENHANCE_FACTORS[this.getForgingGrade()];
   }

   public int getForgingGrade() {
      return this.stackTagCompound != null ? this.stackTagCompound.getInteger("forging_grade") : 0;
   }

   public int getEmergencyCooldown(){
      return this.stackTagCompound != null && this.stackTagCompound.hasKey("emergencyCooldown") ? this.stackTagCompound.getInteger("emergencyCooldown") : 0;
   }

   public void setEmergencyCooldown(int cooldown){
      if (this.stackTagCompound == null) {
         this.stackTagCompound = new NBTTagCompound();
      }

      this.stackTagCompound.setInteger("emergencyCooldown", cooldown);
   }

   public void setForgingGrade(int grade) {
      if (this.stackTagCompound == null) {
         this.stackTagCompound = new NBTTagCompound();
      }

      this.stackTagCompound.setInteger("forging_grade", grade);
   }

   @Shadow
   private boolean getHasSubtypes() {
      return false;
   }

   @Shadow
   @Nonnull
   private Item getItem() {
      return null;
   }

   @Shadow
   private int getMaxDamage() {
      return 0;
   }

   public float getGemMaxNumeric(GemModifierTypes gemModifierTypes) {
      return (float) this.getGemMaxLevel(gemModifierTypes) * gemModifierTypes.getRate();
   }

   public void setGem(ItemStack gemStack, int index)
   {
      if (this.stackTagCompound == null)
      {
         this.setTagCompound(new NBTTagCompound());
      }
      if(!this.stackTagCompound.hasKey("Gems")){
         NBTTagList nbtTagList =  new NBTTagList("Gems");

         for (int i = 0; i < 8; i++) {
            NBTTagCompound var4  = new NBTTagCompound();
            var4.setShort("id", (short)-1);
            var4.setByte("meta", (byte)-1);
            nbtTagList.appendTag(var4);
         }
         this.stackTagCompound.setTag("Gems", nbtTagList);
      }
      NBTTagList nbtTagList =  this.stackTagCompound.getTagList("Gems");
      NBTTagCompound nbtTagCompound = (NBTTagCompound)nbtTagList.tagAt(index);

      nbtTagCompound.setShort("id", gemStack != null ? (short)gemStack.getItem().itemID : (short) -1);
      nbtTagCompound.setByte("meta",gemStack != null? (byte)gemStack.getItemSubtype() : (byte) -1);
   }

   public int getGemMaxLevel(GemModifierTypes gemModifierTypes) {
      // 在宝石里面寻找最大的
      int max = 0;
      if(this.stackTagCompound != null && this.stackTagCompound.hasKey("Gems")) {
         NBTTagList nbtTagList = this.stackTagCompound.getTagList("Gems");
         for (int i = 0; i < nbtTagList.tagCount(); i++) {
            NBTTagCompound nbtTagCompound = (NBTTagCompound) nbtTagList.tagAt(i);
            if (nbtTagCompound.getShort("id") >= 0 && nbtTagCompound.getByte("meta") >= 0) {
               Item item = Item.getItem(nbtTagCompound.getShort("id"));
               if (item instanceof ItemEnhanceGem) {
                  if (nbtTagCompound.getByte("meta") == gemModifierTypes.ordinal()) {
                     int level = ((ItemEnhanceGem) item).gemLevel;
                     if (level > max) {
                        max = level;
                     }
                  }
               }
            }
         }
      }
      return max;
   }

   @Overwrite
   public float getMeleeDamageBonus() {
      return this.getItem().getMeleeDamageBonus(ReflectHelper.dyCast(this)) + this.getGemMaxNumeric(GemModifierTypes.damage);
   }

   @Shadow
   @Nonnull
   private EnumQuality getQuality() {
      return null;
   }

   @Overwrite
   public float getStrVsBlock(Block block, int metadata) {
      return this.getItem().getStrVsBlock(block, metadata);
   }

   @Shadow
   private boolean hasTagCompound() {
      return false;
   }

   @Inject(method = "<init>(III)V",at = @At("RETURN"))
   private void injectCtorFix(CallbackInfo callback){
      if (this.getItem() != null){
         if (this.getItem().hasExpAndLevel()) {
            this.fixNBT();
         }
      }
   }

   @Inject(method = "setTagCompound",at = @At(value = "FIELD",target = "Lnet/minecraft/ItemStack;stackTagCompound:Lnet/minecraft/NBTTagCompound;",shift = At.Shift.AFTER))
   private void injectSetTagFix(CallbackInfoReturnable<ItemStack> callback){
      if (this.getItem().hasExpAndLevel()) {
         this.fixNBT();
      }
   }

   @Shadow
   private boolean isItemStackDamageable() {
      return false;
   }

   @Overwrite
   public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
      this.itemID = par1NBTTagCompound.getShort("id");
      this.stackSize = par1NBTTagCompound.getByte("Count");
      if (this.itemID <= 0) {
         (new Exception()).printStackTrace();
      }

      Item item;
      if (par1NBTTagCompound.hasKey("subtype")) {
         this.setItemSubtype(par1NBTTagCompound.getShort("subtype"));
         this.setItemDamage(par1NBTTagCompound.getInteger("damage"));
      } else {
         if (Minecraft.inDevMode()) {
            System.out.println("Importing item stack " + this.getItem() + ", id=" + this.itemID);
         }

         if (this.getItem().hasExpAndLevel() && this.stackTagCompound == null) {
            NBTTagCompound tagCompound = new NBTTagCompound();
            tagCompound.setInteger("tool_level", 0);
            tagCompound.setInteger("tool_exp", 0);
            tagCompound.setCompoundTag("modifiers", new NBTTagCompound());
            tagCompound.setInteger("forging_grade", 0);
            tagCompound.setInteger("emergencyCooldown",0);
            this.setTagCompound(tagCompound);
         }

         if (this.isItemStackDamageable() && this.getHasSubtypes()) {
            item = this.getItem();
            if (item instanceof ItemAnvil) {
               this.setItemSubtype(par1NBTTagCompound.getShort("Damage"));
            } else {
               Minecraft.setErrorMessage("Unhandled item import, setting damage for: " + this);
               this.setItemDamage(par1NBTTagCompound.getShort("Damage"));
            }
         } else if (this.isItemStackDamageable()) {
            this.setItemDamage(par1NBTTagCompound.getShort("Damage"));
         } else {
            this.setItemSubtype(par1NBTTagCompound.getShort("Damage"));
         }
      }

      if (par1NBTTagCompound.hasKey("tag")) {
         this.stackTagCompound = par1NBTTagCompound.getCompoundTag("tag");
         if (ItemReferencedBook.isReferencedBook(ReflectHelper.dyCast(this))) {
            this.setTagCompound(ItemReferencedBook.generateBookContents(ItemReferencedBook.getReferenceIndex(ReflectHelper.dyCast(this))));
         }
         if (this.getItem().hasExpAndLevel()) {
            this.fixNBT();
         }
      }

      item = this.getItem();
      if (item == null) {
         this.quality = null;
      } else {
         if (par1NBTTagCompound.hasKey("quality")) {
            this.setQuality(EnumQuality.values()[par1NBTTagCompound.getByte("quality")]);
         } else {
            this.setQuality(null);
         }

         if (this.isItemStackDamageable() && this.damage >= this.getMaxDamage()) {
            this.setItemDamage(this.getMaxDamage() - 1);
         }
      }

      this.is_artifact = par1NBTTagCompound.getBoolean("is_artifact");
   }

   public double getPrice() {
      return this.getItem().getPrice();
   }

   public void setIsArtifact(boolean is_artifact) {
      this.is_artifact = is_artifact;
   }

   @Shadow
   private ItemStack setItemDamage(int damage) {
      return null;
   }

   @Shadow
   private ItemStack setItemSubtype(int subtype) {
      return null;
   }

   @Shadow
   public ItemStack setQuality(EnumQuality quality) {
      return null;
   }

   @Shadow
   public ItemStack setTagCompound(NBTTagCompound par1NBTTagCompound) {
      return null;
   }
   @Shadow
   public NBTTagList getEnchantmentTagList() {
      return null;
   }

   public int getEnhanceTotalLevel() {
      int level = 0;
      if(this.getItem() instanceof ItemEnchantedBook) {
         NBTTagList nbtTagList = this.getStoredEnchantmentTagList();
         if(nbtTagList != null) {
            for(int var5 = 0; var5 < nbtTagList.tagCount(); ++var5) {
               NBTTagCompound var6 = (NBTTagCompound)nbtTagList.tagAt(var5);
               short var7 = var6.getShort("id");
               if(Enchantment.enchantmentsList[var7].getNumLevels() == 1) {
                  level += 5;
               } else {
                  level += var6.getShort("lvl");
               }
            }
         }
      } else {
         NBTTagList enchantments = this.getEnchantmentTagList();
         if(enchantments != null) {
            for(int i = 0; i < enchantments.tagCount(); ++i) {
               NBTTagCompound var6 = (NBTTagCompound)enchantments.tagAt(i);
               short var7 = var6.getShort("id");
               if(Enchantment.enchantmentsList[var7].getNumLevels() == 1) {
                  level += 5;
               } else {
                  level += var6.getShort("lvl");
               }
            }
         }
      }

      return level;
   }

   @Overwrite
   public NBTTagCompound writeToNBT(NBTTagCompound par1NBTTagCompound) {
      par1NBTTagCompound.setShort("id", (short)this.itemID);
      par1NBTTagCompound.setByte("Count", (byte)this.stackSize);
      par1NBTTagCompound.setInteger("damage", this.damage);
      par1NBTTagCompound.setShort("subtype", (short)this.subtype);
      NBTTagCompound effective_stackTagCompound;
      if (this.stackTagCompound != null) {
         effective_stackTagCompound = this.stackTagCompound;
         if (ItemReferencedBook.isReferencedBook(ReflectHelper.dyCast(this))) {
            effective_stackTagCompound = new NBTTagCompound();
            effective_stackTagCompound.setInteger("reference_index", ItemReferencedBook.getReferenceIndex(ReflectHelper.dyCast(this)));
         }

         if (!effective_stackTagCompound.hasKey("forging_grade")) {
            effective_stackTagCompound.setInteger("forging_grade", 0);
         }

         par1NBTTagCompound.setCompoundTag("tag", effective_stackTagCompound);
      } else if (this.getItem().hasExpAndLevel()) {
         effective_stackTagCompound = new NBTTagCompound();
         effective_stackTagCompound.setInteger("tool_level", 0);
         effective_stackTagCompound.setInteger("tool_exp", 0);
         effective_stackTagCompound.setCompoundTag("modifiers", new NBTTagCompound());
         effective_stackTagCompound.setInteger("forging_grade", 0);
         par1NBTTagCompound.setCompoundTag("tag", effective_stackTagCompound);
      }

      if (this.getItem().hasQuality()) {
         par1NBTTagCompound.setByte("quality", (byte)this.getQuality().ordinal());
      }

      if (this.is_artifact) {
         par1NBTTagCompound.setBoolean("is_artifact", this.is_artifact);
      }
      return par1NBTTagCompound;
   }
}
