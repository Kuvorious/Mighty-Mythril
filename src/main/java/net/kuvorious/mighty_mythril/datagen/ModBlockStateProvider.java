package net.kuvorious.mighty_mythril.datagen;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.kuvorious.mighty_mythril.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MightyMythril.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOCK_OF_MYTHRIL);
        blockWithItem(ModBlocks.BLOCK_OF_RAW_MYTHRIL);
        blockWithItem(ModBlocks.MYTHRIL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MYTHRIL_ORE);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
