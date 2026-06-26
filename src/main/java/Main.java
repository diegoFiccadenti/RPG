import scenes.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

// TODO 01: risolvere conflitti e bug con la permanenza dei dati (in particolare danno problemi gli items equipaggiati + attacchi imparati)
// TODO 02: risolvere problemi di bilanciamento del gioco (opzionale)
// TODO 03: fare in modo che non si possa iniziare un combattimento senza attacchi equipaggiati
// TODO 04: assegnare 2 attacchi di base al Player già alla creazione (prima risolvi problemi di persistenza)
// TODO 05: controllare le classi una ad una per eventuali metodi inutilizzati o TODO lasciati in sospeso

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