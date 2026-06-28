package it.unicam.cs.mpgc.rpg132379.items;

import it.unicam.cs.mpgc.rpg132379.entities.Character;

public abstract class Item implements Takeable, Droppable {

    private final String name;
    private final String description;
    private final int cost;

    public Item(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public int getCost() {return cost;}

    public void take(Character taker) {
        if (taker == null) throw new  IllegalArgumentException("taker cannot be null");

        taker.getInventory().addItem(this, 1);
    }

    public void drop(Character dropper) {
        if (dropper == null) throw new  IllegalArgumentException("dropper cannot be null");

        dropper.getInventory().removeItem(this, 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Item other = (Item) obj;
        return (this.name.equals(other.name));
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
