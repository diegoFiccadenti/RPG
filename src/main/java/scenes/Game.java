package scenes;

import entities.Player;
import data_structures.Inventory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import quantifiables.HealthPoints;
import quantifiables.ManaPoints;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Game implements MyScene {

    // TODO: implementare creazione personaggio e sistema di permanenza dati
    // creazione player temporanea:
    private static Player player = new Player(
            "NomeDiProva",
            new Inventory(),
            new HealthPoints(86,100),
            new ManaPoints(28,100)
    );

    public static void create(Stage stage) {

        Pane mainPane = createMainPane(stage);

        GridPane infoGrid = createInformationGrid();

        // scene creation
        BorderPane root = new BorderPane();
        root.setCenter(mainPane);
        root.setBottom(infoGrid);

        Scene gameScene = new Scene(root, 640, 480);
        stage.setScene(gameScene);
    }

    private static Pane createMainPane(Stage stage) {

        Pane pane = new Pane();
        pane.setBackground(new Background((new BackgroundFill(Color.DARKGRAY, null, null))));

        Button exit = new Button("Exit");
        exit.setOnAction(e -> {
            MainMenu.create(stage);
            stage.show();
        });

        pane.getChildren().add(exit);

        return pane;
    }

    private static GridPane createInformationGrid() {

        Label playerName = new Label("Name: " + player.getName());
        Label playerLevel = new Label("Level: " + player.getLevel());
        Label playerCoins = new Label("Coins: " + player.getCoins().getCurrentValue());

        Label HP = new Label("HP");
        Label HPValue = new Label(player.getHP().getCurrentValue() + " / " + player.getHP().getMaxValue());
        ProgressBar HPBar = new ProgressBar();
        HPBar.setProgress((double) player.getHP().getCurrentValue()/player.getHP().getMaxValue());
        HBox HP_HBox = createProgressBarWithExplicitValues(HP, HPBar, HPValue);

        Label MP = new Label("MP");
        Label MPValue = new Label(player.getMP().getCurrentValue() + " / " + player.getMP().getMaxValue());
        ProgressBar MPBar = new ProgressBar();
        MPBar.setProgress((double) player.getMP().getCurrentValue()/player.getMP().getMaxValue());
        HBox MP_HBox = createProgressBarWithExplicitValues(MP, MPBar, MPValue);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(100);
        grid.setVgap(10);

        grid.add(playerName, 0,0);
        grid.add(playerLevel, 0,1);
        grid.add(playerCoins, 0,2);
        grid.add(HP_HBox, 1,0);
        grid.add(MP_HBox, 1,1);

        return grid;
    }

    private static HBox createProgressBarWithExplicitValues(Label barName, ProgressBar bar, Label explicitValue) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER_LEFT);
        hBox.getChildren().addAll(barName, bar, explicitValue);

        return hBox;
    }
}
