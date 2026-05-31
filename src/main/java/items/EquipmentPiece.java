package items;

public class EquipmentPiece extends Item implements Equippable {

    private boolean equipped;
    private final int type;
    private final int meleeDamage;
    private final int meleeDefence;
    private final int magicDamage;
    private final int magicDefence;

    public EquipmentPiece(String name, String description, int type, int meleeDamage, int meleeDefence, int magicDamage, int magicDefence) {
        super(name, description);

        // the current range of equipment types
        if (type < 0 || type > 5) {
            throw new IllegalArgumentException("Invalid equipment type");
        }
        this.type = type;

        this.meleeDamage = meleeDamage;
        this.meleeDefence = meleeDefence;
        this.magicDamage = magicDamage;
        this.magicDefence = magicDefence;
    }

    public boolean isEquipped() {return equipped;}

    public void setEquipped(boolean equipped) {this.equipped = equipped;}

    public int getType() {return type;}

    public int getMeleeDamage() {
        return meleeDamage;
    }

    public int getMeleeDefence() {return meleeDefence;}

    public int getMagicDamage() {return magicDamage;}

    public int getMagicDefence() {return magicDefence;}
}
