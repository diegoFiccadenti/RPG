package panes;

import entities.Player;
import items.Item;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import scenes.SceneManager;

import java.util.Map;

public class BagList implements PlayerObserver {

    private final ScrollPane scrollPane;

    private final Player player;

    private final VBox itemList;

    public BagList(SceneManager sceneManager) {
        this.scrollPane = new ScrollPane();
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        this.player = sceneManager.getPlayerSaveManager().getPlayer();

        this.itemList = new VBox();
        itemList.setSpacing(5);
        refreshItemList(player);

        scrollPane.setContent(itemList);
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }

    private void refreshItemList(Player player) {

        itemList.getChildren().clear();
        Map<Item, Integer> items = player.getInventory().getItems();
        for (Item item : items.keySet()) {
            Button newItemButton = new Button();
            newItemButton.setPrefSize(SceneManager.getScreenWidth() * 0.95, SceneManager.getScreenHeight() * 0.1);
            newItemButton.setText(item.getName() + ": " + items.get(item));
            itemList.getChildren().add(newItemButton);
        }
    }

    public void onPlayerUpdate() {
        refreshItemList(this.player);
    }
}
