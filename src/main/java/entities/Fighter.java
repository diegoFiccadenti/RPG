package entities;

import quantifiables.HealthPoints;
import quantifiables.ManaPoints;
import stats_handlers.CombatStats;

public interface Fighter {

    public void attack(Fighter target);

    public CombatStats getCombatStats();
}
