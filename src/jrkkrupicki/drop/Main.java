package jrkkrupicki.drop;

import jrkkrupicki.drop.commands.DropCommand;
import jrkkrupicki.drop.listeners.BlockBreakListener;
import jrkkrupicki.drop.listeners.InventoryClickListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(), this);
        DropManager.loadDrops();
        registerCommand(new DropCommand(), this);
    }

    public static void registerCommand(Command command, JavaPlugin plugin){
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            CommandMap commandMap = (CommandMap)commandMapField.get(Bukkit.getServer());
            commandMap.register(plugin.getName(), command);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
