package net.kuvorious.mighty_mythril.datagen;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.kuvorious.mighty_mythril.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MightyMythril.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.BLOCK_OF_MYTHRIL.get())
                .add(ModBlocks.BLOCK_OF_RAW_MYTHRIL.get())
                .add(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get())
                .add(ModBlocks.MYTHRIL_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.MYTHRIL_ORE.get())
                .add(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get());
    }
}
