package co.dekoderpy.tutorialmod.item;

import co.dekoderpy.tutorialmod.TutorialMod;
import co.dekoderpy.tutorialmod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item.Settings());
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item.Settings());

    public static final ChiselItem CHISEL = registerChiselItem("chisel", new Item.Settings().maxDamage(32));

    private static ChiselItem registerChiselItem(String name, Item.Settings itemSettings) {

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));

        ChiselItem item = new ChiselItem(itemSettings.registryKey(key));

        return Registry.register(Registries.ITEM, key, item);

    }

    private static Item registerItem(String name, Item.Settings itemSettings) {

        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));

        Item item = new Item(itemSettings.registryKey(key));

        return Registry.register(Registries.ITEM, key, item);

    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(CHISEL);
        });
    }
}
