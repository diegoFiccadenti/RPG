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
import utils.ButtonPersonalizer;

public class Tutorial implements SceneFactory {

    private final Scene scene;

    public Tutorial(SceneManager sceneManager) {

        // creating the text
        Text text1 = new Text("Benvenuto nel tutorial di *inserire nome del gioco*!\n");
        text1.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        Text text2 = new Text("Questa è una prova per il testo del tutorial: " +
                "ab cdefgh ijklmnopqrstuvwxyz 123456789 qwerty uiop asdfgh jkl zxcv" +
                "bnm");

        // creating the button for returning to main menu
        Button returnToMenu = ButtonPersonalizer.newButton("Return to Menu", 250, 50, 24);
        returnToMenu.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);
        });

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
        scrollPane.setFitToWidth(true);
        scrollPane.setContent(vbox);

        this.scene = new Scene(scrollPane, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return scene;}
}
