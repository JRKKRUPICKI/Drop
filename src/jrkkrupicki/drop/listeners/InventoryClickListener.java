package jrkkrupicki.drop.listeners;

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
        event.getWhoClicked().sendMessage("blocked");
    }
}
