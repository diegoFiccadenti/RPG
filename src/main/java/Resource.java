public abstract class Resource {

    int currentValue;
    int maxValue;
    int minValue;

    public int getCurrentValue() {
        return currentValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void increaseCurrent(int amountToAdd) {
        if (amountToAdd < 0) throw new IllegalArgumentException("Parameter must be non-negative");
        currentValue += amountToAdd;
        if (currentValue > maxValue) {
            currentValue = maxValue;
        }
    }

    public void decreaseCurrent(int amountToSubtract) {
        if (amountToSubtract < 0) throw new IllegalArgumentException("Parameter must be non-negative");
        currentValue -= amountToSubtract;
        if (currentValue < minValue) {
            currentValue = minValue;
        }
    }

    public void increaseMax(int amountToAdd) {
        if (amountToAdd < 0) throw new IllegalArgumentException("Parameter must be non-negative");
        maxValue += amountToAdd;
    }

    public void decreaseMax(int amountToSubtract) {
        if (amountToSubtract < 0) throw new IllegalArgumentException("Parameter must be non-negative");
        maxValue -= amountToSubtract;
    }
}
