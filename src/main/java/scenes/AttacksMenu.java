package scenes;

import components.AttackSetHandler;
import components.AttackSetHandler.AttackSlot;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import mechanics.Attack;
import panes.AttacksSelector;
import utils.ButtonPersonalizer;

import java.util.Map;

public class AttacksMenu implements SceneFactory {

    private final Scene scene;

    private HBox selectionPane;

    private final AttacksSelector attacksSelector;

    public AttacksMenu(SceneManager sceneManager) {

        BorderPane root = new BorderPane();

        this.attacksSelector = new AttacksSelector(sceneManager);
        createSelectionPane(sceneManager);

        root.setBottom(selectionPane);
        root.setCenter(attacksSelector.getScrollPane());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    @Override
    public Scene getScene() {return scene;}

    private void createSelectionPane(SceneManager sceneManager) {
        this.selectionPane = new HBox();
        selectionPane.setAlignment(Pos.CENTER);
        selectionPane.setSpacing(25);

        Button selectButton = ButtonPersonalizer.newButton("Select");
        addActionToSelectButton(selectButton, sceneManager);

        Button deselectButton = ButtonPersonalizer.newButton("Deselect");
        addActionToDeselectButton(deselectButton, sceneManager);

        Button returnButton = ButtonPersonalizer.newButton("Return");
        returnButton.setOnAction(e -> sceneManager.switchScene(SceneManager.SceneType.STATSVIEWER));

        this.selectionPane.getChildren().addAll(selectButton, deselectButton, returnButton);
    }

    private void addActionToSelectButton(Button selectButton, SceneManager sceneManager) {
        selectButton.setOnAction(e -> {
            Attack selectedAttack = this.attacksSelector.getSelectedAttack();
            if (selectedAttack != null) {
                AttackSetHandler playerAttacksHandler = sceneManager.getPlayerSaveManager().getPlayer().getAttacks();
                playerAttacksHandler.addAttack(selectedAttack);
                attacksSelector.refreshAttacksList();
            }
        });
    }

    private void addActionToDeselectButton(Button deselectButton, SceneManager sceneManager) {
        deselectButton.setOnAction(e -> {
            Attack selectedAttack = this.attacksSelector.getSelectedAttack();
            if (selectedAttack != null) {
                AttackSetHandler playerAttacksHandler = sceneManager.getPlayerSaveManager().getPlayer().getAttacks();
                Map<AttackSlot, Attack> currentlySelectedAttacks = playerAttacksHandler.getAttackSet();
                for (AttackSlot slot : currentlySelectedAttacks.keySet()) {
                    if (currentlySelectedAttacks.get(slot).equals(selectedAttack)) {
                        playerAttacksHandler.emptySlot(slot);
                        attacksSelector.refreshAttacksList();
                    }
                }
            }
        });
    }
}
