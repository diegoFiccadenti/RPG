package items;


// TODO: aggiungere metodi equals e hashCode
public class EquipmentPiece extends Item implements Equippable {

    private boolean equipped;
    private final int type;
    private final int physicalDamage;
    private final int physicalDefence;
    private final int magicDamage;
    private final int magicDefence;

    public EquipmentPiece(String name, String description, int type, int physicalDamage, int physicalDefence, int magicDamage, int magicDefence) {
        super(name, description);

        // the current range of equipment types
        if (type < 0 || type > 5) {
            throw new IllegalArgumentException("Invalid equipment type");
        }
        this.type = type;

        this.physicalDamage = physicalDamage;
        this.physicalDefence = physicalDefence;
        this.magicDamage = magicDamage;
        this.magicDefence = magicDefence;
    }

    public boolean isEquipped() {return equipped;}

    public void setEquipped(boolean equipped) {this.equipped = equipped;}

    public int getType() {return type;}

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public int getPhysicalDefence() {return physicalDefence;}

    public int getMagicDamage() {return magicDamage;}

    public int getMagicDefence() {return magicDefence;}
}
