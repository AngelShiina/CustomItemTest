package net.kitsuakihiko;

import lombok.Getter;
import net.kitsuakihiko.heavysword.HeavySword;
import net.kitsuakihiko.heavysword.HeavySwordCommand;
import net.kitsuakihiko.heavysword.HeavySwordListener;
import net.kitsuakihiko.speedsword.SpeedSwordCommand;
import net.kitsuakihiko.speedsword.SpeedSword;
import net.kitsuakihiko.speedsword.SpeedSwordListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public String prefix = "§8[§bSpeed§eSword§8] ";

    @Getter
    public static Main instance;

    @Getter
    public static SpeedSword speedSword;
    @Getter
    public static HeavySword heavySword;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        speedSword = new SpeedSword();
        heavySword = new HeavySword();
        registerSpeedSword();
        registerHeavySword();

        Bukkit.getConsoleSender().sendMessage(prefix + "§aloaded!");
    }

    private void registerSpeedSword() {
        getCommand("speedsword").setExecutor(new SpeedSwordCommand());

        if(!getConfig().getBoolean("speed_sword_crafted", false)) {
            speedSword.registerSpeedSwordRecipe();
        } else {
            Bukkit.getConsoleSender().sendMessage(prefix + "§cRecipe not registered (already crafted (speedsword)).");
        }
        getServer().getPluginManager().registerEvents(new SpeedSwordListener(), this);
    }

    private void registerHeavySword() {
        getCommand("heavysword").setExecutor(new HeavySwordCommand());
        if(!getConfig().getBoolean("heavy_sword_crafted", false)) {
            heavySword.registerHeavySwordRecipe();
        } else {
            Bukkit.getConsoleSender().sendMessage(prefix + "§cRecipe is not registed (already crafted (heavysword)).");
        }
        getServer().getPluginManager().registerEvents(new HeavySwordListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
