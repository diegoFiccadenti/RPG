package persistence;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import items.EquipmentPiece;
import items.Item;
import items.Potion;

import java.lang.reflect.Type;

public class ItemSerializer implements JsonSerializer<Item> {

    @Override
    public JsonElement serialize(Item item, Type typeOfSrc, JsonSerializationContext context) {

        // we first serialize the complete object
        JsonObject jsonObject = context.serialize(item).getAsJsonObject();

        // then we add the "type" field to handle the subclasses of Item
        String itemType = "UNKNOWN";
        if (item instanceof Potion) {
            itemType = "POTION";
        }
        else if (item instanceof EquipmentPiece) {
            itemType = "EQUIPMENT";
        }
        jsonObject.addProperty("itemType", itemType);

        return jsonObject;
    }
}
