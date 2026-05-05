package model;

import interfaces.Consumable;
import interfaces.Fighter;

public class Potion extends Item implements Consumable {

    private final int recoveredHP;
    private final int recoveredMP;

    public Potion(String name, String description, int recoveredHP, int recoveredMP) {
        super(name, description);
        this.recoveredHP = recoveredHP;
        this.recoveredMP = recoveredMP;
    }

    public int getRecoveredHP() {
        return recoveredHP;
    }

    public int getRecoveredMP() {
        return recoveredMP;
    }

    @Override
    public void use(Fighter user) {
        HealthPoints userHealth = user.getHP();
        ManaPoints userMana = user.getMP();

        userHealth.setCurrent(userHealth.getCurrentValue() + recoveredHP);
        userMana.setCurrent(userMana.getCurrentValue() + recoveredMP);
    }
}
