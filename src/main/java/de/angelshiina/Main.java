package de.angelshiina;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.units.qual.Speed;

public final class Main extends JavaPlugin {

    public String prefix = "§8[§bSpeed§eSword§8] ";

    @Getter
    public static Main instance;

    @Getter
    public static SpeedSword speedSword;

    @Override
    public void onEnable() {
        instance = this;
        speedSword = new SpeedSword();
        getCommand("speedsword").setExecutor(new SpeedSwordCommand());

        Bukkit.getConsoleSender().sendMessage(prefix + "§aloaded!");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
