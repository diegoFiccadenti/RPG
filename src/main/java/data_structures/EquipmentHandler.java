package data_structures;

import items.Equippable;

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

    private int physicalAttack;
    private int physicalDefence;
    private int magicAttack;
    private int magicDefence;

    public EquipmentHandler(int physicalAttack, int physicalDefence, int magicAttack, int magicDefence) {
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
}

