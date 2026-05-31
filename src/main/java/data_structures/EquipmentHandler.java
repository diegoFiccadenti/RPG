package data_structures;

import items.EquipmentPiece;
import items.Equippable;
import entities.Fighter;

import java.util.HashMap;

public class EquipmentHandler {

    private HashMap<Integer, Equippable> equipmentSlots;

    // Keys definition
    private static final int PRIMARY_WEAPON = 0;
    private static final int HEAD = 1;
    private static final int CHEST = 2;
    private static final int LEGS = 3;
    private static final int FEET = 4;
    private static final int CHARM = 5;

    // dependent attributes
    private int physicalAttack;
    private int physicalDefence;
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

        this.physicalAttack = 0;
        this.physicalDefence = 0;
        this.magicAttack = 0;
        this.magicDefence = 0;
    }

    public HashMap<Integer, Equippable> getEquipmentSlots() {
        return equipmentSlots;
    }

    public int getPhysicalAttack() {
        return physicalAttack;
    }

    public int getMagicAttack() {
        return magicAttack;
    }

    public int getPhysicalDefence() {
        return physicalDefence;
    }

    public int getMagicDefence() {
        return magicDefence;
    }

    public void equip(Equippable pieceToEquip, Fighter equipper) {
        int type = pieceToEquip.getType();
        HashMap<Integer, Equippable> equipperEquipmentSlots = equipper.getEquipment().getEquipmentSlots();

        if (equipperEquipmentSlots.get(type) != null) {
            equipperEquipmentSlots.get(type).setEquipped(false);
        }
        equipperEquipmentSlots.put(type, pieceToEquip);
        pieceToEquip.setEquipped(true);
        updateDependantStats();
    }

    public void unequip(Equippable pieceToUnequip, Fighter equipper) {
        int type = pieceToUnequip.getType();
        HashMap<Integer, Equippable> equipperEquipmentSlots = equipper.getEquipment().getEquipmentSlots();

        if (equipperEquipmentSlots.get(type) != null) {
            if (equipperEquipmentSlots.get(type).equals(pieceToUnequip)) {
                equipperEquipmentSlots.get(type).setEquipped(false);
                equipperEquipmentSlots.put(type, null);
            }
        }
    }

    // to call every time a piece of equipment gets equipped or unequipped
    private void updateDependantStats() {

        physicalAttack = 0;
        physicalDefence = 0;
        magicAttack = 0;
        magicDefence = 0;
        for (int i = 0; i < this.equipmentSlots.size(); i++) {
            if (equipmentSlots.get(i) != null && equipmentSlots.get(i) instanceof EquipmentPiece) {
                physicalAttack += ((EquipmentPiece) equipmentSlots.get(i)).getPhysicalDamage();
                physicalDefence += ((EquipmentPiece) equipmentSlots.get(i)).getPhysicalDefence();
                magicAttack += ((EquipmentPiece) equipmentSlots.get(i)).getMagicDamage();
                magicDefence += ((EquipmentPiece) equipmentSlots.get(i)).getMagicDefence();
            }
        }
    }
}

