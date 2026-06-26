package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Player;
import items.Item;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.List;

public class MyReader {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Item.class, new ItemDeserializer())
            // used because items are saved inside inventory with a HashMap<Item, Integer>
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
