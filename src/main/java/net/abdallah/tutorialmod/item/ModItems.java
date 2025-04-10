package net.abdallah.tutorialmod.item;

import net.abdallah.tutorialmod.TutorialMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.IdentityHashMap;

public class ModItems {

    public static final Item RUBY = registerItem("ruby",new Item(new FabricItemSettings())) ;
    public static final Item RAW_RUBY = registerItem("raw_ruby" , new Item((new FabricItemSettings())));
    public static final Item PLATINUM = registerItem("platinum" , new Item((new FabricItemSettings())));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(PLATINUM);
    }


    private static Item registerItem(String name , Item item) {
        return Registry.register(Registries.ITEM , new Identifier(TutorialMod.MOD_ID , name) , item) ;
    }

    public static void  registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for" + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
