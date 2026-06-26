package scenes;

import entities.Player;
import items.Consumable;
import items.Equippable;
import items.Item;
import items.Learnable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import panes.BagSelector;
import utils.ButtonPersonalizer;

import java.util.ArrayList;
import java.util.List;

public class Bag implements SceneFactory {

    private final Scene scene;

    private HBox selectionPane;

    private final BagSelector bagSelector;

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
        selectionPane.setSpacing(50);

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
        else if (currentTab.getText().equals("Learnable")) {
            Button learnButton = createLearnButton(sceneManager);
            buttonsToAdd.add(learnButton);
        }

        Button exitButton = createExitButton(sceneManager);
        buttonsToAdd.add(exitButton);

        selectionPane.getChildren().clear();
        selectionPane.getChildren().addAll(buttonsToAdd);
    }

    private Button createUseConsumableButton(SceneManager sceneManager) {
        Button useButton = ButtonPersonalizer.newButton("Use");
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
        Button exitButton = ButtonPersonalizer.newButton("Exit");
        exitButton.setOnAction(e -> sceneManager.switchScene(SceneManager.SceneType.GAME));
        return exitButton;
    }

    private Button createEquipButton(SceneManager sceneManager) {
        Player player = sceneManager.getPlayerSaveManager().getPlayer();
        Button equipButton = ButtonPersonalizer.newButton("Equip");
        equipButton.setOnAction(e -> {
            if (bagSelector.getSelectedItem() instanceof Equippable) {
                player.getEquipment().equip((Equippable) bagSelector.getSelectedItem());
                bagSelector.refreshItemList();
            }
            else throw new IllegalArgumentException();
        });
        return equipButton;
    }

    private Button createUnequipButton(SceneManager sceneManager) {
        Player player = sceneManager.getPlayerSaveManager().getPlayer();
        Button unequipButton = ButtonPersonalizer.newButton("Unequip");
        unequipButton.setOnAction(e -> {
            if (bagSelector.getSelectedItem() instanceof Equippable) {
                player.getEquipment().unequip((Equippable) bagSelector.getSelectedItem());
                bagSelector.refreshItemList();
            }
            else throw new IllegalArgumentException();
        });
        return unequipButton;
    }

    private Button createLearnButton(SceneManager sceneManager) {
        Player player = sceneManager.getPlayerSaveManager().getPlayer();
        Button learnButton = ButtonPersonalizer.newButton("Learn");
        learnButton.setOnAction(e -> {
            if (bagSelector.getSelectedItem() instanceof Learnable) {
                ((Learnable) bagSelector.getSelectedItem()).learn(player);
                player.getInventory().removeItem(bagSelector.getSelectedItem(), 1);
                bagSelector.refreshItemList();
            }
        });
        return learnButton;
    }
}
