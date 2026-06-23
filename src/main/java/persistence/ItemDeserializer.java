package persistence;

import com.google.gson.*;
import items.Item;
import items.Potion;
import items.EquipmentPiece;
import items.SkillBook;
import mechanics.Attack;
import mechanics.PhysicalAttack;
import mechanics.Spell;

import java.lang.reflect.Type;

public class ItemDeserializer implements JsonDeserializer<Item> {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Attack.class, new JsonDeserializer<Attack>() {
                public Attack deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                    JsonObject object = json.getAsJsonObject();
                    if (object.has("requiredMana")) {
                        return new Gson().fromJson(object, Spell.class);
                    } else {
                        return new Gson().fromJson(object, PhysicalAttack.class);
                    }
                }
            })
            .create();

    @Override
    public Item deserialize (JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

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
