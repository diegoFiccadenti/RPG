package entities;

import quantifiables.Experience;

public interface Levelable {

    public int getLevel();
    public Experience getXP();

    public void gainXP(int gainedXP);
    public void levelUp();
}
