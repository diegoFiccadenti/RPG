package entities;

import components.AttackSetHandler;
import components.Inventory;
import components.StatsHandler;
import components.EquipmentHandler;

public class Enemy extends Character implements Fighter, Lootable {

    private final int DROPPED_XP; // Experience dropped when defeated
    private final StatsHandler statsHandler;
    private final EquipmentHandler equipment;
    private final AttackSetHandler attackSet;

    public Enemy (String name, Inventory inventory, int coins, StatsHandler statsHandler, EquipmentHandler equipment, AttackSetHandler attackSet, int DROPPED_XP) {
        super(name, inventory, coins);
        this.DROPPED_XP = DROPPED_XP;
        this.statsHandler = statsHandler;
        this.equipment = equipment;
        this.attackSet = attackSet;

    }

    public int getDROPPED_XP() {
        return DROPPED_XP;
    }

    public StatsHandler getCombatStats() {
        return statsHandler;
    }

    public EquipmentHandler getEquipment() {return equipment;}

    public AttackSetHandler getAttacks() {return attackSet;}

    public void attack(Fighter target){}

    public void dropLoot() {}
}
