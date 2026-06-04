package data_structures;

import items.Item;

import java.util.HashMap;

public class Inventory {

    private final HashMap<Item, Integer> items;

    private int maxCapacity;

    public Inventory(int maxCapacity) {
        items = new HashMap<>();
        this.maxCapacity = maxCapacity;
    }

    public Inventory(HashMap<Item, Integer> items, int maxCapacity) {
        this.items = items;
        this.maxCapacity = maxCapacity;
    }

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public int getMaxCapacity() {return maxCapacity;}

    public void setMaxCapacity(int maxCapacity) {this.maxCapacity = maxCapacity;}

    public void addItem(Item item, int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

        if (items.containsKey(item)) items.put(item, items.get(item) + amount);
        else items.put(item, amount);
    }

    public boolean removeItem(Item item, int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

        if (items.containsKey(item) && items.get(item) >= amount) {
            items.put(item, items.get(item) - amount);
            if (items.get(item) == 0) items.remove(item);
            return true;
        }
        return false;
    }

    public void listAllItems() {
        for (Item item : items.keySet()) {
            System.out.println(item.getName() + ": " + items.get(item));
        }
    }
}
