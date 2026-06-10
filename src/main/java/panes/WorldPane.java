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

        stats.setOnAction(e -> {
            sceneManager.switchScene(SceneType.STATSVIEWER);
        });

        exit.setOnAction(e -> {
            sceneManager.switchScene(SceneType.MAIN_MENU);
        });

        shop.setOnAction(e -> {
            sceneManager.switchScene(SceneType.SHOP);
        });

        bag.setOnAction(e -> {
            sceneManager.switchScene(SceneType.BAG);
        });

        saveAndExit.setOnAction(e -> {
            sceneManager.getPlayerSaveManager().savePlayer();
            sceneManager.switchScene(SceneType.MAIN_MENU);
        });

        // TEMPORARY BUTTONS FOT TESTS
        VBox testButtons = new VBox();

        Button gainXP = ButtonPersonalizer.newButton("Gain XP");
        gainXP.setOnAction(e -> {
           sceneManager.getPlayerSaveManager().getPlayer().gainXP(100);
           sceneManager.getPlayerSaveManager().notifyObservers();
        });

        testButtons.getChildren().addAll(gainXP);

        vbox1.getChildren().addAll(missionBoard, stats, exit);
        vbox2.getChildren().addAll(shop, bag, saveAndExit);
        root.getChildren().addAll(vbox1, vbox2, testButtons);
    }

    public HBox getMainPane() {return root;}
}
