package scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import panes.CombatPane;
import panes.CombatSelectionGrid;

public class Combat implements MyScene {

    private final CombatPane combatPane;
    private final CombatSelectionGrid combatSelectionGrid;

    private final Scene scene;

    public Combat (SceneManager sceneManager) {

        combatPane = new CombatPane();
        combatSelectionGrid = new CombatSelectionGrid();

        BorderPane root = new BorderPane();

        root.setCenter(combatPane.getPane());
        root.setBottom(combatSelectionGrid.getGrid());

        this.scene = new Scene(root);
    }

    public Scene getScene() {return scene;}
}
