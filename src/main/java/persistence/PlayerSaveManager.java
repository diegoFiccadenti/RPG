package persistence;

import data_structures.Inventory;
import entities.Player;
import panes.PlayerObserver;

import java.nio.file.Path;
import java.util.ArrayList;

public class PlayerSaveManager {

    private Player player;
    private final ArrayList<PlayerObserver> observers;

    public PlayerSaveManager() {
        this.observers = new ArrayList<>();
        readPlayerSaves();
    }

    public Player getPlayer() {return this.player;}

    public void savePlayer() {
        Path path = Path.of("saves/player.json");
        MyWriter.savePlayer(player, path);
    }

    public void readPlayerSaves() {
        Path playerPath = Path.of("saves/player.json");
        Player loadedPlayer = MyReader.readPlayer(playerPath);

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
