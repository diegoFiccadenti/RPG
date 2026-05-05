package model;

import interfaces.Fighter;
import interfaces.Lootable;

public class Enemy extends Character implements Fighter, Lootable {

    private final HealthPoints HP;
    private final ManaPoints MP;

    public Enemy (String name, Inventory inventory, HealthPoints HP, ManaPoints MP) {
        super(name, inventory);
        this.HP = HP;
        this.MP = MP;
    }

    @Override
    public HealthPoints getHP() {
        return HP;
    }

    @Override
    public ManaPoints getMP() {
        return MP;
    }

    public void attack(){}

    public void dropLoot() {}
}
