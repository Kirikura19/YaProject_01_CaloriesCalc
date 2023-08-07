package ru.kirikura.calories.util;

import ru.kirikura.calories.enums.Month;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Walker {
    private final HashMap<Integer, Integer>[]  months = new HashMap[12];
    private int goal = 10000;
    public Walker() {
        HashMap<Integer, Integer> origin = new HashMap<>();
        for(int j = 1; j <= 30; j++)
            origin.put(j, new Random().nextInt(0, 10000)); // По дефолту заполняется нулями. В данном случае, автоматически заполнил на весь год для тестов.

        for(int i = 0; i < months.length; i++) {
            months[i] = (HashMap<Integer, Integer>) origin.clone();
        }
    }
    public void setGoal(int goal) {
        this.goal = goal;
    }
    public void writeDay(Month month, int day, int steps) {
        months[month.getValue() - 1].put(day, steps);
    }
    public static void showFullStatistic(int maxStep, int avgStep, double totalDistance, double burnedCalories, int goodDays, String stat, Month month) {
        System.out.println("Statistic for all days in " + month + ":\n" + stat.toString());
        System.out.println("Max walked distance in steps: " + maxStep);
        System.out.println("Avg count of steps: " + avgStep);
        System.out.println("Total walked distance: " + totalDistance);
        System.out.println("Total burned calories: " + burnedCalories);
        System.out.println("Good days is: " + goodDays);
    }
    public void calculateFullStatistic(Month month) {

        int maxStep = 0;
        int avgStep;
        int steps = 0;
        int goodDays = 0;
        double totalDistance = 0;
        double burnedCalories = 0;
        StringBuilder stat = new StringBuilder();
        HashMap<Integer, Integer> currentMonth = months[month.getValue() - 1];
        for(Map.Entry<Integer, Integer> entry : currentMonth.entrySet()) {
            stat.append(entry.getKey() + " day: " + entry.getValue() + "\n");
            steps += entry.getValue();
            if(maxStep < entry.getValue())
                maxStep = entry.getValue();
            if(entry.getValue() > this.goal) {
                goodDays += 1;
            }
        }
        Calculator calculator = new Calculator(steps, currentMonth.entrySet().size());
        totalDistance = calculator.calculateTotalDistance();
        burnedCalories = calculator.calculateBurnedCalories();
        avgStep = calculator.calculateAvgSteps();
        showFullStatistic(maxStep, avgStep, totalDistance, burnedCalories, goodDays, stat.toString(), month);
    }
}
