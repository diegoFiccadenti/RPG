package it.unicam.cs.mpgc.rpg132379.mechanics;

import it.unicam.cs.mpgc.rpg132379.entities.Fighter;

public interface Attack {

    void use(Fighter user, Fighter target);

    String getName();

    int getPower();
}
