package net.xiaoyu233.mitemod.miteite.util;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Configs {
    public static Map <String, ConfigItem> wenscMap= new HashMap<>();

    public static class ConfigItem<T>{
        public String ConfigKey;
        public T ConfigValue;
        public String ConfigComment;
        ConfigItem(String key, T value, String comment){
            this.ConfigKey = key;
            this.ConfigValue = value;
            this.ConfigComment = comment;
        }

        public void setConfigValue(T configValue) {
            ConfigValue = configValue;
        }
        public T getConfigValue() {
            return this.ConfigValue;
        }
    }
    public static class wenscConfig {
        public static ConfigItem <Boolean> BlnGravel = new ConfigItem("BlnGravel", true, "是否增加燧石概率");
        public static ConfigItem <Boolean> BlnHealth = new ConfigItem("BlnHealth", true, "是否开启最大等级500级");
        public static ConfigItem <Boolean> BlnNutrition = new ConfigItem("BlnNutrition", true, "是否开启增加玩家营养值");

        public static ConfigItem <Integer> ExpModifier = new ConfigItem("ExpModifier", 5120, "怪经验上限，最大5120");
        public static ConfigItem <Integer> MobExpValue = new ConfigItem("MobExpValue", 100, "怪物经验倍率（1-100）");
        public static ConfigItem <Integer> RockExpValue = new ConfigItem("RockExpValue", 10, "宝石经验倍率（1-10）");
        public static ConfigItem <Integer> MeatExpValue = new ConfigItem("MeatExpValue", 10, "烧肉经验倍率（1-10）");
        public static ConfigItem <Integer> OreExpValue = new ConfigItem("OreExpValue", 10, "烧旷经验倍率（1-10）");
        public static ConfigItem <Integer> MobDropValue = new ConfigItem("MobDropValue", 100, "娱乐物品掉落几率（1-100）");
        public static ConfigItem <Integer> DeadMod = new ConfigItem("DeadMod", 0, "死亡复活模式，0是正常掉落，1是死亡不掉落");
        public static ConfigItem <String> ExpMod = new ConfigItem("ExpMod", "2", "怪物掉落经验模式，0基础经验，1随天数增加，2随等级增加");
        public static ConfigItem <Integer> netherWartDifficulty = new ConfigItem("netherWartDifficulty", 2, "地狱疣生长难度");

        public static ConfigItem <Boolean> isOpenStrongBoxBreakRecord = new ConfigItem("isOpenStrongBoxBreakRecord", true, "是否开启私人箱子破坏记录");
        public static ConfigItem <Boolean> isOpenGAFish = new ConfigItem("isOpenGAFish", true, "是否开启娱乐版钓鱼");
        public static ConfigItem <Boolean> isDropZombieBrain = new ConfigItem("isDropZombieBrain", true, "是否掉落僵尸脑子");
        public static ConfigItem <Boolean> isRecipeRottenSoup = new ConfigItem("isRecipeRottenSoup", true, "是否有腐肉汤配方");
        public static ConfigItem <Boolean> isRecipeGAGoldApple = new ConfigItem("isRecipeGAGoldApple", true, "是否有娱乐版金苹果配方");
        public static ConfigItem <Boolean> isRecipeGAPickaxe = new ConfigItem("isRecipeGAPickaxe", true, "是否有娱乐版镐子配方");
        public static ConfigItem <Boolean> isDropBlueGem = new ConfigItem("isDropBlueGem", true, "是否掉落蓝宝石");
        public static ConfigItem <Boolean> isDropGAStones = new ConfigItem("isDropGAStones", true, "是否掉落石粒");
        public static ConfigItem <Boolean> isDropSpiderLegs = new ConfigItem("isDropSpiderLegs", true, "是否掉落蜘蛛腿");
        public static ConfigItem <Boolean> isRecipeGATorch = new ConfigItem("isRecipeGATorch", true, "是否有娱乐版火把，木材配方");
        public static ConfigItem <Boolean> isRecipeMineralBag = new ConfigItem("isRecipeMineralBag", true, "是否有矿物袋配方");
        public static ConfigItem <Boolean> isRecipeGABag = new ConfigItem("isRecipeGABag", true, "是否有纳戒配方");
        public static ConfigItem <Boolean> isRecipeRingKiller = new ConfigItem("isRecipeRingKiller", true, "是否有魔灵刃配方");
        public static ConfigItem <Boolean> isRecipeDrugProtection = new ConfigItem("isRecipeDrugProtection", true, "是否有筑基丹配方");
        public static ConfigItem <Boolean> isDropCreeper = new ConfigItem("isDropCreeper", true, "是否掉落苦力怕宝宝");
        public static ConfigItem <Boolean> isRecipeDrugFull = new ConfigItem("isRecipeDrugFull", true, "是否有辟谷丹配方");

        public static ConfigItem <Float> inWallDamageForPlayer = new ConfigItem("inWallDamageForPlayer", 10.0F, "玩家墙内窒息伤害(小数)");
        public static ConfigItem <Double> steppedMobDamageFactor = new ConfigItem("steppedMobDamageFactor", 1d, "渐进伤害每次增幅点数基础值(小数)");
        public static ConfigItem <Double> steppedMobDamageProgressMax = new ConfigItem("steppedMobDamageProgressMax", 4d, "渐进伤害增幅最大值(小数)");
        public static ConfigItem <Integer> steppedMobDamageProgressIncreaseDay = new ConfigItem("steppedMobDamageProgressIncreaseDay", 24, "渐进伤害每次增幅每增加一点所需天数(整数)");
        public static ConfigItem <Double> steppedPlayerDamageProgress = new ConfigItem("steppedPlayerDamageProgress", 2d, "玩家对怪物渐进伤害(不计附魔)最大值");
        public static ConfigItem <Double> steppedPlayerDamageIncreasePerLvl = new ConfigItem("steppedPlayerDamageIncreasePerLvl", 0.1d, "玩家对怪物渐进伤害每级加成");
        public static ConfigItem <Integer> fishingXp = new ConfigItem("fishingXp", 10, "钓鱼经验(整数)");
        public static ConfigItem <Integer> inRainDebuffTime = new ConfigItem("inRainDebuffTime", 3600, "雨中获得负面效果所需时长(整数)");
        public static ConfigItem <Boolean> firstDayLongerDayTime = new ConfigItem("firstDayLongerDayTime", true, "加长第一天时间(开关)");
        public static ConfigItem <Integer> playerDefenseCooldown = new ConfigItem("playerDefenseCooldown", 160, "玩家格挡冷却(tick)");
        public static ConfigItem <Integer> playerDefenceMaxTime = new ConfigItem("playerDefenceMaxTime", 40, "玩家格挡最大时间(tick)");
        public static ConfigItem <Boolean> playerDisarmPlayer = new ConfigItem("playerDisarmPlayer", true, "玩家缴械玩家");
        public static ConfigItem <Double> bloodMoonMaxHostileFraction = new ConfigItem("bloodMoonMaxHostileFraction", 128d, "血月最大刷怪数量系数(小数)");
        public static ConfigItem <Integer> ghastSpawnLimitDay = new ConfigItem("ghastSpawnLimitDay", 128, "主世界生成恶魂所需天数(整数)");
        public static ConfigItem <Boolean> annihilationSkeletonSpawnInLight = new ConfigItem("annihilationSkeletonSpawnInLight", false, "主世界湮灭骷髅在光照出生成");
        public static ConfigItem <Integer> ancientBoneLordSpawnLimitDay = new ConfigItem("ancientBoneLordSpawnLimitDay", 192, "主世界生成远古骷髅公爵所需天数(整数)");
        public static ConfigItem <Integer> wanderingWitchSpawnChanceOverworld = new ConfigItem("wanderingWitchSpawnChanceOverworld", 33, "主世界流浪女巫生成概率百分比(整数)");
        public static ConfigItem <Integer> wanderingWitchSpawnLimitDayOverworld = new ConfigItem("wanderingWitchSpawnLimitDayOverworld", 64, "主世界流浪女巫生成天数限制(整数)");
        public static ConfigItem <Integer> wanderingWitchSpawnLimitDayOther = new ConfigItem("wanderingWitchSpawnLimitDayOther", 64, "地狱及地底世界流浪女巫生成天数限制(整数)");
        public static ConfigItem <Integer> wanderingWitchSpawnChanceUnderworld = new ConfigItem("wanderingWitchSpawnChanceUnderworld", 50, "地底世界流浪女巫生成概率百分比(整数)");
        public static ConfigItem <Integer> mobMaxSpawnCountIncreasePerDay = new ConfigItem("mobMaxSpawnCountIncreasePerDay", 1, "每天刷怪数量上限增量(整数)");
        public static ConfigItem <Boolean> underworldRandomTeleport = new ConfigItem("underworldRandomTeleport", true, "地底世界随机传送(开关)");
        public static ConfigItem <Integer> underworldRandomTeleportTimeNew = new ConfigItem("underworldRandomTeleportTimeNew", 132000, "地底世界随机传送时间(整数)");
        public static ConfigItem <Boolean> underworldDebuff = new ConfigItem("underworldDebuff", true, "地底世界负面效果(开关)");
        public static ConfigItem <Integer> underworldDebuffPeriod1 = new ConfigItem("underworldDebuffPeriod1", 72000, "地底世界负面效果第一阶段触发时间(整数)");
        public static ConfigItem <Integer> underworldDebuffPeriod2 = new ConfigItem("underworldDebuffPeriod2", 108000, "地底世界负面效果第二阶段触发时间(整数)");
        public static ConfigItem <Boolean> netherrackDamage = new ConfigItem("netherrackDamage", true, "地狱烫脚(开关)");
        public static ConfigItem <Integer> netherrackDamageLimitDay = new ConfigItem("netherrackDamageLimitDay", 96, "地狱烫脚所需天数(整数)");
        public static ConfigItem <Boolean> netherDebuff = new ConfigItem("netherDebuff", true, "地狱负面效果(开关)");
        public static ConfigItem <Integer> netherDebuffTime = new ConfigItem("netherDebuffTime", 72000, "地狱负面效果触发时间(tick)");
        public static ConfigItem <Integer> quartzMaxExpLevel = new ConfigItem("quartzMaxExpLevel", 55, "石英可提供经验最大等级");
        public static ConfigItem <Integer> diamondExp = new ConfigItem("diamondExp", 400, "钻石经验");
        public static ConfigItem <Integer> emeraldExp = new ConfigItem("emeraldExp", 300, "绿宝石经验");
        public static ConfigItem <Integer> quartzExp = new ConfigItem("quartzExp", 35, "石英经验");
        public static ConfigItem <Integer> goldenAppleEatTime = new ConfigItem("goldenAppleEatTime", 10, "金苹果使用耗时（tick）");
        public static ConfigItem <Integer> enchantedGoldenAppleEatTime = new ConfigItem("enchantedGoldenAppleEatTime", 10, "附魔金苹果,腐肉汤使用耗时（tick）");
        public static ConfigItem <Integer> ironToMithrilCookTime = new ConfigItem("ironToMithrilCookTime", 6000, "铁烧制为秘银耗时（tick）");
        public static ConfigItem <Integer> ironBlockCountToMithril = new ConfigItem("ironBlockCountToMithril", 2, "铁烧制为秘银所需铁块数量");
        public static ConfigItem <Integer> mithrilToAdamantiumCookTime = new ConfigItem("mithrilToAdamantiumCookTime", 9000, "秘银烧制为艾德曼耗时");
        public static ConfigItem <Integer> mithrilBlockCountToAdamantium = new ConfigItem("mithrilBlockCountToAdamantium", 1, "秘银烧制为艾德曼所需秘银块数量");
        public static ConfigItem <Integer> critEnchantmentChanceBoostPerLvl = new ConfigItem("critEnchantmentChanceBoostPerLvl", 2, "暴击附魔每级暴击几率");
        public static ConfigItem <Float> critEnchantmentDamageBoostPerLvl = new ConfigItem("critEnchantmentDamageBoostPerLvl", 0.4F, "暴击附魔每级额外伤害");
        public static ConfigItem <Integer> emergencyCooldown = new ConfigItem("emergencyCooldown", 120000, "紧急守备冷却时间（tick）");
        public static ConfigItem <Double> emergencyCooldownReduceEveryArmor = new ConfigItem("emergencyCooldownReduceEveryArmor", 0.2, "紧急守备每件装备冷却减免百分比");
        public static ConfigItem <Integer> emergencyHealthRecoverAmount = new ConfigItem("emergencyHealthRecoverAmount", 10, "紧急守备触发后恢复至的血量");
        public static ConfigItem <Double> conquerorDamageBoostPerLvl = new ConfigItem("conquerorDamageBoostPerLvl", 1d, "征服者每级额外伤害");
        public static ConfigItem <Float> beheadingChanceBoostPerLvl = new ConfigItem("beheadingChanceBoostPerLvl", 0.05f, "斩首每级头颅额外掉落几率");
        public static ConfigItem <Double> allProtectionVDefenceFraction = new ConfigItem("allProtectionVDefenceFraction", 0.1d, "全套保护5伤害减免");
        public static ConfigItem <Boolean> mobSpawnerSpeedUpWithPlayers = new ConfigItem("mobSpawnerSpeedUpWithPlayers", true, "刷怪笼在旁边有玩家时加速生怪");
        public static ConfigItem <Boolean> isSpawnExchanger = new ConfigItem("isSpawnExchanger", true, "是否生成转移骷髅");
        public static ConfigItem <Boolean> boneLordTweak = new ConfigItem("boneLordTweak", true, "骷髅领主增强");
        public static ConfigItem <Boolean> skeletonTripleShot = new ConfigItem("skeletonTripleShot", true, "三发骷髅");
        public static ConfigItem <Boolean> compressedSkeleton = new ConfigItem("compressedSkeleton", true, "分裂骷髅");
        public static ConfigItem <Integer> compressedSkeletonCrackStandTime = new ConfigItem("compressedSkeletonCrackStandTime", 20, "分裂骷髅分裂后停滞时间(tick)");
        public static ConfigItem <Integer> compressedSkeletonExpandCount = new ConfigItem("compressedSkeletonExpandCount", 4, "分裂骷髅分裂数量");
        public static ConfigItem <Boolean> skeletonForceMeleeAttack = new ConfigItem("skeletonForceMeleeAttack", true, "强制骷髅近战");
        public static ConfigItem <Float> boneLordAndLongdeadChangeWeaponChance = new ConfigItem("boneLordAndLongdeadChangeWeaponChance", 0.25f, "古尸和骷髅领主会切换武器概率");
        public static ConfigItem <Boolean> batPoisonAttack = new ConfigItem("batPoisonAttack", true, "吸血蝙蝠攻击使玩家中毒");
        public static ConfigItem <Boolean> infernalCreeperBoost = new ConfigItem("infernalCreeperBoost", true, "增强地狱爬行者");
        public static ConfigItem <Boolean> zombiePigmanUseBow = new ConfigItem("zombiePigmanUseBow", true, "猪人带弓");
        public static ConfigItem <Double> zombiePigmanBoostChance = new ConfigItem("zombiePigmanBoostChance", 0.025D, "精英猪人生成概率");
        public static ConfigItem <Boolean> zombiePigmanAttackAnimails = new ConfigItem("zombiePigmanAttackAnimails", false, "僵尸猪人攻击动物");
        public static ConfigItem <Float> ghastOverworldBoost = new ConfigItem("ghastOverworldBoost", 1.25F, "主世界恶魂火球爆炸范围增强倍数");
        public static ConfigItem <Boolean> wolvesAttackPlayersWithMeat = new ConfigItem("wolvesAttackPlayersWithMeat", true, "狼攻击快捷栏有肉的玩家");
        public static ConfigItem <Integer> villagerWoolToEmeraldShardCount = new ConfigItem("villagerWoolToEmeraldShardCount", 4, "村民用羊毛换绿宝石碎片-羊毛所需数量");
        public static ConfigItem <Integer> villagerWoolToEmeraldShardShardCount = new ConfigItem("villagerWoolToEmeraldShardShardCount", 1, "村民用羊毛换绿宝石碎片-绿宝石碎片获得数量");
        public static ConfigItem <Boolean> canBoostIronGolem = new ConfigItem("canBoostIronGolem", true, "可以强化铁傀儡");
        public static ConfigItem <Boolean> mobDefense = new ConfigItem("mobDefense", true, "怪物格挡");
        public static ConfigItem <Boolean> mobDisarmWhenDefence = new ConfigItem("mobDisarmWhenDefence", true, "怪物格挡时若有缴械附魔有几率缴械");
        public static ConfigItem <Boolean> mobDisarmWhenAttack = new ConfigItem("mobDisarmWhenAttack", true, "怪物攻击时若有缴械附魔有几率缴械");
        public static ConfigItem <Boolean> mobAttackCauseFire = new ConfigItem("mobAttackCauseFire", true, "怪物有几率在手持装备攻击时使目标着火");
        public static ConfigItem <Integer> annihilationSkeletonDespawnTime = new ConfigItem("annihilationSkeletonDespawnTime", 3600, "湮灭骷髅被攻击后消失用时(tick)");
        public static ConfigItem <Float> enderDragonAttackWitherChance = new ConfigItem("enderDragonAttackWitherChance", 0.2f, "末影龙受攻击后给予玩家凋零几率");
        public static ConfigItem <Float> enderDragonImmuneToArrowHealthPercent = new ConfigItem("enderDragonImmuneToArrowHealthPercent", 0.3f, "末影龙免疫弓箭血量百分比");
        public static ConfigItem <Boolean> enderDragonAttackSlowness = new ConfigItem("enderDragonAttackSlowness", true, "末影龙攻击玩家给予玩家缓慢效果");
        public static ConfigItem <Float> netherModAttackFireChance = new ConfigItem("netherModAttackFireChance", 0.5f, "地狱生物攻击火焰附加概率");
        public static ConfigItem <Integer> slimeAttackDamageMultiplier = new ConfigItem("slimeAttackDamageMultiplier", 1, "绿色史莱姆伤害倍数");
        public static ConfigItem <Float> slimeAttackDamageBonus = new ConfigItem("slimeAttackDamageBonus", 4f, "绿色史莱姆伤害加成");
        public static ConfigItem <Integer> giantZombieSpawnZombieCooldown = new ConfigItem("giantZombieSpawnZombieCooldown", 1200, "巨型僵尸生成僵尸间隔(tick)");
        public static ConfigItem <Integer> animalIllToDeathTime = new ConfigItem("animalIllToDeathTime", 144000, "生物生病死亡时间(tick)");
        public static ConfigItem <Integer> breedXpChicken = new ConfigItem("breedXpChicken", 8, "鸡繁殖获得经验");
        public static ConfigItem <Integer> breedXpSheep = new ConfigItem("breedXpSheep", 10, "羊繁殖获得经验");
        public static ConfigItem <Integer> breedXpPig = new ConfigItem("breedXpPig", 15, "猪繁殖获得经验");
        public static ConfigItem <Integer> breedXpCow = new ConfigItem("breedXpCow", 25, "牛繁殖获得经验");
        public static ConfigItem <Integer> emeraldFrequencyBigHills = new ConfigItem("emeraldFrequencyBigHills", 6, "山地绿宝石矿每区块最少生成个数");
        public static ConfigItem <Boolean> overworldAdamantiteOre = new ConfigItem("overworldAdamantiteOre", false, "主世界生成艾德曼");
        public static ConfigItem <Integer> copperFrequencyOverworld = new ConfigItem("copperFrequencyOverworld", 40, "主世界铜矿生成频率");
        public static ConfigItem <Integer> silverFrequencyOverworld = new ConfigItem("silverFrequencyOverworld", 10, "主世界银矿生成频率");
        public static ConfigItem <Integer> ironFrequencyOverworld = new ConfigItem("ironFrequencyOverworld", 40, "主世界铁矿生成频率");
        public static ConfigItem <Integer> goldFrequencyOverworld = new ConfigItem("goldFrequencyOverworld", 20, "主世界金矿生成频率");
        public static ConfigItem <Integer> mithrilFrequencyOverworld = new ConfigItem("mithrilFrequencyOverworld", 10, "主世界秘银矿生成频率");
        public static ConfigItem <Integer> lapisFrequencyOverworld = new ConfigItem("lapisFrequencyOverworld", 4, "主世界青金石矿生成频率");
        public static ConfigItem <Integer> diamondFrequencyOverworld = new ConfigItem("diamondFrequencyOverworld", 5, "主世界钻石矿生成频率");
        public static ConfigItem <Integer> adamantiumFrequencyOverworld = new ConfigItem("adamantiumFrequencyOverworld", 1, "主世界艾德曼矿生成频率");
        public static ConfigItem <Integer> copperFrequencyUnderworld = new ConfigItem("copperFrequencyUnderworld", 40, "地底世界铜矿生成频率");
        public static ConfigItem <Integer> silverFrequencyUnderworld = new ConfigItem("silverFrequencyUnderworld", 10, "地底世界银矿生成频率");
        public static ConfigItem <Integer> ironFrequencyUnderworld = new ConfigItem("ironFrequencyUnderworld", 60, "地底世界铁矿生成频率");
        public static ConfigItem <Integer> goldFrequencyUnderworld = new ConfigItem("goldFrequencyUnderworld", 20, "地底世界金矿生成频率");
        public static ConfigItem <Integer> mithrilFrequencyUnderworld = new ConfigItem("mithrilFrequencyUnderworld", 10, "地底世界秘银矿生成频率");
        public static ConfigItem <Integer> lapisFrequencyUnderworld = new ConfigItem("lapisFrequencyUnderworld", 5, "地底世界青金石矿生成频率");
        public static ConfigItem <Integer> diamondFrequencyUnderworld = new ConfigItem("diamondFrequencyUnderworld", 5, "地底世界钻石矿生成频率");
        public static ConfigItem <Integer> adamantiumFrequencyUnderworld = new ConfigItem("adamantiumFrequencyUnderworld", 2, "地底世界艾德曼矿生成频率");
        public static ConfigItem <Integer> underworldMantleBlockOffset = new ConfigItem("underworldMantleBlockOffset", 0, "地底世界地幔位置向上偏移");
        public static ConfigItem <Integer> netherAdamantiumMaxCountPerChunk = new ConfigItem("netherAdamantiumMaxCountPerChunk", 3, "地狱艾德曼每个区块最大生成数量");
        public static ConfigItem <Integer> netherAdamantiumMaxCountPerVein = new ConfigItem("netherAdamantiumMaxCountPerVein", 2, "地狱艾德曼每个矿脉最大矿物生成数量");
        public static ConfigItem <Integer> healthBarXOffset = new ConfigItem("healthBarXOffset", 0, "营养条GUI横向偏移");
        public static ConfigItem <Integer> healthBarYOffset = new ConfigItem("healthBarYOffset", 0, "营养条GUI纵向偏移");
        public static ConfigItem <Boolean> logPlayersInteractWithPortal = new ConfigItem("logPlayersInteractWithPortal", true, "玩家通过传送门时发送警告(开关)");
        public static ConfigItem <Integer> underworldGateOpenDay = new ConfigItem("underworldGateOpenDay", 1, "地下世界传送门多少天可以打开(主世界天数)");
        public static ConfigItem <Integer> netherGateOpenDay = new ConfigItem("netherGateOpenDay", 1, "地狱传送门多少天可以打开(主世界天数)");
    }

    public static void loadConfigs(){

        wenscMap.put("BlnGravel", wenscConfig.BlnGravel);
        wenscMap.put("BlnHealth", wenscConfig.BlnHealth);
        wenscMap.put("BlnNutrition", wenscConfig.BlnNutrition);
        wenscMap.put("ExpModifier", wenscConfig.ExpModifier);
        wenscMap.put("MobExpValue", wenscConfig.MobExpValue);
        wenscMap.put("RockExpValue", wenscConfig.RockExpValue);
        wenscMap.put("MeatExpValue", wenscConfig.MeatExpValue);
        wenscMap.put("OreExpValue", wenscConfig.OreExpValue);
        wenscMap.put("MobDropValue", wenscConfig.MobDropValue);
        wenscMap.put("DeadMod", wenscConfig.DeadMod);
        wenscMap.put("ExpMod", wenscConfig.ExpMod);
        wenscMap.put("netherWartDifficulty", wenscConfig.netherWartDifficulty);
        wenscMap.put("isOpenStrongBoxBreakRecord", wenscConfig.isOpenStrongBoxBreakRecord);
        wenscMap.put("isOpenGAFish", wenscConfig.isOpenGAFish);
        wenscMap.put("isDropZombieBrain", wenscConfig.isDropZombieBrain);
        wenscMap.put("isRecipeRottenSoup", wenscConfig.isRecipeRottenSoup);
        wenscMap.put("isRecipeGAGoldApple", wenscConfig.isRecipeGAGoldApple);
        wenscMap.put("isRecipeGAPickaxe", wenscConfig.isRecipeGAPickaxe);
        wenscMap.put("isDropBlueGem", wenscConfig.isDropBlueGem);
        wenscMap.put("isDropGAStones", wenscConfig.isDropGAStones);
        wenscMap.put("isDropSpiderLegs", wenscConfig.isDropSpiderLegs);
        wenscMap.put("isRecipeGATorch", wenscConfig.isRecipeGATorch);
        wenscMap.put("isRecipeMineralBag", wenscConfig.isRecipeMineralBag);
        wenscMap.put("isRecipeGABag", wenscConfig.isRecipeGABag);
        wenscMap.put("isRecipeRingKiller", wenscConfig.isRecipeRingKiller);
        wenscMap.put("isRecipeDrugProtection", wenscConfig.isRecipeDrugProtection);
        wenscMap.put("isDropCreeper", wenscConfig.isDropCreeper);
        wenscMap.put("isRecipeDrugFull", wenscConfig.isRecipeDrugFull);

        wenscMap.put("inWallDamageForPlayer", wenscConfig.inWallDamageForPlayer);
        wenscMap.put("steppedMobDamageFactor", wenscConfig.steppedMobDamageFactor);
        wenscMap.put("steppedMobDamageProgressMax", wenscConfig.steppedMobDamageProgressMax);
        wenscMap.put("steppedMobDamageProgressIncreaseDay", wenscConfig.steppedMobDamageProgressIncreaseDay);
        wenscMap.put("steppedPlayerDamageProgress", wenscConfig.steppedPlayerDamageProgress);
        wenscMap.put("steppedPlayerDamageIncreasePerLvl", wenscConfig.steppedPlayerDamageIncreasePerLvl);
        wenscMap.put("fishingXp", wenscConfig.fishingXp);
        wenscMap.put("inRainDebuffTime", wenscConfig.inRainDebuffTime);
        wenscMap.put("firstDayLongerDayTime", wenscConfig.firstDayLongerDayTime);
        wenscMap.put("playerDefenseCooldown", wenscConfig.playerDefenseCooldown);
        wenscMap.put("playerDefenceMaxTime", wenscConfig.playerDefenceMaxTime);
        wenscMap.put("playerDisarmPlayer", wenscConfig.playerDisarmPlayer);
        wenscMap.put("bloodMoonMaxHostileFraction", wenscConfig.bloodMoonMaxHostileFraction);
        wenscMap.put("ghastSpawnLimitDay", wenscConfig.ghastSpawnLimitDay);
        wenscMap.put("annihilationSkeletonSpawnInLight", wenscConfig.annihilationSkeletonSpawnInLight);
        wenscMap.put("ancientBoneLordSpawnLimitDay", wenscConfig.ancientBoneLordSpawnLimitDay);
        wenscMap.put("wanderingWitchSpawnChanceOverworld", wenscConfig.wanderingWitchSpawnChanceOverworld);
        wenscMap.put("wanderingWitchSpawnLimitDayOverworld", wenscConfig.wanderingWitchSpawnLimitDayOverworld);
        wenscMap.put("wanderingWitchSpawnLimitDayOther", wenscConfig.wanderingWitchSpawnLimitDayOther);
        wenscMap.put("wanderingWitchSpawnChanceUnderworld", wenscConfig.wanderingWitchSpawnChanceUnderworld);
        wenscMap.put("mobMaxSpawnCountIncreasePerDay", wenscConfig.mobMaxSpawnCountIncreasePerDay);
        wenscMap.put("underworldRandomTeleport", wenscConfig.underworldRandomTeleport);
        wenscMap.put("underworldRandomTeleportTimeNew", wenscConfig.underworldRandomTeleportTimeNew);
        wenscMap.put("underworldDebuff", wenscConfig.underworldDebuff);
        wenscMap.put("underworldDebuffPeriod1", wenscConfig.underworldDebuffPeriod1);
        wenscMap.put("underworldDebuffPeriod2", wenscConfig.underworldDebuffPeriod2);
        wenscMap.put("netherrackDamage", wenscConfig.netherrackDamage);
        wenscMap.put("netherrackDamageLimitDay", wenscConfig.netherrackDamageLimitDay);
        wenscMap.put("netherDebuff", wenscConfig.netherDebuff);
        wenscMap.put("netherDebuffTime", wenscConfig.netherDebuffTime);
        wenscMap.put("quartzMaxExpLevel", wenscConfig.quartzMaxExpLevel);
        wenscMap.put("diamondExp", wenscConfig.diamondExp);
        wenscMap.put("emeraldExp", wenscConfig.emeraldExp);
        wenscMap.put("quartzExp", wenscConfig.quartzExp);
        wenscMap.put("goldenAppleEatTime", wenscConfig.goldenAppleEatTime);
        wenscMap.put("enchantedGoldenAppleEatTime", wenscConfig.enchantedGoldenAppleEatTime);
        wenscMap.put("ironToMithrilCookTime", wenscConfig.ironToMithrilCookTime);
        wenscMap.put("ironBlockCountToMithril", wenscConfig.ironBlockCountToMithril);
        wenscMap.put("mithrilToAdamantiumCookTime", wenscConfig.mithrilToAdamantiumCookTime);
        wenscMap.put("mithrilBlockCountToAdamantium", wenscConfig.mithrilBlockCountToAdamantium);
        wenscMap.put("critEnchantmentChanceBoostPerLvl", wenscConfig.critEnchantmentChanceBoostPerLvl);
        wenscMap.put("critEnchantmentDamageBoostPerLvl", wenscConfig.critEnchantmentDamageBoostPerLvl);
        wenscMap.put("emergencyCooldown", wenscConfig.emergencyCooldown);
        wenscMap.put("emergencyCooldownReduceEveryArmor", wenscConfig.emergencyCooldownReduceEveryArmor);
        wenscMap.put("emergencyHealthRecoverAmount", wenscConfig.emergencyHealthRecoverAmount);
        wenscMap.put("conquerorDamageBoostPerLvl", wenscConfig.conquerorDamageBoostPerLvl);
        wenscMap.put("beheadingChanceBoostPerLvl", wenscConfig.beheadingChanceBoostPerLvl);
        wenscMap.put("allProtectionVDefenceFraction", wenscConfig.allProtectionVDefenceFraction);
        wenscMap.put("mobSpawnerSpeedUpWithPlayers", wenscConfig.mobSpawnerSpeedUpWithPlayers);
        wenscMap.put("isSpawnExchanger", wenscConfig.isSpawnExchanger);
        wenscMap.put("boneLordTweak", wenscConfig.boneLordTweak);
        wenscMap.put("skeletonTripleShot", wenscConfig.skeletonTripleShot);
        wenscMap.put("compressedSkeleton", wenscConfig.compressedSkeleton);
        wenscMap.put("compressedSkeletonCrackStandTime", wenscConfig.compressedSkeletonCrackStandTime);
        wenscMap.put("compressedSkeletonExpandCount", wenscConfig.compressedSkeletonExpandCount);
        wenscMap.put("skeletonForceMeleeAttack", wenscConfig.skeletonForceMeleeAttack);
        wenscMap.put("boneLordAndLongdeadChangeWeaponChance", wenscConfig.boneLordAndLongdeadChangeWeaponChance);
        wenscMap.put("batPoisonAttack", wenscConfig.batPoisonAttack);
        wenscMap.put("infernalCreeperBoost", wenscConfig.infernalCreeperBoost);
        wenscMap.put("zombiePigmanUseBow", wenscConfig.zombiePigmanUseBow);
        wenscMap.put("zombiePigmanBoostChance", wenscConfig.zombiePigmanBoostChance);
        wenscMap.put("zombiePigmanAttackAnimails", wenscConfig.zombiePigmanAttackAnimails);
        wenscMap.put("ghastOverworldBoost", wenscConfig.ghastOverworldBoost);
        wenscMap.put("wolvesAttackPlayersWithMeat", wenscConfig.wolvesAttackPlayersWithMeat);
        wenscMap.put("villagerWoolToEmeraldShardCount", wenscConfig.villagerWoolToEmeraldShardCount);
        wenscMap.put("villagerWoolToEmeraldShardShardCount", wenscConfig.villagerWoolToEmeraldShardShardCount);
        wenscMap.put("canBoostIronGolem", wenscConfig.canBoostIronGolem);
        wenscMap.put("mobDefense", wenscConfig.mobDefense);
        wenscMap.put("mobDisarmWhenDefence", wenscConfig.mobDisarmWhenDefence);
        wenscMap.put("mobDisarmWhenAttack", wenscConfig.mobDisarmWhenAttack);
        wenscMap.put("mobAttackCauseFire", wenscConfig.mobAttackCauseFire);
        wenscMap.put("annihilationSkeletonDespawnTime", wenscConfig.annihilationSkeletonDespawnTime);
        wenscMap.put("enderDragonAttackWitherChance", wenscConfig.enderDragonAttackWitherChance);
        wenscMap.put("enderDragonImmuneToArrowHealthPercent", wenscConfig.enderDragonImmuneToArrowHealthPercent);
        wenscMap.put("enderDragonAttackSlowness", wenscConfig.enderDragonAttackSlowness);
        wenscMap.put("netherModAttackFireChance", wenscConfig.netherModAttackFireChance);
        wenscMap.put("slimeAttackDamageMultiplier", wenscConfig.slimeAttackDamageMultiplier);
        wenscMap.put("slimeAttackDamageBonus", wenscConfig.slimeAttackDamageBonus);
        wenscMap.put("giantZombieSpawnZombieCooldown", wenscConfig.giantZombieSpawnZombieCooldown);
        wenscMap.put("animalIllToDeathTime", wenscConfig.animalIllToDeathTime);
        wenscMap.put("breedXpChicken", wenscConfig.breedXpChicken);
        wenscMap.put("breedXpSheep", wenscConfig.breedXpSheep);
        wenscMap.put("breedXpPig", wenscConfig.breedXpPig);
        wenscMap.put("breedXpCow", wenscConfig.breedXpCow);
        wenscMap.put("emeraldFrequencyBigHills", wenscConfig.emeraldFrequencyBigHills);
        wenscMap.put("overworldAdamantiteOre", wenscConfig.overworldAdamantiteOre);
        wenscMap.put("copperFrequencyOverworld", wenscConfig.copperFrequencyOverworld);
        wenscMap.put("silverFrequencyOverworld", wenscConfig.silverFrequencyOverworld);
        wenscMap.put("ironFrequencyOverworld", wenscConfig.ironFrequencyOverworld);
        wenscMap.put("goldFrequencyOverworld", wenscConfig.goldFrequencyOverworld);
        wenscMap.put("mithrilFrequencyOverworld", wenscConfig.mithrilFrequencyOverworld);
        wenscMap.put("lapisFrequencyOverworld", wenscConfig.lapisFrequencyOverworld);
        wenscMap.put("diamondFrequencyOverworld", wenscConfig.diamondFrequencyOverworld);
        wenscMap.put("adamantiumFrequencyOverworld", wenscConfig.adamantiumFrequencyOverworld);
        wenscMap.put("copperFrequencyUnderworld", wenscConfig.copperFrequencyUnderworld);
        wenscMap.put("silverFrequencyUnderworld", wenscConfig.silverFrequencyUnderworld);
        wenscMap.put("ironFrequencyUnderworld", wenscConfig.ironFrequencyUnderworld);
        wenscMap.put("goldFrequencyUnderworld", wenscConfig.goldFrequencyUnderworld);
        wenscMap.put("mithrilFrequencyUnderworld", wenscConfig.mithrilFrequencyUnderworld);
        wenscMap.put("lapisFrequencyUnderworld", wenscConfig.lapisFrequencyUnderworld);
        wenscMap.put("diamondFrequencyUnderworld", wenscConfig.diamondFrequencyUnderworld);
        wenscMap.put("adamantiumFrequencyUnderworld", wenscConfig.adamantiumFrequencyUnderworld);
        wenscMap.put("underworldMantleBlockOffset", wenscConfig.underworldMantleBlockOffset);
        wenscMap.put("netherAdamantiumMaxCountPerChunk", wenscConfig.netherAdamantiumMaxCountPerChunk);
        wenscMap.put("netherAdamantiumMaxCountPerVein", wenscConfig.netherAdamantiumMaxCountPerVein);
        wenscMap.put("healthBarXOffset", wenscConfig.healthBarXOffset);
        wenscMap.put("healthBarYOffset", wenscConfig.healthBarYOffset);
        wenscMap.put("logPlayersInteractWithPortal", wenscConfig.logPlayersInteractWithPortal);
        wenscMap.put("underworldGateOpenDay", wenscConfig.underworldGateOpenDay);
        wenscMap.put("netherGateOpenDay", wenscConfig.netherGateOpenDay);



        String filePth = "wensc.cfg";
        File file_mite = new File(filePth);
        if (file_mite.exists()) {
            Properties properties = new Properties();
            FileReader fr = null;
            try {
                fr = new FileReader(file_mite.getName());
                properties.load(fr);
                fr.close();
                readConfigFromFile(file_mite, properties);
                packConfigFile(file_mite, properties);
            } catch (FileNotFoundException var6) {
                var6.printStackTrace();
            } catch (IOException var7) {
                var7.printStackTrace();
            }
        } else {
            try {
                if (file_mite.createNewFile()){
                    file_mite.setExecutable(true);//设置可执行权限
                    file_mite.setReadable(true);//设置可读权限
                    file_mite.setWritable(true);//设置可写权限
                    generateConfigFile(file_mite);
                }
            } catch (IOException e) {
                e.printStackTrace();
                JFrame jFrame = new JFrame();
                jFrame.setAlwaysOnTop(true);
                JOptionPane.showMessageDialog(jFrame, "创建wensc.cfg配置文件失败，请前往www.wensc.cn自行下载", "错误", 0);
                System.exit(0);
            }
        }
    }
    public static void  readConfigFromFile(File file_mite, Properties properties) {
        for (String key : properties.stringPropertyNames()) {
            ConfigItem configItem = wenscMap.get(key);
            if(configItem != null) {
                if(configItem.ConfigValue instanceof Boolean) {
                    configItem.setConfigValue(Boolean.parseBoolean(properties.getProperty(key)));
                } else if(configItem.ConfigValue instanceof Float) {
                    configItem.setConfigValue(Float.parseFloat(properties.getProperty(key)));
                } else if(configItem.ConfigValue instanceof Double) {
                    configItem.setConfigValue(Double.parseDouble(properties.getProperty(key)));
                } else if(configItem.ConfigValue instanceof Integer) {
                    configItem.setConfigValue(Integer.parseInt(properties.getProperty(key)));
                } else {
                    configItem.setConfigValue(properties.getProperty(key));
                }
            }
        }
    }

    public static void packConfigFile(File file,Properties properties) {
        try{
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            for (Map.Entry<String, ConfigItem> entry: wenscMap.entrySet()) {
                ConfigItem value = entry.getValue();
                String localValue = properties.getProperty(value.ConfigKey);
                if(localValue == null) {
                    fileWritter.write("// " + value.ConfigComment + "\n");
                    fileWritter.write(value.ConfigKey + "=" + value.ConfigValue + "\n\n");
                }
            }
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateConfigFile(File file) {
        try{
            FileWriter fileWritter = new FileWriter(file.getName());
            fileWritter.write("// MITE-GA-P14配置文件，说明：【布尔类型：true为开启，false关闭】，在【名称=值】之间/之后不要存在空格或者其他无关字符，【tick：20tick=1秒】\n");
            for (Map.Entry<String, ConfigItem> entry: wenscMap.entrySet()) {
                ConfigItem value = entry.getValue();
                fileWritter.write("// " + value.ConfigComment + "\n");
                fileWritter.write(value.ConfigKey + "=" + value.ConfigValue + "\n\n");
            }
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}