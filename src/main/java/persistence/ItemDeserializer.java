package persistence;

import com.google.gson.*;
import items.*;
import mechanics.Attack;

import java.lang.reflect.Type;

public class ItemDeserializer implements JsonDeserializer<Item> {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Equippable.class, new ItemDeserializer())
            .registerTypeHierarchyAdapter(Attack.class, new AttackDeserializer())
            .create();

    @Override
    public Item deserialize (JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        if (!jsonObject.has("itemType") || jsonObject.get("itemType").isJsonNull()) {
            throw new JsonParseException("Missing or invalid itemType");
        }

        String itemType = jsonObject.get("itemType").getAsString();

        if (itemType.equals("POTION")) {
            return gson.fromJson(jsonObject, Potion.class);
        }
        else if (itemType.equals("EQUIPMENT")) {
            return gson.fromJson(jsonObject, EquipmentPiece.class);
        }
        else if (itemType.equals("SKILL_BOOK")) {
            return gson.fromJson(jsonObject, SkillBook.class);
        }
        else {
            throw new JsonParseException("Invalid item type: " + itemType);
        }
    }
}
