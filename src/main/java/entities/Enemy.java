package entities;

import items.Lootable;
import data_structures.Inventory;
import data_structures.CombatStats;

public class Enemy extends Character implements Fighter, Lootable {

    private final int DROPPED_XP; // Experience dropped when defeated
    private final CombatStats combatStats;


    /*
     TODO:
      creare un metodo che crei un nemico con forza semi-randomica (magari in base al livello giocatore)
      in seguito fare in modo che l'argomento "combatStats" non debba più essere passato nel costruttore
     */
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
