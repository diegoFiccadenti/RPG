package mechanics;

import entities.Fighter;

public class Spell implements Attack {

    private final String name;
    private final String description;
    private final int power;

    public Spell(String name, String description, int power) {
        this.name = name;
        this.description = description;
        this.power = power;
    }

    public String getName() {return name;}

    public String getDescription() {return description;}

    public int getPower() {return power;}

    public void use(Fighter target) {

    }
}