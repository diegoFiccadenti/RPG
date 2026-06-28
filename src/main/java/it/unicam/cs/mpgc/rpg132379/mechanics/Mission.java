package it.unicam.cs.mpgc.rpg132379.mechanics;

import it.unicam.cs.mpgc.rpg132379.entities.Player;
import it.unicam.cs.mpgc.rpg132379.scenes.SceneManager;

public interface Mission {

    void startMission(SceneManager sceneManager);

    void isCompleted(Player player);

    String getDescription();

    int getCoinsRewarded();

    int getExperienceRewarded();
}
