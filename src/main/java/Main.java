import javafx.application.Application;
import javafx.stage.Stage;
import scenes.SceneManager;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        SceneManager sceneManager = new SceneManager(stage);

        // first scene to be displayed
        sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);

        stage.show();

    }

    static void main(String[] args) {
        launch();
    }

}