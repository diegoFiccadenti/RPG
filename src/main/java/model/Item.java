package model;

public abstract class Item {

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
