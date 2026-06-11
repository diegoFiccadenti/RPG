package persistence;

import com.google.gson.*;
import items.Item;
import items.Potion;
import items.EquipmentPiece;

import java.lang.reflect.Type;

public class ItemDeserializer implements JsonDeserializer<Item> {

    @Override
    public Item deserialize (JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        String itemType = jsonObject.get("itemType").getAsString();

        if (itemType.equals("POTION")) {
            return context.deserialize(jsonObject, Potion.class);
        }
        else if (itemType.equals("EQUIPMENT")) {
            return context.deserialize(jsonObject, EquipmentPiece.class);
        }
        else {
            throw new JsonParseException("Invalid item type: " + itemType);
        }
    }
}
