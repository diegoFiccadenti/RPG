package entities;

import data_structures.AttackSetHandler;
import data_structures.StatsHandler;
import data_structures.EquipmentHandler;

public interface Fighter {

    void attack(Fighter target);

    StatsHandler getCombatStats();

    EquipmentHandler getEquipment();

    AttackSetHandler getAttacks();
}
