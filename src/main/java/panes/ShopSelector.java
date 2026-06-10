package panes;

import items.Consumable;
import items.Equippable;
import items.Item;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import scenes.SceneManager;

import java.util.HashMap;
import java.util.Map;

public class ShopSelector {

    private final TabPane tabPane;

    private final VBox consumableList;
    private final VBox equippableList;

    private Item selectedItem;

    public ShopSelector(SceneManager sceneManager) {

        this.tabPane = new TabPane();

        Tab consumableTab = new Tab();
        Tab equippableTab = new Tab();
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

        this.selectedItem = null;

        this.tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                deselectItem();
            }
        });

        tabPane.getTabs().addAll(consumableTab, equippableTab);
        refreshItemList();
    }

    public TabPane getTabPane() {return this.tabPane;}

    public Item getSelectedItem() {return this.selectedItem;}

    public void deselectItem() {this.selectedItem = null;}

    private void refreshItemList() {

        consumableList.getChildren().clear();
        equippableList.getChildren().clear();
        Map<Item, Integer> items = new HashMap();
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
    }
}
