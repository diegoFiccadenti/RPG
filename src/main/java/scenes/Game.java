package scenes;

import entities.Player;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import json.MyReader;
import panes.PlayerInfoGrid;
import panes.WorldPane;

import java.nio.file.Path;

public class Game implements MyScene {

    // creazione player temporanea:
    Path playerPath = Path.of("saves/player.json");
    private final Player player = MyReader.readPlayer(playerPath);

    private final PlayerInfoGrid playerInfoGrid;

    private final WorldPane mainPane;

    private final Scene scene;

    public Game(SceneManager sceneManager) {

        this.playerInfoGrid = new PlayerInfoGrid(player);

        this.mainPane = new WorldPane(sceneManager, player, playerInfoGrid);

        BorderPane root = new BorderPane();
        root.setCenter(mainPane.getMainPane());
        root.setBottom(playerInfoGrid.getGrid());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return this.scene;}
}
