package scenes;

import javafx.geometry.Pos;
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

        // creates and adds the buttons
        Button play = new Button("Play");
        Button tutorial = new Button("Tutorial");
        Button settings = new Button("Settings");
        Button quit = new Button("Quit");
        newMenuButton(play);
        newMenuButton(tutorial);
        newMenuButton(settings);
        newMenuButton(quit);

        vbox.getChildren().addAll(play, tutorial, settings, quit);

        // adds events to buttons
        addEventQuitGame(quit);
        addEventShowTutorial(tutorial, stage);

        // creates menu's scene
        Scene menuScene = new Scene(vbox, 640, 480);
        stage.setScene(menuScene);
    }

    private static void newMenuButton(Button button) {
        button.setPrefSize(200, 50);
        button.setAlignment(Pos.CENTER);
        button.setFont(Font.font("Copperplate Gothic Light", 24));
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
