package com.xlt.phantomrepellent;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions
{
    public static final Potion PhantomRepellentPotion = new Potion(new StatusEffectInstance(ModStatusEffects.PhantomRepel, 9600, 0));
    public static final Potion LongPhantomRepellentPotion = new Potion(new StatusEffectInstance(ModStatusEffects.PhantomRepel, 28800, 0));

    public static void registerModPotions()
    {
        if (ModConfig.Enable_RepelPhantom_Potion) {
            Registry.register(Registries.POTION, new Identifier(PhantomRepellent.MOD_ID, "phantomrepellent"), PhantomRepellentPotion);
            Registry.register(Registries.POTION, new Identifier(PhantomRepellent.MOD_ID, "longphantomrepellent"), LongPhantomRepellentPotion);
        }

        registerModPotionsRecipes();
    }

    public static void registerModPotionsRecipes()
    {
        Item RepelPhantomsIngredient = Registries.ITEM.get(new Identifier(ModConfig.RepelPhantom_Potion_BrewingIngredient));

        if (ModConfig.Enable_RepelPhantom_Potion_BrewingRecipe){
            BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, RepelPhantomsIngredient, PhantomRepellentPotion);
            BrewingRecipeRegistry.registerPotionRecipe(PhantomRepellentPotion, Items.REDSTONE, LongPhantomRepellentPotion);
        }
    }

}
