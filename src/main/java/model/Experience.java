package model;

public class Experience extends Resource {

    public Experience(int currentLevel) {
        int maxValue = maxXPForNewLevel(currentLevel);
        super(0, maxValue, 0);
    }

    public static int maxXPForNewLevel(int currentLevel) {
        return (100*currentLevel) + 100; // used formula to calculate the xp needed for each level
    }

    public int neededXPToLevelUp() {
        return this.getMaxValue() - this.getCurrentValue();
    }
}
