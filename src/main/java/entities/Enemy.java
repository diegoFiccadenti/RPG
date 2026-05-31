package entities;

import items.Lootable;
import data_structures.Inventory;
import data_structures.StatsHandler;

public class Enemy extends Character implements Fighter, Lootable {

    private final int DROPPED_XP; // Experience dropped when defeated
    private final StatsHandler statsHandler;


    /*
     TODO:
      creare un metodo che crei un nemico con forza semi-randomica (magari in base al livello giocatore)
      in seguito fare in modo che l'argomento "combatStats" non debba più essere passato nel costruttore
     */
    public Enemy (String name, Inventory inventory, StatsHandler statsHandler, int DROPPED_XP, int coins) {
        super(name, inventory, coins);
        this.DROPPED_XP = DROPPED_XP;
        this.statsHandler = statsHandler;

    }

    public int getDROPPED_XP() {
        return DROPPED_XP;
    }

    public StatsHandler getCombatStats() {
        return statsHandler;
    }

    public void attack(Fighter target){}

    public void dropLoot() {}
}
