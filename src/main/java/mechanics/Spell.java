package mechanics;

import entities.Fighter;

import java.util.Objects;

public class Spell implements Attack {

    private final String name;
    private final int power;
    private final int requiredMana;

    public Spell(String name, int power, int requiredMana) {
        this.name = name;
        this.power = power;
        this.requiredMana = requiredMana;
    }

    public String getName() {return name;}

    public int getPower() {return power;}

    public int getRequiredMana() {return requiredMana;}

    public void use(Fighter user, Fighter target) {

        int userMana = user.getCombatStats().getMP().getCurrentValue();
        if (userMana >= requiredMana) {
            int totalDamage = power;
            totalDamage += user.getCombatStats().getBasicMagicAttack();
            totalDamage += user.getEquipment().getMagicAttack();
            totalDamage -= target.getEquipment().getMagicDefence();
            if (totalDamage < 0) totalDamage = 0;

            user.getCombatStats().getMP().decreaseCurrent(requiredMana);
            target.getCombatStats().getHP().decreaseCurrent(totalDamage);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Spell spell)) return false;
        return power == spell.power && requiredMana == spell.requiredMana && Objects.equals(name, spell.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power, requiredMana);
    }
}