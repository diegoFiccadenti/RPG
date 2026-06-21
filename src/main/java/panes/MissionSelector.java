package panes;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import mechanics.Mission;
import scenes.SceneManager;
import utils.MissionInitializer;

import java.util.List;

public class MissionSelector {

    private final ScrollPane scrollPane;

    private final VBox missions;

    private Mission selectedMission;

    private final List<Mission> availableMissions;

    public MissionSelector() {

        this.availableMissions = MissionInitializer.getMissions();

        this.missions = new VBox();
        this.missions.setSpacing(5);

        this.scrollPane = new ScrollPane();
        this.scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.scrollPane.setContent(missions);

        this.selectedMission = null;

        refreshMissionList();
    }

    public ScrollPane getScrollPane() {return this.scrollPane;}

    public Mission getSelectedMission() {return this.selectedMission;}

    private void refreshMissionList() {

        this.missions.getChildren().clear();
        for (Mission mission : availableMissions) {
            Button newMissionButton = new Button();
            newMissionButton.setPrefSize(SceneManager.getScreenWidth() * 0.95, SceneManager.getScreenHeight() * 0.1);
            newMissionButton.setText(mission.getDescription() + " - Reward: " + mission.getCoinsRewarded() + " coins | " +  mission.getExperienceRewarded() + " XP");
            newMissionButton.setOnAction(e -> selectedMission = mission);
            missions.getChildren().add(newMissionButton);
        }
    }

}
