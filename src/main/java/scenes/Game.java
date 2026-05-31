package scenes;

import entities.Player;
import data_structures.Inventory;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;

public class Game implements MyScene {

    // TODO: implementare creazione personaggio e sistema di permanenza dati
    // creazione player temporanea:
    private Player player = new Player(
            "NomeDiProva",
            new Inventory()
    );

    private final Scene scene;

    public Game(SceneManager sceneManager) {

        Pane mainPane = createMainPane(sceneManager);

        GridPane infoGrid = createInformationGrid();

        BorderPane root = new BorderPane();
        root.setCenter(mainPane);
        root.setBottom(infoGrid);

        this.scene = new Scene(root, SceneManager.SCREEN_WIDTH, SceneManager.SCREEN_HEIGHT);
    }

    public Scene getScene() {return this.scene;}

    private Pane createMainPane(SceneManager sceneManager) {

        Pane pane = new Pane();
        pane.setBackground(new Background((new BackgroundFill(Color.DARKGRAY, null, null))));

        Button exit = new Button("Exit");
        exit.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);
        });

        pane.getChildren().add(exit);

        return pane;
    }

    private GridPane createInformationGrid() {

        Label playerName = new Label("Name: " + player.getName());
        Label playerLevel = new Label("Level: " + player.getLevel());
        Label playerCoins = new Label("Coins: " + player.getCoins().getCurrentValue());

        int currentHP = player.getCombatStats().getHP().getCurrentValue();
        int maxHP = player.getCombatStats().getHP().getMaxValue();
        int currentMP = player.getCombatStats().getMP().getCurrentValue();
        int maxMP = player.getCombatStats().getMP().getMaxValue();

        Label HP = new Label("HP");
        Label HPValue = new Label(currentHP + " / " + maxHP);
        ProgressBar HPBar = new ProgressBar();
        HPBar.setProgress((double) currentHP / maxHP);
        HBox HP_HBox = createProgressBarWithExplicitValues(HP, HPBar, HPValue);

        Label MP = new Label("MP");
        Label MPValue = new Label(currentMP + " / " + maxMP);
        ProgressBar MPBar = new ProgressBar();
        MPBar.setProgress((double) currentMP / maxMP);
        HBox MP_HBox = createProgressBarWithExplicitValues(MP, MPBar, MPValue);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(100);
        grid.setVgap(10);

        grid.add(playerName, 0,0);
        grid.add(playerLevel, 0,1);
        grid.add(playerCoins, 0,2);
        grid.add(HP_HBox, 1,0);
        grid.add(MP_HBox, 1,1);

        return grid;
    }

    private HBox createProgressBarWithExplicitValues(Label barName, ProgressBar bar, Label explicitValue) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().addAll(barName, bar, explicitValue);

        return hBox;
    }
}
