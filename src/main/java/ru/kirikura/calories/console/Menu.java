package ru.kirikura.calories.console;

import ru.kirikura.calories.util.Walker;
import ru.kirikura.calories.enums.Month;

import java.util.Scanner;

public class Menu {
    private int userChoice;
    public void showMenu() {
        System.out.println(
                "\nChoose your options, please:" +
                "\n1. Enter quantity of steps for chosen day." +
                "\n2. Show statistic for chosen month." +
                "\n3. Change day target." +
                "\n4. Exit.");
        getUserChoice();
    }
    public void getUserChoice(){
        Scanner sc = new Scanner(System.in);
        try{
            this.userChoice = Integer.parseInt(sc.nextLine());
            chooseAction();
        } catch(NumberFormatException e){
            System.out.println("Number format is wrong.\n");
            showMenu();
        }
    }
    public void chooseAction() {
        Scanner sc = new Scanner(System.in);
        Walker walker = new Walker();
        switch (userChoice) {
            case (1):
                walker.writeDay(Month.valueOf(sc.nextLine().toUpperCase()), sc.nextInt(), sc.nextInt());
                break;
            case (2):
                walker.calculateFullStatistic(Month.valueOf(sc.nextLine().toUpperCase()));
                break;
            case (3):
                walker.setGoal(sc.nextInt());
                break;
            case (4):
                System.exit(0);
                break;
        }
        showMenu();
    }
}
