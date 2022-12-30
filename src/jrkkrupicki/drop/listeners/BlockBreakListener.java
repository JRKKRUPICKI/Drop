package jrkkrupicki.drop.listeners;

import jrkkrupicki.drop.Drop;
import jrkkrupicki.drop.DropManager;
import jrkkrupicki.drop.RandomUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        Block block = event.getBlock();
        Player player = event.getPlayer();
        if(DropManager.getBlockedOres().contains(block.getType())){
            event.setDropItems(false);
            event.setExpToDrop(0);
        }
        if(!block.getType().equals(Material.STONE)) return;
        for(Drop drop : DropManager.getDrops()){
            boolean chance = RandomUtils.getChange(drop.getChance());
            if(!chance) continue;
            block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(drop.getMaterial()));
        }
    }
}
