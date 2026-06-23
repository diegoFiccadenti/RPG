package mechanics;

import entities.Fighter;
import entities.Player;
import scenes.SceneManager;

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
        sceneManager.switchScene(SceneManager.SceneType.COMBAT, opponent);
    }

    @Override
    public void isCompleted(Player player) {
        player.getCoins().increaseCurrent(coinsRewarded);
        player.getXP().increaseCurrent(experienceRewarded);
    }

}
