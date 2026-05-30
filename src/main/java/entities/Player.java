package entities;

import data_structures.*;
import quantifiables.Currency;
import quantifiables.Experience;
import quantifiables.HealthPoints;
import quantifiables.ManaPoints;
import stats_handlers.SkillStats;

public class Player extends Character implements Fighter, Levelable {

    private final HealthPoints HP;
    private final ManaPoints MP;
    private final Experience XP;
    private int level;
    private final SkillStats skillStats;
    private final Currency coins;

    public Player(String name, Inventory inventory, HealthPoints HP, ManaPoints MP) {
        super(name, inventory);
        this.HP = HP;
        this.MP = MP;
        this.level = 0;
        this.XP = new Experience(level);
        this.skillStats = new SkillStats();
        this.coins = new Currency(500);
    }

    @Override
    public HealthPoints getHP() {
        return HP;
    }

    @Override
    public ManaPoints getMP() {
        return MP;
    }

    public int getLevel() {
        return level;
    }

    public Experience getXP() {
        return XP;
    }

    public SkillStats getSkillStats() {return skillStats;}

    public Currency getCoins() {return coins;}

    public void gainXP(int gainedXP) {
        if (gainedXP > 0) {
            int xpSurplus = gainedXP - XP.neededXPToLevelUp();
            XP.increaseCurrent(gainedXP);
            if (XP.isAtMaximum()) {
                this.levelUp();
                XP.setMax(Experience.maxXPForNewLevel(level));
                XP.setCurrent(XP.getMinValue());
                this.gainXP(xpSurplus);
            }
        }
    }

    public void levelUp() {
        level++;
        skillStats.addAbilityPoints(3);
    }

    public void attack(Fighter target) {}
}
