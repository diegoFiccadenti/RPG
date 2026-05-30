package scenes;

import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainMenu implements MyScene {

    // creates the main menu scene
    public static void create(Stage stage) {

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
        addEventShowTutorial(tutorial, stage);
        addEventStartGame(play, stage);

        // creates menu's scene
        Scene menuScene = new Scene(vbox, 640, 480);
        stage.setScene(menuScene);
    }

    private static Button newMenuButton(String buttonName) {
        Button button = new Button(buttonName);
        button.setPrefSize(200, 50);
        button.setAlignment(Pos.CENTER);
        button.setFont(Font.font("Copperplate Gothic Light", 24));
        return button;
    }

    private static void addEventStartGame(Button playButton, Stage stage) {
        playButton.setOnAction(e -> {
            Game.create(stage);
            stage.show();
        });
    }

    private static void addEventShowTutorial(Button tutorialButton, Stage stage) {
        tutorialButton.setOnAction(e -> {
            Tutorial.create(stage);
            stage.show();
        });
    }

    private static void addEventQuitGame(Button quitButton) {
        quitButton.setOnAction(e -> {
            System.exit(0); // the game gets closed entirely
        });
    }
}
