package persistence;

import entities.Player;

import java.nio.file.Path;

public class SaveManager {

    private final Player player;

    public SaveManager() {
        this.player = refreshPlayerDataFromSaves();
    }

    public Player getPlayer() {return this.player;}

    public Player refreshPlayerDataFromSaves() {
        Path playerPath = Path.of("saves/player.json");
        return MyReader.readPlayer(playerPath);
    }
}
