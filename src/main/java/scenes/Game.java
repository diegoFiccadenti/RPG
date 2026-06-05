package scenes;

import entities.Player;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import panes.PlayerInfoGrid;
import panes.WorldPane;

public class Game implements MyScene {

    private final Scene scene;

    public Game(SceneManager sceneManager) {

        Player player = sceneManager.getSaveManager().getPlayer();

        PlayerInfoGrid playerInfoGrid = new PlayerInfoGrid(player);

        WorldPane worldPane = new WorldPane(sceneManager, player, playerInfoGrid);

        BorderPane root = new BorderPane();
        root.setCenter(worldPane.getMainPane());
        root.setBottom(playerInfoGrid.getGrid());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return this.scene;}
}
