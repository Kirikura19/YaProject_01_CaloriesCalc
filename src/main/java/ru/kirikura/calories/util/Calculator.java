package ru.kirikura.calories.util;

public class Calculator {
    private final static double lengthStep = 0.75d;
    private final static double calorieStep = 50d;
    private int monthLength;
    private int steps;
    public Calculator(int steps, int monthLength) {
        this.steps = steps;
        this.monthLength = monthLength;
    }
    public double calculateTotalDistance() {
        return steps/lengthStep;
    }

    public double calculateBurnedCalories() {
        return steps/calorieStep;
    }
    public int calculateAvgSteps() {
        return steps/monthLength;
    }
}