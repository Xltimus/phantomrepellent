package com.xlt.phantomrepellent.enchantments;

import com.xlt.phantomrepellent.ModConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class AphantasmalAuraEnchantment extends Enchantment
{
    public AphantasmalAuraEnchantment(Rarity weight, EnchantmentTarget target, EquipmentSlot[] slotTypes) {
        super(weight, target, slotTypes);
    }

    @Override
    public int getMinPower(int level) {
        return level * 25;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 50;
    }

    @Override
    public boolean isTreasure() {
        return ModConfig.AphantasmalAura_isTreasure;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return ModConfig.AphantasmalAura_isVillagerTrade;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return ModConfig.AphantasmalAura_isFoundRandomly;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

}
