package it.unicam.cs.mpgc.rpg132379.items;

import it.unicam.cs.mpgc.rpg132379.components.EquipmentHandler.EquipmentType;

public interface Equippable {

    boolean isEquipped();

    void setEquipped(boolean equipped);

    EquipmentType getType();
}
