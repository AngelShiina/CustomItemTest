package net.kitsuakihiko.heavysword;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Equippable;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import net.kitsuakihiko.Main;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class HeavySword {
    public ItemStack getHeavySword() {
        final ItemStack heavysword = ItemStack.of(Material.STICK);
        final ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.itemAttributes();

        builder.addModifier(Attribute.ATTACK_SPEED, new AttributeModifier(new NamespacedKey(Main.getInstance(), "attack_speed"), -2.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND));
        builder.addModifier(Attribute.ATTACK_DAMAGE, new AttributeModifier(new NamespacedKey(Main.getInstance(), "attack_damage"), 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND));

        heavysword.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS, builder.build());
        heavysword.setData(DataComponentTypes.ITEM_MODEL, Key.key("clipspro", "heavysword"));
        heavysword.setData(DataComponentTypes.ITEM_NAME, Component.text("§bHeavy §eSword"));
        heavysword.setData(DataComponentTypes.EQUIPPABLE, Equippable.equippable(EquipmentSlot.HAND).build());
        heavysword.setData(DataComponentTypes.MAX_STACK_SIZE, 1);

        return heavysword;
    }

    public void registerHeavySwordRecipe() {
        ItemStack result = getHeavySword().clone();

        NamespacedKey key = new NamespacedKey(Main.getInstance(), "heavysword");
        ShapedRecipe recipe = new ShapedRecipe(key, result);

        recipe.shape(
                new String(new char[]{' ', 'I', ' '}),
                new String(new char[]{' ', 'C', ' '}),
                "GLG"
        );

        recipe.setIngredient('I', Material.IRON_BLOCK);
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('L', Material.LEATHER);

        recipe.setIngredient('C', Material.NETHERITE_INGOT);

        Bukkit.addRecipe(recipe);
    }

}
