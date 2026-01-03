package net.kitsuakihiko.items;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Equippable;
import io.papermc.paper.datacomponent.item.ItemAttributeModifiers;
import net.kitsuakihiko.Main;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;

public class SpeedSword {

    public ItemStack getSpeedSword() {
        final ItemStack speedsword = ItemStack.of(Material.STICK);
        final ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.itemAttributes();

        builder.addModifier(Attribute.ATTACK_SPEED, new AttributeModifier(new NamespacedKey(Main.getInstance(), "attack_speed"), 2.5, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND));
        builder.addModifier(Attribute.ATTACK_DAMAGE, new AttributeModifier(new NamespacedKey(Main.getInstance(), "attack_damage"), 6, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlotGroup.MAINHAND));

        speedsword.setData(DataComponentTypes.ATTRIBUTE_MODIFIERS, builder.build());
        speedsword.setData(DataComponentTypes.ITEM_MODEL, Key.key("clipspro", "speed"));
        speedsword.setData(DataComponentTypes.ITEM_NAME, Component.text("§bShort Sword"));
        speedsword.setData(DataComponentTypes.EQUIPPABLE, Equippable.equippable(EquipmentSlot.HAND).build());
        speedsword.setData(DataComponentTypes.MAX_STACK_SIZE, 1);

        return speedsword;
    }
}
