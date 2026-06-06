package entities;

import quantifiables.Experience;

public interface Levelable {

    int getLevel();
    Experience getXP();

    void gainXP(int gainedXP);
    void levelUp();
}
