package scenes;

import entities.Player;
import data_structures.Inventory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import panes.PlayerInfoGrid;

public class Game implements MyScene {

    // TODO: separare in due oggetti distinti la creazione di InfoGrid e MainPane

    // TODO: implementare creazione personaggio e sistema di permanenza dati

    // creazione player temporanea:
    private Player player = new Player(
            "NomeDiProva",
            new Inventory()
    );

    private PlayerInfoGrid playerInfoGrid;

    private final Scene scene;

    public Game(SceneManager sceneManager) {

        Pane mainPane = createMainPane(sceneManager);

        this.playerInfoGrid = new PlayerInfoGrid(player);
        GridPane infoGrid = playerInfoGrid.getGrid();

        BorderPane root = new BorderPane();
        root.setCenter(mainPane);
        root.setBottom(infoGrid);

        this.scene = new Scene(root, SceneManager.SCREEN_WIDTH, SceneManager.SCREEN_HEIGHT);
    }

    public Scene getScene() {return this.scene;}

    private Pane createMainPane(SceneManager sceneManager) {

        Pane pane = new Pane();
        pane.setBackground(new Background((new BackgroundFill(Color.DARKGRAY, null, null))));

        Button exit = new Button("Exit");
        exit.setPrefSize(100, 100);
        exit.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);
        });

        Button takeDamage = new Button("Take Damage");
        takeDamage.setOnAction(e -> {
            player.getCombatStats().getHP().decreaseCurrent(10);
            playerInfoGrid.updateGrid(player);
        });

        pane.getChildren().addAll(exit, takeDamage);

        return pane;
    }
}
