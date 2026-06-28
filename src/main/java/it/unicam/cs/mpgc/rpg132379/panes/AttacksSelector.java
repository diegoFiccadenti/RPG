package it.unicam.cs.mpgc.rpg132379.panes;

import it.unicam.cs.mpgc.rpg132379.components.AttackSetHandler.AttackSlot;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import it.unicam.cs.mpgc.rpg132379.mechanics.Attack;
import it.unicam.cs.mpgc.rpg132379.scenes.SceneManager;

import java.util.List;
import java.util.Map;

public class AttacksSelector {

    private final ScrollPane scrollPane;

    private final VBox attacksVBox;

    private Attack selectedAttack;

    private final List<Attack> learnedAttacks;

    private final Map<AttackSlot, Attack> currentlySelectedAttacks;

    public AttacksSelector(SceneManager sceneManager) {

        this.learnedAttacks = sceneManager.getPlayerSaveManager().getPlayer().getAttacks().getKnownAttacks();
        this.currentlySelectedAttacks = sceneManager.getPlayerSaveManager().getPlayer().getAttacks().getAttackSet();

        this.attacksVBox = new VBox();
        this.attacksVBox.setSpacing(5);

        this.scrollPane = new ScrollPane();
        this.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.scrollPane.setContent(attacksVBox);

        this.selectedAttack = null;

        refreshAttacksList();
    }

    public ScrollPane getScrollPane() {return this.scrollPane;}

    public Attack getSelectedAttack() {return this.selectedAttack;}

    public void refreshAttacksList() {

        this.attacksVBox.getChildren().clear();
        for (Attack attack : learnedAttacks) {
            Button newAttackButton = new Button();
            newAttackButton.setPrefSize(SceneManager.getScreenWidth() * 0.95, SceneManager.getScreenHeight() * 0.1);
            newAttackButton.setText(attack.getName() + " - Power: " + attack.getPower());
            newAttackButton.setOnAction(e -> selectedAttack = attack);
            for (AttackSlot slot : currentlySelectedAttacks.keySet()) {
                if (currentlySelectedAttacks.get(slot) != null && currentlySelectedAttacks.get(slot).equals(attack)) {
                    newAttackButton.setStyle("-fx-background-color: CadetBlue;");
                    newAttackButton.setText("[Selected] " + attack.getName() + " - Power: " + attack.getPower());
                }
            }
            attacksVBox.getChildren().add(newAttackButton);
        }
    }
}
