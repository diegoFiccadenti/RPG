package entities;

import components.Inventory;

public class NPC extends Character implements Talkable {

    public NPC(String name, Inventory inventory) {
        super(name, inventory, 1000);
    }

    public void talk() {}
}
