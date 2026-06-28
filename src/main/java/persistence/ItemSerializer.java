package persistence;

import com.google.gson.*;
import items.*;
import mechanics.Attack;

import java.lang.reflect.Type;

public class ItemSerializer implements JsonSerializer<Item> {

    private static final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Attack.class, new AttackSerializer())
            .create();

    @Override
    public JsonElement serialize(Item item, Type typeOfSrc, JsonSerializationContext context) {

        // we first serialize the complete object
        JsonObject jsonObject = gson.toJsonTree(item).getAsJsonObject();

        // then we add the "type" field to handle the subclasses of Item
        String itemType = "UNKNOWN";
        if (item instanceof Potion) {
            itemType = "POTION";
        }
        else if (item instanceof EquipmentPiece) {
            itemType = "EQUIPMENT";
        }
        else if (item instanceof SkillBook) {
            itemType = "SKILL_BOOK";
        }
        jsonObject.addProperty("itemType", itemType);

        return jsonObject;
    }
}
