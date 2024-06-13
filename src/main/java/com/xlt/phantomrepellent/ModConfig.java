package com.xlt.phantomrepellent;

import eu.midnightdust.lib.config.MidnightConfig;

public class ModConfig extends MidnightConfig {
    @Entry(category = "text") public static boolean Enable_RepelPhantom_Potion = true;
    @Entry(category = "text") public static boolean Enable_RepelPhantom_Potion_BrewingRecipe = true;
    @Entry(category = "text") public static String RepelPhantom_Potion_BrewingIngredient = "minecraft:sunflower";

    @Entry(category = "text") public static boolean Enable_AphantasmalAura_Enchant = true;
    @Entry(category = "text") public static boolean AphantasmalAura_isTreasure = true;
    @Entry(category = "text") public static boolean AphantasmalAura_isVillagerTrade = false;
    @Entry(category = "text") public static boolean AphantasmalAura_isFoundRandomly = false;
    @Entry(category = "text") public static boolean AphantasmalAura_isEndCityLoot = true;
    @Entry(category = "number") public static float AphantasmalAura_EndCityLoot_Chance = 0.1F;
}
