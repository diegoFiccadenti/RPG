package panes;

import components.AttackSetHandler.AttackSlot;
import entities.Fighter;
import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import mechanics.Attack;
import mechanics.CombatTurn;
import scenes.SceneManager;
import utils.ButtonPersonalizer;

public class CombatSelectionGrid {

    private final GridPane grid;

    private final Fighter opponent;

    public CombatSelectionGrid(SceneManager sceneManager, Fighter opponent) {

        this.opponent = opponent;

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPrefSize(SceneManager.getScreenWidth(), 100);

        Button attack1 = createAttackButton(sceneManager, AttackSlot.SLOT1);
        Button attack2 = createAttackButton(sceneManager, AttackSlot.SLOT2);
        Button attack3 = createAttackButton(sceneManager, AttackSlot.SLOT3);
        Button attack4 = createAttackButton(sceneManager, AttackSlot.SLOT4);

        grid.add(attack1, 0, 0);
        grid.add(attack2, 1, 0);
        grid.add(attack3, 0, 1);
        grid.add(attack4, 1, 1);
    }

    public GridPane getGrid() {return grid;}

    private Button createAttackButton(SceneManager sceneManager, AttackSlot slot) {

        Player player = sceneManager.getPlayerSaveManager().getPlayer();
        Attack selectedAttack = player.getAttacks().getAttackSet().get(slot);
        Button newAttackButton = ButtonPersonalizer.newButton("", 200, 30, 16);

        if (selectedAttack == null) {
            newAttackButton.setText("No attack selected");
        }
        else {
            newAttackButton.setText(selectedAttack.getName());
            newAttackButton.setOnAction(e -> {
                CombatTurn nextTurn = new CombatTurn(sceneManager, opponent, selectedAttack);
                nextTurn.executeTurn(sceneManager);
                sceneManager.getPlayerSaveManager().notifyObservers();
            });
        }

        return newAttackButton;

    }
}
