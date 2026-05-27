package items;

import entities.Character;

public abstract class Item implements Takeable, Droppable {

    private final String name;
    private final String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void take(entities.Character taker) {
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
