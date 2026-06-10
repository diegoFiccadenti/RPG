package items;

import components.EquipmentHandler.EquipmentType;

public interface Equippable {

    void setEquipped(boolean equipped);

    EquipmentType getType();
}
