package com.xlt.phantomrepellent;

import com.xlt.phantomrepellent.enchantments.AphantasmalAuraEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchants
{
    private static final EquipmentSlot[] ALL_ARMOR = new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET};

    public static final Enchantment AphantasmalAura = new AphantasmalAuraEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR, ALL_ARMOR);

    public static void registerEnchantments()
    {
        if(ModConfig.Enable_AphantasmalAura_Enchant){
            Registry.register(Registries.ENCHANTMENT, new Identifier(PhantomRepellent.MOD_ID, "aphantasmal_aura"), AphantasmalAura);
        }
    }
}
