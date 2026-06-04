package entities;

import data_structures.Inventory;
import quantifiables.Currency;

public abstract class Character {

    private final String name;
    private final Inventory inventory;
    private final Currency coins = new Currency(0);

    public Character(String name) {
        this.name = name;
        this.inventory = new Inventory(16);
    }

    public Character(String name, Inventory inventory, int coins) {
        this.name = name;
        this.inventory = inventory;
        this.coins.increaseCurrent(coins);
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {return inventory;}

    public Currency getCoins() {return coins;}
}
