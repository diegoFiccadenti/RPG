package panes;

import data_structures.EquipmentHandler.EquipmentType;
import entities.Player;
import items.EquipmentPiece;
import items.Item;
import items.Potion;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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

        Button takeDamage = newPersonalizedButton("Take Damage");
        takeDamage.setOnAction(e -> {
            player.getCombatStats().getHP().decreaseCurrent(10);
            sceneManager.getPlayerSaveManager().notifyObservers();
        });

        Button heal = newPersonalizedButton("Heal");
        heal.setOnAction(e -> {
            player.getCombatStats().getHP().increaseCurrent(5);
            sceneManager.getPlayerSaveManager().notifyObservers();
        });

        Button exit = newPersonalizedButton("Exit");
        exit.setOnAction(e -> {
            sceneManager.switchScene(SceneType.MAIN_MENU);
        });

        Button saveAndExit = newPersonalizedButton("Save & Exit");
        saveAndExit.setOnAction(e -> {
            sceneManager.getPlayerSaveManager().savePlayer();
            sceneManager.switchScene(SceneType.MAIN_MENU);
        });

        Button openBag = newPersonalizedButton("Open Bag");
        openBag.setOnAction(e -> {
            sceneManager.switchScene(SceneType.BAG);
        });

        Button addPotion = newPersonalizedButton("Add Potion");
        addPotion.setOnAction(e -> {
            /* TEST FOR MULTIPLE DIFFERENT ITEMS:
            for (int i = 0; i < 16; i++) {
                Item healingPotion = new Potion("Healing Potion n" + i, "Heals 20 HP", 20, 0);
                player.getInventory().addItem(healingPotion, 1);
            }
             */
            Item healingPotion = new Potion("Healing Potion", "Heals 20 HP", 20, 0);
            player.getInventory().addItem(healingPotion, 1);
        });

        Button addSword = newPersonalizedButton("Add Sword");
        addSword.setOnAction(e -> {
            Item ironSword = new EquipmentPiece("Iron Sword", "A sword made of iron", EquipmentType.PRIMARY_WEAPON, 20, 0, 0, 0);
            player.getInventory().addItem(ironSword, 1);
        });

        vBox.getChildren().addAll(takeDamage, heal, exit, saveAndExit, openBag, addPotion, addSword);
        mainPane.getChildren().addAll(vBox);
    }

    public Pane getMainPane() {return mainPane;}

    private Button newPersonalizedButton(String buttonName) {
        Button button = new Button(buttonName);
        button.setPrefSize(200, 50);
        button.setAlignment(Pos.CENTER);
        button.setFont(Font.font("Copperplate Gothic Light", 24));
        return button;
    }
}
