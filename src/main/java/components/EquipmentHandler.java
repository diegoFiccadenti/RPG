package components;

import items.EquipmentPiece;
import items.Equippable;

import java.util.HashMap;
import java.util.Map;

public class EquipmentHandler {

    private final Map<EquipmentType, Equippable> equipment;

    // Keys definition
    public enum EquipmentType {
        PRIMARY_WEAPON,
        HEAD,
        CHEST,
        LEGS,
        FEET,
        CHARM
    }

    // dependent attributes
    private int meleeAttack;
    private int meleeDefence;
    private int magicAttack;
    private int magicDefence;

    public EquipmentHandler() {
        this.equipment = new HashMap<>();
        for (EquipmentType slot : EquipmentType.values()) {
            this.equipment.put(slot, null);
        }

        updateDependantStats();
    }

    public Map<EquipmentType, Equippable> getEquipment() {
        return equipment;
    }

    public int getMeleeAttack() {
        return meleeAttack;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getMeleeDefence() {
        return meleeDefence;
    }

    public int getMagicDefence() {
        return magicDefence;
    }

    public void equip(Equippable pieceToEquip) {
        EquipmentType type = pieceToEquip.getType();

        if (equipment.get(type) != null) {
            equipment.get(type).setEquipped(false);
        }
        equipment.put(type, pieceToEquip);
        pieceToEquip.setEquipped(true);
        updateDependantStats();
    }

    public void unequip(Equippable pieceToUnequip) {
        EquipmentType type = pieceToUnequip.getType();

        if (equipment.get(type) != null) {
            if (equipment.get(type).equals(pieceToUnequip)) {
                equipment.get(type).setEquipped(false);
                equipment.put(type, null);
                updateDependantStats();
            }
        }
    }

    // to call every time a piece of equipment gets equipped or unequipped
    private void updateDependantStats() {

        meleeAttack = 0;
        meleeDefence = 0;
        magicAttack = 0;
        magicDefence = 0;
        for (EquipmentType slot : equipment.keySet()) {
            Equippable piece = equipment.get(slot);
            if (piece instanceof EquipmentPiece) {
                meleeAttack += ((EquipmentPiece) piece).getMeleeDamage();
                meleeDefence += ((EquipmentPiece) piece).getMeleeDefence();
                magicAttack += ((EquipmentPiece) piece).getMagicDamage();
                magicDefence += ((EquipmentPiece) piece).getMagicDefence();
            }
        }
    }
}

