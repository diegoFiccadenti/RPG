package mechanics;

import entities.Fighter;
import entities.Player;
import scenes.SceneManager;

public class CombatTurn {

    private final Player player;
    private final Fighter opponent;
    private final Attack attackUsedByPlayer;

    public CombatTurn(SceneManager sceneManager, Fighter opponent, Attack attackUsedByPlayer) {

        this.player = sceneManager.getPlayerSaveManager().getPlayer();
        this.opponent = opponent;
        this.attackUsedByPlayer = attackUsedByPlayer;

    }

    public void executeTurn() {
        Attack attackUsedByOpponent = opponent.getAttacks().getRandomAttack();
        opponent.attack(player, attackUsedByOpponent);
        player.attack(opponent, attackUsedByPlayer);
    }
}
