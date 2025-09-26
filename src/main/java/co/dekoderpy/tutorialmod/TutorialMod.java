package co.dekoderpy.tutorialmod;

import co.dekoderpy.tutorialmod.block.ModBlocks;
import co.dekoderpy.tutorialmod.item.ModItemGroups;
import co.dekoderpy.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
    public static final String MOD_ID = "tutorialmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.STARLIGHT_ASHES, 600);
        });
    }
}