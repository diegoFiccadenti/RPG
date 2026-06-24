package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import scenes.SceneManager;

public class CombatSelectionGrid {

    private final GridPane grid;

    public CombatSelectionGrid() {

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(10);
        grid.setPrefSize(SceneManager.getScreenWidth(), 100);

        Button attack1 = new Button("Attack 1");
        Button attack2 = new Button("Attack 2");
        Button attack3 = new Button("Attack 3");
        Button attack4 = new Button("Attack 4");
        Button bag = new Button("Open Bag");

        grid.add(attack1, 0, 0);
        grid.add(attack2, 1, 0);
        grid.add(attack3, 0, 1);
        grid.add(attack4, 1, 1);
        grid.add(bag, 2, 0);
    }

    public GridPane getGrid() {return grid;}
}
