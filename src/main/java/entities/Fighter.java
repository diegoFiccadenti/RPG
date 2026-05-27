package entities;

import quantifiables.HealthPoints;
import quantifiables.ManaPoints;

public interface Fighter {

    public void attack(Fighter target);

    public HealthPoints getHP();
    public ManaPoints getMP();
}
