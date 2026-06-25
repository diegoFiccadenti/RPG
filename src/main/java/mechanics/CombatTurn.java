package mechanics;

import entities.Fighter;
import entities.Lootable;
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

    public void executeTurn(SceneManager sceneManager) {
        player.attack(opponent, attackUsedByPlayer);
        if (checkIfBattleIsWon()) {
            exitBattle(sceneManager, true);
        }
        Attack attackUsedByOpponent = opponent.getAttacks().getRandomAttack();
        opponent.attack(player, attackUsedByOpponent);
        if (checkIfBattleIsLost()) {
            exitBattle(sceneManager, false);
        }
    }

    private boolean checkIfBattleIsWon() {
        return opponent.getCombatStats().getHP().getCurrentValue() <= 0;
    }

    private boolean checkIfBattleIsLost() {
        return player.getCombatStats().getHP().getCurrentValue() <= 0;
    }

    private void exitBattle(SceneManager sceneManager, boolean battleWon) {
        if (battleWon && opponent instanceof Lootable) {
            ((Lootable) opponent).dropLoot(player);
        }
        else if (!battleWon) {
            player.getCombatStats().getHP().increaseCurrent(10);
        }
        sceneManager.switchScene(SceneManager.SceneType.MAIN_MENU);
    }
}
