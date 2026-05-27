package entities;

import quantifiables.HealthPoints;
import quantifiables.ManaPoints;

public interface Fighter {

    public void attack();

    public HealthPoints getHP();
    public ManaPoints getMP();
}
