package it.unicam.cs.mpgc.rpg132379.components;

public class Experience extends Resource {

    public Experience(int currentLevel) {
        int maxValue = maxXPForNewLevel(currentLevel);
        super(0, maxValue, 0);
    }

    public static int maxXPForNewLevel(int currentLevel) {
        // formula used to calculate the xp needed for each level
        return (50*currentLevel*currentLevel) + (50*currentLevel) + 100;
    }

    public int neededXPToLevelUp() {
        return this.getMaxValue() - this.getCurrentValue();
    }
}
