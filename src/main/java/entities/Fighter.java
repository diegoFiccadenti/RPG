package entities;

import data_structures.StatsHandler;

public interface Fighter {

    public void attack(Fighter target);

    public StatsHandler getCombatStats();
}
