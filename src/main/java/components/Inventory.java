package components;

import items.Item;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<Item, Integer> items;

    private int containedItems;
    private int maxCapacity;

    public Inventory(int maxCapacity) {
        items = new HashMap<>();
        this.containedItems = 0;
        this.maxCapacity = maxCapacity;
    }

    public Inventory(Map<Item, Integer> items, int maxCapacity) {
        this.items = items;
        this.containedItems = countItems();
        this.maxCapacity = maxCapacity;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public int getContainedItems() {return containedItems;}

    public int getMaxCapacity() {return maxCapacity;}

    public void setMaxCapacity(int maxCapacity) {this.maxCapacity = maxCapacity;}

    public void addItem(Item item, int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

        if (maxCapacity - containedItems >= amount) {
            containedItems += amount;
            if (items.containsKey(item)) items.put(item, items.get(item) + amount);
            else items.put(item, amount);
        }
    }

    public void removeItem(Item item, int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

        if (items.containsKey(item) && items.get(item) >= amount) {
            containedItems -= amount;
            items.put(item, items.get(item) - amount);
            if (items.get(item) == 0) items.remove(item);
        }
    }

    private int countItems() {
        int count = 0;
        for (Item item : items.keySet()) {
            count += items.get(item);
        }
        return count;
    }
}
