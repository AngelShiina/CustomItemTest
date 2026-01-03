package net.kitsuakihiko;

import lombok.Getter;
import net.kitsuakihiko.commands.SpeedSwordCommand;
import net.kitsuakihiko.items.SpeedSword;
import net.kitsuakihiko.listener.SpeedSwordListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public String prefix = "§8[§bSpeed§eSword§8] ";

    @Getter
    public static Main instance;

    @Getter
    public static SpeedSword speedSword;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        speedSword = new SpeedSword();
        speedSword();

        Bukkit.getConsoleSender().sendMessage(prefix + "§aloaded!");
    }

    private void speedSword() {
        getCommand("speedsword").setExecutor(new SpeedSwordCommand());

        if(!getConfig().getBoolean("speed_sword_crafted", false)) {
            speedSword.registerSpeedSwordRecipe();
        } else {
            Bukkit.getConsoleSender().sendMessage(prefix + "§cRecipe not registered (already crafted).");
        }
        getServer().getPluginManager().registerEvents(new SpeedSwordListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
