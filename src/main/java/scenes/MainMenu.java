package scenes;

import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainMenu implements SceneFactory {

    private final Scene scene;

    public MainMenu(SceneManager sceneManager) {

        // creates vertical container for the buttons
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        vbox.setBackground(new Background((new BackgroundFill(Color.DARKGRAY, null, null))));

        // creates and adds the buttons
        Button play = newMenuButton("Play");
        Button tutorial = newMenuButton("Tutorial");
        Button settings = newMenuButton("Settings");
        Button quit = newMenuButton("Quit");

        vbox.getChildren().addAll(play, tutorial, settings, quit);

        // adds events to buttons
        addEventQuitGame(quit);
        addEventShowTutorial(tutorial, sceneManager);
        addEventStartGame(play, sceneManager);

        // creates menu's scene
        scene = new Scene(vbox, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return scene;}

    private Button newMenuButton(String buttonName) {
        Button button = new Button(buttonName);
        button.setPrefSize(200, 50);
        button.setAlignment(Pos.CENTER);
        button.setFont(Font.font("Copperplate Gothic Light", 24));
        return button;
    }

    private void addEventStartGame(Button playButton, SceneManager sceneManager) {
        playButton.setOnAction(e -> {
            sceneManager.getPlayerSaveManager().readPlayerSaves();
            sceneManager.switchScene(SceneManager.SceneType.GAME);
        });
    }

    private void addEventShowTutorial(Button tutorialButton, SceneManager sceneManager) {
        tutorialButton.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.TUTORIAL);
        });
    }

    private void addEventQuitGame(Button quitButton) {
        quitButton.setOnAction(e -> {
            System.exit(0); // the game gets closed entirely
        });
    }
}
