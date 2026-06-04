import javafx.application.Application;
import javafx.stage.Stage;
import scenes.SceneManager;

// TODO: implementare creazione personaggio e sistema di permanenza dati

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        SceneManager sceneManager = new SceneManager(stage);

        // first scene to be displayed
        SceneManager.SceneType firstScene = SceneManager.SceneType.MAIN_MENU;

        sceneManager.switchScene(firstScene);

        stage.show();

    }

    static void main(String[] args) {
        launch(args);
    }

}