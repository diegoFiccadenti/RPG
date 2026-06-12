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

    public void use(Fighter target) {

    }
}
