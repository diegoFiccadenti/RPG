package items;

import data_structures.EquipmentHandler.EquipmentType;

public interface Equippable {

    void setEquipped(boolean equipped);

    EquipmentType getType();
}
