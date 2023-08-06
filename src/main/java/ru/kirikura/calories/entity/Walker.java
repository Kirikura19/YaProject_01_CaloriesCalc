package ru.kirikura.calories.entity;

import ru.kirikura.calories.enums.Month;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Walker {
    private static final HashMap<Integer, Integer>[]  months = new HashMap[12];
    static{
        HashMap<Integer, Integer> origin = new HashMap<>();
        for(int j = 1; j <= 30; j++)
            origin.put(j, new Random().nextInt(0, 10000));
        for(int i = 0; i < months.length; i++) {
            months[i] = (HashMap<Integer, Integer>) origin.clone();
        }
    }
    private static int goal = 10000;

    public static void setGoal(int newGoal) {
        goal = newGoal;
    }

    public static void getFullStatistic(Month month) {
        int maxStep = 0;
        int avgStep;
        int totalDistance = 0;
        int goodDays = 0;
        System.out.println("Statistic for all days in " + month + ":");
        HashMap<Integer, Integer> currentMonth = months[month.getValue() - 1];
        for(Map.Entry<Integer, Integer> entry : currentMonth.entrySet()) {
            if(maxStep < entry.getValue())
                maxStep = entry.getValue();
            totalDistance += entry.getValue();
            if(entry.getValue() > goal) {
                goodDays += 1;
            }
            System.out.println(entry.getKey() + " day: " + entry.getValue());
        }
        avgStep = totalDistance/30;
        System.out.println("Max walked distance in steps: " + maxStep);
        System.out.println("Avg count of steps: " + avgStep);
        System.out.println("Total walked distance: " + totalDistance);
        System.out.println("Total burned calories: " + (totalDistance/1000) * 3);
        System.out.println("Good days is: " + goodDays);
    }

    public static void writeDay(Month month, int day, int steps) {
        months[month.getValue() - 1].put(day, steps);
    }
}
