package items;

public class Armor extends Item implements Equippable {

    boolean equipped;
    int physicalDefence;
    int magicDefence;

    public Armor(String name, String description, int physicalDefence, int magicDefence) {
        super(name, description);
        this.physicalDefence = physicalDefence;
        this.magicDefence = magicDefence;
    }

    public boolean isEquipped() {
        return equipped;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public int getMagicDefence() {
        return magicDefence;
    }

    public void equip() {
        equipped = true;
    }

    public void unequip() {
        equipped = false;
    }
}
