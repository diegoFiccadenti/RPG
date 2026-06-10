package items;

import entities.Fighter;

public class Potion extends Item implements Consumable {

    private final int recoveredHP;
    private final int recoveredMP;

    public Potion(String name, String description, int cost, int recoveredHP, int recoveredMP) {
        super(name, description, cost);
        this.recoveredHP = recoveredHP;
        this.recoveredMP = recoveredMP;
    }

    @Override
    public void useOn(Fighter user) {
        user.getCombatStats().getHP().increaseCurrent(recoveredHP);
        user.getCombatStats().getMP().increaseCurrent(recoveredMP);
    }
}
