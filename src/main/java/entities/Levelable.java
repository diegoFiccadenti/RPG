package entities;

import components.Experience;

public interface Levelable {

    int getLevel();
    Experience getXP();

    void gainXP(int gainedXP);
    void levelUp();
}
