package model;

import interfaces.Fighter;
import interfaces.Lootable;

public class Enemy extends Character implements Fighter, Lootable {

    public Enemy (String name) {
        super(name);
    }

    public void attack(){}

    public void takeDamage() {}

    public void dropLoot() {}
}
