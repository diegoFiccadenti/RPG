package entities;

import components.AttackSetHandler;
import components.Inventory;
import components.StatsHandler;
import components.EquipmentHandler;
import mechanics.Attack;
import mechanics.PhysicalAttack;
import mechanics.Spell;

public class Enemy extends Character implements Fighter, Lootable {

    private final int DROPPED_XP; // Experience dropped when defeated
    private final StatsHandler personalStats;
    private final EquipmentHandler equipment;
    private final AttackSetHandler attackSet;

    public Enemy (String name, Inventory inventory, int coins, int DROPPED_XP, StatsHandler personalStats, EquipmentHandler equipment, AttackSetHandler attackSet) {
        super(name, inventory, coins);
        this.DROPPED_XP = DROPPED_XP;
        this.personalStats = personalStats;
        this.equipment = equipment;
        this.attackSet = attackSet;
    }

    public int getDROPPED_XP() {
        return DROPPED_XP;
    }

    public StatsHandler getCombatStats() {
        return personalStats;
    }

    public EquipmentHandler getEquipment() {return equipment;}

    public AttackSetHandler getAttacks() {return attackSet;}

    public void attack(Fighter target, Attack attackUsed){
        int totalDamage = 0;
        totalDamage += attackUsed.getPower();
        if (attackUsed instanceof Spell) {
            int currentMana = personalStats.getMP().getCurrentValue();
            if (currentMana >= ((Spell) attackUsed).getRequiredMana()) {
                totalDamage += personalStats.getBasicMagicAttack();
                totalDamage += equipment.getMagicAttack();
                totalDamage -= target.getEquipment().getMagicDefence();
                personalStats.getMP().decreaseCurrent(((Spell) attackUsed).getRequiredMana());
            }
            else {
                totalDamage = 0;
            }

        }
        else if (attackUsed instanceof PhysicalAttack) {
            totalDamage += personalStats.getBasicMeleeAttack();
            totalDamage += equipment.getMeleeAttack();
            totalDamage -= target.getEquipment().getMeleeDefence();
        }
        target.getCombatStats().getHP().decreaseCurrent(totalDamage);
    }

    public void dropLoot(Looter looter) {
        looter.getCoins().increaseCurrent(this.getCoins().getCurrentValue());
        if (looter instanceof Levelable) {
            ((Levelable) looter).getXP().increaseCurrent(DROPPED_XP);
        }
    }
}
