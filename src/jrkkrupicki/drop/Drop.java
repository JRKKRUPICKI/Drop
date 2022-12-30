package jrkkrupicki.drop;

import org.bukkit.Material;

public class Drop {

    private Material material;
    private double chance;

    public Drop(Material material, double chance){
        this.material = material;
        this.chance = chance;
    }

    public Material getMaterial(){
        return material;
    }

    public double getChance(){
        return chance;
    }
}
