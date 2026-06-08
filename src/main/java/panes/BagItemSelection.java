package panes;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import scenes.SceneManager;
import scenes.SceneManager.SceneType;

public class BagItemSelection {

    private final HBox hbox;

    public BagItemSelection(SceneManager sceneManager) {

        this.hbox = new HBox();
        this.hbox.setAlignment(Pos.CENTER);
        this.hbox.setSpacing(100);

        Button useButton = new Button("Use");
        useButton.setPrefSize(200, 50);

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(200, 50);
        exitButton.setOnAction(e -> {
            sceneManager.switchScene(SceneType.GAME);
        });

        this.hbox.getChildren().addAll(useButton, exitButton);
    }

    public HBox getHBox() {return this.hbox;}
}
