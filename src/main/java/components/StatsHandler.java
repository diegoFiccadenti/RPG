package components;

import java.util.HashMap;
import java.util.Map;

// Manages the stats which depends on character level or ability points used
public class StatsHandler {

    private final Map<Stat,Integer> skillStats;

    // Keys definition
    public enum Stat {
        ABILITY_POINTS,
        STRENGTH,
        VITALITY,
        INTELLIGENCE,
        CHARISMA
    }

    // dependent attributes
    private final HealthPoints HP = new HealthPoints(0, 0);
    private final ManaPoints MP = new ManaPoints(0, 0);
    private int basicMeleeAttack = 0;
    private int basicMagicAttack = 0;
    private int persuasiveness = 0;

    public StatsHandler() {

        // default value: 5 (for level 0 entities)
        skillStats = new HashMap<>();
        skillStats.put(Stat.ABILITY_POINTS, 0); // Points to distribute on the others stats
        skillStats.put(Stat.STRENGTH, 5); // Strength stat
        skillStats.put(Stat.VITALITY, 5); // Vitality stat
        skillStats.put(Stat.INTELLIGENCE, 5); // Intelligence stat
        skillStats.put(Stat.CHARISMA, 5); // Charisma stat

        updateDependantStats();
    }

    public StatsHandler(Map<Stat,Integer> skillStats) {
        if (skillStats == null) {
            throw new IllegalArgumentException("skillStats cannot be null");
        }
        for (Stat stat : Stat.values()) {
            if (skillStats.containsKey(stat)) {
                throw new IllegalArgumentException("given skillStats is not valid");
            }
        }

        this.skillStats = new HashMap<>(skillStats);
        updateDependantStats();
    }

    public Map<Stat,Integer> getSkillStats() {return skillStats;}

    public HealthPoints getHP() {return HP;}

    public ManaPoints getMP() {return MP;}

    public int getBasicMeleeAttack() {return basicMeleeAttack;}

    public int getBasicMagicAttack() {return basicMagicAttack;}

    public int getPersuasiveness() {return persuasiveness;}

    // to call every time a skill stat changes (except for Ability Points)
    private void updateDependantStats() {
        this.HP.setMax(20*skillStats.get(Stat.VITALITY));
        this.HP.setCurrent(this.HP.getMaxValue());
        this.MP.setMax(20*skillStats.get(Stat.INTELLIGENCE));
        this.MP.setCurrent(this.MP.getMaxValue());
        this.basicMeleeAttack = 2*skillStats.get(Stat.STRENGTH);
        this.basicMagicAttack = 2*skillStats.get(Stat.INTELLIGENCE);
        this.persuasiveness = 2*skillStats.get(Stat.CHARISMA);
    }

    public boolean increaseStat(Stat statName) {
        if (!skillStats.containsKey(statName)) {
            throw new IllegalArgumentException("Unknown skill stat: " + statName);
        }
        if (statName == Stat.ABILITY_POINTS) {
            throw new IllegalArgumentException("Cannot use this method for increasing ability points");
        }

        if (skillStats.get(Stat.ABILITY_POINTS) > 0) {
            skillStats.put(statName, skillStats.get(statName) + 1);
            skillStats.put(Stat.ABILITY_POINTS, skillStats.get(Stat.ABILITY_POINTS) - 1);
            updateDependantStats();
            return true;
        }
        return false;
    }

    public boolean increaseStat(Stat statName, int amount) {
        if (!skillStats.containsKey(statName)) {
            throw new IllegalArgumentException("Unknown skill stat: " + statName);
        }
        if (statName == Stat.ABILITY_POINTS) {
            throw new IllegalArgumentException("Cannot use this method for increasing ability points");
        }

        if (skillStats.get(Stat.ABILITY_POINTS) >= amount) {
            skillStats.put(statName, skillStats.get(statName) + amount);
            skillStats.put(Stat.ABILITY_POINTS, skillStats.get(Stat.ABILITY_POINTS) - amount);
            updateDependantStats();
            return true;
        }
        return false;
    }

    public void addAbilityPoints(int amount) {
        skillStats.put(Stat.ABILITY_POINTS, skillStats.get(Stat.ABILITY_POINTS) + amount);
    }

    public void showStats() {
        for(Stat stat : skillStats.keySet()) {
            if (stat == Stat.STRENGTH) System.out.println("Strength: " + skillStats.get(stat));
            else if (stat == Stat.VITALITY) System.out.println("Vitality: " + skillStats.get(stat));
            else if (stat == Stat.INTELLIGENCE) System.out.println("Intelligence: " + skillStats.get(stat));
            else if (stat == Stat.CHARISMA) System.out.println("Charisma: " + skillStats.get(stat));
            else if (stat == Stat.ABILITY_POINTS) System.out.println("Ability Points: " + skillStats.get(stat));
        }
    }
}
