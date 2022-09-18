package net.xiaoyu233.mitemod.miteite.trans.entity;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.*;

@Mixin(EntityVillager.class)
public abstract class EntityVillagerTrans extends EntityAgeable implements IMerchant, NPC {
   @Shadow private boolean isMating;
   @Shadow
   private MerchantRecipeList buyingList;
   @Shadow
   private float field_82191_bN;

   private Object [] villagerEnhanceBookList = Arrays.stream(Enchantment.enchantmentsBookList).filter(enhance -> enhance.getNumLevels() > 1).toArray();


   public EntityVillagerTrans(World par1World) {
      super(par1World);
   }

   @Shadow
   private static void addBlacksmithItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3) {
   }

   @Shadow
   private static void addMerchantItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3) {
   }

   private static void forEmeraldShard(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3) {
      if (par2Random.nextFloat() < par3) {
         par0MerchantRecipeList.add(new MerchantRecipe(new ItemStack(par1, Configs.wenscConfig.villagerWoolToEmeraldShardCount.ConfigValue), new ItemStack(Item.shardEmerald, Configs.wenscConfig.villagerWoolToEmeraldShardShardCount.ConfigValue)));
      }
   }

   @Shadow
   private static ItemStack getRandomSizedStack(int par0, Random par1Random) {
      return new ItemStack(1);
   }

   @Shadow
   public void a(MerchantRecipeList merchantRecipeList) {
   }

   @Overwrite
   private void addDefaultEquipmentAndRecipies(int par1) {
      if (this.buyingList != null) {
         this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
      } else {
         this.field_82191_bN = 0.0F;
      }

      MerchantRecipeList var2;
      var2 = new MerchantRecipeList();
      int var6;
      label51:
      switch(this.getProfession()) {
      case 0:
         addMerchantItem(var2, Item.wheat.itemID, this.rand, this.adjustProbability(0.9F));
         forEmeraldShard(var2, Block.cloth.blockID, this.rand, this.adjustProbability(0.5F));
         addMerchantItem(var2, Item.chickenRaw.itemID, this.rand, this.adjustProbability(0.5F));
         addMerchantItem(var2, Item.fishCooked.itemID, this.rand, this.adjustProbability(0.4F));
         addBlacksmithItem(var2, Item.bread.itemID, this.rand, this.adjustProbability(0.9F));
         addBlacksmithItem(var2, Item.melon.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.appleRed.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.cookie.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.shears.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.flintAndSteel.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.chickenCooked.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.arrowFlint.itemID, this.rand, this.adjustProbability(0.5F));
         if (this.rand.nextFloat() < this.adjustProbability(0.5F)) {
            var2.add(new MerchantRecipe(new ItemStack(Block.gravel, 4), new ItemStack(Item.emerald), new ItemStack(Item.flint.itemID, 4 + this.rand.nextInt(2), 0)));
         }
         break;
      case 1:
//         addMerchantItem(var2, Item.paper.itemID, this.rand, this.adjustProbability(0.8F));
//         addMerchantItem(var2, Item.book.itemID, this.rand, this.adjustProbability(0.8F));
//         addMerchantItem(var2, Item.writtenBook.itemID, this.rand, this.adjustProbability(0.8F));
//         addBlacksmithItem(var2, Block.bookShelf.blockID, this.rand, this.adjustProbability(0.8F));
//         addBlacksmithItem(var2, Block.glass.blockID, this.rand, this.adjustProbability(0.8F));
//         addBlacksmithItem(var2, Item.compass.itemID, this.rand, this.adjustProbability(0.8F));
//         addBlacksmithItem(var2, Item.pocketSundial.itemID, this.rand, this.adjustProbability(0.8F));
         if (this.rand.nextFloat() < this.adjustProbability(0.9F)) {
            var2.add(new MerchantRecipe(new ItemStack(Item.emerald, 4), new ItemStack(Item.diamond, 3)));
         }
         if (this.rand.nextFloat() < this.adjustProbability(0.9F)) {
            var2.add(new MerchantRecipe(new ItemStack(Item.diamond, 3), new ItemStack(Item.emerald, 4)));
         }
//         if (this.rand.nextFloat() < this.adjustProbability(0.8F)) {
            Enchantment var8 = (Enchantment)villagerEnhanceBookList[this.rand.nextInt(villagerEnhanceBookList.length)];
            int var10 = MathHelper.getRandomIntegerInRange(this.rand, 1, var8.getNumLevels());
            ItemStack var11 = Item.enchantedBook.getEnchantedItemStack(new EnchantmentInstance(var8, var10));
            var6 = var10 * 5 + this.rand.nextInt(10);
            if(var6 > 32) {
               var2.add(new MerchantRecipe(new ItemStack(Item.emerald, 32), new ItemStack(Item.emerald, (var6 - 32 > 32 ? 32 : var6 - 32)), var11));
            } else {
               var2.add(new MerchantRecipe(new ItemStack(Item.emerald, var6), var11));
            }
//         }
         break;
      case 2:
         addBlacksmithItem(var2, Item.eyeOfEnder.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.redstone.itemID, this.rand, this.adjustProbability(0.4F));
         addBlacksmithItem(var2, Block.glowStone.blockID, this.rand, this.adjustProbability(0.3F));
         int[] var3 = new int[]{Item.swordCopper.itemID, Item.swordIron.itemID, Item.plateCopper.itemID, Item.plateIron.itemID, Item.axeCopper.itemID, Item.axeIron.itemID, Item.pickaxeCopper.itemID, Item.pickaxeIron.itemID};
         int[] var4 = var3;
         int var5 = var3.length;
         var6 = 0;

         while(true) {
            if (var6 >= var5) {
               break label51;
            }

            int var7 = var4[var6];
            if (this.rand.nextFloat() < this.adjustProbability(0.05F)) {
               var2.add(new MerchantRecipe(new ItemStack(var7, 1, 0), new ItemStack(Item.emerald, 2 + this.rand.nextInt(3), 0), EnchantmentManager.addRandomEnchantment(this.rand, new ItemStack(var7, 1, 0), 5 + this.rand.nextInt(15))));
            }

            ++var6;
         }
      case 3:
         addMerchantItem(var2, Item.coal.itemID, this.rand, this.adjustProbability(0.7F));
         addMerchantItem(var2, Item.ingotIron.itemID, this.rand, this.adjustProbability(0.5F));
         addMerchantItem(var2, Item.ingotGold.itemID, this.rand, this.adjustProbability(0.5F));
         addBlacksmithItem(var2, Item.swordIron.itemID, this.rand, this.adjustProbability(0.5F));
         addBlacksmithItem(var2, Item.axeIron.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.pickaxeIron.itemID, this.rand, this.adjustProbability(0.5F));
         addBlacksmithItem(var2, Item.shovelIron.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.hoeIron.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.helmetIron.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.plateIron.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.legsIron.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.bootsIron.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.pickaxeCopper.itemID, this.rand, this.adjustProbability(0.5F));
         addBlacksmithItem(var2, Item.shovelCopper.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.axeCopper.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.hoeCopper.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.daggerCopper.itemID, this.rand, this.adjustProbability(0.5F));
         addBlacksmithItem(var2, Item.swordCopper.itemID, this.rand, this.adjustProbability(0.5F));
         addBlacksmithItem(var2, Item.daggerIron.itemID, this.rand, this.adjustProbability(0.5F));
         addBlacksmithItem(var2, Item.helmetCopper.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.plateCopper.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.legsCopper.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.bootsCopper.itemID, this.rand, this.adjustProbability(0.2F));
         addBlacksmithItem(var2, Item.helmetChainCopper.itemID, this.rand, this.adjustProbability(0.1F));
         addBlacksmithItem(var2, Item.plateChainCopper.itemID, this.rand, this.adjustProbability(0.1F));
         addBlacksmithItem(var2, Item.legsChainCopper.itemID, this.rand, this.adjustProbability(0.1F));
         addBlacksmithItem(var2, Item.bootsChainCopper.itemID, this.rand, this.adjustProbability(0.1F));
         addBlacksmithItem(var2, Item.helmetChainIron.itemID, this.rand, this.adjustProbability(0.1F));
         addBlacksmithItem(var2, Item.plateChainIron.itemID, this.rand, this.adjustProbability(0.1F));
         addBlacksmithItem(var2, Item.legsChainIron.itemID, this.rand, this.adjustProbability(0.1F));
         addBlacksmithItem(var2, Item.bootsChainIron.itemID, this.rand, this.adjustProbability(0.1F));
         break;
      case 4:
         addMerchantItem(var2, Item.coal.itemID, this.rand, this.adjustProbability(0.7F));
         addMerchantItem(var2, Item.porkRaw.itemID, this.rand, this.adjustProbability(0.5F));
         addMerchantItem(var2, Item.beefRaw.itemID, this.rand, this.adjustProbability(0.5F));
         addMerchantItem(var2, Item.lambchopRaw.itemID, this.rand, this.adjustProbability(0.5F));
         addBlacksmithItem(var2, Item.saddle.itemID, this.rand, this.adjustProbability(0.1F));
         addBlacksmithItem(var2, Item.plateLeather.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.bootsLeather.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.helmetLeather.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.legsLeather.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.porkCooked.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.beefCooked.itemID, this.rand, this.adjustProbability(0.3F));
         addBlacksmithItem(var2, Item.lambchopCooked.itemID, this.rand, this.adjustProbability(0.3F));
      }

      if (var2.isEmpty()) {
         addMerchantItem(var2, Item.ingotGold.itemID, this.rand, 1.0F);
      }

      Collections.shuffle(var2);
      if (this.buyingList == null) {
         this.buyingList = new MerchantRecipeList();
      }

      for(int var9 = 0; var9 < par1 && var9 < var2.size(); ++var9) {
         ItemStack enchantedBook = ((MerchantRecipe)var2.get(var9)).getItemToSell();
         if(enchantedBook != null && enchantedBook.getItem() instanceof ItemEnchantedBook) {
            this.addDifferentEnhanceBook(((MerchantRecipe)var2.get(var9)), enchantedBook);
         } else {
            this.buyingList.addToListWithCheck((MerchantRecipe)var2.get(var9));
         }
      }
   }

   public void addDifferentEnhanceBook(MerchantRecipe recipe, ItemStack enchantedBook) {
      if(this.buyingList.size() == 0) {
         this.buyingList.add(recipe);
      } else {
         boolean canAddToRecipe = false;
         boolean existEnhanceBook = false;
         for(int var2 = 0; var2 < this.buyingList.size(); ++var2) {
            MerchantRecipe var3 = (MerchantRecipe)this.buyingList.get(var2);
            NBTTagList nbtTagList = var3.getItemToSell().getStoredEnchantmentTagList();
            NBTTagList nbtTagList2 = enchantedBook.getStoredEnchantmentTagList();
            if(nbtTagList != null && nbtTagList2 != null) {
               existEnhanceBook = true;
               for(int var5 = 0; var5 < nbtTagList.tagCount(); ++var5) {
                  NBTTagCompound var6 = (NBTTagCompound)nbtTagList.tagAt(var5);
                  for(int var7 = 0; var7 < nbtTagList2.tagCount(); ++var7) {
                     NBTTagCompound var8 = (NBTTagCompound) nbtTagList2.tagAt(var7);
                     if (var6.getShort("id") == var8.getShort("id")) {
                        if (var6.getShort("lvl") != var8.getShort("lvl")) {
                           canAddToRecipe = true;
                        }
                     } else {
                        canAddToRecipe = true;
                     }
                  }
               }
            }
         }
         if(canAddToRecipe || !existEnhanceBook) {
            this.buyingList.add(recipe);
         }
      }
   }

   @Shadow
   private float adjustProbability(float par1) {
      return 0.0F;
   }

   @Shadow
   public EntityAgeable createChild(EntityAgeable var1) {
      return null;
   }

   @Shadow
   public void func_110297_a_(ItemStack itemStack) {
   }

   @Shadow
   private int getProfession() {
      return 0;
   }

   @Shadow
   public void useRecipe(MerchantRecipe merchantRecipe) {
   }
}
