package jrkkrupicki.drop.listeners;

import jrkkrupicki.drop.DropManager;
import jrkkrupicki.drop.commands.DropCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryClickListener implements Listener {

    @EventHandler()
    public void onInventoryClick(InventoryClickEvent event){
        Inventory inventory = event.getClickedInventory();
        if(inventory == null) return;
        if(!event.getView().getTitle().equals("Drop")) return;
        event.setCancelled(true);
        int slot = event.getRawSlot();
        Player player = (Player)event.getWhoClicked();
        if(slot == 8){
            boolean result = DropManager.toggleDisabledCobblestone(player.getUniqueId());
            event.getWhoClicked().sendMessage("disabledCobblestone: " + result);
            event.setCurrentItem(DropCommand.getDisabledCobblestoneItem(player));
        }
    }
}
