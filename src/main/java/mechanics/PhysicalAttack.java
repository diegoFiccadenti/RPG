package mechanics;

import entities.Fighter;

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

        target.getCombatStats().getHP().decreaseCurrent(totalDamage);
    }
}
