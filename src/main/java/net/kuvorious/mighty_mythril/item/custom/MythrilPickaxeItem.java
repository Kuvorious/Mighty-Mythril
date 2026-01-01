package net.kuvorious.mighty_mythril.item.custom;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.enchantment.Enchantment;

public class MythrilPickaxeItem extends PickaxeItem {
    public MythrilPickaxeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean supportsEnchantment(ItemStack stack, Holder<Enchantment> enchantment) {
        System.out.println("=== FORCING ENCHANTMENT SUPPORT ===");
        System.out.println("Enchantment: " + enchantment);

        // Force it to return true for testing
        return true;
    }
}
