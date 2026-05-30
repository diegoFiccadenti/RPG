package entities;

import items.Lootable;
import quantifiables.HealthPoints;
import data_structures.Inventory;
import quantifiables.ManaPoints;

public class Enemy extends Character implements Fighter, Lootable {

    private final HealthPoints HP;
    private final ManaPoints MP;
    private final int DROPPED_XP; // Experience dropped when defeated

    public Enemy (String name, Inventory inventory, HealthPoints HP, ManaPoints MP, int DROPPED_XP, int coins) {
        super(name, inventory, coins);
        this.HP = HP;
        this.MP = MP;
        this.DROPPED_XP = DROPPED_XP;
    }

    @Override
    public HealthPoints getHP() {
        return HP;
    }

    @Override
    public ManaPoints getMP() {
        return MP;
    }

    public int getDROPPED_XP() {
        return DROPPED_XP;
    }

    public void attack(Fighter target){}

    public void dropLoot() {}
}
