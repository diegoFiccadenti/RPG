package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import scenes.SceneManager;
import scenes.SceneManager.SceneType;
import utils.ButtonPersonalizer;

import java.util.Optional;

public class WorldPane {

    private final HBox root;

    public WorldPane(SceneManager sceneManager) {

        this.root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setFillHeight(true);
        root.setSpacing(50);
        root.setPadding(new Insets(100));
        root.setBackground(new Background(new BackgroundFill(Color.DARKGREY, null, null)));

        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        vbox1.setSpacing(20);
        vbox2.setSpacing(20);

        Button missionBoard = ButtonPersonalizer.newButton("Missions");
        Button stats = ButtonPersonalizer.newButton("Stats");
        Button exit = ButtonPersonalizer.newButton("Exit");
        Button shop = ButtonPersonalizer.newButton("Shop");
        Button bag = ButtonPersonalizer.newButton("Bag");
        Button saveAndExit = ButtonPersonalizer.newButton("Save & Exit");

        missionBoard.setOnAction(e -> sceneManager.switchScene(SceneType.MISSIONBOARD));

        stats.setOnAction(e -> sceneManager.switchScene(SceneType.STATSVIEWER));

        exit.setOnAction(e -> {
            Alert confirm = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to continue?");
            confirm.setTitle("Exiting without saving");
            confirm.setHeaderText("You are about to exit without saving");
            Optional<ButtonType> result = confirm.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                sceneManager.switchScene(SceneType.MAIN_MENU);
            }
        });

        shop.setOnAction(e -> sceneManager.switchScene(SceneType.SHOP));

        bag.setOnAction(e -> sceneManager.switchScene(SceneType.BAG));

        saveAndExit.setOnAction(e -> {
            sceneManager.getPlayerSaveManager().savePlayer();
            sceneManager.switchScene(SceneType.MAIN_MENU);
        });

        vbox1.getChildren().addAll(missionBoard, stats, exit);
        vbox2.getChildren().addAll(shop, bag, saveAndExit);
        root.getChildren().addAll(vbox1, vbox2);
    }

    public HBox getMainPane() {return root;}
}
