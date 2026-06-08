package scenes;

import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.PlayerSaveManager;

public class SceneManager {

    private final Stage stage;

    private final PlayerSaveManager playerSaveManager;

    private static final int SCREEN_WIDTH = 640;
    private static final int SCREEN_HEIGHT = 480;

    // static scenes (created once when the game starts)
    private final SceneFactory mainMenuScene;
    private final SceneFactory tutorialScene;

    // dynamic scenes (re-created every time they are needed)
    private SceneFactory gameScene;
    private SceneFactory combatScene;
    private SceneFactory bagScene;

    public enum SceneType {
        MAIN_MENU,
        TUTORIAL,
        GAME,
        COMBAT,
        BAG
    }

    public SceneManager(Stage stage, PlayerSaveManager playerSaveManager) {
        this.stage = stage;
        this.playerSaveManager = playerSaveManager;

        stage.setTitle("MyRPG");
        stage.setResizable(false);

        mainMenuScene = new MainMenu(this);
        tutorialScene = new Tutorial(this);
    }

    public PlayerSaveManager getPlayerSaveManager() {return this.playerSaveManager;}

    public static int getScreenWidth() {return SCREEN_WIDTH;}

    public static int getScreenHeight() {return SCREEN_HEIGHT;}

    public void switchScene(SceneType scene) {

        Scene newScene;
        // observers' list gets cleared every time a scene changes
        playerSaveManager.clearObservers();
        if (scene == SceneType.MAIN_MENU) {
            newScene = mainMenuScene.getScene();
        }
        else if (scene == SceneType.TUTORIAL) {
            newScene = tutorialScene.getScene();
        }
        else if (scene == SceneType.GAME) {
            initGameScene();
            newScene = gameScene.getScene();
        }
        else if (scene == SceneType.COMBAT) {
            initCombatScene();
            newScene = combatScene.getScene();
        }
        else if (scene == SceneType.BAG) {
            initBagScene();
            newScene = bagScene.getScene();
        }
        else throw new IllegalArgumentException("Invalid scene type");

        stage.setScene(newScene);
    }

    private void initGameScene() {
        this.gameScene = new Game(this);
    }

    private void initCombatScene() {
        this.combatScene = new Combat(this);
    }

    private void initBagScene() {
        this.bagScene = new Bag(this);
    }
}
