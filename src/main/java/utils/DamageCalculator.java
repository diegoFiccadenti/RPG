package utils;

import entities.Fighter;
import mechanics.Attack;
import mechanics.PhysicalAttack;
import mechanics.Spell;

public class DamageCalculator {

    public static int calculateDamage(Fighter attacker, Fighter target, Attack attackUsed) {
        int totalDamage = 0;
        totalDamage += attackUsed.getPower();
        if (attackUsed instanceof Spell) {
            int currentMana = attacker.getCombatStats().getMP().getCurrentValue();
            if (currentMana >= ((Spell) attackUsed).getRequiredMana()) {
                totalDamage += attacker.getCombatStats().getBasicMagicAttack();
                totalDamage += attacker.getEquipment().getMagicAttack();
                totalDamage -= target.getEquipment().getMagicDefence();
                attacker.getCombatStats().getMP().decreaseCurrent(((Spell) attackUsed).getRequiredMana());
            }
            else {
                totalDamage = 0;
            }
        }
        else if (attackUsed instanceof PhysicalAttack) {
            totalDamage += attacker.getCombatStats().getBasicMeleeAttack();
            totalDamage += attacker.getEquipment().getMeleeAttack();
            totalDamage -= target.getEquipment().getMeleeDefence();
        }
        return totalDamage;
    }
}
