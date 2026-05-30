package entities;

import items.Lootable;
import data_structures.Inventory;
import stats_handlers.CombatStats;

public class Enemy extends Character implements Fighter, Lootable {

    private final int DROPPED_XP; // Experience dropped when defeated
    private final CombatStats combatStats;

    public Enemy (String name, Inventory inventory, CombatStats combatStats, int DROPPED_XP, int coins) {
        super(name, inventory, coins);
        this.DROPPED_XP = DROPPED_XP;
        this.combatStats = combatStats;

    }

    public int getDROPPED_XP() {
        return DROPPED_XP;
    }

    public CombatStats getCombatStats() {
        return combatStats;
    }

    public void attack(Fighter target){}

    public void dropLoot() {}
}
