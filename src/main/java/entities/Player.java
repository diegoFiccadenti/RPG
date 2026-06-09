package entities;

import data_structures.*;
import quantifiables.Experience;
import data_structures.StatsHandler;
import data_structures.StatsHandler.Stat;

public class Player extends Character implements Fighter, Levelable {

    private final Experience XP;
    private int level;
    private final StatsHandler personalStats;
    private final EquipmentHandler equipment;
    private final AttackSetHandler attackSet;

    public Player(String name, Inventory inventory) {
        super(name, inventory, 0);
        this.level = 0;
        this.XP = new Experience(level);
        this.personalStats = new StatsHandler();
        this.equipment = new EquipmentHandler();
        this.attackSet = new AttackSetHandler();
    }

    public int getLevel() {
        return level;
    }

    public Experience getXP() {
        return XP;
    }

    public StatsHandler getCombatStats() {return personalStats;}

    public EquipmentHandler getEquipment() {return equipment;}

    public AttackSetHandler getAttacks() {return attackSet;}

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
        personalStats.addAbilityPoints(3);
        // following lines are a temporary solution, can be removed once a stats assigner is implemented
        personalStats.increaseStat(Stat.STRENGTH, 1);
        personalStats.increaseStat(Stat.VITALITY, 1);
        personalStats.increaseStat(Stat.INTELLIGENCE, 1);
        personalStats.increaseStat(Stat.CHARISMA, 1);
    }

    public void attack(Fighter target) {}
}
