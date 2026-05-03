package model;

public abstract class Resource {

    private int currentValue;
    private int maxValue;
    private final int minValue;

    public Resource(int currentValue, int maxValue, int minValue) {
        this.currentValue = currentValue;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }

    public int getCurrentValue() {
        return currentValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public boolean isAtMaximum() {
        return currentValue >= maxValue;
    }

    public boolean isAtMinimum() {
        return currentValue <= minValue;
    }

    public void setCurrent(int newCurrent) {

        this.currentValue = newCurrent;

        if (currentValue > maxValue) {
            currentValue = maxValue;
        }
        if (currentValue < minValue) {
            currentValue = minValue;
        }
    }

    public void setMax(int newMax) {
        if (newMax < minValue) {
            throw new IllegalArgumentException("maxValue must be greater than minValue");
        }
        this.maxValue = newMax;
    }
}
