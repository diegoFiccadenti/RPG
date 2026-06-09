package panes;

import entities.Player;
import items.Consumable;
import items.Equippable;
import items.Item;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import scenes.SceneManager;

import java.util.Map;

public class BagSelector implements PlayerObserver {

    private final TabPane tabPane;

    private final Tab consumableTab;
    private final Tab equippableTab;

    private final VBox consumableList;
    private final VBox equippableList;

    private final Player player;

    private Item selectedItem;

    public BagSelector(SceneManager sceneManager) {

        this.tabPane = new TabPane();

        this.consumableTab = new Tab();
        this.equippableTab = new Tab();
        consumableTab.setClosable(false);
        equippableTab.setClosable(false);
        consumableTab.setText("Consumables");
        equippableTab.setText("Equipment");

        ScrollPane consumableScrollPane = new ScrollPane();
        ScrollPane equippableScrollPane = new ScrollPane();

        this.consumableList = new VBox();
        this.equippableList = new VBox();
        consumableList.setSpacing(5);
        equippableList.setSpacing(5);

        consumableScrollPane.setContent(consumableList);
        equippableScrollPane.setContent(equippableList);
        consumableTab.setContent(consumableScrollPane);
        equippableTab.setContent(equippableScrollPane);

        this.player = sceneManager.getPlayerSaveManager().getPlayer();
        this.selectedItem = null;

        refreshItemList();
    }

    public TabPane getTabPane() {return this.tabPane;}

    public Item getSelectedItem() {return this.selectedItem;}

    public void deselectItem() {this.selectedItem = null;}

    public Tab getSelectedTab() {return this.tabPane.getSelectionModel().getSelectedItem();}

    private void refreshItemList() {

        consumableList.getChildren().clear();
        equippableList.getChildren().clear();
        Map<Item, Integer> items = player.getInventory().getItems();
        for (Item item : items.keySet()) {
            Button newItemButton = new Button();
            newItemButton.setPrefSize(SceneManager.getScreenWidth() * 0.95, SceneManager.getScreenHeight() * 0.1);
            newItemButton.setText(item.getName() + ": " + items.get(item));
            if (item instanceof Consumable) {
                newItemButton.setOnAction(e -> {
                    selectedItem = item;
                });
                consumableList.getChildren().add(newItemButton);
            }
            else if (item instanceof Equippable) {
                equippableList.getChildren().add(newItemButton);
            }
        }

        tabPane.getTabs().addAll(consumableTab, equippableTab);
    }

    public void onPlayerUpdate() {
        refreshItemList();
    }
}
