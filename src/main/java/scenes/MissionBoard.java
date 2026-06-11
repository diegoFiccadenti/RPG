package scenes;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MissionBoard implements SceneFactory {

    private final Scene scene;

    public MissionBoard(SceneManager sceneManager) {

        Pane root = new Pane();

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return this.scene;}
}
