package utils;

import components.AttackSetHandler;
import components.EquipmentHandler;
import components.Inventory;
import components.StatsHandler;
import components.StatsHandler.Stat;
import entities.Enemy;
import entities.Fighter;
import items.EquipmentPiece;
import items.Equippable;
import mechanics.*;

import java.util.ArrayList;
import java.util.List;

public class MissionInitializer {

    public static List<Mission> getMissions() {
        List<Mission> missions = new ArrayList<>();

        Mission mission1 = goblinSlayMission();
        Mission mission3 = evilMageBountyMission();
        Mission mission2 = dragonSlayMission();

        missions.add(mission1);
        missions.add(mission2);
        missions.add(mission3);

        return missions;
    }

    private static Mission goblinSlayMission() {

        StatsHandler goblinStats = new StatsHandler();
        goblinStats.increaseStat(Stat.STRENGTH, 3);
        goblinStats.increaseStat(Stat.VITALITY, 1);

        EquipmentHandler goblinEquipment = new EquipmentHandler();
        Equippable commonHat = new EquipmentPiece("Common hat", "A simple hat", 100, EquipmentHandler.EquipmentType.HEAD, 0, 3,0,1);
        Equippable commonShirt = new EquipmentPiece("Common shirt", "A simple shirt", 100, EquipmentHandler.EquipmentType.CHEST, 0, 3,0,1);
        Equippable commonPants = new EquipmentPiece("Common pants", "Simple pants", 100, EquipmentHandler.EquipmentType.LEGS, 0, 3,0,1);
        Equippable commonBoots = new EquipmentPiece("Common boots", "A simple pair of boots", 100, EquipmentHandler.EquipmentType.FEET, 0, 3,0,1);
        Equippable rustySword = new EquipmentPiece("Rusty sword", "Has seen better times", 100, EquipmentHandler.EquipmentType.PRIMARY_WEAPON, 10, 0,0,0);
        goblinEquipment.equip(commonHat);
        goblinEquipment.equip(commonShirt);
        goblinEquipment.equip(commonPants);
        goblinEquipment.equip(commonBoots);
        goblinEquipment.equip(rustySword);

        AttackSetHandler goblinAttacks = new AttackSetHandler();
        Attack slash = new PhysicalAttack("Slash", 10);
        Attack assault = new PhysicalAttack("Assault", 12);
        Attack energyOrb = new Spell("Energy Orb", 12, 5);
        goblinAttacks.addAttack(slash);
        goblinAttacks.addAttack(assault);
        goblinAttacks.addAttack(energyOrb);

        Fighter goblin = new Enemy("Goblin", new Inventory(16), 25, 10, goblinStats, goblinEquipment, goblinAttacks);

        return new BountyMission("Slay a goblin", goblin, 100, 100);
    }

    private static Mission evilMageBountyMission() {

        StatsHandler mageStats = new StatsHandler();
        mageStats.increaseStat(Stat.STRENGTH, 3);
        mageStats.increaseStat(Stat.VITALITY, 5);
        mageStats.increaseStat(Stat.INTELLIGENCE, 10);

        EquipmentHandler mageEquipment = new EquipmentHandler();
        Equippable wizardHood = new EquipmentPiece("Wizard hood", "A common choice among wizards", 400, EquipmentHandler.EquipmentType.HEAD, 0, 4,0,10);
        Equippable wizardRobes = new EquipmentPiece("Wizard robes", "A common choice among wizards", 400, EquipmentHandler.EquipmentType.CHEST, 0, 4,0,10);
        Equippable wizardPants = new EquipmentPiece("Wizard pants", "A common choice among wizards", 400, EquipmentHandler.EquipmentType.LEGS, 0, 4,0,10);
        Equippable wizardBoots = new EquipmentPiece("Wizard boots", "A common choice among wizards", 400, EquipmentHandler.EquipmentType.FEET, 0, 4,0,10);
        Equippable wizardStaff = new EquipmentPiece("Wizard staff", "Every wizard used it at least once", 650, EquipmentHandler.EquipmentType.PRIMARY_WEAPON, 5, 0,20,0);
        mageEquipment.equip(wizardHood);
        mageEquipment.equip(wizardRobes);
        mageEquipment.equip(wizardPants);
        mageEquipment.equip(wizardBoots);
        mageEquipment.equip(wizardStaff);

        AttackSetHandler mageAttacks = new AttackSetHandler();
        Attack punch = new PhysicalAttack("Punch", 8);
        Attack energyBeam = new Spell("Energy Beam", 20, 10);
        Attack energyOrb = new Spell("Energy Orb", 12, 5);
        mageAttacks.addAttack(punch);
        mageAttacks.addAttack(energyBeam);
        mageAttacks.addAttack(energyOrb);

        Fighter evilMage = new Enemy("Evil Mage", new Inventory(16), 50, 40, mageStats, mageEquipment, mageAttacks);

        return new BountyMission("Bounty: evil mage", evilMage, 500, 500);
    }

    private static Mission dragonSlayMission() {

        StatsHandler dragonStats = new StatsHandler();
        dragonStats.increaseStat(Stat.STRENGTH, 30);
        dragonStats.increaseStat(Stat.VITALITY, 30);
        dragonStats.increaseStat(Stat.INTELLIGENCE, 30);

        EquipmentHandler dragonEquipment = new EquipmentHandler();

        AttackSetHandler dragonAttacks = new AttackSetHandler();
        Attack blazeOfFire = new Spell("Blaze of Fire", 40, 15);
        Attack claws = new PhysicalAttack("Claws", 25);
        Attack bite = new PhysicalAttack("Bite", 30);
        dragonAttacks.addAttack(blazeOfFire);
        dragonAttacks.addAttack(claws);
        dragonAttacks.addAttack(bite);

        Fighter dragon = new Enemy("Dragon", new Inventory(16), 250, 500, dragonStats, dragonEquipment, dragonAttacks);

        return new BountyMission("Slay a dragon", dragon, 2500, 2000);
    }
}
