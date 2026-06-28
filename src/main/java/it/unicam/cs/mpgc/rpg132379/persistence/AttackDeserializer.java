package it.unicam.cs.mpgc.rpg132379.persistence;

import com.google.gson.*;
import it.unicam.cs.mpgc.rpg132379.mechanics.Attack;
import it.unicam.cs.mpgc.rpg132379.mechanics.PhysicalAttack;
import it.unicam.cs.mpgc.rpg132379.mechanics.Spell;

import java.lang.reflect.Type;

public class AttackDeserializer implements JsonDeserializer<Attack> {

    private final Gson gson = new GsonBuilder().create();

    @Override
    public Attack deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        if (!jsonObject.has("type") || jsonObject.get("type").isJsonNull()) {
            throw new JsonParseException("Missing or invalid type");
        }

        String itemType = jsonObject.get("type").getAsString();

        if (itemType.equals("Spell")) {
            return gson.fromJson(jsonObject, Spell.class);
        }
        else if (itemType.equals("PhysicalAttack")) {
            return gson.fromJson(jsonObject, PhysicalAttack.class);
        }
        else throw new JsonParseException("Unknown item type: " + itemType);
    }
}
