package panes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import scenes.SceneManager;
import scenes.SceneManager.SceneType;
import utils.ButtonPersonalizer;

public class WorldPane {

    private final HBox root;

    public WorldPane(SceneManager sceneManager) {

        this.root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setFillHeight(true);
        root.setSpacing(50);
        root.setPadding(new Insets(100));

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

        exit.setOnAction(e -> {
            sceneManager.switchScene(SceneType.MAIN_MENU);
        });

        bag.setOnAction(e -> {
            sceneManager.switchScene(SceneType.BAG);
        });

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
