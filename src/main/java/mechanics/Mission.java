package mechanics;

import entities.Player;

public interface Mission {

    void startMission();

    void isCompleted(Player player);

    String getDescription();

    int getCoinsRewarded();

    int getExperienceRewarded();
}
