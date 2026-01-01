package net.kuvorious.mighty_mythril.item;

import net.kuvorious.mighty_mythril.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier MYTHRIL = new SimpleTier(ModTags.Blocks.INCORRECT_BLOCK_FOR_MYTHRIL_TOOL,
            800, 6f, 2f, 14, () -> Ingredient.of(ModItems.MYTHRIL_INGOT));
    public static final Tier MYTHGOLD = new SimpleTier(ModTags.Blocks.INCORRECT_BLOCK_FOR_MYTHGOLD_TOOL,
            800, 6f, 2f, 22, () -> Ingredient.of(ModItems.MYTHRIL_INGOT));
}