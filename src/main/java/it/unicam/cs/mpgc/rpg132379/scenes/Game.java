package it.unicam.cs.mpgc.rpg132379.scenes;

import javafx.scene.layout.*;
import javafx.scene.Scene;
import it.unicam.cs.mpgc.rpg132379.panes.PlayerInfoGrid;
import it.unicam.cs.mpgc.rpg132379.panes.WorldPane;

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
