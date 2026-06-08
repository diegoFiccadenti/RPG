package panes;

import entities.Player;
import items.Item;
import items.Potion;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import scenes.SceneManager;
import scenes.SceneManager.SceneType;

public class WorldPane {

    private final Pane mainPane;

    public WorldPane(SceneManager sceneManager) {

        this.mainPane = new Pane();
        mainPane.setBackground(new Background((new BackgroundFill(Color.DARKGRAY, null, null))));

        Player player = sceneManager.getPlayerSaveManager().getPlayer();

        VBox vBox = new VBox();
        vBox.setSpacing(10);

        Button takeDamage = new Button("Take Damage");
        takeDamage.setPrefSize(200, 50);
        takeDamage.setOnAction(e -> {
            player.getCombatStats().getHP().decreaseCurrent(10);
            sceneManager.getPlayerSaveManager().notifyObservers();
        });

        Button heal = new Button("Heal");
        heal.setPrefSize(200, 50);
        heal.setOnAction(e -> {
            player.getCombatStats().getHP().increaseCurrent(5);
            sceneManager.getPlayerSaveManager().notifyObservers();
        });

        Button exit = new Button("Exit");
        exit.setPrefSize(200, 50);
        exit.setOnAction(e -> {
            sceneManager.getPlayerSaveManager().clearObservers();
            sceneManager.switchScene(SceneType.MAIN_MENU);
        });

        Button saveAndExit = new Button("Save & Exit");
        saveAndExit.setPrefSize(200, 50);
        saveAndExit.setOnAction(e -> {
            sceneManager.getPlayerSaveManager().savePlayer();
            sceneManager.getPlayerSaveManager().clearObservers();
            sceneManager.switchScene(SceneType.MAIN_MENU);
        });

        Button openBag = new Button("Open bag");
        openBag.setPrefSize(200, 50);
        openBag.setOnAction(e -> {
            sceneManager.switchScene(SceneType.BAG);
        });

        Button addPotion = new Button("Add Potion");
        addPotion.setPrefSize(200, 50);
        addPotion.setOnAction(e -> {
            Item healingPotion = new Potion("Healing Potion", "Heals 20 HP", 20, 0);
            player.getInventory().addItem(healingPotion, 1);
        });

        Button removePotion = new Button("Remove Potion");
        removePotion.setPrefSize(200, 50);
        removePotion.setOnAction(e -> {
            Item healingPotion = new Potion("Healing Potion", "Heals 20 HP", 20, 0);
            player.getInventory().removeItem(healingPotion, 1);
        });

        vBox.getChildren().addAll(takeDamage, heal, exit, saveAndExit, openBag, addPotion, removePotion);
        mainPane.getChildren().addAll(vBox);
    }

    public Pane getMainPane() {return mainPane;}
}
