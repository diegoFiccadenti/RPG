package interfaces;

import model.Experience;

public interface Levelable {

    public int getLevel();
    public Experience getXP();

    public void gainXP(int gainedXP);
    public void levelUp();
}
