package net.kuvorious.mighty_mythril.item;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MightyMythril.MODID);

public static final DeferredItem<Item> FRIEND = ITEMS.register("friend",
        () -> new Item(new Item.Properties()));
public static final DeferredItem<Item> RAW_MYTHRIL = ITEMS.register("raw_mythril",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
