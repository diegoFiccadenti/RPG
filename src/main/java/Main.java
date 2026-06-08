import persistence.PlayerSaveManager;
import scenes.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        PlayerSaveManager playerSaveManager = new PlayerSaveManager();

        // first scene to be displayed
        SceneManager.SceneType firstScene = SceneManager.SceneType.MAIN_MENU;

        SceneManager sceneManager = new SceneManager(stage, firstScene, playerSaveManager);
        sceneManager.switchScene(firstScene);

        stage.show();

    }

    static void main(String[] args) {
        launch(args);
    }

}