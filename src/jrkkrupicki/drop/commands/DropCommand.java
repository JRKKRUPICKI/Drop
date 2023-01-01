package jrkkrupicki.drop.commands;

import jrkkrupicki.drop.Drop;
import jrkkrupicki.drop.DropManager;
import jrkkrupicki.drop.builders.InventoryBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
            player.sendMessage(ChatColor.DARK_AQUA + drop.getMaterial().name() + " " + ChatColor.GREEN + drop.getChance() + "%");
        }
        InventoryBuilder inventoryBuilder = new InventoryBuilder().rows(1).title("Drop");
        for(int i = 0; i < DropManager.getDrops().size(); i++){
            inventoryBuilder.item(i, prepareItem(DropManager.getDrops().get(i)));
        }
        inventoryBuilder.item(8, getDisabledCobblestoneItem(player));
        player.openInventory(inventoryBuilder.build());
        return true;
    }

    public ItemStack prepareItem(Drop drop){
        ItemStack item = new ItemStack(drop.getMaterial());
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_AQUA + "" + drop.getChance() + "%");
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getDisabledCobblestoneItem(Player player){
        ItemStack item = new ItemStack(Material.COBBLESTONE);
        ItemMeta meta = item.getItemMeta();
        if(DropManager.isDisabledCobblestone(player.getUniqueId())) meta.setDisplayName(ChatColor.RED + "No Cobblestone Drop");
        else meta.setDisplayName(ChatColor.GREEN + "Cobblestone Drop");
        item.setItemMeta(meta);
        return item;
    }
}
