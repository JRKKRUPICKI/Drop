package jrkkrupicki.drop.builders;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryBuilder {

    private int rows;
    private String title;
    private ItemStack[] items;

    public InventoryBuilder rows(int rows){
        this.rows = rows;
        items = new ItemStack[rows * 9];
        return this;
    }

    public InventoryBuilder title(String title){
        this.title = title;
        return this;
    }

    public InventoryBuilder item(int slot, ItemStack item){
        items[slot] = item;
        return this;
    }

    public InventoryBuilder item(int row, int column, ItemStack item){
        return item(row * 9 + column, item);
    }

    public Inventory build(){
        Inventory inventory;
        if(title == null) inventory = Bukkit.createInventory(null, rows * 9);
        else inventory =  Bukkit.createInventory(null, rows * 9, title);
        for(int i = 0; i < items.length; i++){
            if(items[i] == null) continue;
            inventory.setItem(i, items[i]);
        }
        return inventory;
    }
}
