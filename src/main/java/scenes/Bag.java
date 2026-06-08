package scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import panes.BagItemSelection;
import panes.BagList;

public class Bag implements SceneFactory {

    private final Scene scene;

    public Bag(SceneManager sceneManager) {

        BorderPane root = new BorderPane();

        BagList bagList = new BagList(sceneManager);
        sceneManager.getPlayerSaveManager().addObserver(bagList);
        BagItemSelection bagItemSelection = new BagItemSelection(sceneManager);

        root.setBottom(bagItemSelection.getHBox());
        root.setCenter(bagList.getTabPane());

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return scene;}
}
