package items;

public class EquipmentPiece extends Item implements Equippable {

    private boolean equipped;
    private int physicalDamage;
    private int physicalDefence;
    private int magicDamage;
    private int magicDefence;
    private int type;

    public EquipmentPiece(String name, String description, int physicalDamage, int physicalDefence, int magicDamage, int magicDefence, int type) {
        super(name, description);
        this.physicalDamage = physicalDamage;
        this.physicalDefence = physicalDefence;
        this.magicDamage = magicDamage;
        this.magicDefence = magicDefence;

        if (type < 0 || type > 5) {
            throw new IllegalArgumentException("Invalid equipment type");
        }
    }

    public boolean isEquipped() {
        return equipped;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public int getMagicDamage() {
        return magicDamage;
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
