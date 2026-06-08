package panes;

import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import scenes.SceneManager;

public class PlayerInfoGrid implements PlayerObserver {

    private final GridPane grid;

    private final Player player;

    private final Label playerName;
    private final Label playerLevel;
    private final Label playerCoins;

    private final Label HPValue;
    private final ProgressBar HPBar;
    private final HBox HP_HBox;

    private final Label MPValue;
    private final ProgressBar MPBar;
    private final HBox MP_HBox;

    public PlayerInfoGrid(SceneManager sceneManager) {

        this.player = sceneManager.getPlayerSaveManager().getPlayer();

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(10);
        grid.setPrefSize(SceneManager.getScreenWidth(), 100);

        this.playerName = new Label();
        this.playerLevel = new Label();
        this.playerCoins = new Label();

        this.HPValue = new Label();
        this.HPBar = new ProgressBar();
        this.HP_HBox = new HBox();
        HP_HBox.setSpacing(10);
        HP_HBox.setAlignment(Pos.CENTER_LEFT);

        this.MPValue = new Label();
        this.MPBar = new ProgressBar();
        this.MP_HBox = new HBox();
        MP_HBox.setSpacing(10);
        MP_HBox.setAlignment(Pos.CENTER_LEFT);

        refreshData();
        this.HP_HBox.getChildren().addAll(new Label("HP"), HPBar, HPValue);
        this.MP_HBox.getChildren().addAll(new Label("MP"), MPBar, MPValue);
        addValuesToGrid();
    }

    public GridPane getGrid() {return grid;}

    public void refreshData() {

        this.playerName.setText("Name: " + player.getName());
        this.playerLevel.setText("Level: " + player.getLevel());
        this.playerCoins.setText("Coins: " + player.getCoins().getCurrentValue());

        int currentHP = player.getCombatStats().getHP().getCurrentValue();
        int maxHP = player.getCombatStats().getHP().getMaxValue();
        this.HPValue.setText(currentHP + " / " + maxHP);
        this.HPBar.setProgress((double) currentHP / maxHP);

        int currentMP = player.getCombatStats().getMP().getCurrentValue();
        int maxMP = player.getCombatStats().getMP().getMaxValue();
        this.MPValue.setText(currentMP + " / " + maxMP);
        this.MPBar.setProgress((double) currentMP / maxMP);
    }

    private void addValuesToGrid() {
        grid.getChildren().clear();
        grid.add(playerName, 0,0);
        grid.add(playerLevel, 0,1);
        grid.add(playerCoins, 0,2);
        grid.add(HP_HBox, 1,0);
        grid.add(MP_HBox, 1,1);
    }

    public void onPlayerUpdate() {
        refreshData();
    }
}
