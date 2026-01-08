package net.kuvorious.mighty_mythril.datagen;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.kuvorious.mighty_mythril.block.ModBlocks;
import net.kuvorious.mighty_mythril.item.ModItems;
import net.kuvorious.mighty_mythril.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModItemRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModItemRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> MYTHRIL_SMELTABLES = List.of(ModItems.RAW_MYTHRIL,
                ModBlocks.MYTHRIL_ORE, ModBlocks.DEEPSLATE_MYTHRIL_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MYTHRIL_SWORD.get())
                .pattern(" M ")
                .pattern(" M ")
                .pattern(" S ")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_sword");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MYTHRIL_PICKAXE.get())
                .pattern("MMM")
                .pattern(" S ")
                .pattern(" S ")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_pickaxe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MYTHRIL_AXE.get())
                .pattern("MM ")
                .pattern("MS ")
                .pattern(" S ")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_axe");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MYTHRIL_SHOVEL.get())
                .pattern(" M ")
                .pattern(" S ")
                .pattern(" S ")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_shovel");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.MYTHRIL_HOE.get())
                .pattern("MM ")
                .pattern(" S ")
                .pattern(" S ")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .define('S', Items.STICK)
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_hoe");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MYTHRIL_HELMET.get())
                .pattern("MMM")
                .pattern("M M")
                .pattern("   ")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_helmet");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MYTHRIL_CHESTPLATE.get())
                .pattern("M M")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_chestplate");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MYTHRIL_LEGGINGS.get())
                .pattern("MMM")
                .pattern("M M")
                .pattern("M M")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_leggings");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.MYTHRIL_BOOTS.get())
                .pattern("M M")
                .pattern("M M")
                .pattern("   ")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythril_boots");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_MYTHRIL.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:block_from_mythril");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_RAW_MYTHRIL.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.RAW_MYTHRIL.get())
                .unlockedBy("has_raw_mythril", has(ModItems.RAW_MYTHRIL)).save(recipeOutput, "mightymythril:block_from_raw_mythril");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHGOLD_SMITHING_TEMPLATE.get())
                        .pattern("M M")
                        .pattern("MGM")
                        .pattern("MMM")
                        .define('M', ModItems.MYTHRIL_INGOT.get())
                        .define('G', Blocks.GOLD_BLOCK)
                        .unlockedBy("has_mythril_ingot", has(ModItems.MYTHRIL_INGOT)).save(recipeOutput, "mightymythril:mythgold_smithing_template");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYTHGOLD_SMITHING_TEMPLATE.get(), 2)
                .pattern("M M")
                .pattern("MTM")
                .pattern("MMM")
                .define('M', ModItems.MYTHRIL_INGOT.get())
                .define('T', ModItems.MYTHGOLD_SMITHING_TEMPLATE)
                .unlockedBy("has_mythgold_smithing_template", has(ModItems.MYTHGOLD_SMITHING_TEMPLATE)).save(recipeOutput, "mightymythril:mythgold_smith_duplicate");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MYTHRIL_INGOT.get(), 9)
                .requires(ModBlocks.BLOCK_OF_MYTHRIL)
                .unlockedBy("has_mythril_block", has(ModBlocks.BLOCK_OF_MYTHRIL)).save(recipeOutput, "mightymythril:mythril_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_MYTHRIL.get(), 9)
                .requires(ModBlocks.BLOCK_OF_RAW_MYTHRIL)
                .unlockedBy("has_raw_mythril_block", has(ModBlocks.BLOCK_OF_RAW_MYTHRIL)).save(recipeOutput, "mightymythril:mythril_from_raw_block");

        oreSmelting(recipeOutput, MYTHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MYTHRIL_INGOT.get(), 0.25f, 200, "mythril");
        oreBlasting(recipeOutput, MYTHRIL_SMELTABLES, RecipeCategory.MISC, ModItems.MYTHRIL_INGOT.get(), 0.25f, 100, "mythril");

        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                Ingredient.of(ModItems.MYTHRIL_HELMET.get()),
                Ingredient.of(Items.GOLD_INGOT),
                RecipeCategory.COMBAT,
                ModItems.MYTHGOLD_HELMET.get()
        )
                .unlocks("has_mythril_helmet", has(ModItems.MYTHRIL_HELMET))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_helmet_smithing"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.MYTHRIL_CHESTPLATE.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.MYTHGOLD_CHESTPLATE.get()
                )
                .unlocks("has_mythril_chestplate", has(ModItems.MYTHRIL_CHESTPLATE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_chestplate_smithing"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.MYTHRIL_LEGGINGS.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.MYTHGOLD_LEGGINGS.get()
                )
                .unlocks("has_mythril_leggings", has(ModItems.MYTHRIL_LEGGINGS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_leggings_smithing"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.MYTHRIL_BOOTS.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.MYTHGOLD_BOOTS.get()
                )
                .unlocks("has_mythril_boots", has(ModItems.MYTHRIL_BOOTS))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_boots_smithing"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.MYTHRIL_SWORD.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.COMBAT,
                        ModItems.MYTHGOLD_SWORD.get()
                )
                .unlocks("has_mythril_sword", has(ModItems.MYTHRIL_SWORD))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_sword_smithing"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.MYTHRIL_PICKAXE.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.MYTHGOLD_PICKAXE.get()
                )
                .unlocks("has_mythril_pickaxe", has(ModItems.MYTHRIL_PICKAXE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_pickaxe_smithing"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.MYTHRIL_AXE.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.MYTHGOLD_AXE.get()
                )
                .unlocks("has_mythril_axe", has(ModItems.MYTHRIL_AXE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_axe_smithing"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.MYTHRIL_SHOVEL.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.MYTHGOLD_SHOVEL.get()
                )
                .unlocks("has_mythril_shovel", has(ModItems.MYTHRIL_SHOVEL))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_shovel_smithing"));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.MYTHGOLD_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.MYTHRIL_HOE.get()),
                        Ingredient.of(Items.GOLD_INGOT),
                        RecipeCategory.TOOLS,
                        ModItems.MYTHGOLD_HOE.get()
                )
                .unlocks("has_mythril_hoe", has(ModItems.MYTHRIL_HOE))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(MightyMythril.MODID, "mythgold_hoe_smithing"));



    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MightyMythril.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
