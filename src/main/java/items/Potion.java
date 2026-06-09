package items;

import entities.Fighter;

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
    public void useOn(Fighter user) {
        user.getCombatStats().getHP().increaseCurrent(recoveredHP);
        user.getCombatStats().getMP().increaseCurrent(recoveredMP);
    }
}
