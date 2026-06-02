package panes;

import entities.Player;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import scenes.SceneManager;

// TODO: WorldPane non dovrebbe conoscere playerInfoGrid (rompe principi SOLID), implementare una soluzione

public class WorldPane {

    private final Pane mainPane;

    public WorldPane(SceneManager sceneManager, Player player, PlayerInfoGrid playerInfoGrid) {

        this.mainPane = new Pane();
        mainPane.setBackground(new Background((new BackgroundFill(Color.DARKGRAY, null, null))));

        Button exit = new Button("Exit");
        exit.setPrefSize(100, 100);
        exit.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);
        });

        Button takeDamage = new Button("Take Damage");
        takeDamage.setOnAction(e -> {
            player.getCombatStats().getHP().decreaseCurrent(10);
            playerInfoGrid.refreshData(player);
        });

        mainPane.getChildren().addAll(exit, takeDamage);
    }

    public Pane getMainPane() {return mainPane;}
}
