package data_structures;

import items.EquipmentPiece;
import items.Equippable;

import java.util.HashMap;
import java.util.Map;

public class EquipmentHandler {

    private final Map<Integer, Equippable> equipmentSlots;

    // Keys definition
    public static final int PRIMARY_WEAPON = 0;
    public static final int HEAD = 1;
    public static final int CHEST = 2;
    public static final int LEGS = 3;
    public static final int FEET = 4;
    public static final int CHARM = 5;

    // dependent attributes
    private int meleeAttack;
    private int meleeDefence;
    private int magicAttack;
    private int magicDefence;

    public EquipmentHandler() {
        this.equipmentSlots = new HashMap<>();
        this.equipmentSlots.put(PRIMARY_WEAPON, null);
        this.equipmentSlots.put(HEAD, null);
        this.equipmentSlots.put(CHEST, null);
        this.equipmentSlots.put(LEGS, null);
        this.equipmentSlots.put(FEET, null);
        this.equipmentSlots.put(CHARM, null);

        updateDependantStats();
    }

    public EquipmentHandler(Map<Integer, Equippable> equipment) {
        if (equipment == null) {
            throw new IllegalArgumentException("Equipment cannot be null");
        }
        if (!equipment.containsKey(PRIMARY_WEAPON) ||
                !equipment.containsKey(HEAD) ||
                !equipment.containsKey(CHEST) ||
                !equipment.containsKey(LEGS) ||
                !equipment.containsKey(FEET) ||
                !equipment.containsKey(CHARM)) {
            throw new IllegalArgumentException("given equipment is not valid");
        }

        this.equipmentSlots = new HashMap<>(equipment);
        updateDependantStats();
    }

    public Map<Integer, Equippable> getEquipmentSlots() {
        return equipmentSlots;
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
        int type = pieceToEquip.getType();

        if (equipmentSlots.get(type) != null) {
            equipmentSlots.get(type).setEquipped(false);
        }
        equipmentSlots.put(type, pieceToEquip);
        pieceToEquip.setEquipped(true);
        updateDependantStats();
    }

    public void unequip(Equippable pieceToUnequip) {
        int type = pieceToUnequip.getType();

        if (equipmentSlots.get(type) != null) {
            if (equipmentSlots.get(type).equals(pieceToUnequip)) {
                equipmentSlots.get(type).setEquipped(false);
                equipmentSlots.put(type, null);
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
        for (int slot : equipmentSlots.keySet()) {
            Equippable piece = equipmentSlots.get(slot);
            if (piece instanceof EquipmentPiece) {
                meleeAttack += ((EquipmentPiece) piece).getMeleeDamage();
                meleeDefence += ((EquipmentPiece) piece).getMeleeDefence();
                magicAttack += ((EquipmentPiece) piece).getMagicDamage();
                magicDefence += ((EquipmentPiece) piece).getMagicDefence();
            }
        }
    }
}

