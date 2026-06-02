package panes;

import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class PlayerInfoGrid {

    private final GridPane grid;

    private final Label playerName;
    private final Label playerLevel;
    private final Label playerCoins;

    private int currentHP;
    private int maxHP;
    private final Label HPLabel;
    private final Label HPValue;
    private final ProgressBar HPBar;
    private final HBox HP_HBox;

    private int currentMP;
    private int maxMP;
    private final Label MPLabel;
    private final Label MPValue;
    private final ProgressBar MPBar;
    private final HBox MP_HBox;

    public PlayerInfoGrid(Player player) {

        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(10);

        this.playerName = new Label();
        this.playerLevel = new Label();
        this.playerCoins = new Label();

        this.HPLabel = new Label("HP");
        this.HPValue = new Label();
        this.HPBar = new ProgressBar();
        this.HP_HBox = new HBox();
        HP_HBox.setSpacing(10);
        HP_HBox.setAlignment(Pos.CENTER_LEFT);

        this.MPLabel = new Label("MP");
        this.MPValue = new Label();
        this.MPBar = new ProgressBar();
        this.MP_HBox = new HBox();
        MP_HBox.setSpacing(10);
        MP_HBox.setAlignment(Pos.CENTER_LEFT);

        refreshData(player);
    }

    public GridPane getGrid() {return grid;}

    public void refreshData(Player player) {

        this.playerName.setText("Name: " + player.getName());
        this.playerLevel.setText("Level: " + player.getLevel());
        this.playerCoins.setText("Coins: " + player.getCoins().getCurrentValue());

        this.currentHP = player.getCombatStats().getHP().getCurrentValue();
        this.maxHP = player.getCombatStats().getHP().getMaxValue();
        this.HPValue.setText(currentHP + " / " + maxHP);
        this.HPBar.setProgress((double) currentHP / maxHP);
        this.HP_HBox.getChildren().clear();
        this.HP_HBox.getChildren().addAll(HPLabel, HPBar, HPValue);

        this.currentMP = player.getCombatStats().getMP().getCurrentValue();
        this.maxMP = player.getCombatStats().getMP().getMaxValue();
        this.MPValue.setText(currentMP + " / " + maxMP);
        this.MPBar.setProgress((double) currentMP / maxMP);
        this.MP_HBox.getChildren().clear();
        this.MP_HBox.getChildren().addAll(MPLabel, MPBar, MPValue);

        addValuesToGrid();
    }

    private void addValuesToGrid() {
        grid.getChildren().clear();
        grid.add(playerName, 0,0);
        grid.add(playerLevel, 0,1);
        grid.add(playerCoins, 0,2);
        grid.add(HP_HBox, 1,0);
        grid.add(MP_HBox, 1,1);
    }
}
