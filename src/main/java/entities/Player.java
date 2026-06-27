package entities;

import components.*;
import components.Experience;
import components.StatsHandler;
import components.StatsHandler.Stat;
import items.SkillBook;
import mechanics.Attack;
import mechanics.Mission;
import mechanics.PhysicalAttack;
import mechanics.Spell;

public class Player extends Character implements Fighter, Levelable, Looter {

    private final Experience XP;
    private int level;
    private final StatsHandler personalStats;
    private final EquipmentHandler equipment;
    private final AttackSetHandler attackSet;
    private Mission currentMission;

    public Player(String name, Inventory inventory) {
        super(name, inventory, 1000);
        this.level = 0;
        this.XP = new Experience(level);
        this.personalStats = new StatsHandler();
        this.equipment = new EquipmentHandler();
        this.attackSet = new AttackSetHandler();
        this.currentMission = null;

        addStartingAttacks();
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

    public Mission getCurrentMission() {return currentMission;}

    public void setCurrentMission(Mission currentMission) {this.currentMission = currentMission;}

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
        personalStats.addAbilityPoints(4);
        // following lines are a temporary solution, can be removed once a stats assigner is implemented
        personalStats.increaseStat(Stat.STRENGTH, 1);
        personalStats.increaseStat(Stat.VITALITY, 1);
        personalStats.increaseStat(Stat.INTELLIGENCE, 1);
        personalStats.increaseStat(Stat.CHARISMA, 1);
    }

    public void attack(Fighter target, Attack attackUsed) {
        attackUsed.use(this, target);
    }

    private void addStartingAttacks() {
        Attack punch = new PhysicalAttack("Punch", 3);
        SkillBook punchBook = new SkillBook("Learned attack: punch", "Use your fists", 100, punch);
        Attack basicMagicAttack = new Spell("Basic magic attack", 5, 10);
        SkillBook basicMagicAttackBook = new SkillBook("Learned attack: Basic magic attack", "A simple release of mana, good to start learning magic", 250, basicMagicAttack);
        punchBook.learn(this);
        basicMagicAttackBook.learn(this);
        attackSet.addAttack(punch);
        attackSet.addAttack(basicMagicAttack);
    }
}
