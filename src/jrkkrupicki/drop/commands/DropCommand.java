package jrkkrupicki.drop.commands;

import jrkkrupicki.drop.Drop;
import jrkkrupicki.drop.DropManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DropCommand extends Command {

    public DropCommand() {
        super("drop");
    }

    @Override
    public boolean execute(CommandSender commandSender, String label, String[] args) {
        if(!(commandSender instanceof Player)){
            commandSender.sendMessage(ChatColor.RED + "Only for players");
            return true;
        }
        Player player = (Player)commandSender;
        for(Drop drop : DropManager.getDrops()){
            player.sendMessage(ChatColor.AQUA + drop.getMaterial().name() + " " + ChatColor.GREEN + drop.getChance() + "%");
        }
        return true;
    }
}
