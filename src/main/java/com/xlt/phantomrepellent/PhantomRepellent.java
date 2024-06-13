package com.xlt.phantomrepellent;

import com.xlt.phantomrepellent.events.LootTableModifer;
import com.xlt.phantomrepellent.events.RepelPhantomsEvent;
import eu.midnightdust.lib.config.MidnightConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PhantomRepellent implements ModInitializer {
	public static final String MOD_ID = "phantomrepellent";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Phantom-Repellent...");

		//Initialize Config
		MidnightConfig.init(MOD_ID, ModConfig.class);

		//Register Potions
		ModStatusEffects.registerStatusEffects();
		ModPotions.registerModPotions();

		//Register Enchantments
		ModEnchants.registerEnchantments();

		//Populate LootTables
		LootTableModifer.init();

		//Register Events
		ServerTickEvents.END_WORLD_TICK.register(new RepelPhantomsEvent());
	}
}