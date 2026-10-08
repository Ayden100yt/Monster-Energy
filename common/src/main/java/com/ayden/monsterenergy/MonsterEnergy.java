package com.ayden.monsterenergy;

import java.util.List;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class MonsterEnergy {
	public static final String MOD_ID = "monster_energy";
	public static final String CAN_NAME = "monster_energy_can";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// 60 seconds (20 ticks = 1 second)
	public static final int EFFECT_TICKS = 60 * 20;

	public static final ResourceKey<Item> CAN_KEY = ResourceKey.create(
			Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, CAN_NAME));

	private MonsterEnergy() {
	}

	// 1.6s drink animation + sound, then Speed II and Haste I
	public static Consumable canConsumable() {
		return Consumables.defaultDrink()
				.onConsume(new ApplyStatusEffectsConsumeEffect(List.of(
						new MobEffectInstance(MobEffects.SPEED, EFFECT_TICKS, 1),
						new MobEffectInstance(MobEffects.HASTE, EFFECT_TICKS, 0))))
				.build();
	}

	// Monster can
	public static Item createCan() {
		return new Item(new Item.Properties()
				.setId(CAN_KEY)
				.stacksTo(16)
				.rarity(Rarity.UNCOMMON)
				.component(DataComponents.CONSUMABLE, canConsumable()));
	}
}
