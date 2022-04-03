package net.xiaoyu233.mitemod.miteite.item;

import net.minecraft.*;
import net.xiaoyu233.mitemod.miteite.block.Blocks;
import net.xiaoyu233.mitemod.miteite.util.Configs;
import net.xiaoyu233.mitemod.miteite.util.Constant;
import net.xiaoyu233.mitemod.miteite.util.RecipeRegister;
import org.spongepowered.asm.mixin.Overwrite;

import java.util.List;

import static net.xiaoyu233.mitemod.miteite.util.ReflectHelper.createInstance;

public class Items extends Item{
    public static final Item BLAZE_COAL_POWDER = new ItemBlazeCoalPowder(Constant.getNextItemID());
    public static final Item DIAMOND_CHUNK = createInstance(Item.class,new Class[]{int.class,Material.class,String.class},Constant.getNextItemID(),Material.diamond,"diamond_chunk").setCraftingDifficultyAsComponent(ItemRock.getCraftingDifficultyAsComponent(Material.diamond) /(float)4);
    public static final Item OBSIDIAN_STICK = createInstance(Item.class,new Class[]{int.class,Material.class,String.class},Constant.getNextItemID(),Material.obsidian,"obsidian_stick");
    public static final ItemAxe VIBRANIUM_AXE = createInstance(ItemAxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.vibranium);
    public static final ItemBattleAxe VIBRANIUM_BATTLE_AXE = createInstance(ItemBattleAxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.vibranium);
    public static final ItemArmor VIBRANIUM_BOOTS = new ItemBoots(Constant.getNextItemID(),Materials.vibranium,false);
    public static final ItemBow VIBRANIUM_BOW = new ItemBow(Constant.getNextItemID(),Materials.vibranium);
    public static final ItemArmor VIBRANIUM_CHESTPLATE = new ItemCuirass(Constant.getNextItemID(), Materials.vibranium, false);
    public static final ItemDagger VIBRANIUM_DAGGER = createInstance(ItemDagger.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.vibranium);
    public static final ItemArmor VIBRANIUM_HELMET = new ItemHelmet(Constant.getNextItemID(),Materials.vibranium,false);
    public static final Item VIBRANIUM_INGOT = createInstance(ItemIngot.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.vibranium);
    public static final ItemArmor VIBRANIUM_LEGGINGS = new ItemLeggings(Constant.getNextItemID(),Materials.vibranium,false);
    public static final ItemNugget VIBRANIUM_NUGGET = createInstance(ItemNugget.class, new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.vibranium);
    public static final ItemPickaxe VIBRANIUM_PICKAXE = createInstance(ItemPickaxe.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.vibranium);
    public static final ItemShovel VIBRANIUM_SHOVEL = createInstance(ItemShovel.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.vibranium);
    public static final ItemSword VIBRANIUM_SWORD = createInstance(ItemSword.class,new Class[]{int.class,Material.class},Constant.getNextItemID(), Materials.vibranium);
    public static final ItemWarHammer VIBRANIUM_WAR_HAMMER = createInstance(ItemWarHammer.class,new Class[]{int.class,Material.class},Constant.getNextItemID(),Materials.vibranium);
    public static final ItemEnhanceStone IRON_ENHANCE_STONE = (ItemEnhanceStone) new ItemEnhanceStone(ItemEnhanceStone.Types.iron).setCraftingDifficultyAsComponent(ItemRock.getCraftingDifficultyAsComponent(Material.iron) * 2f);
    public static final ItemEnhanceStone MITHRIL_ENHANCE_STONE = (ItemEnhanceStone) new ItemEnhanceStone(ItemEnhanceStone.Types.mithril).setCraftingDifficultyAsComponent(ItemRock.getCraftingDifficultyAsComponent(Material.mithril) * 2f);
    public static final ItemEnhanceStone ADAMANTIUM_ENHANCE_STONE = (ItemEnhanceStone) new ItemEnhanceStone(ItemEnhanceStone.Types.adamantium).setCraftingDifficultyAsComponent(ItemRock.getCraftingDifficultyAsComponent(Material.diamond) * 2f);
    public static final ItemEnhanceStone UNIVERSAL_ENHANCE_STONE = (ItemEnhanceStone) new ItemEnhanceStone(ItemEnhanceStone.Types.universal).setCraftingDifficultyAsComponent(ItemRock.getCraftingDifficultyAsComponent(Material.ender_pearl) * 2f);

