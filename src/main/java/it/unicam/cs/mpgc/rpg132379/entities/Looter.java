package it.unicam.cs.mpgc.rpg132379.entities;

import it.unicam.cs.mpgc.rpg132379.components.Inventory;

import it.unicam.cs.mpgc.rpg132379.components.Currency;

public interface Looter {

    Currency getCoins();

    Inventory getInventory();
}
