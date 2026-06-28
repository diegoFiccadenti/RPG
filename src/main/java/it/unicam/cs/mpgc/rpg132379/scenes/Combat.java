package it.unicam.cs.mpgc.rpg132379.scenes;

import it.unicam.cs.mpgc.rpg132379.entities.Fighter;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import it.unicam.cs.mpgc.rpg132379.panes.CombatPane;
import it.unicam.cs.mpgc.rpg132379.panes.CombatSelectionGrid;

public class Combat implements SceneFactory {

    private final Scene scene;

    public Combat (SceneManager sceneManager, Fighter opponent) {

        CombatPane combatPane = new CombatPane(sceneManager, opponent);
        sceneManager.getPlayerSaveManager().addObserver(combatPane);
        CombatSelectionGrid combatSelectionGrid = new CombatSelectionGrid(sceneManager, opponent);

        BorderPane root = new BorderPane();

        root.setCenter(combatPane.getMainPane());
        root.setBottom(combatSelectionGrid.getGrid());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return scene;}
}
