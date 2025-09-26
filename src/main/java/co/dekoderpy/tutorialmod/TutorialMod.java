package co.dekoderpy.tutorialmod;

import co.dekoderpy.tutorialmod.block.ModBlocks;
import co.dekoderpy.tutorialmod.item.ModItemGroups;
import co.dekoderpy.tutorialmod.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
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

        registerFuel();
        registerTooltips();
    }

    public void registerFuel() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(ModItems.STARLIGHT_ASHES, 600);
        });
    }

    public static void registerTooltips() {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModItems.CHISEL)) {
                if (Screen.hasShiftDown()) {
                    list.add(Text.translatable("tooltip.tutorialmod.chisel.shift_down"));
                } else {
                    list.add(Text.translatable("tooltip.tutorialmod.chisel"));
                }
            }
            if (itemStack.isOf(ModBlocks.MAGIC_BLOCK.asItem())) {
                list.add(Text.translatable("tooltip.tutorialmod.magic_block.tooltip"));
            }
            if (itemStack.isOf(ModItems.CAULIFLOWER)) {
                list.add(Text.translatable("tooltip.tutorialmod.cauliflower.tooltip"));
            }
        });
    }
}