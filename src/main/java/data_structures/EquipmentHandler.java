package data_structures;

import java.util.HashMap;

public class EquipmentHandler {

    private HashMap<Integer, Integer> equipmentSlots;

    // Keys definition
    private static final int PRIMARY_WEAPON = 0;
    private static final int HEAD = 1;
    private static final int CHEST = 2;
    private static final int LEGS = 3;
    private static final int FEET = 4;
    private static final int CHARM = 5;

    int physicalAttack;
    int physicalDefence;
    int magicAttack;
    int magicDefence;

    public EquipmentHandler(int physicalAttack, int physicalDefence, int magicAttack, int magicDefence) {
        this.physicalAttack = physicalAttack;
        this.physicalDefence = physicalDefence;
        this.magicAttack = magicAttack;
        this.magicDefence = magicDefence;
    }
}

