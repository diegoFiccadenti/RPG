package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import panes.MissionSelector;
import utils.ButtonPersonalizer;

public class MissionBoard implements SceneFactory {

    private final Scene scene;

    private HBox selectionPane;

    private final MissionSelector missionSelector;

    public MissionBoard(SceneManager sceneManager) {

        BorderPane root = new BorderPane();

        this.missionSelector = new MissionSelector();
        createSelectionPane(sceneManager);

        root.setBottom(selectionPane);
        root.setCenter(missionSelector.getScrollPane());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return this.scene;}

    private void createSelectionPane(SceneManager sceneManager) {
        this.selectionPane = new HBox();
        selectionPane.setAlignment(Pos.CENTER);
        selectionPane.setSpacing(50);

        Button startButton = ButtonPersonalizer.newButton("Start");
        addActionToStartButton(startButton, sceneManager);

        Button exitButton = ButtonPersonalizer.newButton("Exit");
        exitButton.setOnAction(e -> sceneManager.switchScene(SceneManager.SceneType.GAME));

        this.selectionPane.getChildren().addAll(startButton, exitButton);
    }

    private void addActionToStartButton(Button startButton, SceneManager sceneManager) {
        startButton.setOnAction(e -> {});

    }
}
