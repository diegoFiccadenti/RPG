package it.unicam.cs.mpgc.rpg132379.persistence;

import com.google.gson.*;
import it.unicam.cs.mpgc.rpg132379.mechanics.Attack;

import java.lang.reflect.Type;

public class AttackSerializer implements JsonSerializer<Attack> {

    private final Gson gson = new GsonBuilder().create();

    @Override
    public JsonElement serialize(Attack attack, Type typeOfSrc, JsonSerializationContext context) {

        JsonObject jsonObject = gson.toJsonTree(attack).getAsJsonObject();

        jsonObject.addProperty("type", attack.getClass().getSimpleName());
        return jsonObject;
    }

}
