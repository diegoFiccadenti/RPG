package scenes;

import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.PlayerSaveManager;

public class SceneManager {

    private final Stage stage;

    private final PlayerSaveManager playerSaveManager;

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

    public SceneManager(Stage stage, PlayerSaveManager playerSaveManager) {
        this.stage = stage;
        this.playerSaveManager = playerSaveManager;

        stage.setTitle("MyRPG");
        stage.setResizable(false);

        mainMenuScene = new MainMenu(this);
        tutorialScene = new Tutorial(this);
        gameScene = new Game(this);
        combatScene = new Combat(this);
    }

    public PlayerSaveManager getPlayerSaveManager() {return this.playerSaveManager;}

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