    public static final Item Stones = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Material.diamond, "stones").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(1);;
    public static final Item Gem_Blue = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Material.diamond, "gem_blue").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(100);
    public static final Item Gem_Yellow = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Material.diamond, "gem_yellow").setCraftingDifficultyAsComponent(1.0E-9F).setXPReward(1000);

    public static final Item Guilt1 = new ItemGuilt1(Constant.getNextItemID());
    public static final Item Guilt2 = new ItemGuilt2(Constant.getNextItemID());
    public static final Item Guilt3 = new ItemGuilt3(Constant.getNextItemID());
    public static final Item Guilt4 = new ItemGuilt4(Constant.getNextItemID());
    public static final Item Guilt5 = new ItemGuilt5(Constant.getNextItemID());
    public static final Item Guilt6 = new ItemGuilt6(Constant.getNextItemID());
    public static final Item Guilt7 = new ItemGuilt7(Constant.getNextItemID());

    public static final ItemPickaxe A_PICKAXE = createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, Constant.getNextItemID(), Materials.ancient_metal);
    public static final ItemPickaxe B_PICKAXE = createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, Constant.getNextItemID(), Materials.ancient_metal);
    public static final ItemPickaxe C_PICKAXE = createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, Constant.getNextItemID(), Materials.mithril);
    public static final ItemPickaxe D_PICKAXE = createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, Constant.getNextItemID(), Materials.adamantium);
    public static final ItemPickaxe E_PICKAXE = createInstance(ItemPickaxe.class, new Class[]{int.class, Material.class}, Constant.getNextItemID(), Materials.vibranium);

    public static final ItemFood Zombie_Brain = new ItemZombie_Brain(Constant.getNextItemID());
    public static final ItemFood Zombie_Drug = new ItemZombie_Drug(Constant.getNextItemID());
    public static final ItemFood Spider_Leg = new ItemSpider_Leg(Constant.getNextItemID());
    public static final ItemFood Zombie_Soup = new ItemZombie_Soup(Constant.getNextItemID());
    public static final Item Spider_Leg_B = new ItemSpider_Leg_B(Constant.getNextItemID());
    public static final Item ColorBag = new ItemColorBag(Constant.getNextItemID(), Material.seed, "color_bag");
    public static final Item Drug_BG = new ItemDrug_BG(Constant.getNextItemID());
    public static final Item BadApple = new ItemBadApple(Constant.getNextItemID());
    public static final Item Creeper_Baby = new ItemCreeper_Baby(Constant.getNextItemID());
    public static final Item Creeper_Soul = new ItemCreeper_Soul(Constant.getNextItemID());
    public static final ItemFood Drug_ZJ = new ItemDrug_ZJ(Constant.getNextItemID());

    public static final Item Stack_Gold_Nether = createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, new Object[]{Constant.getNextItemID(), Materials.vibranium});
    public static final Item Stack_Gold = createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, new Object[]{Constant.getNextItemID(), Materials.vibranium});
    public static final Item Stack_Silver = createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, new Object[]{Constant.getNextItemID(), Materials.vibranium});
    public static final Item Stack_Copper = createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, new Object[]{Constant.getNextItemID(), Materials.vibranium});
    public static final Item Stack_Iron = createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, new Object[]{Constant.getNextItemID(), Materials.vibranium});
    public static final Item Stack_Mithril = createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, new Object[]{Constant.getNextItemID(), Materials.vibranium});
    public static final Item Stack_Adamantium = createInstance(ItemNugget.class, new Class[]{int.class, Material.class}, new Object[]{Constant.getNextItemID(), Materials.vibranium});
    public static final Item Stack_Torch = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Material.seed, "stack_torch");
    public static final Item Stack_Torch_On = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Materials.seed, "stack_torch_on");
    public static final Item Stack_Log = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Material.seed, "stack_log");
    public static final Item Stack_Leather = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Material.diamond, "stack_leather");
    public static final Item GABag = new ItemGABag(Constant.getNextItemID(), Materials.vibranium);
    public static final Item lavaInPipes = new ItemLavaInPipes(Constant.getNextItemID(), Materials.lava);

    public static final Item ringKillerCopper = new ItemRingKiller(Constant.getNextItemID(), Materials.copper).setUnlocalizedName("ringKillerCopper");
    public static final Item ringKillerIron = new ItemRingKiller(Constant.getNextItemID(), Materials.iron).setUnlocalizedName("ringKillerIron");
    public static final Item ringKillerAncient = new ItemRingKiller(Constant.getNextItemID(), Materials.ancient_metal).setUnlocalizedName("ringKillerAncient");
    public static final Item ringKillerMithril = new ItemRingKiller(Constant.getNextItemID(), Materials.mithril).setUnlocalizedName("ringKillerMithril");
    public static final Item ringKillerAdamantium = new ItemRingKiller(Constant.getNextItemID(), Materials.adamantium).setUnlocalizedName("ringKillerAdamantium");
    public static final Item ringKillerVibranium = new ItemRingKiller(Constant.getNextItemID(), Materials.vibranium).setUnlocalizedName("ringKillerVibranium");



    private static Item register(String resourceLocation, Item item, CreativeModeTab tab) {
        item.setResourceLocation(item.getResourceLocationPrefix() + resourceLocation);
        item.setUnlocalizedName(resourceLocation);
        item.setCreativeTab(tab);
        return item;
    }

    private static Item register(String resourceLocation, Item item) {
        item.setResourceLocation(item.getResourceLocationPrefix() + resourceLocation);
        item.setUnlocalizedName(resourceLocation);
        return item;
    }

    @Overwrite
    public void a(int par1, CreativeModeTab par2CreativeTabs, List par3List) {
//        par3List.add(new ItemStack(par1, 1, 0));
    }

    public static void registerItems() {
        register("obsidian_stick", OBSIDIAN_STICK, CreativeModeTab.tabMaterials);
        register("vibranium", VIBRANIUM_INGOT, CreativeModeTab.tabMaterials);
        register("vibranium_nugget", VIBRANIUM_NUGGET, CreativeModeTab.tabMaterials);
        register("vibranium_helmet", VIBRANIUM_HELMET);
        register("vibranium_chestplate", VIBRANIUM_CHESTPLATE);
        register("vibranium_leggings", VIBRANIUM_LEGGINGS);
        register("vibranium_boots", VIBRANIUM_BOOTS);
        register("vibranium_sword", VIBRANIUM_SWORD);
        register("vibranium_shovel", VIBRANIUM_SHOVEL);
        register("vibranium_pickaxe", VIBRANIUM_PICKAXE);
        register("vibranium_axe", VIBRANIUM_AXE);
        register("vibranium_dagger", VIBRANIUM_DAGGER);
        register("vibranium_war_hammer", VIBRANIUM_WAR_HAMMER);
        register("vibranium_battle_axe", VIBRANIUM_BATTLE_AXE);
        register("diamond_chunk", DIAMOND_CHUNK, CreativeModeTab.tabMaterials);
        register("blaze_coal_powder", BLAZE_COAL_POWDER, CreativeModeTab.tabMaterials);
        register("bows/vibranium/", VIBRANIUM_BOW).setUnlocalizedName("vibranium_bow");
        register("enhance_stone/iron",IRON_ENHANCE_STONE , CreativeModeTab.tabMaterials);
        register("enhance_stone/mithril",MITHRIL_ENHANCE_STONE , CreativeModeTab.tabMaterials);
        register("enhance_stone/adamantium",ADAMANTIUM_ENHANCE_STONE , CreativeModeTab.tabMaterials);
        register("enhance_stone/universal",UNIVERSAL_ENHANCE_STONE , CreativeModeTab.tabMaterials);

        Stones.setCreativeTab(CreativeModeTab.tabMaterials);
        Gem_Blue.setCreativeTab(CreativeModeTab.tabMaterials);
        Item.porkCooked.setXPReward(3 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.fishCooked.setXPReward(3 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.beefCooked.setXPReward(4 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.chickenCooked.setXPReward(3 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.lambchopCooked.setXPReward(2 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.fishLargeCooked.setXPReward(4 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.bakedPotato.setXPReward(1 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.bread.setXPReward(1 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.wormCooked.setXPReward(1 * Configs.wenscConfig.MeatExpValue.ConfigValue);
        Item.ingotIron.setXPReward(20 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotSilver.setXPReward(15 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotCopper.setXPReward(10 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotGold.setXPReward(10 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotAncientMetal.setXPReward(20 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotMithril.setXPReward(40 * Configs.wenscConfig.OreExpValue.ConfigValue);
        Item.ingotAdamantium.setXPReward(100 * Configs.wenscConfig.OreExpValue.ConfigValue);

        register("stones", Stones).setUnlocalizedName("stones").setMaxStackSize(64);
        register("gem_blue", Gem_Blue).setUnlocalizedName("gem_blue").setMaxStackSize(64);
        register("gem_yellow", Gem_Yellow).setUnlocalizedName("gem_yellow").setMaxStackSize(64);

        register("guilt1", Guilt1).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt2", Guilt2).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt3", Guilt3).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt4", Guilt4).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt5", Guilt5).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt6", Guilt6).setLowestCraftingDifficultyToProduce(1.0F);
        register("guilt7", Guilt7).setLowestCraftingDifficultyToProduce(1.0F);

        register("a_pickaxe", A_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("b_pickaxe", B_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("c_pickaxe", C_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("d_pickaxe", D_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);
        register("e_pickaxe", E_PICKAXE).setLowestCraftingDifficultyToProduce(1.0F);

        register("zombie_brain", Zombie_Brain);
        register("zombie_drug", Zombie_Drug).setLowestCraftingDifficultyToProduce(1.0F);
        register("spider_leg", Spider_Leg);
        register("spider_leg_b", Spider_Leg_B).setLowestCraftingDifficultyToProduce(1.0F);
        register("zombie_soup", Zombie_Soup).setLowestCraftingDifficultyToProduce(1.0F);
        register("color_bag", ColorBag);
        register("drug_bg", Drug_BG).setUnlocalizedName("drug_bg").setLowestCraftingDifficultyToProduce(1.0F);;
        register("bad_apple", BadApple).setLowestCraftingDifficultyToProduce(1.0F);
        register("drug_zj", Drug_ZJ).setUnlocalizedName("drug_zj").setLowestCraftingDifficultyToProduce(1.0F);

        register("stack_gold_nether", Stack_Gold_Nether).setUnlocalizedName("stack_gold_nether").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_gold", Stack_Gold).setUnlocalizedName("stack_gold").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_silver", Stack_Silver).setUnlocalizedName("stack_silver").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);;
        register("stack_copper", Stack_Copper).setUnlocalizedName("stack_copper").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_iron", Stack_Iron).setUnlocalizedName("stack_iron").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_mithril", Stack_Mithril).setUnlocalizedName("stack_mithril").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);;
        register("stack_adamantium", Stack_Adamantium).setUnlocalizedName("stack_adamantium").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_torch", Stack_Torch).setUnlocalizedName("stack_torch").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_torch_on", Stack_Torch_On).setUnlocalizedName("stack_torch_on").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_log", Stack_Log).setUnlocalizedName("stack_log").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("stack_leather", Stack_Leather).setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);
        register("creeper_baby", Creeper_Baby).setUnlocalizedName("creeper_baby");
        register("creeper_soul", Creeper_Soul).setUnlocalizedName("creeper_soul").setCraftingDifficultyAsComponent(1.0E-9F);

        register("ga_bag", GABag).setUnlocalizedName("ga_bag").setLowestCraftingDifficultyToProduce(1.0F);

        register("lava_in_pipes", lavaInPipes).setUnlocalizedName("lava_in_pipes").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_copper", ringKillerCopper).setUnlocalizedName("ring_killer_copper").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_iron", ringKillerIron).setUnlocalizedName("ring_killer_iron").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_ancient", ringKillerAncient).setUnlocalizedName("ring_killer_ancient").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_mithril", ringKillerMithril).setUnlocalizedName("ring_killer_mithril").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_adamantium", ringKillerAdamantium).setUnlocalizedName("ring_killer_adamantium").setLowestCraftingDifficultyToProduce(1.0F);
        register("ring_killer/ring_killer_vibranium", ringKillerVibranium).setUnlocalizedName("ring_killer_vibranium").setLowestCraftingDifficultyToProduce(1.0F);

        Constant.initItemArray();
    }

    public static void registerRecipes(RecipeRegister register) {
        register.registerShapelessRecipe(new ItemStack(Blocks.blockLantern, 1), true,Blocks.torchWood, ironNugget, ironNugget, ironNugget, ironNugget, ironNugget, ironNugget, ironNugget, ironNugget);
        if(Configs.wenscConfig.isRecipeGABag.ConfigValue) {
            register.registerShapedRecipe(new ItemStack(GABag, 1), true, "#*#", "*#*", "#*#", '#', Blocks.obsidian, '*', Items.enderPearl);
        }

        register.registerShapedRecipe(new ItemStack(Item.paper), true, new Object[]{"###", '#', Item.stick});

        register.registerShapelessRecipe(new ItemStack(Blocks.blockGotcha, 64, 4), true, new Object[]{Gem_Blue});

        for(int i = 1; i < 10 ; ++i) {
            register.registerShapelessRecipe(new ItemStack(Block.cobblestone, i), true, new ItemStack(Stones, i));
        }

        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful0, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 0)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful1, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 1)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful2, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 2)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful3, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 3)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful4, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 4)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful5, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 5)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful6, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 6)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful7, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 7)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful8, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 8)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful9, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 9)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful10, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 10)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful11, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 11)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful12, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 12)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful13, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 13)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful14, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 14)});
        register.registerShapelessRecipe(new ItemStack(Blocks.blockStairsColorful15, 64), true, new Object[]{Gem_Blue,redstone, Blocks.stairsCobblestone, new ItemStack(Item.dyePowder, 1, 15)});


        for(int i = 0; i < 16; ++i) {
            register.registerShapelessRecipe(new ItemStack(Blocks.blockColorful, 64, i), true, Gem_Blue, redstone, new ItemStack(Item.dyePowder, 1, i));
            register.registerShapelessRecipe(new ItemStack(Blocks.blockColorfulBrick, 64, i), true, Gem_Blue, redstone, Blocks.stoneBrick, new ItemStack(Item.dyePowder, 1, i));
            register.registerShapelessRecipe(new ItemStack(Blocks.blockGotcha, 64, i), true, new Object[]{Gem_Blue, new ItemStack(Item.dyePowder, 1, i)});
            if(Configs.wenscConfig.isRecipeGAPickaxe.ConfigValue) {
                register.registerShapedRecipe(new ItemStack(A_PICKAXE, 1), true, "###", "#I#", "###", 'I', Item.pickaxeAncientMetal, '#', new ItemStack(Blocks.blockGotcha, 1, i));
            }
            register.registerShapelessRecipe(new ItemStack(Items.silk, 4), true, new Object[]{new ItemStack(Block.cloth, 1, i)});
        }
        if(Configs.wenscConfig.isRecipeGAPickaxe.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Guilt1, 1), true, Block.blockCopper, Block.blockSilver, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt2, 1), true, Block.blockSilver, Block.blockDiamond, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt3, 1), true, Block.blockCopper, Block.blockRedstone, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt4, 1), true, Block.blockSilver, Block.blockAncientMetal, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt5, 1), true, Block.blockCopper, Block.blockEmerald, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt6, 1), true, Block.blockSilver, Block.blockNetherQuartz, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);
            register.registerShapelessRecipe(new ItemStack(Guilt7, 1), true, Block.blockCopper, Block.blockLapis, Block.blockIron, Block.blockGold, Block.blockMithril, Gem_Blue);

            register.registerShapelessRecipe(new ItemStack(B_PICKAXE), true, A_PICKAXE, Block.blockAncientMetal, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
            register.registerShapelessRecipe(new ItemStack(C_PICKAXE), true, B_PICKAXE, Block.blockMithril, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
            register.registerShapelessRecipe(new ItemStack(D_PICKAXE), true, C_PICKAXE, Block.blockAdamantium, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
            register.registerShapelessRecipe(new ItemStack(E_PICKAXE), true, D_PICKAXE, Blocks.blockVibranium, Guilt1, Guilt2, Guilt3, Guilt4, Guilt5, Guilt6, Guilt7);
        }

        register.registerShapelessRecipe(new ItemStack(Zombie_Drug), true, new Object[]{Zombie_Brain, Zombie_Brain, Zombie_Brain, Block.plantYellow});
        register.registerShapelessRecipe(new ItemStack(Zombie_Drug, 3), true, new Object[]{Zombie_Brain, Zombie_Brain, Zombie_Brain, Item.goldenCarrot});

        register.registerShapelessRecipe(new ItemStack(Items.leather, 1), true, Items.rottenFlesh);
        register.registerShapelessRecipe(new ItemStack(Blocks.cloth, 1), true, Items.silk, Items.silk, Items.silk, Items.silk);

        register.registerShapedRecipe(new ItemStack(Item.poisonousPotato, 1), true, new Object[]{"##", "##", '#', Item.seeds});
        if(Configs.wenscConfig.isRecipeRottenSoup.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Zombie_Soup), true, new Object[]{Item.rottenFlesh, Item.spiderEye, Item.poisonousPotato, new ItemStack(Item.dyePowder, 1, 15)});
        }

        register.registerShapelessRecipe(new ItemStack(Spider_Leg_B, 6, 0), true, new Object[]{new ItemStack(Spider_Leg, 6, 0), Item.bakedPotato, Item.snowball});
        if(Configs.wenscConfig.isRecipeGAGoldApple.ConfigValue) {
            register.registerShapedRecipe(new ItemStack(BadApple), true, new Object[]{"##", "##", '#', Block.leaves});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', BadApple, '#', Item.goldNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', BadApple, '#', Item.copperNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', BadApple, '#', Item.silverNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', BadApple, '#', Item.ironNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', BadApple, '#', Item.mithrilNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', BadApple, '#', Item.adamantiumNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', BadApple, '#', Item.ancientMetalNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', BadApple, '#', VIBRANIUM_NUGGET});

            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', Item.appleRed, '#', Item.copperNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', Item.appleRed, '#', Item.silverNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', Item.appleRed, '#', Item.ironNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', Item.appleRed, '#', Item.mithrilNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', Item.appleRed, '#', Item.adamantiumNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', Item.appleRed, '#', Item.ancientMetalNugget});
            register.registerShapedRecipe(new ItemStack(Item.appleGold), true, new Object[]{"###", "#N#", "###", 'N', Item.appleRed, '#', VIBRANIUM_NUGGET});
        }
        if(Configs.wenscConfig.isRecipeDrugProtection.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Drug_ZJ, 2), true, new Object[]{Item.emerald, Item.emerald, Item.egg, Block.plantYellow});
        }
        if(Configs.wenscConfig.isRecipeMineralBag.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Stack_Gold_Nether, 2), true, new Object[]{new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2)});
            register.registerShapelessRecipe(new ItemStack(Stack_Gold_Nether, 1), true, new Object[]{new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2), new ItemStack(Block.oreGold, 1, 2)});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 36, 2), true, new Object[]{Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 32, 2), true, new Object[]{Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 28, 2), true, new Object[]{Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 24, 2), true, new Object[]{Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 20, 2), true, new Object[]{Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 16, 2), true, new Object[]{Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 12, 2), true, new Object[]{Stack_Gold_Nether, Stack_Gold_Nether, Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 8, 2), true, new Object[]{Stack_Gold_Nether, Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 4, 2), true, new Object[]{Stack_Gold_Nether});
            register.registerShapelessRecipe(new ItemStack(Stack_Gold, 2), true, new Object[]{Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold});
            register.registerShapelessRecipe(new ItemStack(Stack_Gold, 1), true, new Object[]{Block.oreGold, Block.oreGold, Block.oreGold, Block.oreGold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 36), true, new Object[]{Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 32), true, new Object[]{Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 28), true, new Object[]{Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 24), true, new Object[]{Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 20), true, new Object[]{Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 16), true, new Object[]{Stack_Gold, Stack_Gold, Stack_Gold, Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 12), true, new Object[]{Stack_Gold, Stack_Gold, Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 8), true, new Object[]{Stack_Gold, Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Block.oreGold, 4), true, new Object[]{Stack_Gold});
            register.registerShapelessRecipe(new ItemStack(Stack_Silver, 2), true, new Object[]{Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver});
            register.registerShapelessRecipe(new ItemStack(Stack_Silver, 1), true, new Object[]{Block.oreSilver, Block.oreSilver, Block.oreSilver, Block.oreSilver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 36), true, new Object[]{Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 32), true, new Object[]{Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 28), true, new Object[]{Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 24), true, new Object[]{Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 20), true, new Object[]{Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 16), true, new Object[]{Stack_Silver, Stack_Silver, Stack_Silver, Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 12), true, new Object[]{Stack_Silver, Stack_Silver, Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 8), true, new Object[]{Stack_Silver, Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Block.oreSilver, 4), true, new Object[]{Stack_Silver});
            register.registerShapelessRecipe(new ItemStack(Stack_Copper, 2), true, new Object[]{Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper});
            register.registerShapelessRecipe(new ItemStack(Stack_Copper, 1), true, new Object[]{Block.oreCopper, Block.oreCopper, Block.oreCopper, Block.oreCopper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 36), true, new Object[]{Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 32), true, new Object[]{Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 28), true, new Object[]{Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 24), true, new Object[]{Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 20), true, new Object[]{Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 16), true, new Object[]{Stack_Copper, Stack_Copper, Stack_Copper, Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 12), true, new Object[]{Stack_Copper, Stack_Copper, Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 8), true, new Object[]{Stack_Copper, Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Block.oreCopper, 4), true, new Object[]{Stack_Copper});
            register.registerShapelessRecipe(new ItemStack(Stack_Iron, 2), true, new Object[]{Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron});
            register.registerShapelessRecipe(new ItemStack(Stack_Iron, 1), true, new Object[]{Block.oreIron, Block.oreIron, Block.oreIron, Block.oreIron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 36), true, new Object[]{Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 32), true, new Object[]{Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 28), true, new Object[]{Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 24), true, new Object[]{Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 20), true, new Object[]{Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 16), true, new Object[]{Stack_Iron, Stack_Iron, Stack_Iron, Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 12), true, new Object[]{Stack_Iron, Stack_Iron, Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 8), true, new Object[]{Stack_Iron, Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Block.oreIron, 4), true, new Object[]{Stack_Iron});
            register.registerShapelessRecipe(new ItemStack(Stack_Mithril, 2), true, new Object[]{Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril});
            register.registerShapelessRecipe(new ItemStack(Stack_Mithril, 1), true, new Object[]{Block.oreMithril, Block.oreMithril, Block.oreMithril, Block.oreMithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 36), true, new Object[]{Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 32), true, new Object[]{Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 28), true, new Object[]{Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 24), true, new Object[]{Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 20), true, new Object[]{Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 16), true, new Object[]{Stack_Mithril, Stack_Mithril, Stack_Mithril, Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 12), true, new Object[]{Stack_Mithril, Stack_Mithril, Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 8), true, new Object[]{Stack_Mithril, Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Block.oreMithril, 4), true, new Object[]{Stack_Mithril});
            register.registerShapelessRecipe(new ItemStack(Stack_Adamantium, 2), true, new Object[]{Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium});
            register.registerShapelessRecipe(new ItemStack(Stack_Adamantium, 1), true, new Object[]{Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium, Block.oreAdamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 36), true, new Object[]{Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 32), true, new Object[]{Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 28), true, new Object[]{Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 24), true, new Object[]{Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 20), true, new Object[]{Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 16), true, new Object[]{Stack_Adamantium, Stack_Adamantium, Stack_Adamantium, Stack_Adamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 12), true, new Object[]{Stack_Adamantium, Stack_Adamantium, Stack_Adamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 8), true, new Object[]{Stack_Adamantium, Stack_Adamantium});
            register.registerShapelessRecipe(new ItemStack(Block.oreAdamantium, 4), true, new Object[]{Stack_Adamantium});
        }

        if(Configs.wenscConfig.isRecipeGATorch.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{Block.wood, Item.silk, Item.coal, Item.coal});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{Block.wood, Item.sinew, Item.coal, Item.coal});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{Block.wood, Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{Block.wood, Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 1), Item.silk, Item.coal, Item.coal});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 1), Item.sinew, Item.coal, Item.coal});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 1), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 1), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 2), Item.silk, Item.coal, Item.coal});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 2), Item.sinew, Item.coal, Item.coal});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 2), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 2), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 3), Item.silk, Item.coal, Item.coal});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 3), Item.sinew, Item.coal, Item.coal});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 3), Item.silk, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{new ItemStack(Block.wood, 1, 3), Item.sinew, new ItemStack(Item.coal, 1, 1), new ItemStack(Item.coal, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 64), true, new Object[]{Stack_Torch, Stack_Torch, Stack_Torch, Stack_Torch});
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 48), true, new Object[]{Stack_Torch, Stack_Torch, Stack_Torch});
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 32), true, new Object[]{Stack_Torch, Stack_Torch});
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 16), true, new Object[]{Stack_Torch});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 1), true, new Object[]{Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch, 2), true, new Object[]{Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On, Stack_Torch_On});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch_On, 1), true, new Object[]{Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood});
            register.registerShapelessRecipe(new ItemStack(Stack_Torch_On, 2), true, new Object[]{Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood, Block.torchWood});
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 12), true, new Object[]{Stack_Torch_On, Stack_Torch_On, Stack_Torch_On});
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 8), true, new Object[]{Stack_Torch_On, Stack_Torch_On});
            register.registerShapelessRecipe(new ItemStack(Block.torchWood, 4), true, new Object[]{Stack_Torch_On});
            register.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new Object[]{Block.wood, Block.wood, Block.wood, Block.wood});
            register.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new Object[]{new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1), new ItemStack(Block.wood, 1, 1)});
            register.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new Object[]{new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2), new ItemStack(Block.wood, 1, 2)});
            register.registerShapelessRecipe(new ItemStack(Stack_Log, 1), true, new Object[]{new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3), new ItemStack(Block.wood, 1, 3)});
            register.registerShapelessRecipe(new ItemStack(Stack_Leather, 1, 0), true, new Object[]{new ItemStack(Item.leather, 8, 0), Item.silk});
            register.registerShapelessRecipe(new ItemStack(Stack_Leather, 1, 0), true, new Object[]{new ItemStack(Item.leather, 8, 0), Item.sinew});
            register.registerShapelessRecipe(new ItemStack(Item.leather, 8, 0), true, new Object[]{Stack_Leather});

            register.registerShapelessRecipe(new ItemStack(Block.wood, 16), true, new Object[]{Stack_Log, Stack_Log, Stack_Log, Stack_Log});
            register.registerShapelessRecipe(new ItemStack(Block.wood, 12), true, new Object[]{Stack_Log, Stack_Log, Stack_Log});
            register.registerShapelessRecipe(new ItemStack(Block.wood, 8), true, new Object[]{Stack_Log, Stack_Log});
            register.registerShapelessRecipe(new ItemStack(Block.wood, 4), true, new Object[]{Stack_Log});
        }

        register.registerShapelessRecipe(new ItemStack(Creeper_Soul), true, new Object[]{Creeper_Baby, Creeper_Baby, Creeper_Baby, Creeper_Baby});

        if(Configs.wenscConfig.isRecipeDrugFull.ConfigValue) {
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, new Object[]{Block.plantYellow, Item.copperNugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8)});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, new Object[]{Block.plantYellow, Item.silverNugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8)});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, new Object[]{Block.plantYellow, Item.goldNugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8)});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, new Object[]{Block.plantYellow, Item.ironNugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8)});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, new Object[]{Block.plantYellow, Item.mithrilNugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8)});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, new Object[]{Block.plantYellow, Item.adamantiumNugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8)});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, new Object[]{Block.plantYellow, Item.ancientMetalNugget, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8)});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 64), true, new Object[]{Block.plantYellow, VIBRANIUM_NUGGET, Item.redstone, new ItemStack(Block.plantRed, 1, 0), new ItemStack(Block.plantRed, 1, 1), new ItemStack(Block.plantRed, 1, 2), new ItemStack(Block.plantRed, 1, 5), new ItemStack(Block.plantRed, 1, 7), new ItemStack(Block.plantRed, 1, 8)});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantYellow, 7), Item.copperNugget});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantYellow, 7), Item.silverNugget});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantYellow, 7), Item.goldNugget});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantYellow, 7), Item.ironNugget});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantYellow, 7), Item.mithrilNugget});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantYellow, 7), Item.adamantiumNugget});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantYellow, 7), Item.ancientMetalNugget});
            register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantYellow, 7), VIBRANIUM_NUGGET});
        }




        for(int i = 0; i < 16; ++i) {
            if (i == 0 || i == 1 || i == 2 || i == 5 || i == 7 || i == 8) {
                if(Configs.wenscConfig.isRecipeDrugFull.ConfigValue) {
                    register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantRed, 7, i), Item.copperNugget});
                    register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantRed, 7, i), Item.silverNugget});
                    register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantRed, 7, i), Item.goldNugget});
                    register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantRed, 7, i), Item.ironNugget});
                    register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantRed, 7, i), Item.mithrilNugget});
                    register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantRed, 7, i), Item.adamantiumNugget});
                    register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantRed, 7, i), Item.ancientMetalNugget});
                    register.registerShapelessRecipe(new ItemStack(Drug_BG, 1), true, new Object[]{Item.redstone, new ItemStack(Block.plantRed, 7, i), VIBRANIUM_NUGGET});
                }
                register.registerShapelessRecipe(new ItemStack(Zombie_Drug), true, new Object[]{Zombie_Brain, Zombie_Brain, Zombie_Brain, new ItemStack(Block.plantRed, 1, i)});
                if(Configs.wenscConfig.isRecipeDrugProtection.ConfigValue) {
                    register.registerShapelessRecipe(new ItemStack(Drug_ZJ, 2), true, new Object[]{Item.emerald, Item.emerald, Item.egg, new ItemStack(Block.plantRed, 1, i)});
                }
            }
        }

        register.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, new Object[]{"I I", "IDI", " I ", 'D', Block.chest, 'I', Item.ingotGold});
        register.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, new Object[]{"I I", "IDI", " I ", 'D', Block.chest, 'I', Item.ingotSilver});
        register.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, new Object[]{"I I", "IDI", " I ", 'D', Block.chest, 'I', Item.ingotCopper});
        register.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, new Object[]{"I I", "IDI", " I ", 'D', Block.chest, 'I', Item.ingotAncientMetal});
        register.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, new Object[]{"I I", "IDI", " I ", 'D', Block.chest, 'I', Item.ingotMithril});
        register.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, new Object[]{"I I", "IDI", " I ", 'D', Block.chest, 'I', Item.ingotAdamantium});
        register.registerShapedRecipe(new ItemStack(Block.hopperBlock), true, new Object[]{"I I", "IDI", " I ", 'D', Block.chest, 'I', VIBRANIUM_INGOT});

        if(Configs.wenscConfig.isRecipeRingKiller.ConfigValue) {
            register.registerShapedRecipe(new ItemStack(ringKillerCopper, 1), true, new Object[]{"###", "#*#","###", '#', Items.swordCopper , '*', Items.emerald});
            register.registerShapedRecipe(new ItemStack(ringKillerIron, 1), true, new Object[]{"###", "#*#","###", '#', Items.swordIron , '*', Items.ringKillerCopper});
            register.registerShapedRecipe(new ItemStack(ringKillerAncient, 1), true, new Object[]{"###", "#*#","###", '#', Items.swordAncientMetal , '*', Items.ringKillerIron});
            register.registerShapedRecipe(new ItemStack(ringKillerMithril, 1), true, new Object[]{"###", "#*#","###", '#', Items.swordMithril , '*', Items.ringKillerAncient});
            register.registerShapedRecipe(new ItemStack(ringKillerAdamantium, 1), true, new Object[]{"###", "#*#","###", '#', Items.swordAdamantium , '*', Items.ringKillerMithril});
            register.registerShapedRecipe(new ItemStack(ringKillerVibranium, 1), true, new Object[]{"###", "#*#","###", '#', VIBRANIUM_SWORD , '*', Items.ringKillerAdamantium});
        }


        register.registerShapedRecipe(new ItemStack(OBSIDIAN_STICK), true, "#", "#", '#', Block.obsidian);
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_INGOT),
                false,
                "NIN",
                "IDI",
                "NIN",
                'N',
                Item.mithrilNugget,
                'I',
                Item.ingotAdamantium,
                'D',
                Item.diamond);
        register.registerShapelessRecipe(new ItemStack(VIBRANIUM_NUGGET, 9), true, VIBRANIUM_INGOT);
        register.registerShapelessRecipe(new ItemStack(VIBRANIUM_INGOT),
                true,
                VIBRANIUM_NUGGET,
                VIBRANIUM_NUGGET,
                VIBRANIUM_NUGGET,
                VIBRANIUM_NUGGET,
                VIBRANIUM_NUGGET,
                VIBRANIUM_NUGGET,
                VIBRANIUM_NUGGET,
                VIBRANIUM_NUGGET,
                VIBRANIUM_NUGGET);
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_HELMET),
                true,
                "#A#",
                "# #",
                '#', VIBRANIUM_INGOT,
                'A', Item.helmetAdamantium).extendsNBT();
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_CHESTPLATE),
                true,
                "# #",
                "#A#",
                "###",
                '#', VIBRANIUM_INGOT,
                'A', Item.plateAdamantium).extendsNBT();
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_LEGGINGS),
                true,
                "#A#",
                "# #",
                "# #",
                '#', VIBRANIUM_INGOT,
                'A', Item.legsAdamantium).extendsNBT();
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_BOOTS),
                true,
                "A #",
                "# #",
                '#', VIBRANIUM_INGOT,
                'A', Item.bootsAdamantium).extendsNBT();
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_PICKAXE),
                true,
                "###",
                " A ",
                " S ",
                '#', VIBRANIUM_INGOT,
                'S', OBSIDIAN_STICK,
                'A', pickaxeAncientMetal);
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_SHOVEL),
                true,
                "#",
                "A",
                "S",
                '#', VIBRANIUM_INGOT,
                'S', OBSIDIAN_STICK,
                'A', shovelAncientMetal);
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_SWORD),
                true,
                " # ",
                " # ",
                " A ",
                '#', VIBRANIUM_INGOT,
                'S', OBSIDIAN_STICK,
                'A', swordAncientMetal);
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_AXE),
                true,
                "##",
                "A#",
                "S ",
                '#', VIBRANIUM_INGOT,
                'S', OBSIDIAN_STICK,
                'A', axeAncientMetal);
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_DAGGER),
                true,
                "I",
                "A",
                'I', VIBRANIUM_INGOT,
                'A', daggerAncientMetal);
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_WAR_HAMMER),
                true,
                "III",
                "IAI",
                " S ",
                'I', VIBRANIUM_INGOT,
                'S', OBSIDIAN_STICK,
                'A', warHammerAncientMetal);
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_BATTLE_AXE),
                true,
                "I I",
                "IAI",
                " S ",
                'I', VIBRANIUM_INGOT,
                'S', OBSIDIAN_STICK,
                'A', battleAxeAncientMetal);
        register.registerShapelessRecipe(new ItemStack(VIBRANIUM_INGOT, 9), true, Blocks.blockVibranium);
        register.registerShapelessRecipe(new ItemStack(Item.diamond),
                false,
                DIAMOND_CHUNK,
                DIAMOND_CHUNK,
                DIAMOND_CHUNK,
                DIAMOND_CHUNK);
        register.registerShapedRecipe(new ItemStack(BLAZE_COAL_POWDER),
                true,
                " B ",
                "BCB",
                " B ",
                'B', Item.blazePowder,
                'C', Item.coal);
        RecipesFurnace.smelting().addSmelting(Block.coalBlock.blockID, new ItemStack(DIAMOND_CHUNK));
        register.registerShapedRecipe(new ItemStack(VIBRANIUM_BOW),
                true,
                "NSL",
                "AVL",
                "NSL",
                'S', OBSIDIAN_STICK,
                'V', VIBRANIUM_INGOT,
                'L', Item.silk,
                'N', VIBRANIUM_NUGGET,
                'A', bowAncientMetal);
        register.registerShapedRecipe(new ItemStack(Item.emerald),
                true,
                "SS",
                "SS",
                'S', Item.shardEmerald);
        register.registerShapelessRecipe(new ItemStack(Item.shardEmerald, 4), true, Item.emerald);
        register.registerShapedRecipe(new ItemStack(IRON_ENHANCE_STONE),
                true,
                " C ",
                "SIS",
                " C ",
                'I', Item.ingotIron,
                'C', Item.ingotCopper,
                'S', Item.ingotSilver);
        register.registerShapedRecipe(new ItemStack(MITHRIL_ENHANCE_STONE),
                true,
                " I ",
                "GMG",
                " I ",
                'I', Item.ingotIron,
                'G', Item.ingotGold,
                'M', Item.ingotMithril);
        register.registerShapedRecipe(new ItemStack(ADAMANTIUM_ENHANCE_STONE),
                true,
                " D ",
                "MAM",
                " R ",
                'R', Block.blockRedstone,
                'D', Item.diamond,
                'M', Item.ingotMithril,
                'A', Item.ingotAdamantium);
        register.registerShapedRecipe(new ItemStack(UNIVERSAL_ENHANCE_STONE),
                true,
                "gDg",
                "bTb",
                "BEB",
                'g', Item.glowstone,
                'D', Item.bottleOfDisenchanting,
                'b', Item.blazePowder,
                'T', Item.ghastTear,
                'B', Item.book,
                'E', Item.enderPearl);
    }
}
