import scenes.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO 01: risolvere conflitti e bug con la permanenza dei dati (in particolare danno problemi gli items equipaggiati + attacchi imparati)

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // first scene to be displayed
        SceneManager.SceneType firstScene = SceneManager.SceneType.MAIN_MENU;

        SceneManager sceneManager = new SceneManager(stage, firstScene);

    }

    static void main(String[] args) {
        launch(args);
    }

}