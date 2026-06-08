package scenes;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import panes.BagItemSelection;
import panes.BagList;

public class Bag implements MyScene {

    private final Scene scene;

    public Bag(SceneManager sceneManager) {

        BorderPane root = new BorderPane();

        ScrollBar scrollbar = new ScrollBar();
        scrollbar.setOrientation(Orientation.VERTICAL);
        BagList bagList = new BagList();
        BagItemSelection bagItemSelection = new BagItemSelection(sceneManager);

        root.setBottom(bagItemSelection.getHBox());
        root.setCenter(bagList.getScrollPane());
        root.setRight(scrollbar);

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    public Scene getScene() {return scene;}
}
