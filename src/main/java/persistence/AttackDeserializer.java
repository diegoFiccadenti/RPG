package persistence;

import com.google.gson.*;
import mechanics.Attack;
import mechanics.PhysicalAttack;
import mechanics.Spell;

import java.lang.reflect.Type;

public class AttackDeserializer implements JsonDeserializer<Attack> {

    @Override
    public Attack deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();
        String itemType = jsonObject.get("type").getAsString();

        if (itemType.equals("Spell")) {
            return context.deserialize(json, Spell.class);
        }
        else if (itemType.equals("PhysicalAttack")) {
            return context.deserialize(json, PhysicalAttack.class);
        }
        else throw new JsonParseException("Unknown item type: " + itemType);
    }
}
