package entities;

import data_structures.*;
import quantifiables.Experience;
import data_structures.CombatStats;

public class Player extends Character implements Fighter, Levelable {

    private final Experience XP;
    private int level;
    private final CombatStats combatStats;

    public Player(String name, Inventory inventory) {
        super(name, inventory, 0);
        this.level = 0;
        this.XP = new Experience(level);
        this.combatStats = new CombatStats();
    }

    public int getLevel() {
        return level;
    }

    public Experience getXP() {
        return XP;
    }

    public CombatStats getCombatStats() {return combatStats;}

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
        combatStats.addAbilityPoints(3);
    }

    public void attack(Fighter target) {}
}
