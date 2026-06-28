package it.unicam.cs.mpgc.rpg132379.panes;

import it.unicam.cs.mpgc.rpg132379.items.Consumable;
import it.unicam.cs.mpgc.rpg132379.items.Equippable;
import it.unicam.cs.mpgc.rpg132379.items.Item;
import it.unicam.cs.mpgc.rpg132379.items.Learnable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import it.unicam.cs.mpgc.rpg132379.persistence.MyReader;
import it.unicam.cs.mpgc.rpg132379.scenes.SceneManager;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ShopSelector {

    private final TabPane tabPane;

    private final VBox consumableList;
    private final VBox equippableList;
    private final VBox learnableList;

    private Item selectedItem;

    private final List<Item> sellingItems;

    public ShopSelector() {

        this.sellingItems = fillShopWithItems();

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
        consumableScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        equippableScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        learnableScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        consumableTab.setContent(consumableScrollPane);
        equippableTab.setContent(equippableScrollPane);
        learnableTab.setContent(learnableScrollPane);

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

    private void refreshItemList() {

        consumableList.getChildren().clear();
        equippableList.getChildren().clear();
        learnableList.getChildren().clear();
        for (Item item : sellingItems) {
            Button newItemButton = new Button();
            newItemButton.setPrefSize(SceneManager.getScreenWidth() * 0.95, SceneManager.getScreenHeight() * 0.1);
            newItemButton.setText(item.getName() + ": " + item.getCost() + " coins");
            newItemButton.setOnAction(e -> selectedItem = item);
            if (item instanceof Consumable) {
                consumableList.getChildren().add(newItemButton);
            }
            else if (item instanceof Equippable) {
                equippableList.getChildren().add(newItemButton);
            }
            else if (item instanceof Learnable) {
                learnableList.getChildren().add(newItemButton);
            }
        }
    }

    private List<Item> fillShopWithItems() {

        Path shopItemsResourcePath = Paths.get("src/main/resources/shopItems.json");
        return MyReader.readItemList(shopItemsResourcePath);
    }
}
