package net.kuvorious.mighty_mythril.datagen;

import net.kuvorious.mighty_mythril.MightyMythril;
import net.kuvorious.mighty_mythril.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

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

        trimmedArmorItem(ModItems.MYTHRIL_HELMET);
        trimmedArmorItem(ModItems.MYTHRIL_CHESTPLATE);
        trimmedArmorItem(ModItems.MYTHRIL_LEGGINGS);
        trimmedArmorItem(ModItems.MYTHRIL_BOOTS);
    }

    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MODID = MightyMythril.MODID;

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterials, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterials.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterials.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath);
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace() + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MODID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
    }
}
