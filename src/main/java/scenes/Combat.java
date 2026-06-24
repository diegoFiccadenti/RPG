package scenes;

import entities.Fighter;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import panes.CombatPane;
import panes.CombatSelectionGrid;

public class Combat implements SceneFactory {

    private final Scene scene;

    public Combat (SceneManager sceneManager, Fighter opponent) {

        CombatPane combatPane = new CombatPane(sceneManager, opponent);
        CombatSelectionGrid combatSelectionGrid = new CombatSelectionGrid(sceneManager, opponent);

        BorderPane root = new BorderPane();

        root.setCenter(combatPane.getMainPane());
        root.setBottom(combatSelectionGrid.getGrid());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return scene;}
}
