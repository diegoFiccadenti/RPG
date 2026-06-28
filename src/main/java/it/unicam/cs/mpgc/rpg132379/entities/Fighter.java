package it.unicam.cs.mpgc.rpg132379.entities;

import it.unicam.cs.mpgc.rpg132379.components.AttackSetHandler;
import it.unicam.cs.mpgc.rpg132379.components.StatsHandler;
import it.unicam.cs.mpgc.rpg132379.components.EquipmentHandler;
import it.unicam.cs.mpgc.rpg132379.mechanics.Attack;

public interface Fighter {

    void attack(Fighter target, Attack attackUsed);

    StatsHandler getCombatStats();

    EquipmentHandler getEquipment();

    AttackSetHandler getAttacks();
}
