package scenes;

import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.PlayerSaveManager;

public class SceneManager {

    private final Stage stage;

    private Scene currentScene;

    private final PlayerSaveManager playerSaveManager;

    private static final int SCREEN_WIDTH = 640;
    private static final int SCREEN_HEIGHT = 480;

    // static scenes (created once when the game starts)
    private final SceneFactory mainMenuScene;
    private final SceneFactory shopScene;

    // dynamic scenes (re-created every time they are needed)
    private SceneFactory gameScene;
    private SceneFactory combatScene;
    private SceneFactory bagScene;
    private SceneFactory statsScene;

    public enum SceneType {
        MAIN_MENU,
        GAME,
        COMBAT,
        BAG,
        STATSVIEWER,
        SHOP
    }

    public SceneManager(Stage stage, SceneType firstScene, PlayerSaveManager playerSaveManager) {
        this.stage = stage;
        this.playerSaveManager = playerSaveManager;

        stage.setTitle("MyRPG");
        stage.setResizable(false);

        mainMenuScene = new MainMenu(this);
        shopScene = new Shop(this);

        switchScene(firstScene);
    }

    public Scene getCurrentScene() {return this.currentScene;}

    public PlayerSaveManager getPlayerSaveManager() {return this.playerSaveManager;}

    public static int getScreenWidth() {return SCREEN_WIDTH;}

    public static int getScreenHeight() {return SCREEN_HEIGHT;}

    public void switchScene(SceneType newScene) {

        // observers' list gets cleared every time a scene changes
        playerSaveManager.clearObservers();
        if (newScene == SceneType.MAIN_MENU) {
            currentScene = mainMenuScene.getScene();
        }
        else if (newScene == SceneType.GAME) {
            initGameScene();
            currentScene = gameScene.getScene();
        }
        else if (newScene == SceneType.COMBAT) {
            initCombatScene();
            currentScene = combatScene.getScene();
        }
        else if (newScene == SceneType.BAG) {
            initBagScene();
            currentScene = bagScene.getScene();
        }
        else if (newScene == SceneType.STATSVIEWER) {
            initStatsScene();
            currentScene = statsScene.getScene();
        }
        else if (newScene == SceneType.SHOP) {
            currentScene = shopScene.getScene();
        }
        else throw new IllegalArgumentException("Invalid scene type");

        stage.setScene(currentScene);
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

    private void initStatsScene() {
        this.statsScene = new StatsView(this);
    }
}
