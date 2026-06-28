package it.unicam.cs.mpgc.rpg132379.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.rpg132379.entities.Player;
import it.unicam.cs.mpgc.rpg132379.items.Equippable;
import it.unicam.cs.mpgc.rpg132379.items.Item;
import it.unicam.cs.mpgc.rpg132379.mechanics.Attack;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.List;

public class MyReader {

    private static final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Item.class, new ItemDeserializer())
            .registerTypeAdapter(Equippable.class, new ItemDeserializer())
            .registerTypeHierarchyAdapter(Attack.class, new AttackDeserializer())
            // used because it.unicam.cs.mpgc.rpg132379.items are saved inside inventory with a HashMap<Item, Integer>
            .enableComplexMapKeySerialization()
            .setPrettyPrinting()
            .create();

    public static Player readPlayer(Path path){
        try (FileReader reader = new FileReader(path.toFile())) {
            return gson.fromJson(reader, Player.class);
        } catch (IOException e) {
            System.err.println("Errore durante la lettura: " + e.getMessage());
        }
        return null;
    }

    public static List<Item> readItemList(Path path){
        try (FileReader reader = new FileReader(path.toFile())) {
            Type type = new TypeToken<List<Item>>(){}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            System.err.println("Errore durante la lettura: " + e.getMessage());
        }
        return null;
    }
}
