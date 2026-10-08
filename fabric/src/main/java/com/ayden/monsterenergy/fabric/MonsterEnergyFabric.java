package com.ayden.monsterenergy.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import com.ayden.monsterenergy.MonsterEnergy;

/** Fabric entry point (see fabric.mod.json). */
public class MonsterEnergyFabric implements ModInitializer {
	public static Item MONSTER_ENERGY_CAN;

	@Override
	public void onInitialize() {
		MONSTER_ENERGY_CAN = Registry.register(BuiltInRegistries.ITEM, MonsterEnergy.CAN_KEY, MonsterEnergy.createCan());

		// Shows the can in the "Food & Drinks" creative tab
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
				.register(output -> output.accept(MONSTER_ENERGY_CAN));

		MonsterEnergy.LOGGER.info("Monster Energy loaded (Fabric).");
	}
}
