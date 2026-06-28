package it.unicam.cs.mpgc.rpg132379.panes;

import it.unicam.cs.mpgc.rpg132379.entities.Player;
import it.unicam.cs.mpgc.rpg132379.items.Consumable;
import it.unicam.cs.mpgc.rpg132379.items.Equippable;
import it.unicam.cs.mpgc.rpg132379.items.Item;
import it.unicam.cs.mpgc.rpg132379.items.Learnable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import it.unicam.cs.mpgc.rpg132379.scenes.SceneManager;

import java.util.Map;

public class BagSelector implements PlayerObserver {

    private final TabPane tabPane;

    private final VBox consumableList;
    private final VBox equippableList;
    private final VBox learnableList;

    private final Player player;

    private Item selectedItem;

    public BagSelector(SceneManager sceneManager) {

        this.tabPane = new TabPane();

        Tab consumableTab = new Tab();
        Tab equippableTab = new Tab();
        Tab learnableTab = new Tab();
        consumableTab.setClosable(false);
        equippableTab.setClosable(false);
        learnableTab.setClosable(false);
        consumableTab.setText("Consumables");
        equippableTab.setText("Equipment");
        learnableTab.setText("Learnable");

        ScrollPane consumableScrollPane = new ScrollPane();
        ScrollPane equippableScrollPane = new ScrollPane();
        ScrollPane learnableScrollPane = new ScrollPane();

        this.consumableList = new VBox();
        this.equippableList = new VBox();
        this.learnableList = new VBox();
        consumableList.setSpacing(5);
        equippableList.setSpacing(5);
        learnableList.setSpacing(5);

        consumableScrollPane.setContent(consumableList);
        equippableScrollPane.setContent(equippableList);
        learnableScrollPane.setContent(learnableList);
        consumableTab.setContent(consumableScrollPane);
        equippableTab.setContent(equippableScrollPane);
        learnableTab.setContent(learnableScrollPane);

        this.player = sceneManager.getPlayerSaveManager().getPlayer();
        this.selectedItem = null;

        this.tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                deselectItem();
            }
        });

        tabPane.getTabs().addAll(consumableTab, equippableTab, learnableTab);
        refreshItemList();
    }

    public TabPane getTabPane() {return this.tabPane;}

    public Item getSelectedItem() {return this.selectedItem;}

    public void deselectItem() {this.selectedItem = null;}

    public Tab getSelectedTab() {return this.tabPane.getSelectionModel().getSelectedItem();}

    public void refreshItemList() {

        consumableList.getChildren().clear();
        equippableList.getChildren().clear();
        learnableList.getChildren().clear();
        Map<Item, Integer> items = player.getInventory().getItems();
        for (Item item : items.keySet()) {
            Button newItemButton = new Button();
            newItemButton.setPrefSize(SceneManager.getScreenWidth() * 0.95, SceneManager.getScreenHeight() * 0.1);
            newItemButton.setText(item.getName() + ": " + items.get(item));
            if (item instanceof Consumable) {
                newItemButton.setOnAction(e -> selectedItem = item);
                consumableList.getChildren().add(newItemButton);
            }
            else if (item instanceof Equippable equippableItem) {
                newItemButton.setOnAction(e -> selectedItem = item);
                if (equippableItem.isEquipped()) {
                    newItemButton.setStyle("-fx-background-color: CadetBlue;");
                    newItemButton.setText("[Equipped] " + item.getName() + ": " + items.get(equippableItem));
                }
                equippableList.getChildren().add(newItemButton);
            }
            else if (item instanceof Learnable) {
                newItemButton.setOnAction(e -> selectedItem = item);
                learnableList.getChildren().add(newItemButton);
            }
        }
    }

    public void onPlayerUpdate() {
        refreshItemList();
    }
}
