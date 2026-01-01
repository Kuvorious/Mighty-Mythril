package net.kuvorious.mighty_mythril.item;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.kuvorious.mighty_mythril.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MightyMythril.MODID);

    public static final Supplier<CreativeModeTab> MYTHRIL_ITEMS_TAB =
            CREATIVE_MODE_TAB.register("mythril_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RAW_MYTHRIL.get()))
                            .title(Component.translatable("creativetab.mighty_mythril.mythril_items"))
                                    .displayItems((itemDisplayParameters, output) -> {
                                        output.accept(ModItems.RAW_MYTHRIL);
                                        output.accept(ModItems.MYTHRIL_INGOT);
                                        output.accept(ModItems.MYTHRIL_SWORD);
                                        output.accept(ModItems.MYTHRIL_PICKAXE);
                                        output.accept(ModItems.MYTHRIL_AXE);
                                        output.accept(ModItems.MYTHRIL_SHOVEL);
                                        output.accept(ModItems.MYTHRIL_HOE);
                                        output.accept(ModItems.MYTHGOLD_SWORD);
                                        output.accept(ModItems.MYTHGOLD_PICKAXE);
                                        output.accept(ModItems.MYTHGOLD_AXE);
                                        output.accept(ModItems.MYTHGOLD_SHOVEL);
                                        output.accept(ModItems.MYTHGOLD_HOE);
                                        output.accept(ModItems.FRIEND);
                                        output.accept(ModBlocks.BLOCK_OF_RAW_MYTHRIL);
                                        output.accept(ModBlocks.MYTHRIL_ORE);
                                        output.accept(ModBlocks.DEEPSLATE_MYTHRIL_ORE);
                                        output.accept(ModBlocks.BLOCK_OF_MYTHRIL);

             }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
