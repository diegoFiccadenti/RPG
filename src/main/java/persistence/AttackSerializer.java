package persistence;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import mechanics.Attack;

import java.lang.reflect.Type;

public class AttackSerializer implements JsonSerializer<Attack> {

    @Override
    public JsonElement serialize(Attack attack, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(attack).getAsJsonObject();

        jsonObject.addProperty("type", attack.getClass().getSimpleName());
        return jsonObject;
    }

}
