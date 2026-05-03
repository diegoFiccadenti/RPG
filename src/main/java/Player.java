public class Player extends Character implements Fighter, Levelable {

    private final HealthPoints HP;
    private final ManaPoints MP;
    private final Experience XP;
    private int level;

    public Player(String name, HealthPoints HP, ManaPoints MP) {
        super(name);
        this.HP = HP;
        this.MP = MP;
        this.level = 0;
        this.XP = new Experience(level);
    }

    public HealthPoints getHP() {
        return HP;
    }

    public ManaPoints getMP() {
        return MP;
    }

    public int getLevel() {
        return level;
    }

    public Experience getXP() {
        return XP;
    }

    public void gainXP(int gainedXP) {
        if (gainedXP > 0) {
            int xpSurplus = gainedXP - XP.neededXPToLevelUp();
            XP.setCurrent(XP.getCurrentValue() + gainedXP);
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
    }

    public void attack() {}

    public void takeDamage() {}
}
