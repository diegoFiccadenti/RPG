package mechanics;

import entities.Player;
import scenes.SceneManager;

public interface Mission {

    void startMission(SceneManager sceneManager);

    void isCompleted(Player player);

    String getDescription();

    int getCoinsRewarded();

    int getExperienceRewarded();
}
