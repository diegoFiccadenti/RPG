package scenes;

import javafx.scene.layout.*;
import javafx.scene.Scene;
import panes.PlayerInfoGrid;
import panes.WorldPane;

public class Game implements SceneFactory {

    private final Scene scene;

    public Game(SceneManager sceneManager) {

        PlayerInfoGrid playerInfoGrid = new PlayerInfoGrid(sceneManager);
        sceneManager.getPlayerSaveManager().addObserver(playerInfoGrid);

        WorldPane worldPane = new WorldPane(sceneManager);

        BorderPane root = new BorderPane();
        root.setCenter(worldPane.getMainPane());
        root.setBottom(playerInfoGrid.getGrid());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return this.scene;}
}
