import scenes.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO 01: risolvere conflitti e bug con la permanenza dei dati (in particolare vedi comportamento degli items di player quando sono equipaggiati o meno)
// TODO 02: implementare scena del combattimento

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