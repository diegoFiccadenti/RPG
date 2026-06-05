package scenes;

import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.SaveManager;

public class SceneManager {

    private final Stage stage;

    private final SaveManager saveManager;

    private static final int SCREEN_WIDTH = 640;
    private static final int SCREEN_HEIGHT = 480;

    private final MyScene mainMenuScene;
    private final MyScene tutorialScene;
    private final MyScene gameScene;
    private final MyScene combatScene;

    public enum SceneType {
        MAIN_MENU,
        TUTORIAL,
        GAME,
        COMBAT
    }

    public SceneManager(Stage stage, SaveManager saveManager) {
        this.stage = stage;
        this.saveManager = saveManager;

        stage.setTitle("MyRPG");
        stage.setResizable(false);

        mainMenuScene = new MainMenu(this);
        tutorialScene = new Tutorial(this);
        gameScene = new Game(this);
        combatScene = new Combat(this);
    }

    public SaveManager getSaveManager() {return this.saveManager;}

    public static int getScreenWidth() {return SCREEN_WIDTH;}

    public static int getScreenHeight() {return SCREEN_HEIGHT;}

    public void switchScene(SceneType scene) {

        Scene newScene;
        if (scene == SceneType.MAIN_MENU) {
            newScene = mainMenuScene.getScene();
        }
        else if (scene == SceneType.TUTORIAL) {
            newScene = tutorialScene.getScene();
        }
        else if (scene == SceneType.GAME) {
            newScene = gameScene.getScene();
        }
        else if (scene == SceneType.COMBAT) {
            newScene = combatScene.getScene();
        }
        else throw new IllegalArgumentException("Invalid scene type");

        stage.setScene(newScene);
    }
}
