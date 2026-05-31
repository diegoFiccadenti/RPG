package items;

public class Weapon extends Item implements Equippable {

    boolean equipped;
    int physicalDamage;
    int magicDamage;

    public Weapon(String name, String description, int physicalDamage, int magicDamage) {
        super(name, description);
        equipped = false;
        this.physicalDamage = physicalDamage;
        this.magicDamage = magicDamage;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public int getMagicDamage() {
        return magicDamage;
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
