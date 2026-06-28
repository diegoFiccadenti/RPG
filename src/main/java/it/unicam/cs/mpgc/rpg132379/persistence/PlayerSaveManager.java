package it.unicam.cs.mpgc.rpg132379.persistence;

import it.unicam.cs.mpgc.rpg132379.components.Inventory;
import it.unicam.cs.mpgc.rpg132379.entities.Player;
import it.unicam.cs.mpgc.rpg132379.panes.PlayerObserver;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PlayerSaveManager {

    private Player player;
    private final List<PlayerObserver> observers;

    public PlayerSaveManager() {
        this.observers = new ArrayList<>();
        readPlayerSaves();
    }

    public Player getPlayer() {return this.player;}

    public List<PlayerObserver> getObservers() {return this.observers;}

    public void savePlayer() {
        File directory = new File("saves");
        if (!directory.exists()) directory.mkdir();

        Path path = Path.of("saves/player.json");
        MyWriter.savePlayer(player, path);
    }

    public void readPlayerSaves() {
        File file = new File("saves/player.json");
        Player loadedPlayer = null;

        if (file.exists()) {
            Path playerPath = file.toPath();
            loadedPlayer = MyReader.readPlayer(playerPath);
        }

        if (loadedPlayer != null) {
            this.player = loadedPlayer;
        }
        else {
            this.player = new Player("NomeDiProva", new Inventory(16));
        }
        notifyObservers();
    }

    public void addObserver(PlayerObserver observer) {
        this.observers.add(observer);
    }

    public void clearObservers() {
        this.observers.clear();
    }

    public void notifyObservers() {
        for (PlayerObserver observer : this.observers) {
            observer.onPlayerUpdate();
        }
    }
}
