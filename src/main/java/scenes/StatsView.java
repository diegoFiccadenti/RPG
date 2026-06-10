package scenes;

import data_structures.StatsHandler.Stat;
import entities.Player;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import panes.PlayerObserver;
import utils.ButtonPersonalizer;

import java.util.Map;

public class StatsView implements SceneFactory, PlayerObserver {

    private final Scene scene;

    private final Player player;

    Label playerName;
    Label playerLevel;
    Label abilityPoints;
    Label strength;
    Label vitality;
    Label intelligence;
    Label charisma;

    public StatsView(SceneManager sceneManager) {

        this.player = sceneManager.getPlayerSaveManager().getPlayer();

        BorderPane root = new BorderPane();

        VBox infoList = new VBox();
        infoList.setSpacing(10);
        infoList.setAlignment(Pos.CENTER);
        updateLabels();
        formatLabels();
        infoList.getChildren().addAll(playerName, playerLevel,  abilityPoints, strength, vitality, intelligence, charisma);

        HBox bottomPane = new HBox();
        bottomPane.setAlignment(Pos.CENTER);
        Button exit = ButtonPersonalizer.newButton("Exit");
        exit.setOnAction(e -> {
            sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);
        });
        bottomPane.getChildren().add(exit);

        root.setCenter(infoList);
        root.setBottom(bottomPane);

        this.scene = new Scene(root, SceneManager.getScreenWidth(), SceneManager.getScreenHeight());
    }

    @Override
    public Scene getScene() {return this.scene;}


    @Override
    public void onPlayerUpdate() {
        updateLabels();
    }

    private void updateLabels() {
        Map<Stat, Integer> skillStats = player.getCombatStats().getSkillStats();
        this.playerName = new Label("Player Name: " +  player.getName());
        this.playerLevel = new Label("Player Level: " +  player.getLevel());
        this.abilityPoints = new Label("ABILITY POINTS: " + skillStats.get(Stat.ABILITY_POINTS));
        this.strength = new Label("ABILITY POINTS: " + skillStats.get(Stat.STRENGTH));
        this.vitality = new Label("VITALITY: " + skillStats.get(Stat.VITALITY));
        this.intelligence = new Label("INTELLIGENCE: " + skillStats.get(Stat.INTELLIGENCE));
        this.charisma = new Label("CHARISMA: " + skillStats.get(Stat.CHARISMA));
    }

    private void formatLabels() {
        this.playerName.setFont(Font.font("Copperplate Gothic Light", 24));
        this.playerLevel.setFont(Font.font("Copperplate Gothic Light", 24));
        this.abilityPoints.setFont(Font.font("Copperplate Gothic Light", 24));
        this.strength.setFont(Font.font("Copperplate Gothic Light", 24));
        this.vitality.setFont(Font.font("Copperplate Gothic Light", 24));
        this.intelligence.setFont(Font.font("Copperplate Gothic Light", 24));
        this.charisma.setFont(Font.font("Copperplate Gothic Light", 24));
    }
}
