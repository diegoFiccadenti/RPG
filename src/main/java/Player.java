public class Player extends Character implements Fighter {

    private final HealthPoints HP;
    private final ManaPoints MP;
    private int level;

    public Player(String name, HealthPoints HP, ManaPoints MP) {
        super(name);
        this.HP = HP;
        this.MP = MP;
        this.level = 0;
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

    public void attack() {}

    public void takeDamage() {}
}
