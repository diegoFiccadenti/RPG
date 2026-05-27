package entities;

import data_structures.Inventory;

public abstract class Character {

    private final String name;
    private final Inventory inventory;

    public Character(String name, Inventory inventory) {
        this.name = name;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {return inventory;}
}
