package items;

import components.EquipmentHandler.EquipmentType;

public class EquipmentPiece extends Item implements Equippable {

    private boolean equipped;
    private final EquipmentType type;
    private final int meleeDamage;
    private final int meleeDefence;
    private final int magicDamage;
    private final int magicDefence;

    public EquipmentPiece(String name, String description, EquipmentType type, int meleeDamage, int meleeDefence, int magicDamage, int magicDefence) {
        super(name, description);

        this.type = type;

        this.meleeDamage = meleeDamage;
        this.meleeDefence = meleeDefence;
        this.magicDamage = magicDamage;
        this.magicDefence = magicDefence;
    }

    public boolean isEquipped() {return equipped;}

    public void setEquipped(boolean equipped) {this.equipped = equipped;}

    public EquipmentType getType() {return type;}

    public int getMeleeDamage() {
        return meleeDamage;
    }

    public int getMeleeDefence() {return meleeDefence;}

    public int getMagicDamage() {return magicDamage;}

    public int getMagicDefence() {return magicDefence;}
}
