import persistence.PlayerSaveManager;
import scenes.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO: rifinire ed estendere il sistema di persistenza dei dati
//  *IMPORTANTE!* sistemare il bug che rompe il gioco quando l'inventario non è vuoto

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        PlayerSaveManager saveManager = new PlayerSaveManager();
        SceneManager sceneManager = new SceneManager(stage, saveManager);

        // first scene to be displayed
        SceneManager.SceneType firstScene = SceneManager.SceneType.MAIN_MENU;

        sceneManager.switchScene(firstScene);

        stage.show();

    }

    static void main(String[] args) {
        launch(args);
    }

}