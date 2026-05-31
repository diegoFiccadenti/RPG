package entities;

import data_structures.CombatStats;

public interface Fighter {

    public void attack(Fighter target);

    public CombatStats getCombatStats();
}
