package de.angelshiina;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SpeedSwordCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player player)) {
            sender.sendMessage(Main.getInstance().prefix + "§cYou can't use this Command!");
            return true;
        }

        if(!player.hasPermission("speedsword.get")) {
            player.sendMessage(Main.getInstance().prefix + "§cYou don't have the permission to do this!");
            return true;
        }

        ItemStack sword = Main.speedSword.getSpeedSword();
        player.getInventory().addItem(sword);
        player.sendMessage(Main.getInstance().prefix + "§aYou got the SpeedSword! §ehave fun §6:D");
        return true;
    }

}
