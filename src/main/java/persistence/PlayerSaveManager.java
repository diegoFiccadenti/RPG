package persistence;

import entities.Player;
import panes.PlayerObserver;

import java.nio.file.Path;
import java.util.ArrayList;

public class PlayerSaveManager {

    private Player player;
    private final ArrayList<PlayerObserver> observers;

    public PlayerSaveManager() {
        readPlayerSaves();
        this.observers = new ArrayList<>();
    }

    public Player getPlayer() {return this.player;}

    public void savePlayer() {
        Path path = Path.of("saves/player.json");
        MyWriter.savePlayer(player, path);
    }

    public void readPlayerSaves() {
        Path playerPath = Path.of("saves/player.json");
        this.player = MyReader.readPlayer(playerPath);
        notifyObservers();
    }

    public void addObserver(PlayerObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(PlayerObserver observer) {
        this.observers.remove(observer);
    }

    public void notifyObservers() {
        for (PlayerObserver observer : this.observers) {
            observer.onPlayerUpdate();
        }
    }
}
