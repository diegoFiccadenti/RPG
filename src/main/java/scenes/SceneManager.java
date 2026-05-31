package scenes;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneManager {

    private final Stage stage;

    public static final int SCREEN_WIDTH = 640;
    public static final int SCREEN_HEIGHT = 480;

    private final MyScene mainMenuScene;
    private final MyScene tutorialScene;
    private final MyScene gameScene;

    public enum SceneType {
        MAIN_MENU,
        TUTORIAL,
        GAME
    }

    public SceneManager(Stage stage) {
        this.stage = stage;

        stage.setTitle("MyRPG");
        stage.setResizable(false);

        mainMenuScene = new MainMenu(this);
        tutorialScene = new Tutorial(this);
        gameScene = new Game(this);
    }

    public void switchScene(SceneType scene) {

        Scene newScene = null;
        if (scene == SceneType.MAIN_MENU) {
            newScene = mainMenuScene.getScene();
        }
        else if (scene == SceneType.TUTORIAL) {
            newScene = tutorialScene.getScene();
        }
        else if (scene == SceneType.GAME) {
            newScene = gameScene.getScene();
        }
        else throw new IllegalArgumentException("Invalid scene type");

        stage.setScene(newScene);
    }

    public static int getScreenWidth() {return SCREEN_WIDTH;}

    public static int getScreenHeight() {return SCREEN_HEIGHT;}
}
