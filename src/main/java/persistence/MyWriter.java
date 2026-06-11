package persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import entities.Player;
import items.Item;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.List;

public class MyWriter {

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(Item.class, new ItemSerializer())
            // used because items are saved inside inventory with a HashMap<Item, Integer>
            .enableComplexMapKeySerialization()
            .setPrettyPrinting()
            .create();

    public static void savePlayer(Player player, Path path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            gson.toJson(player, writer);
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura: " + e.getMessage());
        }
    }

    public static void saveItemList(List<Item> itemList, Path path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            Type type = new TypeToken<List<Item>>(){}.getType();
            gson.toJson(itemList, type, writer);
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura: " + e.getMessage());
        }
    }
}
