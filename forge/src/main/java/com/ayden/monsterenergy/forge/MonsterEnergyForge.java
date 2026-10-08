package com.ayden.monsterenergy.forge;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.ayden.monsterenergy.MonsterEnergy;

@Mod(MonsterEnergy.MOD_ID)
public final class MonsterEnergyForge {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MonsterEnergy.MOD_ID);

	public static final RegistryObject<Item> MONSTER_ENERGY_CAN = ITEMS.register(MonsterEnergy.CAN_NAME, MonsterEnergy::createCan);

	public MonsterEnergyForge(FMLJavaModLoadingContext context) {
		ITEMS.register(context.getModBusGroup());

		// Shows the can in the "Food & Drinks" creative tab
		BuildCreativeModeTabContentsEvent.BUS.addListener(MonsterEnergyForge::addToCreativeTab);

		MonsterEnergy.LOGGER.info("Monster Energy loaded (Forge).");
	}

	private static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			event.accept(MONSTER_ENERGY_CAN);
		}
	}
}
