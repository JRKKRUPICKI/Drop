package jrkkrupicki.drop;

import jrkkrupicki.drop.commands.DropCommand;
import jrkkrupicki.drop.listeners.BlockBreakListener;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.craftbukkit.v1_19_R1.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public class DropMain extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        DropManager.loadDrops();
        registerCommand(new DropCommand());
    }

    public void registerCommand(Command command){
//        ((CraftServer)Bukkit.getServer()).getCommandMap().register(getName(), new DropCommand());
        try {
            Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            commandMapField.setAccessible(true);
            CommandMap commandMap = (CommandMap)commandMapField.get(Bukkit.getServer());
            commandMap.register(getName(), command);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
