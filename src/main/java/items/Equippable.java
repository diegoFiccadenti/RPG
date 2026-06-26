package items;

import components.EquipmentHandler.EquipmentType;

public interface Equippable {

    boolean isEquipped();

    void setEquipped(boolean equipped);

    EquipmentType getType();
}
