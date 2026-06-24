package panes;

import entities.Fighter;
import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import scenes.SceneManager;

import java.nio.file.Path;

public class CombatPane implements PlayerObserver {

    private final HBox root;

    private final Player player;
    private final Fighter opponent;

    private final ProgressBar playerHPProgressBar;
    private final ProgressBar playerMPProgressBar;
    private final ProgressBar opponentHPProgressBar;
    private final ProgressBar opponentMPProgressBar;

    public CombatPane(SceneManager sceneManager, Fighter opponent) {

        this.player = sceneManager.getPlayerSaveManager().getPlayer();
        this.opponent = opponent;

        HBox playerHPHBox = new HBox();
        HBox playerMPHBox = new HBox();
        HBox opponentHPHBox = new HBox();
        HBox opponentMPHBox = new HBox();

        playerHPProgressBar = new ProgressBar();
        playerMPProgressBar = new ProgressBar();
        opponentHPProgressBar = new ProgressBar();
        opponentMPProgressBar = new ProgressBar();

        root = new HBox();
        root.setAlignment(Pos.BOTTOM_CENTER);
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

        Label HPLabel = new Label("HP");
        Label MPLabel = new Label("MP");
        playerHPHBox.getChildren().addAll(HPLabel, playerHPProgressBar);
        playerMPHBox.getChildren().addAll(MPLabel, playerMPProgressBar);
        opponentHPHBox.getChildren().addAll(HPLabel, opponentHPProgressBar);
        opponentMPHBox.getChildren().addAll(MPLabel, opponentMPProgressBar);

        refreshCharactersBars();

        playerVBox.getChildren().addAll(playerSprite, playerHPHBox, playerMPHBox);
        opponentVBox.getChildren().addAll(opponentSprite, opponentHPHBox, opponentMPHBox);

        root.getChildren().addAll(playerVBox, opponentVBox);
    }

    public Pane getMainPane() {return root;}

    @Override
    public void onPlayerUpdate() {
        refreshCharactersBars();
    }

    private void refreshCharactersBars() {

        int currentPlayerHP = player.getCombatStats().getHP().getCurrentValue();
        int currentPlayerMP = player.getCombatStats().getMP().getCurrentValue();
        int currentOpponentHP = opponent.getCombatStats().getHP().getCurrentValue();
        int currentOpponentMP = opponent.getCombatStats().getMP().getCurrentValue();
        int maxPlayerHP = player.getCombatStats().getHP().getMaxValue();
        int maxPlayerMP = player.getCombatStats().getMP().getMaxValue();
        int maxOpponentHP = opponent.getCombatStats().getHP().getMaxValue();
        int maxOpponentMP = opponent.getCombatStats().getMP().getMaxValue();

        this.playerHPProgressBar.setProgress((double) currentPlayerHP / maxPlayerHP);
        this.playerMPProgressBar.setProgress((double) currentPlayerMP / maxPlayerMP);
        this.opponentHPProgressBar.setProgress((double) currentOpponentHP / maxOpponentHP);
        this.opponentMPProgressBar.setProgress((double) currentOpponentMP / maxOpponentMP);
    }
}
