package it.unicam.cs.mpgc.rpg132379;

import it.unicam.cs.mpgc.rpg132379.scenes.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

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