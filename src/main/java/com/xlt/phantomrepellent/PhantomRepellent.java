package com.xlt.phantomrepellent;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhantomRepellent implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "phantomrepellent";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static StatusEffect PhantomRepel = new PhantomRepelEffect(StatusEffectCategory.BENEFICIAL, 0xA9CB3F);
	public static Potion PhantomRepellentPotion = new Potion(new StatusEffectInstance(PhantomRepel, 9600, 0));
	public static Potion LongPhantomRepellentPotion = new Potion(new StatusEffectInstance(PhantomRepel, 28800, 0));

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Phantom-Repellent...");

		Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, "phantomrepel"), PhantomRepel);

		Registry.register(Registries.POTION, new Identifier(MOD_ID,"phantomrepellent"), PhantomRepellentPotion);
		Registry.register(Registries.POTION, new Identifier(MOD_ID,"longphantomrepellent"), LongPhantomRepellentPotion);
		BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.SUNFLOWER, PhantomRepellentPotion);
		BrewingRecipeRegistry.registerPotionRecipe(PhantomRepellentPotion, Items.REDSTONE, LongPhantomRepellentPotion);
	}
}