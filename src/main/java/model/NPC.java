package model;

import interfaces.Talkable;

public class NPC extends Character implements Talkable {

    public NPC(String name, Inventory inventory) {
        super(name, inventory);
    }

    public void talk() {}
}
