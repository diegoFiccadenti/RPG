package entities;

import components.AttackSetHandler;
import components.StatsHandler;
import components.EquipmentHandler;
import mechanics.Attack;

public interface Fighter {

    void attack(Fighter target, Attack attackUsed);

    StatsHandler getCombatStats();

    EquipmentHandler getEquipment();

    AttackSetHandler getAttacks();
}
