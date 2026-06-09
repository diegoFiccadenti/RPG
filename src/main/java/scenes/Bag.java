package scenes;

import entities.Player;
import items.Consumable;
import items.Item;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import panes.BagSelector;

import java.util.ArrayList;
import java.util.List;

public class Bag implements SceneFactory {

    private final Scene scene;

    private HBox selectionPane;

    private BagSelector bagSelector;

    public Bag(SceneManager sceneManager) {

        BorderPane root = new BorderPane();

        this.bagSelector = new BagSelector(sceneManager);
        sceneManager.getPlayerSaveManager().addObserver(bagSelector);
        createSelectionPane(sceneManager);

        // Every time a different tab is selected, the selectionPane gets updated
        this.bagSelector.getTabPane().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                refreshSelectionPane(sceneManager);
            }
        });

        root.setBottom(selectionPane);
        root.setCenter(bagSelector.getTabPane());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return scene;}

    private void createSelectionPane(SceneManager sceneManager) {
        this.selectionPane = new HBox();
        selectionPane.setAlignment(Pos.CENTER);
        selectionPane.setSpacing(100);

        refreshSelectionPane(sceneManager);
    }

    private void refreshSelectionPane(SceneManager sceneManager) {

        Tab currentTab = bagSelector.getSelectedTab();

        List<Button> buttonsToAdd = new ArrayList<>();

        if (currentTab.getText().equals("Consumables")) {
            Button useConsumableButton = createUseConsumableButton(sceneManager);
            buttonsToAdd.add(useConsumableButton);
        }
        else if (currentTab.getText().equals("Equipment")) {
            Button equipButton = createEquipButton(sceneManager);
            Button unequipButton = createUnequipButton(sceneManager);
            buttonsToAdd.add(equipButton);
            buttonsToAdd.add(unequipButton);
        }

        Button exitButton = createExitButton(sceneManager);
        buttonsToAdd.add(exitButton);

        selectionPane.getChildren().clear();
        selectionPane.getChildren().addAll(buttonsToAdd);
    }

    private Button createUseConsumableButton(SceneManager sceneManager) {
        Button useButton = new Button("Use");
        useButton.setPrefSize(200, 50);
        useButton.setOnAction(e -> {
            Item selectedItem = bagSelector.getSelectedItem();
            if (selectedItem != null) {
                Player player = sceneManager.getPlayerSaveManager().getPlayer();
                ((Consumable) selectedItem).useOn(player);
                player.getInventory().removeItem(selectedItem, 1);
                sceneManager.getPlayerSaveManager().notifyObservers();
                // if the player runs out of an item while using it, then the item gets deselected
                if (!player.getInventory().getItems().containsKey(selectedItem)) {
                    bagSelector.deselectItem();
                }
            }
        });
        return useButton;
    }

    private Button createExitButton(SceneManager sceneManager) {
        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(200, 50);
        exitButton.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.GAME);
        });
        return exitButton;
    }

    private Button createEquipButton(SceneManager sceneManager) {
        Button equipButton = new Button("Equip");
        equipButton.setPrefSize(200, 50);
        return equipButton;
    }

    private Button createUnequipButton(SceneManager sceneManager) {
        Button unequipButton = new Button("Unequip");
        unequipButton.setPrefSize(200, 50);
        return unequipButton;
    }
}
