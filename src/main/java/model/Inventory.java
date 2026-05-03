package model;

import java.util.HashMap;

public class Inventory extends HashMap<Item, Integer> {

    public Inventory() {
        super();
    }

    public void addItem(Item item, int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

        if (this.containsKey(item)) this.put(item, this.get(item) + amount);
        else this.put(item, amount);
    }

    public boolean removeItem(Item item, int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

        if (this.containsKey(item) && this.get(item) >= amount) {
            this.put(item, this.get(item) - amount);
            if (this.get(item) == 0) this.remove(item);
            return true;
        }
        return false;
    }

    public void listAllItems() {
        for (Item item : this.keySet()) {
            System.out.println(item.getName() + ": " + this.get(item));
        }
    }
}
