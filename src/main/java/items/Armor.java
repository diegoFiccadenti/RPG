package items;

public class Armor extends Item implements Equippable {

    boolean equipped;
    int physicalDefence;
    int magicalDefence;

    public Armor(String name, String description, int physicalDefence, int magicalDefence) {
        super(name, description);
        this.physicalDefence = physicalDefence;
        this.magicalDefence = magicalDefence;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public int getMagicalDefence() {
        return magicalDefence;
    }

    public void equip() {
        equipped = true;
    }

    public void unequip() {
        equipped = false;
    }
}
