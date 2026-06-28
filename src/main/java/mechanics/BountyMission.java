package mechanics;

import components.AttackSetHandler.AttackSlot;
import entities.Fighter;
import entities.Player;
import javafx.scene.control.Alert;
import scenes.SceneManager;

import java.util.Map;

public class BountyMission implements Mission {

    private final String description;

    private final Fighter opponent;

    private final int coinsRewarded;
    private final int experienceRewarded;

    public BountyMission(String description, Fighter opponent, int coinsRewarded, int experienceRewarded) {
        this.description = description;
        this.opponent = opponent;
        this.coinsRewarded = coinsRewarded;
        this.experienceRewarded = experienceRewarded;
    }

    public String getDescription() {return description;}

    public Fighter getOpponent() {return opponent;}

    public int getCoinsRewarded() {return coinsRewarded;}

    public int getExperienceRewarded() {return experienceRewarded;}

    @Override
    public void startMission(SceneManager sceneManager) {
        Player player = sceneManager.getPlayerSaveManager().getPlayer();
        if (!checkIfMissionCanBeStarted(player)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mission cannot be started");
            alert.setHeaderText("No attacks currently equipped!");
            alert.setContentText("Equip at least one attack to start a combat");
            alert.showAndWait();
            return;
        }
        player.setCurrentMission(this);
        sceneManager.switchScene(SceneManager.SceneType.COMBAT, opponent);
    }

    @Override
    public void isCompleted(Player player) {
        player.getCoins().increaseCurrent(coinsRewarded);
        player.gainXP(experienceRewarded);
    }

    private boolean checkIfMissionCanBeStarted(Player player) {
        Map<AttackSlot, Attack> playerActiveAttacks = player.getAttacks().getAttackSet();
        for (AttackSlot slot : playerActiveAttacks.keySet()) {
            if (playerActiveAttacks.get(slot) != null) {
                return true;
            }

        }
        return false;
    }

}
