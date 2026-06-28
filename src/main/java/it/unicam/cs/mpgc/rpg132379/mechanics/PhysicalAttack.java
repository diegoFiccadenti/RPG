package it.unicam.cs.mpgc.rpg132379.mechanics;

import it.unicam.cs.mpgc.rpg132379.entities.Fighter;

import java.util.Objects;

public class PhysicalAttack implements Attack {

    private final String name;
    private final int power;

    public PhysicalAttack(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {return name;}

    public int getPower() {return power;}

    public void use(Fighter user, Fighter target) {

        int totalDamage = power;
        totalDamage += user.getCombatStats().getBasicMeleeAttack();
        totalDamage += user.getEquipment().getMeleeAttack();
        totalDamage -= target.getEquipment().getMeleeDefence();

        if (totalDamage < 0) totalDamage = 0;

        target.getCombatStats().getHP().decreaseCurrent(totalDamage);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PhysicalAttack that)) return false;
        return power == that.power && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power);
    }
}
