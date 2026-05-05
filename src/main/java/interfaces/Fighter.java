package interfaces;

import model.HealthPoints;
import model.ManaPoints;

public interface Fighter {

    public void attack();

    public HealthPoints getHP();
    public ManaPoints getMP();
}
