package net.kuvorious.mighty_mythril.item;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.kuvorious.mighty_mythril.item.custom.FriendHand;
import net.kuvorious.mighty_mythril.item.custom.MythrilPickaxeItem;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.world.item.Items.registerItem;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MightyMythril.MODID);

public static final DeferredItem<Item> FRIEND = ITEMS.register("friend",
        () -> new FriendHand(new Item.Properties().durability(32)));
public static final DeferredItem<Item> RAW_MYTHRIL = ITEMS.register("raw_mythril",
        () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> MYTHRIL_SWORD = ITEMS.register("mythril_sword",
            () -> new SwordItem(ModToolTiers.MYTHRIL, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.MYTHRIL, 3, -2.4f))));
    public static final DeferredItem<PickaxeItem> MYTHRIL_PICKAXE = ITEMS.register("mythril_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MYTHRIL, new Item.Properties()
                    .durability(800)
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.MYTHRIL, 1, -2.8f))));
    public static final DeferredItem<AxeItem> MYTHRIL_AXE = ITEMS.register("mythril_axe",
            () -> new AxeItem(ModToolTiers.MYTHRIL, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.MYTHRIL, 5, -3.1f))));
    public static final DeferredItem<ShovelItem> MYTHRIL_SHOVEL = ITEMS.register("mythril_shovel",
            () -> new ShovelItem(ModToolTiers.MYTHRIL, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.MYTHRIL, 1.5f, -3.0f))));
    public static final DeferredItem<HoeItem> MYTHRIL_HOE = ITEMS.register("mythril_hoe",
            () -> new HoeItem(ModToolTiers.MYTHRIL, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.MYTHRIL, -2.0f, -1.0f))));

    public static final DeferredItem<SwordItem> MYTHGOLD_SWORD = ITEMS.register("mythgold_sword",
            () -> new SwordItem(ModToolTiers.MYTHGOLD, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.MYTHGOLD, 3, -1.8f))));
    public static final DeferredItem<PickaxeItem> MYTHGOLD_PICKAXE = ITEMS.register("mythgold_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MYTHGOLD, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.MYTHGOLD, 1, -2.4f))));
    public static final DeferredItem<AxeItem> MYTHGOLD_AXE = ITEMS.register("mythgold_axe",
            () -> new AxeItem(ModToolTiers.MYTHGOLD, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.MYTHGOLD, 5, -2.7f))));
    public static final DeferredItem<ShovelItem> MYTHGOLD_SHOVEL = ITEMS.register("mythgold_shovel",
            () -> new ShovelItem(ModToolTiers.MYTHGOLD, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.MYTHGOLD, 1.5f, -2.6f))));
    public static final DeferredItem<HoeItem> MYTHGOLD_HOE = ITEMS.register("mythgold_hoe",
            () -> new HoeItem(ModToolTiers.MYTHGOLD, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.MYTHGOLD, -2.0f, -0.5f))));

    public static final DeferredItem<MythrilPickaxeItem> MYTHRIL_PICKAXE_TEST = ITEMS.register("mythril_pickaxe_test",
            () -> new MythrilPickaxeItem(ModToolTiers.MYTHRIL, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

