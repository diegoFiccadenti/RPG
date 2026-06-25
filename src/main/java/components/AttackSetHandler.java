package components;

import mechanics.Attack;

import java.util.*;

public class AttackSetHandler {

    private final List<Attack> knownAttacks;

    private final Map<AttackSlot, Attack> attackSet;

    public enum AttackSlot {
        SLOT1,
        SLOT2,
        SLOT3,
        SLOT4
    }

    public AttackSetHandler() {
        this.knownAttacks = new ArrayList<>();
        this.attackSet = new HashMap<>();
        for (AttackSlot slot : AttackSlot.values()) {
            this.attackSet.put(slot, null);
        }
    }

    public List<Attack> getKnownAttacks() {return this.knownAttacks;}

    public Map<AttackSlot, Attack> getAttackSet() {return this.attackSet;}

    public void addAttack(Attack attack) {
        for (AttackSlot slot : AttackSlot.values()) {
            if (attackSet.get(slot) == null) {
                attackSet.put(slot, attack);
                return;
            }
        }
    }

    public void emptySlot(AttackSlot slot) {
        this.attackSet.put(slot, null);
    }

    public Attack getRandomAttack() {

        List<Attack> activeAttacks = attackSet.values().stream()
                .filter(Objects::nonNull)
                .toList();

        if (activeAttacks.isEmpty()) {
            throw new IllegalArgumentException("This fighter has no attacks to chose from attacks found");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(activeAttacks.size());

        return activeAttacks.get(randomIndex);

    }
}
