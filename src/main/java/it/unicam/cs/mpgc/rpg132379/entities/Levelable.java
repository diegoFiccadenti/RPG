package it.unicam.cs.mpgc.rpg132379.entities;

import it.unicam.cs.mpgc.rpg132379.components.Experience;

public interface Levelable {

    int getLevel();
    Experience getXP();

    void gainXP(int gainedXP);
    void levelUp();
}
