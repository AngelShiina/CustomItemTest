package net.kitsuakihiko.heavysword;

import net.kitsuakihiko.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HeavySwordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage(Main.getInstance().prefix + "§cYou can't use this Command!");
            return true;
        }

        if(!player.hasPermission("swords.get.heavysword")) {
            player.sendMessage(Main.getInstance().prefix + "§cYou don't have the permission to do this!");
            return true;
        }

        ItemStack sword = Main.heavySword.getHeavySword();
        player.getInventory().addItem(sword);
        player.sendMessage(Main.getInstance().prefix + "§aYou got the HeavySword! §ehave fun §6:D");
        return true;
    }
}
