package net.kuvorious.mighty_mythril.datagen;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.kuvorious.mighty_mythril.item.ModItems;
import net.kuvorious.mighty_mythril.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import net.minecraft.tags.ItemTags;
import net.kuvorious.mighty_mythril.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MightyMythril.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.MYTHRIL_SWORD.get())
                .add(ModItems.MYTHGOLD_SWORD.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.MYTHRIL_PICKAXE.get())
                .add(ModItems.MYTHGOLD_PICKAXE.get());

        tag(ItemTags.AXES)
                .add(ModItems.MYTHRIL_AXE.get())
                .add(ModItems.MYTHGOLD_AXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.MYTHRIL_SHOVEL.get())
                .add(ModItems.MYTHGOLD_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.MYTHRIL_HOE.get())
                .add(ModItems.MYTHGOLD_HOE.get());

        tag(Tags.Items.INGOTS)
                .add(ModItems.MYTHRIL_INGOT.get());

        tag(Tags.Items.RAW_MATERIALS)
                .add(ModItems.RAW_MYTHRIL.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MYTHRIL_HELMET.get())
                .add(ModItems.MYTHRIL_CHESTPLATE.get())
                .add(ModItems.MYTHRIL_LEGGINGS.get())
                .add(ModItems.MYTHRIL_BOOTS.get())
                .add(ModItems.MYTHGOLD_HELMET.get())
                .add(ModItems.MYTHGOLD_CHESTPLATE.get())
                .add(ModItems.MYTHGOLD_LEGGINGS.get())
                .add(ModItems.MYTHGOLD_BOOTS.get());

        this.tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.MYTHRIL_HELMET.get())
                .add(ModItems.MYTHGOLD_HELMET.get());

        this.tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.MYTHRIL_CHESTPLATE.get())
                .add(ModItems.MYTHGOLD_CHESTPLATE.get());

        this.tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.MYTHRIL_LEGGINGS.get())
                .add(ModItems.MYTHGOLD_LEGGINGS.get());

        this.tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.MYTHRIL_BOOTS.get())
                .add(ModItems.MYTHGOLD_BOOTS.get());

    }
}
