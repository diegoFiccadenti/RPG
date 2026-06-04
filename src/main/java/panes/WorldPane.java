package panes;

import entities.Player;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import json.MyWriter;
import scenes.SceneManager;

import java.nio.file.Path;

// TODO: WorldPane non dovrebbe conoscere playerInfoGrid (rompe principi SOLID), implementare una soluzione

public class WorldPane {

    private final Pane mainPane;

    public WorldPane(SceneManager sceneManager, Player player, PlayerInfoGrid playerInfoGrid) {

        this.mainPane = new Pane();
        mainPane.setBackground(new Background((new BackgroundFill(Color.DARKGRAY, null, null))));

        VBox vBox = new VBox();
        vBox.setSpacing(10);

        Button takeDamage = new Button("Take Damage");
        takeDamage.setPrefSize(200, 50);
        takeDamage.setOnAction(e -> {
            player.getCombatStats().getHP().decreaseCurrent(10);
            playerInfoGrid.refreshData(player);
        });

        Button heal = new Button("Heal");
        heal.setPrefSize(200, 50);
        heal.setOnAction(e -> {
            player.getCombatStats().getHP().increaseCurrent(5);
            playerInfoGrid.refreshData(player);
        });

        Button exit = new Button("Exit");
        exit.setPrefSize(200, 50);
        exit.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);
        });

        Button saveAndExit = new Button("Save & Exit");
        saveAndExit.setPrefSize(200, 50);
        saveAndExit.setOnAction(e -> {
            Path playerSavePath = Path.of("saves/player.json");
            MyWriter.savePlayer(player, playerSavePath);
            sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);
        });

        vBox.getChildren().addAll(takeDamage, heal, exit, saveAndExit);
        mainPane.getChildren().addAll(vBox);
    }

    public Pane getMainPane() {return mainPane;}
}
