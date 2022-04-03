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


    public static final Item Gem_Blue = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Material.diamond, "gem_blue").setCraftingDifficultyAsComponent(1.0E-9F);

    public static final Item Stack_Torch = createInstance(Item.class, new Class[]{int.class, Material.class, String.class}, Constant.getNextItemID(), Material.seed, "stack_torch");


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

        Gem_Blue.setCreativeTab(CreativeModeTab.tabMaterials);

        register("gem_blue", Gem_Blue).setUnlocalizedName("gem_blue").setMaxStackSize(64);

        register("stack_torch", Stack_Torch).setUnlocalizedName("stack_torch").setMaxStackSize(64).setCraftingDifficultyAsComponent(1.0E-9F);


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

        register.registerShapelessRecipe(new ItemStack(Blocks.blockGotcha, 64, 4), true, new Object[]{Gem_Blue});

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
        }


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
