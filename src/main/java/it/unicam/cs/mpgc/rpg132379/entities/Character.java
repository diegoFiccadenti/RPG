package it.unicam.cs.mpgc.rpg132379.entities;

import it.unicam.cs.mpgc.rpg132379.components.Inventory;
import it.unicam.cs.mpgc.rpg132379.components.Currency;

public abstract class Character {

    private final String name;
    private final Inventory inventory;
    private final Currency coins;

    public Character(String name, Inventory inventory, int coins) {
        this.name = name;
        this.inventory = inventory;
        this.coins = new Currency(coins);
    }

    public String getName() {
        return name;
    }

    public Inventory getInventory() {return inventory;}

    public Currency getCoins() {return coins;}
}
