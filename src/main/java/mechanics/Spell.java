package mechanics;

import entities.Fighter;

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

    public void use(Fighter target) {

    }
}