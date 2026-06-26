package entities;

import components.Inventory;

import components.Currency;

public interface Looter {

    Currency getCoins();

    Inventory getInventory();
}
