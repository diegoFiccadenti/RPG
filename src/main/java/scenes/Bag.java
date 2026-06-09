package scenes;

import entities.Player;
import items.Consumable;
import items.Item;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import panes.BagSelector;
import panes.BagSelectorObserver;

public class Bag implements SceneFactory, BagSelectorObserver {

    private final Scene scene;

    private HBox selectionPane;

    private BagSelector bagSelector;

    public Bag(SceneManager sceneManager) {

        BorderPane root = new BorderPane();

        this.bagSelector = new BagSelector(sceneManager);
        sceneManager.getPlayerSaveManager().addObserver(bagSelector);
        createSelectionPane(sceneManager);

        root.setBottom(selectionPane);
        root.setCenter(bagSelector.getTabPane());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return scene;}

    public HBox getSelectionPane() {return selectionPane;}

    private void createSelectionPane(SceneManager sceneManager) {
        this.selectionPane = new HBox();
        selectionPane.setAlignment(Pos.CENTER);
        selectionPane.setSpacing(100);

        refreshSelectionPane(sceneManager);
    }

    private void refreshSelectionPane(SceneManager sceneManager) {

        Button useButton = new Button("Use");
        useButton.setPrefSize(200, 50);
        useButton.setOnAction(e -> {
            Item selectedItem = bagSelector.getSelectedItem();
            Player player = sceneManager.getPlayerSaveManager().getPlayer();
            if (selectedItem instanceof Consumable) {
                ((Consumable) selectedItem).useOn(player);
                player.getInventory().removeItem(selectedItem, 1);
                sceneManager.getPlayerSaveManager().notifyObservers();
            }
        });

        Button exitButton = new Button("Exit");
        exitButton.setPrefSize(200, 50);
        exitButton.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.GAME);
        });

        selectionPane.getChildren().addAll(useButton, exitButton);
    }

    public void onBagSelectorUpdate() {

    }
}
