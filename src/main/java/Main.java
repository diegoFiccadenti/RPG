import data_structures.Inventory;
import entities.Player;

import json.MyWriter;
import java.nio.file.Path;

import scenes.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO: implementare creazione personaggio e sistema di permanenza dati

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Player player = new Player("PlayerName", new Inventory(16));

        Path playerSavePath = Path.of("saves/player.json");
        MyWriter.savePlayer(player, playerSavePath);

        SceneManager sceneManager = new SceneManager(stage);

        // first scene to be displayed
        SceneManager.SceneType firstScene = SceneManager.SceneType.MAIN_MENU;

        sceneManager.switchScene(firstScene);

        stage.show();

    }

    static void main(String[] args) {
        launch(args);
    }

}