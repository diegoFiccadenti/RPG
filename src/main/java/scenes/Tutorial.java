package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Tutorial implements MyScene {

    public static void create(Stage stage) {

        // creating the text
        Text text1 = new Text("Benvenuto nel tutorial di *inserire nome del gioco*!\n");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        Text text2 = new Text("Questa è una prova per il testo del tutorial: " +
                "ab cdefgh ijklmnopqrstuvwxyz 123456789 qwerty uiop asdfgh jkl zxcv" +
                "bnm");

        // creating the button for returning to main menu
        Button returnToMenu = new Button("Return to Menu");
        personalizeReturnButton(returnToMenu, stage);

        // creating the text-flow area
        TextFlow textFlow = new TextFlow(text1, text2);
        textFlow.setLineSpacing(5);

        // creating the VBox
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.TOP_CENTER);
        vbox.setSpacing(20);
        vbox.getChildren().addAll(textFlow);
        vbox.getChildren().add(returnToMenu); // added for last so it stays on the bottom

        // creating the scrollPane
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);

        Scene tutorialScene = new Scene(scrollPane, 640, 480);

        stage.setScene(tutorialScene);
    }

    private static void personalizeReturnButton(Button button, Stage stage) {
        button.setPrefSize(250, 50);
        button.setAlignment(Pos.CENTER);
        button.setFont(Font.font("Copperplate Gothic Light", 24));
        button.setOnAction(e -> {
            MainMenu.create(stage);
            stage.show();
        });
    }
}
