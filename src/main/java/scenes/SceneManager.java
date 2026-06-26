package scenes;

import entities.Fighter;
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
    private SceneFactory missionBoardScene;
    private SceneFactory attacksMenuScene;

    public enum SceneType {
        MAIN_MENU,
        GAME,
        COMBAT,
        BAG,
        STATSVIEWER,
        SHOP,
        MISSIONBOARD,
        ATTACKS_MENU
    }

    public SceneManager(Stage stage, SceneType firstScene) {

        this.stage = stage;
        this.playerSaveManager = new PlayerSaveManager();

        stage.setTitle("MyRPG");
        stage.setResizable(false);

        mainMenuScene = new MainMenu(this);
        shopScene = new Shop(this);

        switchScene(firstScene);
        stage.show();
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
        else if (newScene == SceneType.MISSIONBOARD) {
            initMissionBoardScene();
            currentScene = missionBoardScene.getScene();
        }
        else if (newScene == SceneType.ATTACKS_MENU) {
            initAttacksMenuScene();
            currentScene = attacksMenuScene.getScene();
        }
        else throw new IllegalArgumentException("Invalid scene type");

        stage.setScene(currentScene);
    }

    public void switchScene(SceneType newScene, Fighter opponent) {

        playerSaveManager.clearObservers();
        if (newScene == SceneType.COMBAT) {
            initCombatScene(opponent);
            currentScene = combatScene.getScene();
        }
        else throw new IllegalArgumentException("Invalid scene type");

        stage.setScene(currentScene);
    }

    private void initGameScene() {
        this.gameScene = new Game(this);
    }

    private void initCombatScene(Fighter opponent) {
        this.combatScene = new Combat(this, opponent);
    }

    private void initBagScene() {
        this.bagScene = new Bag(this);
    }

    private void initStatsScene() {
        this.statsScene = new StatsView(this);
    }

    private void initMissionBoardScene() {
        this.missionBoardScene = new MissionBoard(this);
    }

    private void initAttacksMenuScene() {
        this.attacksMenuScene = new AttacksMenu(this);
    }
}
