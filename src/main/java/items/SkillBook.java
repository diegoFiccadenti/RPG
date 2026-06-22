package items;

import entities.Fighter;
import mechanics.Attack;

public class SkillBook extends Item implements Learnable {

    private final Attack taughtAttack;

    public SkillBook(String name, String description, int cost, Attack taughtAttack) {
        super(name, description, cost);
        this.taughtAttack = taughtAttack;
    }

    public String learn(Fighter learner) {

        // if the learner does not know the attack he learns it
        if (!learner.getAttacks().getKnownAttacks().contains(taughtAttack)) {
            learner.getAttacks().getKnownAttacks().add(taughtAttack);
            return "Learned attack: " + taughtAttack.getName();
        }
        return "Attack already known";
    }
}
