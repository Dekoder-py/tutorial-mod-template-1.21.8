package co.dekoderpy.tutorialmod.item;

import co.dekoderpy.tutorialmod.TutorialMod;
import co.dekoderpy.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup TUTORIAL_MOD_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "tutorial_mod_items"), FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET)).displayName(Text.translatable("itemgroup.tutorial_mod_items")).entries(((displayContext, entries) -> {
        entries.add(ModItems.PINK_GARNET);
        entries.add(ModItems.RAW_PINK_GARNET);
        entries.add(ModBlocks.PINK_GARNET_BLOCK);
        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        entries.add(ModBlocks.PINK_GARNET_ORE);
        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        entries.add(ModBlocks.MAGIC_BLOCK);
        entries.add(ModBlocks.BLUE_GEMSTONE_BLOCK);
        entries.add(ModItems.CHISEL);
        entries.add(ModItems.CAULIFLOWER);
        entries.add(ModItems.STARLIGHT_ASHES);

    })).build());


    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);

    }
}
