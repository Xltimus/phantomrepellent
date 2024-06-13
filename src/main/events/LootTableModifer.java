package com.xlt.phantomrepellent.events;

import com.xlt.phantomrepellent.ModConfig;
import com.xlt.phantomrepellent.ModEnchants;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.EnchantRandomlyLootFunction;
import net.minecraft.util.Identifier;

public class LootTableModifer {

    public static final Identifier ENDCITY_LOOT = new Identifier("minecraft","chests/end_city_treasure");

    public static void init(){
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (ModConfig.Enable_AphantasmalAura_Enchant && ModConfig.AphantasmalAura_isEndCityLoot) {
                if (source.isBuiltin() && ENDCITY_LOOT.equals(id)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .conditionally(RandomChanceLootCondition.builder(ModConfig.AphantasmalAura_EndCityLoot_Chance))
                            .with(ItemEntry.builder(Items.BOOK).apply(new EnchantRandomlyLootFunction.Builder().add(ModEnchants.AphantasmalAura)));

                    tableBuilder.pool(poolBuilder);
                }
            }
        });
    }
}
