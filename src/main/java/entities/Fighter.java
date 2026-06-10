package entities;

import components.AttackSetHandler;
import components.StatsHandler;
import components.EquipmentHandler;

public interface Fighter {

    void attack(Fighter target);

    StatsHandler getCombatStats();

    EquipmentHandler getEquipment();

    AttackSetHandler getAttacks();
}
