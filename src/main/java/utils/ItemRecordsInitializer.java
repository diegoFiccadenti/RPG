package utils;

import components.EquipmentHandler.EquipmentType;
import items.EquipmentPiece;
import items.Item;
import items.Potion;
import items.SkillBook;
import mechanics.Attack;
import mechanics.PhysicalAttack;
import mechanics.Spell;
import persistence.MyWriter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ItemRecordsInitializer {

    // method called only during the development of the game
    public static void InitShopItems() {

        List<Item> shopItems = new ArrayList<>();

        Item healPotion = new Potion("Healing Potion", "Heals 20 HP", 50, 20, 0);
        Item manaPotion = new Potion("Mana Potion", "Recovers 20 MP", 50, 0, 20);
        Item bigHealPotion = new Potion("Big Healing Potion", "Heals 50 HP", 200, 50, 0);
        Item bigManaPotion = new Potion("Big Mana Potion", "Recovers 50 MP", 200, 0, 50);
        Item woodenClub = new EquipmentPiece("Wooden club", "Does its job", 50, EquipmentType.PRIMARY_WEAPON, 8, 0,0,0);
        Item rustySword = new EquipmentPiece("Rusty sword", "Has seen better times", 100, EquipmentType.PRIMARY_WEAPON, 10, 0,0,0);
        Item ironSword = new EquipmentPiece("Iron sword", "Widely used among adventures", 500, EquipmentType.PRIMARY_WEAPON, 20, 0,0,0);
        Item steelSword = new EquipmentPiece("Steel sword", "An adventure's first choice", 1000, EquipmentType.PRIMARY_WEAPON, 25, 0,0,0);
        Item lightSword = new EquipmentPiece("Light sword", "Very sharp and shiny", 5000, EquipmentType.PRIMARY_WEAPON, 35, 0,10,0);
        Item woodenStick = new EquipmentPiece("Wooden stick", "Is a stick", 10, EquipmentType.PRIMARY_WEAPON, 3, 0,3,0);
        Item apprenticeStaff = new EquipmentPiece("Apprentice staff", "Common staff among new apprentices and magic-enthusiasts", 150, EquipmentType.PRIMARY_WEAPON, 5, 0,10,0);
        Item wizardStaff = new EquipmentPiece("Wizard staff", "Every wizard used it at least once", 650, EquipmentType.PRIMARY_WEAPON, 5, 0,20,0);
        Item elderStaff = new EquipmentPiece("Elder staff", "A staff used by expert wizards", 1500, EquipmentType.PRIMARY_WEAPON, 5, 0,25,0);
        Item moonShadowStaff = new EquipmentPiece("Moon Shadow staff", "Perfect for night lovers", 3450, EquipmentType.PRIMARY_WEAPON, 5, 0,30,0);
        Item soulSpireStaff = new EquipmentPiece("Soul Spire staff", "A powerful staff", 6800, EquipmentType.PRIMARY_WEAPON, 5, 0,38,0);
        Item commonHat = new EquipmentPiece("Common hat", "A simple hat", 100, EquipmentType.HEAD, 0, 3,0,1);
        Item commonShirt = new EquipmentPiece("Common shirt", "A simple shirt", 100, EquipmentType.CHEST, 0, 3,0,1);
        Item commonPants = new EquipmentPiece("Common pants", "Simple pants", 100, EquipmentType.LEGS, 0, 3,0,1);
        Item commonBoots = new EquipmentPiece("Common boots", "A simple pair of boots", 100, EquipmentType.FEET, 0, 3,0,1);
        Item hunterHat = new EquipmentPiece("Hunter hat", "Commonly used by hunters", 250, EquipmentType.HEAD, 0, 7,0,2);
        Item hunterVest = new EquipmentPiece("Hunter vest", "Commonly used by hunters", 250, EquipmentType.CHEST, 0, 7,0,2);
        Item hunterPants = new EquipmentPiece("Hunter pants", "Commonly used by hunters", 250, EquipmentType.LEGS, 0, 7,0,2);
        Item hunterBoots = new EquipmentPiece("Hunter boots", "Commonly used by hunters", 250, EquipmentType.FEET, 0, 7,0,2);
        Item knightHelm = new EquipmentPiece("Knight helm", "Used by the knight order", 750, EquipmentType.HEAD, 0, 12,0,3);
        Item knightChestPlate = new EquipmentPiece("Knight chest plate", "Used by the knight order", 1000, EquipmentType.CHEST, 0, 15,0,4);
        Item knightPlateLeggings = new EquipmentPiece("Knight plate leggings", "Used by the knight order", 1000, EquipmentType.LEGS, 0, 15,0,4);
        Item knightPlateBoots = new EquipmentPiece("Knight plate boots", "Used by the knight order", 750, EquipmentType.FEET, 0, 12,0,3);
        Item wizardHood = new EquipmentPiece("Wizard hood", "A common choice among wizards", 400, EquipmentType.HEAD, 0, 4,0,10);
        Item wizardRobes = new EquipmentPiece("Wizard robes", "A common choice among wizards", 400, EquipmentType.CHEST, 0, 4,0,10);
        Item wizardPants = new EquipmentPiece("Wizard pants", "A common choice among wizards", 400, EquipmentType.LEGS, 0, 4,0,10);
        Item wizardBoots = new EquipmentPiece("Wizard boots", "A common choice among wizards", 400, EquipmentType.FEET, 0, 4,0,10);

        Attack slash = new PhysicalAttack("Slash", 6);
        Item slashBook = new SkillBook("Learned attack: slash", "A simple swing of the weapon", 300, slash);
        Attack lunge = new PhysicalAttack("Lunge", 8);
        Item lungeBook = new SkillBook("Learned attack: lunge", "Lunge at your opponent", 500, lunge);
        Attack heavySlash = new PhysicalAttack("Heavy slash", 11);
        Item heavySlashBook = new SkillBook("Learned attack: Heavy slash", "An heavy swing of the weapon", 1000, heavySlash);
        Attack basicMagicAttack = new Spell("Basic magic attack", 5, 10);
        Item basicMagicAttackBook = new SkillBook("Learned attack: Basic magic attack", "A simple release of mana, good to start learning magic", 250, basicMagicAttack);
        Attack fireball = new Spell("Fireball", 8, 20);
        Item fireBallBook = new SkillBook("Learned attack: Fireball", "Burn the enemies!", 700, fireball);
        Attack storm = new Spell("Storm", 15, 45);
        Item stormBook = new SkillBook("Learned attack: Storm", "Generate a storm that will strike the enemies", 1500, storm);

        shopItems.add(rustySword);
        shopItems.add(healPotion);
        shopItems.add(manaPotion);
        shopItems.add(bigHealPotion);
        shopItems.add(bigManaPotion);
        shopItems.add(woodenClub);
        shopItems.add(ironSword);
        shopItems.add(steelSword);
        shopItems.add(lightSword);
        shopItems.add(woodenStick);
        shopItems.add(apprenticeStaff);
        shopItems.add(wizardStaff);
        shopItems.add(elderStaff);
        shopItems.add(moonShadowStaff);
        shopItems.add(soulSpireStaff);
        shopItems.add(commonHat);
        shopItems.add(commonShirt);
        shopItems.add(commonPants);
        shopItems.add(commonBoots);
        shopItems.add(hunterHat);
        shopItems.add(hunterVest);
        shopItems.add(hunterPants);
        shopItems.add(hunterBoots);
        shopItems.add(knightHelm);
        shopItems.add(knightChestPlate);
        shopItems.add(knightPlateLeggings);
        shopItems.add(knightPlateBoots);
        shopItems.add(wizardHood);
        shopItems.add(wizardRobes);
        shopItems.add(wizardPants);
        shopItems.add(wizardBoots);
        shopItems.add(wizardStaff);
        shopItems.add(slashBook);
        shopItems.add(lungeBook);
        shopItems.add(heavySlashBook);
        shopItems.add(basicMagicAttackBook);
        shopItems.add(fireBallBook);
        shopItems.add(stormBook);

        Path shopItemsResourcePath = Paths.get("src/main/resources/shopItems.json");
        MyWriter.saveItemList(shopItems, shopItemsResourcePath);
    }
}
