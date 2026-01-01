package net.kuvorious.mighty_mythril.datagen;

import net.kuvorious.mighty_mythril.block.ModBlocks;
import net.kuvorious.mighty_mythril.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {

    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLOCK_OF_MYTHRIL.get());
        dropSelf(ModBlocks.BLOCK_OF_RAW_MYTHRIL.get());

        add(ModBlocks.MYTHRIL_ORE.get(),
        block -> createOreDrop(ModBlocks.MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));

        add(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                block -> createOreDrop(ModBlocks.MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
