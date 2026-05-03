package model;

import java.util.HashMap;

// Manges the stats which depends on character level or ability points used
public class SkillStats extends HashMap<Integer,Integer> {

    // Keys definition
    private static final int ABILITY_POINTS = 0;
    private static final int STRENGTH = 1;
    private static final int VITALITY = 2;
    private static final int INTELLIGENCE = 3;
    private static final int CHARISMA = 4;

    public SkillStats() {
        super();
        // default value: 5 (for level 0 entities)
        this.put(ABILITY_POINTS, 0); // Points to distribute on the others stats
        this.put(STRENGTH, 5); // Strength stat
        this.put(VITALITY, 5); // Vitality stat
        this.put(INTELLIGENCE, 5); // Intelligence stat
        this.put(CHARISMA, 5); // Charisma stat
    }

    public SkillStats(int str, int vit, int intl, int chr) {
        super();

        this.put(ABILITY_POINTS, 0); // Points to distribute on the others stats
        this.put(STRENGTH, str); // Strength stat
        this.put(VITALITY, vit); // Vitality stat
        this.put(INTELLIGENCE, intl); // Intelligence stat
        this.put(CHARISMA, chr); // Charisma stat
    }

    public boolean increaseStat(int statName) {
        if (statName == ABILITY_POINTS) {
            throw new IllegalArgumentException("Cannot use this method for increasing ability points");
        }

        if (this.get(ABILITY_POINTS) > 0) {
            this.put(statName, this.get(statName) + 1);
            this.put(ABILITY_POINTS, this.get(ABILITY_POINTS) - 1);
            return true;
        }
        return false;
    }

    public boolean increaseStat(int statName, int amount) {
        if (statName == ABILITY_POINTS) {
            throw new IllegalArgumentException("Cannot use this method for increasing ability points");
        }

        if (this.get(ABILITY_POINTS) >= amount) {
            this.put(statName, this.get(statName) + amount);
            this.put(ABILITY_POINTS, this.get(ABILITY_POINTS) - amount);
            return true;
        }
        return false;
    }

    public void addAbilityPoints(int amount) {
        this.put(ABILITY_POINTS, this.get(ABILITY_POINTS) + amount);
    }

    public void showStats() {
        for(int stat : this.keySet()) {
            if (stat == STRENGTH) System.out.println("Strength: " + this.get(stat));
            else if (stat == VITALITY) System.out.println("Vitality: " + this.get(stat));
            else if (stat == INTELLIGENCE) System.out.println("Intelligence: " + this.get(stat));
            else if (stat == CHARISMA) System.out.println("Charisma: " + this.get(stat));
            else if (stat == ABILITY_POINTS) System.out.println("Ability Points: " + this.get(stat));
        }
    }
}
