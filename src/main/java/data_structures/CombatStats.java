package data_structures;

import quantifiables.HealthPoints;
import quantifiables.ManaPoints;
import java.util.HashMap;

// Manges the stats which depends on character level or ability points used
public class CombatStats {

    public HashMap<Integer,Integer> skillStats;

    // Keys definition
    private static final int ABILITY_POINTS = 0;
    private static final int STRENGTH = 1;
    private static final int VITALITY = 2;
    private static final int INTELLIGENCE = 3;
    private static final int CHARISMA = 4;

    // dependent attributes
    private final HealthPoints HP = new HealthPoints(100, 100);
    private final ManaPoints MP = new ManaPoints(100, 100);

    public CombatStats() {
        // default value: 5 (for level 0 entities)
        skillStats.put(ABILITY_POINTS, 0); // Points to distribute on the others stats
        skillStats.put(STRENGTH, 5); // Strength stat
        skillStats.put(VITALITY, 5); // Vitality stat
        skillStats.put(INTELLIGENCE, 5); // Intelligence stat
        skillStats.put(CHARISMA, 5); // Charisma stat

        updateDependantStats();
    }

    public CombatStats(int str, int vit, int intl, int chr) {

        skillStats.put(ABILITY_POINTS, 0); // Points to distribute on the others stats
        skillStats.put(STRENGTH, str); // Strength stat
        skillStats.put(VITALITY, vit); // Vitality stat
        skillStats.put(INTELLIGENCE, intl); // Intelligence stat
        skillStats.put(CHARISMA, chr); // Charisma stat

        updateDependantStats();
    }

    public HealthPoints getHP() {return HP;}

    public ManaPoints getMP() {return MP;}

    // to call every time a skill stat changes (except for Ability Points)
    private void updateDependantStats() {
        this.HP.setMax(20*skillStats.get(VITALITY));
        this.MP.setMax(20*skillStats.get(INTELLIGENCE));
    }

    public boolean increaseStat(int statName) {
        if (statName == ABILITY_POINTS) {
            throw new IllegalArgumentException("Cannot use this method for increasing ability points");
        }

        if (skillStats.get(ABILITY_POINTS) > 0) {
            skillStats.put(statName, skillStats.get(statName) + 1);
            skillStats.put(ABILITY_POINTS, skillStats.get(ABILITY_POINTS) - 1);
            updateDependantStats();
            return true;
        }
        return false;
    }

    public boolean increaseStat(int statName, int amount) {
        if (statName == ABILITY_POINTS) {
            throw new IllegalArgumentException("Cannot use this method for increasing ability points");
        }

        if (skillStats.get(ABILITY_POINTS) >= amount) {
            skillStats.put(statName, skillStats.get(statName) + amount);
            skillStats.put(ABILITY_POINTS, skillStats.get(ABILITY_POINTS) - amount);
            updateDependantStats();
            return true;
        }
        return false;
    }

    public void addAbilityPoints(int amount) {
        skillStats.put(ABILITY_POINTS, skillStats.get(ABILITY_POINTS) + amount);
    }

    public void showStats() {
        for(int stat : skillStats.keySet()) {
            if (stat == STRENGTH) System.out.println("Strength: " + skillStats.get(stat));
            else if (stat == VITALITY) System.out.println("Vitality: " + skillStats.get(stat));
            else if (stat == INTELLIGENCE) System.out.println("Intelligence: " + skillStats.get(stat));
            else if (stat == CHARISMA) System.out.println("Charisma: " + skillStats.get(stat));
            else if (stat == ABILITY_POINTS) System.out.println("Ability Points: " + skillStats.get(stat));
        }
    }
}
