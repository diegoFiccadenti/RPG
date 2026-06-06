package persistence;

import entities.Player;
import panes.PlayerObserver;

import java.nio.file.Path;
import java.util.ArrayList;

public class PlayerSaveManager {

    private final Player player;
    private final ArrayList<PlayerObserver> observers;

    public PlayerSaveManager() {
        this.player = readPlayerSaves();
        this.observers = new ArrayList<>();
    }

    public Player getPlayer() {return this.player;}

    public void savePlayer() {
        Path path = Path.of("saves/player.json");
        MyWriter.savePlayer(player, path);
    }

    public Player readPlayerSaves() {
        Path playerPath = Path.of("saves/player.json");
        return MyReader.readPlayer(playerPath);
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
