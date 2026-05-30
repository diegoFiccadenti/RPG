package scenes;

import data_structures.Inventory;
import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import quantifiables.HealthPoints;
import quantifiables.ManaPoints;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Game implements MyScene {

    public static void create(Stage stage) {

        // TODO: implementare creazione personaggio e sistema di permanenza dati
        // creazione player temporanea:
        Player player = new Player(
                "NomeDiProva",
                new Inventory(),
                new HealthPoints(86,100),
                new ManaPoints(28,100)
        );

        // information grid's content
        Label HP = new Label("HP");
        Label MP = new Label("MP");
        Label HPValue = new Label(player.getHP().getCurrentValue() + " / " + player.getHP().getMaxValue());
        Label MPValue = new Label(player.getMP().getCurrentValue() + " / " + player.getMP().getMaxValue());
        ProgressBar HPBar = new ProgressBar();
        HPBar.setProgress((double) player.getHP().getCurrentValue()/player.getHP().getMaxValue());
        ProgressBar MPBar = new ProgressBar();
        MPBar.setProgress((double) player.getMP().getCurrentValue()/player.getMP().getMaxValue());
        Label playerName = new Label("Name: " + player.getName());
        Label playerLevel = new Label("Level: " + player.getLevel());
        Label playerCoins = new Label("Coins: " + player.getCoins().getCurrentValue());

        HBox HP_HBox = new HBox();
        HBox MP_HBox = new HBox();
        HP_HBox.setSpacing(10);
        HP_HBox.setAlignment(Pos.CENTER_LEFT);
        HP_HBox.getChildren().addAll(HP, HPBar, HPValue);
        MP_HBox.setSpacing(10);
        MP_HBox.getChildren().addAll(MP, MPBar, MPValue);
        MP_HBox.setAlignment(Pos.CENTER_LEFT);

        GridPane infoGrid = new GridPane();
        infoGrid.setAlignment(Pos.TOP_CENTER);
        infoGrid.setHgap(100);
        infoGrid.setVgap(10);
        infoGrid.add(playerName, 0,0);
        infoGrid.add(playerLevel, 0,1);
        infoGrid.add(playerCoins, 0,2);
        infoGrid.add(HP_HBox, 1,0);
        infoGrid.add(MP_HBox, 1,1);

        // main pane
        Pane pane = new Pane();

        // scene creation
        BorderPane root = new BorderPane();
        root.setCenter(pane);
        root.setBottom(infoGrid);

        Scene gameScene = new Scene(root, 640, 480);
        stage.setScene(gameScene);
    }
}
