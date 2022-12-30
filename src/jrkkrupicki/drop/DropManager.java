package jrkkrupicki.drop;

import org.bukkit.Material;

import java.util.ArrayList;
import java.util.HashSet;

public class DropManager {

    private static ArrayList<Drop> drops = new ArrayList<>();
    private static HashSet<Material> blockedOres = new HashSet<>();

    public static void loadDrops(){
        drops.add(new Drop(Material.COAL, 10));
        drops.add(new Drop(Material.COPPER_INGOT, 5));
        drops.add(new Drop(Material.LAPIS_LAZULI, 6));
        drops.add(new Drop(Material.IRON_INGOT, 6));
        drops.add(new Drop(Material.GOLD_INGOT, 4));
        drops.add(new Drop(Material.REDSTONE, 4));
        drops.add(new Drop(Material.DIAMOND, 2));
        drops.add(new Drop(Material.EMERALD, 2));
        blockedOres.add(Material.COAL_ORE);
        blockedOres.add(Material.DEEPSLATE_COAL_ORE);
        blockedOres.add(Material.COPPER_ORE);
        blockedOres.add(Material.DEEPSLATE_COPPER_ORE);
        blockedOres.add(Material.LAPIS_ORE);
        blockedOres.add(Material.DEEPSLATE_LAPIS_ORE);
        blockedOres.add(Material.IRON_ORE);
        blockedOres.add(Material.DEEPSLATE_IRON_ORE);
        blockedOres.add(Material.GOLD_ORE);
        blockedOres.add(Material.DEEPSLATE_GOLD_ORE);
        blockedOres.add(Material.REDSTONE_ORE);
        blockedOres.add(Material.DEEPSLATE_REDSTONE_ORE);
        blockedOres.add(Material.DIAMOND_ORE);
        blockedOres.add(Material.DEEPSLATE_DIAMOND_ORE);
        blockedOres.add(Material.EMERALD_ORE);
        blockedOres.add(Material.DEEPSLATE_EMERALD_ORE);
    }

    public static ArrayList<Drop> getDrops(){
        return drops;
    }

    public static HashSet<Material> getBlockedOres(){
        return blockedOres;
    }
}
