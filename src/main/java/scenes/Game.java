package scenes;

import entities.Player;
import data_structures.Inventory;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import panes.PlayerInfoGrid;
import panes.WorldPane;

public class Game implements MyScene {

    // creazione player temporanea:
    private final Player player = new Player(
            "NomeDiProva",
            new Inventory()
    );

    private final PlayerInfoGrid playerInfoGrid;

    private final WorldPane mainPane;

    private final Scene scene;

    public Game(SceneManager sceneManager) {

        this.playerInfoGrid = new PlayerInfoGrid(player);

        this.mainPane = new WorldPane(sceneManager, player, playerInfoGrid);

        BorderPane root = new BorderPane();
        root.setCenter( mainPane.getMainPane());
        root.setBottom(playerInfoGrid.getGrid());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return this.scene;}
}
