package it.unicam.cs.mpgc.rpg132379.scenes;

import it.unicam.cs.mpgc.rpg132379.components.Inventory;
import it.unicam.cs.mpgc.rpg132379.entities.Player;
import it.unicam.cs.mpgc.rpg132379.items.Item;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import it.unicam.cs.mpgc.rpg132379.panes.ShopSelector;
import it.unicam.cs.mpgc.rpg132379.utils.ButtonPersonalizer;

public class Shop implements SceneFactory {

    private final Scene scene;

    private HBox selectionPane;

    private final ShopSelector shopSelector;

    public Shop(SceneManager sceneManager) {

        BorderPane root = new BorderPane();

        this.shopSelector = new ShopSelector();
        createSelectionPane(sceneManager);

        root.setBottom(selectionPane);
        root.setCenter(shopSelector.getTabPane());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    @Override
    public Scene getScene() {return scene;}

    private void createSelectionPane(SceneManager sceneManager) {
        this.selectionPane = new HBox();
        selectionPane.setAlignment(Pos.CENTER);
        selectionPane.setSpacing(50);

        Button buyButton = ButtonPersonalizer.newButton("Buy");
        addActionToBuyButton(buyButton, sceneManager);

        Button exitButton = ButtonPersonalizer.newButton("Exit");
        exitButton.setOnAction(e -> sceneManager.switchScene(SceneManager.SceneType.GAME));

        this.selectionPane.getChildren().addAll(buyButton, exitButton);
    }

    private void addActionToBuyButton(Button buyButton, SceneManager sceneManager) {
        buyButton.setOnAction(e -> {
            Item selectedItem = this.shopSelector.getSelectedItem();
            if (selectedItem != null) {
                Player player = sceneManager.getPlayerSaveManager().getPlayer();
                Inventory playersInventory = player.getInventory();
                // transaction is executed if player has enough coins and space in the inventory
                if (player.getCoins().getCurrentValue() >= selectedItem.getCost()
                        && playersInventory.getMaxCapacity() > playersInventory.getContainedItems()) {
                    player.getCoins().decreaseCurrent(selectedItem.getCost());
                    playersInventory.addItem(selectedItem, 1);
                }
            }
        });
    }
}