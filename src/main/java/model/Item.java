package model;

import interfaces.Takeable;
import interfaces.Droppable;

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

    public void take() {}

    public void drop() {}

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
