package panes;

import entities.Fighter;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.nio.file.Path;

public class CombatPane implements PlayerObserver {

    private final HBox root;

    public CombatPane(Fighter opponent) {

        root = new HBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(50);

        VBox playerVBox = new VBox();
        VBox opponentVBox = new VBox();
        playerVBox.setAlignment(Pos.CENTER);
        opponentVBox.setAlignment(Pos.CENTER);
        playerVBox.setSpacing(10);
        opponentVBox.setSpacing(10);

        Path playerSpritePath = Path.of("src/main/resources/sprites/39.png");
        ImageView playerSprite = new ImageView(new Image(playerSpritePath.toUri().toString()));
        ImageView opponentSprite = new ImageView(new Image(playerSpritePath.toUri().toString()));

        playerVBox.getChildren().addAll(playerSprite);
        opponentVBox.getChildren().addAll(opponentSprite);

        root.getChildren().addAll(playerVBox, opponentVBox);
    }

    public Pane getMainPane() {return root;}

    @Override
    public void onPlayerUpdate() {

    }
}
