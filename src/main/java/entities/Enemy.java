package entities;

import data_structures.Inventory;
import data_structures.StatsHandler;
import data_structures.EquipmentHandler;

public class Enemy extends Character implements Fighter, Lootable {

    private final int DROPPED_XP; // Experience dropped when defeated
    private final StatsHandler statsHandler;
    private final EquipmentHandler equipment;

    /*
     TODO:
      creare un metodo che crei un nemico con forza semi-randomica (magari in base al livello giocatore)
      in seguito fare in modo che l'argomento "combatStats" non debba più essere passato nel costruttore
     */
    public Enemy (String name, Inventory inventory, int coins, StatsHandler statsHandler, EquipmentHandler equipment, int DROPPED_XP) {
        super(name, inventory, coins);
        this.DROPPED_XP = DROPPED_XP;
        this.statsHandler = statsHandler;
        this.equipment = equipment;

    }

    public int getDROPPED_XP() {
        return DROPPED_XP;
    }

    public StatsHandler getCombatStats() {
        return statsHandler;
    }

    public EquipmentHandler getEquipment() {return equipment;}

    public void attack(Fighter target){}

    public void dropLoot() {}
}
