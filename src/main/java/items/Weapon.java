package items;

public class Weapon extends Item implements Equippable {

    boolean equipped;
    int magicalDamage;
    int physicalDamage;

    public Weapon(String name, String description, int physicalDamage, int magicalDamage) {
        super(name, description);
        equipped = false;
        this.physicalDamage = physicalDamage;
        this.magicalDamage = magicalDamage;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public int getMagicalDamage() {
        return magicalDamage;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public void equip() {
        equipped = true;
    }

    public void unequip() {
        equipped = false;
    }
}
