package net.kuvorious.mighty_mythril.datagen;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.kuvorious.mighty_mythril.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MightyMythril.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_MYTHRIL.get());
        basicItem(ModItems.MYTHRIL_INGOT.get());
        basicItem(ModItems.MYTHRIL_SWORD.get());
        basicItem(ModItems.MYTHRIL_PICKAXE.get());
        basicItem(ModItems.MYTHRIL_AXE.get());
        basicItem(ModItems.MYTHRIL_SHOVEL.get());
        basicItem(ModItems.MYTHRIL_HOE.get());
    }
}
