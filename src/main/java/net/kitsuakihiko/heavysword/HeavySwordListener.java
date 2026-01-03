package net.kitsuakihiko.heavysword;

import net.kitsuakihiko.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

public class HeavySwordListener implements Listener {
    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent event) {
        if (event.getRecipe() == null) return;

        ItemStack result = event.getRecipe().getResult();
        if (result == null) return;

        if (!result.isSimilar(Main.getHeavySword().getHeavySword())) return;

        if (Main.getInstance().getConfig().getBoolean("heavy_sword_crafted")) {
            event.getInventory().setResult(null);
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (event.getRecipe() == null) return;

        ItemStack result = event.getRecipe().getResult();
        if (result == null) return;

        if (!result.isSimilar(Main.getHeavySword().getHeavySword())) return;

        if (!Main.getInstance().getConfig().getBoolean("heavy_sword_crafted")) {
            Main.getInstance().getConfig().set("heavy_sword_crafted", true);
            Main.getInstance().saveConfig();

            event.getWhoClicked().sendMessage(
                    Main.getInstance().prefix +
                            "§aYou crafted the §eONLY §aHeavy Sword on this server!"
            );
        }
    }
}
